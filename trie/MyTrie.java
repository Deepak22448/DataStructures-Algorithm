package trie;

public class MyTrie {

    private static class TrieNode {
        char data;
        TrieNode[] children = new TrieNode[26];
        boolean isTerminal;

        TrieNode(char ch) {
            this.data = ch;
            for (int i = 0; i < 26; i++)
                children[i] = null;
            this.isTerminal = false;
        }
    }

    private static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode('0');
        }

        void insertUtil(TrieNode root, String word) {
            if (word.length() == 0) {
                root.isTerminal = true;
                return;
            }

            int index = word.charAt(0) - 'A';

            TrieNode child;
            if (root.children[index] != null) {
                child = root.children[index];
            } else {
                child = new TrieNode(word.charAt(0));
                root.children[index] = child;
            }

            insertUtil(child, word.substring(1));
        }

        void insertWord(String word) {
            insertUtil(root, word);
        }

        boolean searchUtil(TrieNode root, String word) {
            if (word.length() == 0)
                return root.isTerminal;

            int index = word.charAt(0) - 'A';
            TrieNode child;

            if (root.children[index] != null) {
                child = root.children[index];
            } else {
                return false;
            }

            return searchUtil(child, word.substring(1));
        }

        boolean search(String word) {
            return searchUtil(root, word);
        }

        boolean isEmpty(TrieNode root) {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null)
                    return false;
            }
            return true;
        }

        TrieNode remove(TrieNode root, String word, int depth) {
            if (root == null)
                return null;

            if (depth == word.length()) {

                if (root.isTerminal)
                    root.isTerminal = false;

                if (isEmpty(root))
                    root = null;

                return root;
            }

            int index = word.charAt(depth) - 'A';
            root.children[index] = remove(root.children[index], word, depth + 1);

            if (isEmpty(root) && root.isTerminal == false)
                root = null;

            return root;
        }
    }

    public static void main(String[] args) {

        Trie t = new Trie();
        t.insertWord("ARM");
        t.insertWord("DO");
        t.insertWord("TIME");

        System.out.println("Present or not : " + t.search("TIME"));
        t.remove(t.root, "TIME", 0);
        System.out.println("Present or not : " + t.search("TIME"));

    }

}

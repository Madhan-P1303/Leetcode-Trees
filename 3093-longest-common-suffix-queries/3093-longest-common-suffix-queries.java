class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int idx = -1;
    }

    TrieNode root = new TrieNode();
    String[] wordsContainer;

    // choose better index
    private int better(int oldIdx, int newIdx) {

        if (oldIdx == -1) return newIdx;

        int len1 = wordsContainer[oldIdx].length();
        int len2 = wordsContainer[newIdx].length();

        // smaller length
        if (len2 < len1) {
            return newIdx;
        }

        // same length -> earlier index
        if (len1 == len2 && newIdx < oldIdx) {
            return newIdx;
        }

        return oldIdx;
    }

    private void insert(String word, int index) {

        TrieNode node = root;

        // update root
        node.idx = better(node.idx, index);

        // insert reversed word
        for (int i = word.length() - 1; i >= 0; i--) {

            int ch = word.charAt(i) - 'a';

            if (node.child[ch] == null) {
                node.child[ch] = new TrieNode();
            }

            node = node.child[ch];

            node.idx = better(node.idx, index);
        }
    }

    private int search(String word) {

        TrieNode node = root;

        // traverse reversed query
        for (int i = word.length() - 1; i >= 0; i--) {

            int ch = word.charAt(i) - 'a';

            if (node.child[ch] == null) {
                break;
            }

            node = node.child[ch];
        }

        return node.idx;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        this.wordsContainer = wordsContainer;

        // build trie
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        // process queries
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}
public class TrieNode {

    char val;

    boolean isWord;

    TrieNode[] children = new TrieNode[26];

    TrieNode(){

    }

    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}

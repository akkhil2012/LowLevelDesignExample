public class Trie {

    TrieNode root;

    Trie(){
        root = new TrieNode();
        root.val=' ';
    }


    public void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) { // if Node; which is the datatype at index is null
                TrieNode trieNodeNew = new TrieNode(c);
                ws.children[c - 'a'] = trieNodeNew;
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }


    /*
    search
     */
    public boolean search(String word){
        TrieNode ws = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(ws.children[c-'a']==null)
                    return  false;
            ws=ws.children[c-'a'];
        }
        return ws.isWord;
    }

    /*
      Starts with
     */

    public boolean startsWith(String prefix){
        TrieNode ws = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(ws.children[c-'a']==null)
                return false;
            ws = ws.children[c-'a'];
        }
      return true;
    }









}






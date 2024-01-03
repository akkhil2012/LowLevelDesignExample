public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        String insertFisrt = "akkhil";
        trie.insert(insertFisrt);

        insertFisrt = "kumar";
        trie.insert(insertFisrt);


        System.out.println(" Is element present :: " + trie.search(insertFisrt));


    }
}
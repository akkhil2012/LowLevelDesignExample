public class Main {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        LRUCache lrucache = new LRUCache(2);

        print(lrucache.get(1) == -1);

        lrucache.put(2, 1);
        //lrucache.printDLL();
        lrucache.put(1, 1);
        //lrucache.printDLL();
//        print(lrucache);
        print(lrucache.get(2) == 1);
        //lrucache.printDLL();
//        print(lrucache);

        lrucache.put(4, 1);
       // lrucache.printDLL();
        print(lrucache.get(1) == -1);
        print(lrucache.get(2) == 1);
       // lrucache.printDLL();


    }

    public static void print(Object obj) {
        System.out.println("print :: " + obj);
    }
}
public class JavaInnerClassExample {

    public static void main(String args[]){

        OuterClass outerClass = new OuterClass();

       // OuterClass.InnerClass innerClass = new InnerClass().S

        OuterClass.StaticInnerClass innerClass = new OuterClass.StaticInnerClass();
        innerClass.test();

        OuterClass.InnerClass innerClass1 = new OuterClass().new InnerClass();
        innerClass1.test();

        MemerOuterClass memerOuterClass = new MemerOuterClass();
        memerOuterClass.testMethod();



    }




}


/*

 */

class OuterClass{

    class InnerClass{

        void test(){
            System.out.println("-----1 -----------");
        }
    }

    static class StaticInnerClass{
        void test(){
            System.out.println("-----2 -----------");
        }
    }
}


/*
member inner class
 */
class MemerOuterClass{

    void testMethod(){

        class LocalInnerClass{
            void test(){
                System.out.println("-----3 -----------");
            }
        }

        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.test();

    }
}
public class TypePromotionSample {

    public static void main(String[] args) {

            TypeSample typeSample = new TypeSample();
            typeSample.test(1,3);
    }
}


class TypeSample{

    void test(int first,long second){
        System.out.println(" Inside promoted method.....");

    }

    void test(int first,int second){
        System.out.println(" Inside ACTUAL matching method.....");

    }

}

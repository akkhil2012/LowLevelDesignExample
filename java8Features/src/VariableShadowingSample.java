public class VariableShadowingSample {

    public static void main(String[] args) {

        Parent child = new Child();
        child.test1();

    }


}

class Parent{

    public  User  test1(){
        System.out.println("Fro child.........");
        return new User("",1);
    }

}


class Child extends Parent{
    public  Memeber  test1(){
        System.out.println("Fro PArent.........");
        return  new Memeber("",1);
    }
}



class Memeber extends  User{

    public Memeber(String name, int age) {
        super(name, age);
    }
}

import java.util.*;

public class ComparableExample {

    public static void main(String[] args) {
        User p1 = new User("first",40);
        User p2 = new User("second",50);
        User p3 = new User("third",50);

        List<User> users = new ArrayList<>();
        users.add(p1);
        users.add(p2);
        users.add(p3);


        Collections.sort(users);

        users.stream()
                .forEach(user -> System.out.println(" "+ user.getName()));


        Collections.sort(users,new UserComparator());

        System.out.println("<-------- when using comparator---------->");

        users.stream()
                .forEach(user -> System.out.println(" "+ user.getName()));


    }

}


    class UserComparator implements  Comparator<User>{
        @Override
        public int compare(User o1, User o2) {
            if(o1.getAge()!=o2.getAge()){
                return o1.getAge()-o2.getAge();
            }
            return -o1.getName().compareTo(o2.getName());
        }
    }

    class User implements Comparable<User> {

        String name;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        int age;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }


        @Override
        public int compareTo(User o) {
            return -this.age+o.age;
        }
    }


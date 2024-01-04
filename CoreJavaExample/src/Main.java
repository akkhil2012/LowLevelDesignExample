import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


        Lock lock = new ReentrantLock();

        Resource resource = new Resource(lock);

        Thread t1 = new Thread(resource);

        Thread t2 = new Thread(resource);

        t1.start();



        t2.start();

        Thread.sleep(3000);

        System.out.println("About to call notify...");

        synchronized (lock){
            lock.notifyAll();
        }




        // reference and object comparision
        /*String str1 = "akkhil";
        String str2= new String("akkhil");
        String str3 = str1;

        System.out.println("1: " + str1.equals(str2));
        System.out.println("2: " + (str1==str2));//false
        System.out.println("3: " + (str1==str3));
        System.out.println("3: " + (str1.equals(str3)));

        Person p1 = new Person("akhil1",12);
        Person p2 = new Person("akhil",12);

        Person p3 = p1;
        System.out.println(" are equal: by equals " + p1.equals(p2)); //false
        System.out.println(" are equal: reference " + (p1==p3)); //true
        System.out.println(" are equal: by overriding name  " + p1.equals(p2)); //true
        System.out.println("hashcode for person1 : " + p1.hashCode());
        System.out.println("hashcode for person2 : " + p2.hashCode());
        System.out.println("hashcode for person3 : " + p3.hashCode());*/





        // JAVA 11 FEATURES
            //1.
        // FILES WRITE STRING
        Path filePath = Path.of("example1.txt");

        String content = "Hello, World!\nThis is an example........";

        Files.writeString(filePath,content, StandardOpenOption.CREATE);

        System.out.println("CONTENTS WRITEEN TO FILE");



        //2.
        // CONVERT THE COLLLECTIONS TO ARRAY

        List<String> sampleList = Arrays.asList("Java", "Kotlin");
        String[] array = sampleList.toArray(String[]::new);

        Arrays.stream(array).forEach(System.out::println);


        //3.
        // HTTP CLIENT
        /*HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://dummy.restapiexample.com/api/v1/employees"))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(" Response....... " + httpResponse.body().toString());*/
       // assertThat(httpResponse.body()).isEqualTo("Hello from the server!");


        //4.
        // No need to compile java class first using javac



    }
}



class Person{

    String name;

    @Override
    public boolean equals(Object o) {
        Person person = (Person) o;
        return person.name.equals(this.name);
    }

    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int hashCode() {
        return this.age;
    }
}


class Resource implements  Runnable{

    Lock lock;

    public Resource(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        System.out.println(" wait:  Thread running is " + Thread.currentThread().getName());

        synchronized (lock) {
            try {
                lock.wait();
                System.out.println(" Entered the wait state");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(" Notify: Thread RESUMED is............... " + Thread.currentThread().getName());

    }
}















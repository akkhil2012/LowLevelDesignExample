public class Main {
    public static void main(String[] args) {
        VideoStreamingPlatform videoStreamingPlatform
                = new VideoStreamingPlatform();



        User user = new User("first","FirstUSser");
        videoStreamingPlatform
                .signUpUser(user);



        System.out.println(" Upload new Video...");
        Video video = new Video("firstVideo");
        videoStreamingPlatform
                .uploadVideo(user.getId(),video);


        System.out.println(" Watch Video...");
        videoStreamingPlatform.watchVideo(user.getId(),video.getId());

        videoStreamingPlatform.rateVideo(user.getId(), video.getId(),5 );


        System.out.println("-------------------");
        videoStreamingPlatform.subscribe(user.getId());



    }
}
import model.*;
import service.SprintService;

public class JiraController {

    public static void main(String args[]){

        Sprint sprint = Sprint.builder()
                .withSprintData()
                .withStretegy()
                .build("sprintFirst");


        SprintService service = new SprintService(sprint);

        Task story = new Story("story1");

        //add task
        service.addTask(story);

        Task feature = new Feature("Feature1");

        //add task
        service.addTask(feature);

        System.out.println(" TAsk added..........");




        System.out.println(" TAsk fetched..........");
        service.fetchTasks()
                .stream()
                .forEach(task -> System.out.println(" "+ task.getEntityName()));




        // remove task
        String entityId = story.getEntityId();
        service.removeTask(entityId);

        String userId = "akhil";
        service.assignTask(entityId,userId);




        Sprint sprint1 = Sprint.builder()
                .withSprintData()
                .build("sprint2");





    }
}

package respository;

import model.Bug;
import model.Feature;
import model.Story;
import model.Task;

import java.util.*;
import java.util.stream.Collectors;

public class JiraRepository {

    Map<String, List<Task>> tasks; // user to task

    Map<String, Story> stories;
    Map<String, Feature> features;
    Map<String, Bug> bugs;

    public JiraRepository() {
        this.tasks = new HashMap<>();
        this.stories = new HashMap<>();
        this.features = new HashMap<>();
        this.bugs = new HashMap<>();
    }

    public void addTask(Task task) {

        // Task task;
        if (task instanceof Story) {
            Story story = (Story) task;
            String id = UUID.randomUUID().toString();
            stories.put(id, story);
        } else if (task instanceof Bug) {
            Bug bug = (Bug) task;
            String id = UUID.randomUUID().toString();
            bugs.put(id, bug);
        } else if (task instanceof Feature) {
            Feature feature = (Feature) task;
            String id = UUID.randomUUID().toString();
            features.put(id, feature);

        }
    }

    public void assignTask(String task, String userId) {
    }


    public void removeTask(String taskId) {
    }

    public List<Task> fetchAllTasks() {
        List<Task> result = new ArrayList<>();

        result.addAll(stories.entrySet().stream().map(story ->story.getValue()).collect(Collectors.toList()));
        result.addAll(features.entrySet().stream().map(feature ->feature.getValue()).collect(Collectors.toList()));
        result.addAll(bugs.entrySet().stream().map(bug ->bug.getValue()).collect(Collectors.toList()));

        return result;
    }
}










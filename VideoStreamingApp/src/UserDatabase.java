import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private Map<String, User> usersById;

    public UserDatabase() {
        usersById = new HashMap<>();
    }

    public void addUser(User user) {
        usersById.put(user.getId(), user);
    }

    public User getUser(String id) {
        return usersById.get(id);
    }

    public Collection<User> getAllUsers() {
        return usersById.values();
    }
}

public abstract class Entity {

    String content;

    public Entity(String content) {
        this.content = content;
    }

    public abstract void publish(String content);
}

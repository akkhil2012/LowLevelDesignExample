import java.util.UUID;

public class Comment extends Entity {

    String commentsData;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    String commentId;

    Member member;


    public String getCommentId() {
        return commentId;
    }

    public Comment(String commentsData) {
        super(commentsData);
        this.commentId = UUID.randomUUID().toString();
        this.commentsData = commentsData;
    }

    @Override
    public void publish(String content) {

    }
}

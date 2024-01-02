import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Answer extends  Entity{
    Set<Comment> commentsForAnswer;

    String answerId;

    public void setMember(Member member) {
        this.member = member;
    }

    Member member;

    public void answeredForQuestion(String question) {
        this.question = question;
    }

    String question;

    public Answer(String answer) {
        super(answer);
        this.commentsForAnswer = new HashSet<>();
        this.answerId = UUID.randomUUID().toString();
    }

    @Override
    public void publish(String content) {

    }
}

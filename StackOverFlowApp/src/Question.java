import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Question extends  Entity{

    String content;

    String questionId;

    public String getContent() {
        return content;
    }

    Member member;

    public Set<Answer> getAnswerToQuestionsSet() {
        return answerToQuestionsSet;
    }

    public Set<Comment> getCommentsToQuestionsSet() {
        return commentsToQuestionsSet;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Question(String content, String userId) {
        super(content);
        this.questionId = UUID.randomUUID().toString();
        this.content = userId;
        this.answerToQuestionsSet = new HashSet<>();
        this.commentsToQuestionsSet = new HashSet<>();
    }

    Set<Answer> answerToQuestionsSet;



    Set<Comment> commentsToQuestionsSet;

    @Override
    public void publish(String content) {
     System.out.println("Question published is " + content);
    }
}

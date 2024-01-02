import java.util.HashMap;
import java.util.Map;

public class StackOverFlowDAO {
    Map<String,Answer> answerMap;
    Map<String,Question> questionMap;
    Map<String,Comment> commentMap;

    public Map<String, Question> getQuestionMap() {
        return questionMap;
    }

    public StackOverFlowDAO() {
        this.answerMap = new HashMap<>();
        this.questionMap = new HashMap<>();
        this.commentMap = new HashMap<>();
    }


    public void createQuestion(Question question) {
        questionMap.put(question.questionId,question);

    }

    public void createAnswer(String answersContent, Answer answer) {
        answerMap.put(answer.answerId,answer);
    }

    public void createComment(Comment comment) {
        commentMap.put(comment.getCommentId(),comment);
    }
}

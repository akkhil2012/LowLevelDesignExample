import java.util.Set;

public interface StackOverFlowService {

    void writeQuestion(String userId,String questionContent);

    void writeAnswer(String userId,String questionId,String answersContent);

    void writeComments(String userId,String entityToCommentTo,String commentsContent);


    Set<Question> seachQuestions();
}

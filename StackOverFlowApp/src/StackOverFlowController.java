import java.util.Set;

public class StackOverFlowController {


    StackOverFlowService service;


    public StackOverFlowController(StackOverFlowService service) {
        this.service = service;
    }


    public  void askQuestion(String userId,String questionContent){
        service.writeQuestion(userId,questionContent);

    }

    public  void writeAnswer(String userId,String questionid,String answerContent){
        service.writeAnswer(userId,questionid,answerContent);

    }


    public  void writeComments(String userId,String entityToCommentTo,String questionContent){
        service.writeComments(userId,entityToCommentTo,questionContent);

    }


    public Set<Question> searchQuestions() {
        return service.seachQuestions();
    }
}

import java.util.Set;
import java.util.stream.Collectors;

public class StackOverFlowServiceImpl implements  StackOverFlowService{

    StackOverFlowDAO stackOverFlowDAO;


    public StackOverFlowServiceImpl(StackOverFlowDAO stackOverFlowDAO) {
        this.stackOverFlowDAO = stackOverFlowDAO;
    }

    @Override
    public void writeQuestion(String userId, String questionContent) {
        Question question = new Question(questionContent,userId);
        stackOverFlowDAO.createQuestion(question);
        question.setMember(new Member(userId));
        question.publish(questionContent);

       // System.out.println(" Question is  asked.......");
    }

    @Override
    public void writeAnswer(String userId, String quesetionId,String answersContent) {
        Answer answer = new Answer(answersContent);
        stackOverFlowDAO.createAnswer(answersContent,answer);
        answer.setMember(new Member(userId));
        answer.answeredForQuestion(quesetionId);
        System.out.println(" Answer given......");

    }

    @Override
    public void writeComments(String userId, String entityToCommentTo,String commentsContent) {
        Comment comment = new Comment(commentsContent);
        stackOverFlowDAO.createComment(comment);
        comment.setMember(new Member(userId));

        System.out.println(" Comment was made.......");

    }

    @Override
    public Set<Question> seachQuestions() {
        return stackOverFlowDAO.getQuestionMap().entrySet().stream()
                .map(question -> question.getValue())
                .collect(Collectors.toSet());
    }
}

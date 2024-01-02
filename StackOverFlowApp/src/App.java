public class App {

    public static void main(String args[]){

        StackOverFlowDAO stackOverFlowDAO = new StackOverFlowDAO();
        StackOverFlowService service = new StackOverFlowServiceImpl(stackOverFlowDAO);
        StackOverFlowController stackOverFlowController
                = new StackOverFlowController(service);

        stackOverFlowController.askQuestion("user1","sample qiestion...");
        stackOverFlowController.writeAnswer("user2","question1","sample answer to smple question");
        stackOverFlowController.writeComments("user3","answer1","Sample comment to ana nswer");


        System.out.println(" questions asked....................");

        stackOverFlowController.searchQuestions()
                .stream()
                .map(ques -> ques.getContent())
                .forEach(System.out::println);

    }
}

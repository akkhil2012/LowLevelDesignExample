public class ElevatorButtonPanel extends  ButtonPanel{

    Dispatcher dispatcher;

    public ElevatorButtonPanel(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    void executeRequest(Request request) {
            dispatcher.executeElevatorInnerRequest(request);
    }
}

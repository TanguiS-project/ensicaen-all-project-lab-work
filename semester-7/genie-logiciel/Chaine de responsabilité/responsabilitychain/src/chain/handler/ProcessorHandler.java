package chain.handler;

public abstract class ProcessorHandler {
    private ProcessorHandler _next;
    public ProcessorHandler setNextProcessor( ProcessorHandler ph ) {
        _next = ph;
        return this;
    }

    public void handleRequest( int input ) {
        if ( _next != null ) {
            _next.handleRequest(input);
        }
    }
}

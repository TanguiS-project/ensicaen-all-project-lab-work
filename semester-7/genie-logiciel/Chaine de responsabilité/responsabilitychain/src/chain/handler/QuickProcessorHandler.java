package chain.handler;

import chain.ProcessorQuick;

public class QuickProcessorHandler extends ProcessorHandler {
    private final ProcessorQuick _p;

    public QuickProcessorHandler(ProcessorQuick _p) {
        this._p = _p;
    }

    @Override
    public void handleRequest(int input) {
        if ( !_p.isBusy() ) {
            System.out.println("Traitement de " + input + " par un quickProcessor");
            _p.runTask(input);
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        super.handleRequest(input);
    }
}

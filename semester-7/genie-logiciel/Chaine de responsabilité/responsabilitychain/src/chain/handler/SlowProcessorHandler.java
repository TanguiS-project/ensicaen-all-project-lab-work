package chain.handler;

import chain.ProcessorQuick;
import chain.ProcessorSlow;

public class SlowProcessorHandler extends ProcessorHandler {
    private final ProcessorSlow _p;

    public SlowProcessorHandler(ProcessorSlow _p) {
        this._p = _p;
    }

    @Override
    public void handleRequest(int input) {
        if ( !_p.isBusy() ) {
            System.out.println("Traitement de " + input + " par un slowProcessor");
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

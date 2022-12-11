package chain;

import java.util.Random;

public class ProcessorSlow {
    private boolean _busy = false;
    private MathCompute _task = null;
    private final ResultPool _resultPool;

    public ProcessorSlow( ResultPool resultPool ) {
        _resultPool = resultPool;
    }

    public void runTask( int value ) {
        if (_task != null) {
            try {
                _task.join();
            } catch (Exception e) {
            }
        }
        _task = new MathCompute(value, _resultPool, (int) (Math.random() * 10));
        _task.start();
    }

    public boolean isBusy() {
        if (_task != null) {
            return _task.isAlive();
        } else {
            return false;
        }
    }
}

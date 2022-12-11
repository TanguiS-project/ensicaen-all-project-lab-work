package chain;

import java.util.Random;

public class ProcessorQuick {
    private boolean _busy = false;
    private MathCompute _task = null;
    private final ResultPool _resultPool;

    public ProcessorQuick( ResultPool resultPool ) {
        _resultPool = resultPool;
    }

    public void runTask( int value ) {
        if (_task != null) {
            try {
                _task.join();
            } catch (Exception e) {
            }
        }
        Random r = new Random();
        _task = new MathCompute(value, _resultPool, r.nextInt(5));
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

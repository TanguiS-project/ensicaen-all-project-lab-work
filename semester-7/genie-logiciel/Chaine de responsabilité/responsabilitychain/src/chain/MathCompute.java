package chain;

import java.util.ArrayList;
import java.util.List;

public class MathCompute extends Thread {
    private final int _value;
    private List<Integer> _results;
    private final ResultPool _resultPool;
    private final int _delay;

    public MathCompute( int value, ResultPool resultPool, int delay ) {
        _value = value;
        _results = new ArrayList<>();
        _resultPool = resultPool;
        _delay = delay;
    }

    public List<Integer> getResult() {
        return _results;
    }

    public int getValue() {
        return _value;
    }

    @Override
    public void run() {
        _results = PremierFactorDecomposition.decomposePowPremiers(_value);
        try {
            Thread.sleep(_delay * 1000L);
        } catch (Exception ignored) {
        }
        _resultPool.addResult(this);
    }
}

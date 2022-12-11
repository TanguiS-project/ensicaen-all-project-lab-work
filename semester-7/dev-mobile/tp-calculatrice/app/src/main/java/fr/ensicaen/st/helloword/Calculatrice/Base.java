package fr.ensicaen.st.helloword.Calculatrice;

import android.widget.Button;

import java.util.Map;
import java.util.Objects;

public class Base {
    private final int _handledBase;
    private Base next;

    public Base(int handledBase) {
        _handledBase = handledBase;
    }

    public Base setNext(Base next) {
        this.next = next;
        return this;
    }
    public void handleRequest(int input, Map<String, Button> bts) {
        if ( input == _handledBase ) {
            for ( int i = 0; i < 10; i++) {
                Objects.requireNonNull(bts.get(Integer.toString(i))).setEnabled(i < _handledBase);
            }
            return;
        }
        if ( next != null ) {
            next.handleRequest(input, bts);
        }
    }
}

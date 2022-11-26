package fr.ensicaen.st.helloword.Calculatrice;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator {
    public static float compute(String operation) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("rhino");
        double result = (double) engine.eval(operation);
        return (float) result;
    }
}

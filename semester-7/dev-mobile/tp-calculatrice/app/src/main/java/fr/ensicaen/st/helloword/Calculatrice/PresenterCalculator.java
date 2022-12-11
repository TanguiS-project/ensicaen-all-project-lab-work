package fr.ensicaen.st.helloword.Calculatrice;

import android.widget.Button;

import java.util.Map;

import javax.script.ScriptException;

public class PresenterCalculator {
    private StringBuilder _currentInput;
    private StringBuilder _lastInputWithResult;
    private short _numberParenthesesOpened;
    private static Base _baseChain;

    public PresenterCalculator() {
        _currentInput = new StringBuilder();
        _numberParenthesesOpened = 0;
        _baseChain = new Base(2).setNext(new Base(8).setNext(new Base(10)));
    }

    static private boolean isOperator( char input ) {
        return input == '-' || input == '+' || input == 'x' || input == '/' || input == '%';
    }

    static private boolean isOperand( char input ) {
        return Character.isDigit(input);
    }

    static private boolean isOpenParenthesis( char input ) {
        return input == '(';
    }

    static private boolean isCloseParenthesis( char input ) {
        return input == ')';
    }


    static private boolean isFloat(String input ) {
        try {
            Float.parseFloat(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isLastInputIsOperatorAndInputIsOperator( char input ) {
        if ( _currentInput.length() > 0 ) {
            return isOperator(_currentInput.charAt(_currentInput.length()-1)) && isOperator(input);
        }
        return false;
    }

    private boolean isVirguleAuthorised() {
        int i = _currentInput.length()-1;
        while ( i > 0 && !isOperator(_currentInput.charAt(i))) {
            if ( _currentInput.charAt(i) == '.' ) {
                return false;
            }
            i--;
        }
        return true;
    }

    public void parseInput(String text) throws ScriptException, ComputeIsDoneException {

        switch (text) {
            case "=":
                manageComputingAction();
                break;
            case "AC":
                manageClearingAction();
                break;
            case "Del":
                manageDeletingAction();
                break;
            case "( )":
                manageParenthesisAction();
                break;
            case ",":
                manageComaAction();
                break;
            default:
                manageDigitAction(text);
                break;
        }
    }

    private void manageDigitAction(String text) {
        if ( _currentInput.length() == 0 && text.charAt(0) != '-' && !isOperand(text.charAt(0)) ) {
            return;
        } else if ( _currentInput.length() == 1 && _currentInput.charAt(0) == '-' && isOperator(text.charAt(0))) {
            return;
        }
        if ( isLastInputIsOperatorAndInputIsOperator(text.charAt(0)) ) {
            _currentInput.deleteCharAt(_currentInput.length()-1);
        }
        _currentInput.append(text);
    }

    private void manageComaAction() {
        if(_currentInput.length() == 0 ) {
            _currentInput.append("0");
        } else if ( !isVirguleAuthorised() ) {
            return;
        }
        _currentInput.append(".");
    }

    private void manageParenthesisAction() {
        if ( _currentInput.length() == 0 ) {
            return;
        }
        char lastInput = _currentInput.charAt(_currentInput.length()-1);
        if ( isOperator(lastInput) || isOpenParenthesis(lastInput) ) {
            _numberParenthesesOpened++;
            _currentInput.append("(");
            return;
        }
        if ( (isOperand(lastInput) || isCloseParenthesis(lastInput)) && (_numberParenthesesOpened) == 0 ) {
            _numberParenthesesOpened++;
            _currentInput.append("x(");
            return;
        }
        if ( _numberParenthesesOpened  != 0 ) {
            _numberParenthesesOpened--;
            _currentInput.append(")");
        } else {
            _numberParenthesesOpened++;
            _currentInput.append("(");
        }
    }

    private void manageDeletingAction() {
        if ( _currentInput.length() == 0 ) {
            return;
        }
        _currentInput.deleteCharAt(_currentInput.length()-1);
    }

    private void manageClearingAction() {
        _currentInput = new StringBuilder();
    }

    private void manageComputingAction() throws ComputeIsDoneException, ScriptException {
        if ( _currentInput.length() == 0 || isFloat(_currentInput.toString()) ) {
            if ( _lastInputWithResult.length() == 0 ) {
                return;
            }
            _currentInput = new StringBuilder(_lastInputWithResult.toString().split("=")[1].trim());
            throw new ComputeIsDoneException();
        }
        _lastInputWithResult = new StringBuilder(_currentInput);
        _currentInput = new StringBuilder(Float.toString(Calculator.compute( toValidOperation())));
        _lastInputWithResult.append(" = ").append(_currentInput);
        System.out.println(_lastInputWithResult);
        throw new ComputeIsDoneException();
    }

    private String toValidOperation() {
        for ( int i = 0; i < _currentInput.length(); i++ ) {
            if ( _currentInput.charAt(i) == 'x' ) {
                _currentInput.setCharAt(i, '*');
            }
        }
        System.out.println(_currentInput.toString());
        return _currentInput.toString();
    }

    public void changeBase(String newBaseFromMenuItem, Map<String, Button> buttonMap) {
        _baseChain.handleRequest(Integer.parseInt(newBaseFromMenuItem), buttonMap);
    }

    public String updateResult() {
        return _currentInput.toString();
    }

    public String updatePreviousResult() {
        return _lastInputWithResult.toString();
    }
}

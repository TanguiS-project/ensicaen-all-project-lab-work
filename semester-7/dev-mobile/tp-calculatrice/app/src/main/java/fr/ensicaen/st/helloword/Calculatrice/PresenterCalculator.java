package fr.ensicaen.st.helloword.Calculatrice;

import javax.script.ScriptException;

public class PresenterCalculator {
    private StringBuilder _currentInput;
    private StringBuilder _lastInputWithResult;
    private short _numberParenthesesOpened;
    private boolean _isFirstParenthesis;


    public PresenterCalculator() {
        _currentInput = new StringBuilder();
        _numberParenthesesOpened = 0;
        _isFirstParenthesis = true;
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
                if ( _currentInput.length() == 0 || isFloat(_currentInput.toString()) ) {
                    if ( _lastInputWithResult.length() == 0 ) {
                        break;
                    }
                    _currentInput = new StringBuilder(_lastInputWithResult.toString().split("=")[1].trim());
                    throw new ComputeIsDoneException();
                }
                _lastInputWithResult = new StringBuilder(_currentInput);
                _currentInput = new StringBuilder(Float.toString(Calculator.compute( toValidOperation())));
                _lastInputWithResult.append(" = ").append(_currentInput);
                System.out.println(_lastInputWithResult);
                throw new ComputeIsDoneException();
            case "AC":
                _currentInput = new StringBuilder();
                _isFirstParenthesis = true;
                break;
            case "Del":
                if ( _currentInput.length() == 0 ) {
                    break;
                }
                _currentInput.deleteCharAt(_currentInput.length()-1);
                break;
            case "( )":
                char lastInput = _currentInput.charAt(_currentInput.length()-1);
                if ( isOperator(lastInput) || isOpenParenthesis(lastInput) ) {
                    _numberParenthesesOpened++;
                    _currentInput.append("(");
                    break;
                }
                if ( (isOperand(lastInput) || isCloseParenthesis(lastInput)) && (_numberParenthesesOpened) == 0 ) {
                    _numberParenthesesOpened++;
                    _currentInput.append("x(");
                    break;
                }
                if ( _numberParenthesesOpened  != 0 ) {
                    _numberParenthesesOpened--;
                    _currentInput.append(")");
                } else {
                    _numberParenthesesOpened++;
                    _currentInput.append("(");
                }
                break;
            case ",":
                if(_currentInput.length() == 0 ) {
                    _currentInput.append("0");
                } else if ( !isVirguleAuthorised() ) {
                    break;
                }
                _currentInput.append(".");
                break;
            default:
                if ( _currentInput.length() == 0 && text.charAt(0) != '-' && !isOperand(text.charAt(0)) ) {
                    break;
                } else if ( _currentInput.length() == 1 && _currentInput.charAt(0) == '-' && isOperator(text.charAt(0))) {
                    break;
                }
                if ( isLastInputIsOperatorAndInputIsOperator(text.charAt(0)) ) {
                    _currentInput.deleteCharAt(_currentInput.length()-1);
                }
                _currentInput.append(text);
                break;
        }
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

    public String updateResult() {
        return _currentInput.toString();
    }

    public String updatePreviousResult() {
        return _lastInputWithResult.toString();
    }
}

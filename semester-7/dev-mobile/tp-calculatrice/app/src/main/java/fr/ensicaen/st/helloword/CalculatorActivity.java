package fr.ensicaen.st.helloword;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptException;

import fr.ensicaen.st.helloword.Calculatrice.ComputeIsDoneException;
import fr.ensicaen.st.helloword.Calculatrice.PresenterCalculator;

public class CalculatorActivity extends AppCompatActivity {
    private Map<String, Button> _btList;
    private TextView _result;
    private TextView _previousResult;
    private PresenterCalculator _calculator;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        _calculator = new PresenterCalculator();
        getButton();
        _result = findViewById(R.id._result);
        _previousResult = findViewById(R.id._previousResult);
        setToolBar();
        addEventListener();
    }

    private void setToolBar() {
        Toolbar toolBar = findViewById(R.id._toolbarCalculator);
        toolBar.setTitle("Calculator");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        _calculator.changeBase(item.getTitle().toString(), _btList);
        return true;
    }

    private void addEventListener() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            _btList.forEach( (k, bt) -> bt.setOnClickListener( (v) -> {
                try {
                    _calculator.parseInput(bt.getText().toString());
                } catch (ScriptException e) {
                    Toast.makeText(v.getContext(), "/!\\ ERROR when COMPUTING /!\\", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                } catch (ComputeIsDoneException doneException) {
                    _previousResult.setText(_calculator.updatePreviousResult());
                }
                _result.setText(_calculator.updateResult());
            }));
        }
    }

    private void getButton() {
        _btList = new HashMap<>();
        _btList.put("0", findViewById(R.id._zero));
        _btList.put("1", findViewById(R.id._one) );
        _btList.put("2", findViewById(R.id._two) );
        _btList.put("3", findViewById(R.id._three) );
        _btList.put("4", findViewById(R.id._four) );
        _btList.put("5",findViewById(R.id._five) );
        _btList.put("6", findViewById(R.id._six) );
        _btList.put("7", findViewById(R.id._seven) );
        _btList.put("8", findViewById(R.id._eight) );
        _btList.put("9", findViewById(R.id._nine) );
        _btList.put("AC", findViewById(R.id._AC));
        _btList.put("()", findViewById(R.id._parentheses) );
        _btList.put("%", findViewById(R.id._pourc) );
        _btList.put("/", findViewById(R.id._div) );
        _btList.put("x", findViewById(R.id._multiplication) );
        _btList.put("-", findViewById(R.id._minus) );
        _btList.put("+",  findViewById(R.id._add) );
        _btList.put("=", findViewById(R.id._compute) );
        _btList.put("supp", findViewById(R.id._delete) );
        _btList.put(",", findViewById(R.id._virgule));
    }
}
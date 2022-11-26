package fr.ensicaen.st.helloword;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.util.ArraySet;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptException;

import fr.ensicaen.st.helloword.Calculatrice.ComputeIsDoneException;
import fr.ensicaen.st.helloword.Calculatrice.PresenterCalculator;

public class CalculatorActivity extends AppCompatActivity {
    private ArraySet<Button> _btList;
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
        setSupportActionBar(toolBar);
        ActionBar actionBar = getSupportActionBar();
        if ( actionBar != null ) {
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_base, menu);
        return true;
    }

    private void addEventListener() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            _btList.forEach( (bt) -> bt.setOnClickListener( (v) -> {
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            _btList = new ArraySet<>();
        }
        _btList.add( findViewById(R.id._zero) );
        _btList.add( findViewById(R.id._one) );
        _btList.add( findViewById(R.id._two) );
        _btList.add( findViewById(R.id._three) );
        _btList.add( findViewById(R.id._four) );
        _btList.add( findViewById(R.id._five) );
        _btList.add( findViewById(R.id._six) );
        _btList.add( findViewById(R.id._seven) );
        _btList.add( findViewById(R.id._eight) );
        _btList.add( findViewById(R.id._nine) );
        _btList.add( findViewById(R.id._AC));
        _btList.add( findViewById(R.id._parentheses) );
        _btList.add( findViewById(R.id._pourc) );
        _btList.add( findViewById(R.id._div) );
        _btList.add( findViewById(R.id._multiplication) );
        _btList.add( findViewById(R.id._minus) );
        _btList.add( findViewById(R.id._add) );
        _btList.add( findViewById(R.id._compute) );
        _btList.add( findViewById(R.id._delete) );
        _btList.add(findViewById(R.id._virgule));
    }
}
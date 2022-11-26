package fr.ensicaen.st.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button _bt;
    private Intent _calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _bt = findViewById(R.id._btCalc);
        _bt.setOnClickListener(v -> {
            if ( v == _bt ) {
                _calc = new Intent(this, CalculatorActivity.class);
                startActivity(_calc);
            }
        });
    }
}
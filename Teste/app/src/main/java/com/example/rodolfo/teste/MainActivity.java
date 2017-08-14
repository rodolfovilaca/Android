package com.example.rodolfo.teste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void soma(View view){
        EditText n1 = (EditText) findViewById(R.id.n1);
        int num1 =  Integer.parseInt(n1.getText().toString());
        EditText n2 = (EditText) findViewById(R.id.n2);
        int num2 =  Integer.parseInt(n2.getText().toString());

        int soma =  num1 + num2;

        Toast.makeText(this, "Resultado: "+soma, Toast.LENGTH_LONG).show();
    }
}

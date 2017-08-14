package com.example.rodolfo.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int CONSTANTE_TELA_UM = 1;
    public static final int CONSTANTE_TELA_DOIS = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendScrOne(View view){
        EditText n = (EditText) findViewById(R.id.nameText);
        EditText e =  (EditText) findViewById(R.id.emailText);

        Bundle params = new Bundle();
        params.putString("name", n.getText().toString());
        params.putString("email", e.getText().toString());
        Intent intent =  new Intent(this, Tela1.class);
        intent.putExtras(params);

        startActivityForResult(intent, CONSTANTE_TELA_UM);
    }
    public void sendScrTwo(View view){
        EditText n = (EditText) findViewById(R.id.nameText);
        EditText e =  (EditText) findViewById(R.id.emailText);

        Bundle params = new Bundle();
        params.putString("name", n.getText().toString());
        params.putString("email", e.getText().toString());
        Intent intent =  new Intent(this, Tela2.class);
        intent.putExtras(params);

        startActivityForResult(intent, CONSTANTE_TELA_DOIS);
    }
    protected void onActivityResult(int codigoTela, int resultado, Intent intent){
        if(codigoTela == CONSTANTE_TELA_UM){
            Bundle params = intent.getExtras();
            if(params != null){
                String msg = params.getString("msg");
                Toast.makeText(this,"Tela 1 Resultado: "+resultado+" | Msg: "+msg, Toast.LENGTH_LONG).show();
            }
        }

        if(codigoTela == CONSTANTE_TELA_DOIS){
            Bundle params = intent.getExtras();
            if(params != null){
                String msg = params.getString("msg");
            }
        }
    }
}

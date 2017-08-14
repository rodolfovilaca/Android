package com.example.rodolfo.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Tela1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        Intent intent = getIntent();
        if(intent != null){
            Bundle params =  intent.getExtras();
            if(params != null){
                String name = params.getString("name");
                String email = params.getString("email");

                TextView nameReceived = (TextView) findViewById(R.id.nameReceivedTela1);
                TextView emailReceived = (TextView) findViewById(R.id.emailReceivedTela1);
                nameReceived.setText("Nome: "+name);
                emailReceived.setText("Email:"+email);
            }
        }
    }

    public void aceitarTelaUm(View view){
        Intent intent = new Intent();
        intent.putExtra("msg", "aceitou");

        setResult(1, intent);
        finish();
    }

    public void rejeitarTelaUm(View view){
        Intent intent = new Intent();
        intent.putExtra("msg", "rejeitou");

        setResult(2, intent);
        finish();
    }
}

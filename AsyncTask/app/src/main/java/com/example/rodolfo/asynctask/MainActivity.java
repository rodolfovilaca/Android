package com.example.rodolfo.asynctask;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements TarefaInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void downloadImg(View view){
        Tarefa tarefa =  new Tarefa(this,this);
        tarefa.execute("http://www.thiengo.com.br/img/system/logo/thiengo-80-80.png");
    }

    @Override
    public void inserirMainThread(Bitmap img) {
        ImageView iv =  (ImageView) findViewById(R.id.imageView);
        iv.setImageBitmap(img);
    }
}

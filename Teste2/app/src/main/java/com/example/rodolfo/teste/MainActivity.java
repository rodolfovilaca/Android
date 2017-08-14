package com.example.rodolfo.teste;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {
    private Bitmap img;
    //private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //handler =  new Handler();
    }
    public void downloadImg(View view){
        final ProgressDialog progress =  new ProgressDialog(this);
        progress.setMessage("Carregando Imagem...");
        progress.show();

        new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    URL url = new URL("http://www.thiengo.com.br/img/system/logo/thiengo-80-80.png");
                    HttpURLConnection concection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = concection.getInputStream();
                    img = BitmapFactory.decodeStream(inputStream);
                }catch (IOException e){}

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progress.setMessage("Imagem Carregada!");
                        ImageView iv =  (ImageView) findViewById(R.id.imageView);
                        iv.setImageBitmap(img);
                        progress.dismiss();

                    }
                });
            }
        }.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Script", getClass().getName()+" stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Script", getClass().getName()+" destroy");
    }
}

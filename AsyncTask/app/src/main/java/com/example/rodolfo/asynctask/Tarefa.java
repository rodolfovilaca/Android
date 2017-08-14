package com.example.rodolfo.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Tarefa extends AsyncTask<String, String, Bitmap> {
    private ProgressDialog progress;
    private Context context;
    private TarefaInterface ti;


    public Tarefa(Context context, TarefaInterface ti){
        this.context = context;
        this.ti = ti;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progress =  new ProgressDialog(context);
        progress.setMessage("Carregando Imagem...");
        progress.show();
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap img = null;

        try{
            publishProgress("Ainda Carregando...");
            URL url = new URL(params[0]);
            HttpURLConnection concection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = concection.getInputStream();
            img = BitmapFactory.decodeStream(inputStream);
            publishProgress("Imagem Carregada!");
        }catch (IOException e){}
        return img;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        progress.setMessage(values[0]);
    }

    @Override
    protected void onPostExecute(Bitmap img) {
        super.onPostExecute(img);
        ti.inserirMainThread(img);
        progress.dismiss();
    }
}

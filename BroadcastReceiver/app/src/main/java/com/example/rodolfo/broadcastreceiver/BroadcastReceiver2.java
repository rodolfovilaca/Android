package com.example.rodolfo.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by conra on 01/03/2017.
 */

public class BroadcastReceiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Scipt", "BroadcastReceiver");
    }
}

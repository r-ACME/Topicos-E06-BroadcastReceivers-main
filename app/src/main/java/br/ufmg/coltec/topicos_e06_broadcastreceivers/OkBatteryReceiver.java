package br.ufmg.coltec.topicos_e06_broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

public class OkBatteryReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("BATTERY_CHANGE", "Bateria OK!");

        MainActivity main = (MainActivity) context;

        main.switchActivityTheme(R.style.Theme_TopicosE06BroadcastReceivers);
    }
}

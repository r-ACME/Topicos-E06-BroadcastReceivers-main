package br.ufmg.coltec.topicos_e06_broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

public class LowBatteryReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("BATTERY_CHANGE", "Bateria Fraca!");

            MainActivity main = (MainActivity) context;

            main.switchActivityTheme(R.style.Theme_TopicosE06BroadcastReceiversLowBattery);

        }
}


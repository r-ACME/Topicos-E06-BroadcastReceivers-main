package br.ufmg.coltec.topicos_e06_broadcastreceivers;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private static int CURRENT_THEME = R.style.Theme_TopicosE06BroadcastReceivers;

    LowBatteryReceiver lowBatteryReceiver = new LowBatteryReceiver();
    OkBatteryReceiver okBatteryReceiver = new OkBatteryReceiver();

    IntentFilter lowBatteryFilter = new IntentFilter(Intent.ACTION_BATTERY_LOW);
    IntentFilter okBatteryFilter = new IntentFilter(Intent.ACTION_BATTERY_OKAY);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTheme(CURRENT_THEME);
        setContentView(R.layout.activity_main);

        this.registerReceiver(lowBatteryReceiver, lowBatteryFilter);
        this.registerReceiver(okBatteryReceiver, okBatteryFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        this.unregisterReceiver(lowBatteryReceiver);
        this.unregisterReceiver(okBatteryReceiver);
    }

    /**
     * Realiza a troca do tema da Activity.
     *
     * Basicamente, esse método atualiza a variável estática responsável por definir o tema da
     * activity com o novo valor enviado por parâmetro, e recria toda a activity do zero para
     * que o novo tema seja aplicado.
     *
     * @param themeId Id do tema que será trocado.
     *                O parâmetro se refere ao ID que o tema possui na classe R.java.
     *                Para esse app específico, podemos informar dois possíveis IDs.
     *                - R.style.Theme_TopicosE06BroadcastReceivers (Tema padrão)
     *                - R.style.Theme_TopicosE06BroadcastReceiversLowBattery (bateria baixa)
     */
    void switchActivityTheme(int themeId) {

        CURRENT_THEME = themeId;
        MainActivity.this.finish();
        MainActivity.this.startActivity(new Intent(MainActivity.this, MainActivity.class));
    }
}
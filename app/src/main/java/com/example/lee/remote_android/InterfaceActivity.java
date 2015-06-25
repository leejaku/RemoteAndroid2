package com.example.lee.remote_android;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONObject;


public class InterfaceActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);
        //TextView t1 = (TextView) findViewById(R.id.txtprova);
       /* ListView v1 = (ListView) findViewById(R.id.listDevices);
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected = v1.getSelectedItemPosition();
            }
        });*/

        HttpLogin connection = HttpLogin.getLogin();
        HttpDevices elenco = new HttpDevices(connection.getUser(),connection.getPsw());
        elenco.inviaDati();
        while(elenco.finish()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
        String match = elenco.getStringa();
        Log.i("STRINGHE: ", match);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_interface, menu);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

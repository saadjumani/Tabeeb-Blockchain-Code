package com.example.hp.pharmacist;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;

import static android.content.ContentValues.TAG;

public class envoice extends AppCompatActivity {
String preID;
String amnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envoice);
    }
    public void onclick(View view){
   TextView prescID = findViewById(R.id.editText3);
            preID = String.valueOf(prescID.getText());
            TextView  ammount= findViewById(R.id.editText);
            amnt = String.valueOf(ammount.getText());

            new GetContacts().execute();
        }

    //
    class GetContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();


        }

        @Override
        protected Void doInBackground(Void... arg0) {
            Log.d(TAG, "function ke shrur mai");
            //Toast.makeText(MainActthis,"Requested",Toast.LENGTH_LONG).show();
            HttpHandler sh = new HttpHandler();
            String url = null;
        //    Toast.makeText(envoice.this,"Requested",Toast.LENGTH_LONG).show();
                url = "http://192.168.8.102:3004/api/"+preID+"/"+amnt;
                //  Toast.makeText(MainActivity.this,"Doctor Registered",Toast.LENGTH_LONG).show();

            String jsonStr = sh.makeServiceCall(url);
//            Toast.makeText(MainActivity.this,jsonStr,Toast.LENGTH_LONG).show();


            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }
}



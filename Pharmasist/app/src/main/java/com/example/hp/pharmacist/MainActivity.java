package com.example.hp.pharmacist;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "";
    prescription dt = null;
    String dID;
    String priscID;
    String prisc;

    TextView docID ;
    TextView patID ;
    TextView prescrip ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            ArrayList contactList = new ArrayList<>();
        docID = findViewById(R.id.textView7);
        patID = findViewById(R.id.textView8);
        prescrip = findViewById(R.id.textView9);
            //lv = (ListView) findViewById(R.id.list);

            //new GetContacts().execute();

            //response();
        }
        public void onclick(View v){
            TextView prisc = findViewById(R.id.editText2);
            priscID = String.valueOf(prisc.getText());
            new GetContacts().execute();
        }
        public void onclick2(View view){
            Intent myIntent = new Intent(view.getContext(), envoice.class);
            startActivityForResult(myIntent, 0);
        }


    //
    private class GetContacts extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();


        }

        @Override
        protected Void doInBackground(Void... arg0) {
            Log.d(TAG, "function ke shrur mai" );
            ObjectMapper mapper = new ObjectMapper();
        //    Toast.makeText(MainActivity.this,"Requested",Toast.LENGTH_LONG).show();
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "http://192.168.8.102:3000/api/Prescription/"+priscID;
            String jsonStr = sh.makeServiceCall(url);
//            Toast.makeText(MainActivity.this,jsonStr,Toast.LENGTH_LONG).show();
//            Log.d(TAG, jsonStr);
            try {
                Log.d(TAG, "yaha tak pohach rha hai");
                Log.d(TAG, "Response from url: " + jsonStr);
                //Toast.makeText(MainActivity.this,jsonStr,Toast.LENGTH_LONG).show();
                dt = mapper.readValue(jsonStr,prescription.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Log.e(TAG, "Response from url: " + jsonStr);
            try {
                String st = mapper.writeValueAsString(prescription.class);

            } catch (IOException e) {
                e.printStackTrace();

            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            docID.setText("Doctor Name: "+dt.doctor_id);
            patID.setText("Patient Name: "+dt.patient_id);
            prescrip.setText("Description: "+dt.prescription_data);
        }
    }
}

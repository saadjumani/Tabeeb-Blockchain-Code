package com.example.hp.doctorapp;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    String doctorID;
    String patient_ID;
    String prescriptionid;
    String prescriptionData;
    FileInputStream in = null;
    FileOutputStream out = null;
    Typeface typeface;
    //TextView prescription_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         typeface= Typeface.createFromAsset(getAssets(), "fonts/font.ttf");

    }
    //response();

    public void onClick(View v) throws FileNotFoundException {


        String name="Jumani";
        String pr = "10024";
        TextView Patiant_id = findViewById(R.id.editText2);
        Patiant_id.setTypeface(typeface);
        patient_ID = String.valueOf(Patiant_id.getText());
        int co = Integer.parseInt(String.valueOf(Patiant_id.getText()));
        co = co /2;
        pr=Integer.toString(co);
        Log.d(TAG, "+++++++++++++"+co);
        TextView doc_ID = findViewById(R.id.textView7);
        doc_ID.setTypeface(typeface);
        doc_ID.setText("Doctor ID: "+name);
        doctorID = name;

        TextView prescription_id  = findViewById(R.id.textView8);
        prescription_id.setTypeface(typeface);
        prescription_id .setText("Prescription ID: "+pr);
        prescriptionid= pr;

        TextView prescription_Data = findViewById(R.id.editDescription);
        prescriptionData = String.valueOf(prescription_Data.getText());

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
            // Making a request to url and getting response
            String url = "http://192.168.8.102:3001/api/"+prescriptionid+"/"+patient_ID+"/"+doctorID+"/"+prescriptionData;
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


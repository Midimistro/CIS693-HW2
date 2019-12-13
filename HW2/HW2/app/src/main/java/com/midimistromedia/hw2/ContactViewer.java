package com.midimistromedia.hw2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class ContactViewer extends AppCompatActivity {
    protected TextView fnTitle;
    protected TextView fnText;
    protected TextView lnTitle;
    protected TextView lnText;
    protected TextView emlTitle;
    protected TextView emlText;
    protected TextView phnTitle;
    protected TextView phnText;
    protected Intent data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get Views
        setContentView(R.layout.activity_contact_viewer);
        fnTitle = findViewById(R.id.firstNameTitle);
        fnText = findViewById(R.id.firstNameText);
        lnTitle = findViewById(R.id.lastNameTitle);
        lnText = findViewById(R.id.lastNameText);
        emlTitle = findViewById(R.id.emailTitle);
        emlText = findViewById(R.id.emailText);
        phnTitle = findViewById(R.id.phoneTitle);
        phnText = findViewById(R.id.phoneText);
        data2=getIntent();
        String jsonMyObject = null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            jsonMyObject = extras.getString("myObject");
        }
        Contact myObject = new Gson().fromJson(jsonMyObject, Contact.class);
        fnText.setText(myObject.firstName);
        lnText.setText(myObject.lastName);
        emlText.setText(myObject.email);
        phnText.setText(myObject.phoneNumber);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (1001): {
                String jsonMyObject = null;
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    jsonMyObject = extras.getString("myObject");
                }
                Contact myObject = new Gson().fromJson(jsonMyObject, Contact.class);
                fnText.setText(myObject.firstName);
                lnText.setText(myObject.lastName);
                emlText.setText(myObject.email);
                phnText.setText(myObject.phoneNumber);
            }
        }
    }
}

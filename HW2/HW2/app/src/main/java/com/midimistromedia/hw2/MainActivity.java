package com.midimistromedia.hw2;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contact> contacts = new ArrayList<>();
    ListView contactList;
    ContactAdapter contactAdapter;
    TextView noList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactList = findViewById(R.id.ContactList);
        final ImageButton addContactButton = findViewById(R.id.AddNewContactButton);
        noList = findViewById(R.id.NoEntriesText);

        contactAdapter = new ContactAdapter(this,contacts);
        contactList.setAdapter(contactAdapter);
        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Dessert dessert = desserts.get(i);
                Intent viewContact = new Intent(MainActivity.this, ContactViewer.class);
                viewContact.putExtra("myObject", new Gson().toJson(contacts.get(i)));
                startActivityForResult(viewContact,1002);
            }
        });


        addContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AddContact = new Intent(MainActivity.this,addContact.class);
                startActivityForResult(AddContact,1001);
            }
        });
    }

    //Retrieve new json instance on finish of add
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //If add activity, add accordingly
        switch (requestCode){
            case(1001):
            {
                if (resultCode == Activity.RESULT_OK) {
                    String jsonMyObject = null;
                    Bundle extras = data.getExtras();
                    if (extras != null) {
                        jsonMyObject = extras.getString("myObject");
                    }
                    Contact myObject = new Gson().fromJson(jsonMyObject, Contact.class);
                    contacts.add(myObject);
                    contactAdapter.notifyDataSetChanged();

                }
                break;
            }
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(contacts.isEmpty()){
            //If no contacts
            noList.setText("Sorry, no contacts");
        }else {
            //else 'hide'
            noList.setText("");
        }
    }
}
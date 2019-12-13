package com.midimistromedia.hw2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

public class addContact extends AppCompatActivity {
    protected Contact newContact;
    protected String fn;
    protected String ln;
    protected String eml;
    protected String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        //Get layout details:
        final EditText firstName = findViewById(R.id.firstNameInput);
        final EditText lastName = findViewById(R.id.lastNameInput);
        final EditText email = findViewById(R.id.emailInput);
        final EditText phoneNumber = findViewById(R.id.phoneInput);
        Button addNewContactButton = findViewById(R.id.addContactButton);

        //Set Onlick Listener:
        addNewContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add values to new contact
                newContact = new Contact(firstName.getText().toString(),lastName.getText().toString(),email.getText().toString(),phoneNumber.getText().toString());
               /* newContact.firstName=firstName.getText().toString();
                newContact.lastName=lastName.getText().toString();
                newContact.email=email.getText().toString();
                newContact.phoneNumber = phoneNumber.getText().toString();*/

                //Go back to main and provide new contact instance via json
                Intent backToMain = new Intent();
                backToMain.putExtra("myObject", new Gson().toJson(newContact));
                setResult(Activity.RESULT_OK,backToMain);
                finish();
                //startActivityForResult(backToMain,1001);
            }
        });
    }
}

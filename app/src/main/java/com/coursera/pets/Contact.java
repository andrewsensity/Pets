package com.coursera.pets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class Contact extends AppCompatActivity {

    private Button btnSendMessage;
    private TextInputEditText itName, itEmail, itMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnSendMessage = (Button) findViewById(R.id.btnSendMessage);
        itName = (TextInputEditText) findViewById(R.id.itName);
        itEmail = (TextInputEditText) findViewById(R.id.itEmail);
        itMessage = (TextInputEditText) findViewById(R.id.itMessage);

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto: " + itEmail.getText().toString()));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Mensaje de " + itName.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, itMessage.getText().toString());
                startActivity(intent);
            }
        });
    }
}
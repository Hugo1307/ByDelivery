package com.example.bydelivery_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private String clientEmail = "";
    private String clientPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView t2 = (TextView) findViewById(R.id.label_login_sabermais);
        t2.setMovementMethod(LinkMovementMethod.getInstance());

    }

    public void efetuarLogin(View v){

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        EditText textBoxEmail = (EditText) findViewById(R.id.textbox_login_email);
        EditText textBoxPassword = (EditText) findViewById(R.id.textbox_login_password);

        clientEmail = textBoxEmail.getText().toString();
        clientPassword = textBoxPassword.getText().toString();

        this.finish();

    }

}

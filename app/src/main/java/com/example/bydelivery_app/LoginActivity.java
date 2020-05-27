package com.example.bydelivery_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView t2 = (TextView) findViewById(R.id.label_login_sabermais);
        t2.setMovementMethod(LinkMovementMethod.getInstance());

    }

    public void efetuarLogin(View v){

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

    }

}

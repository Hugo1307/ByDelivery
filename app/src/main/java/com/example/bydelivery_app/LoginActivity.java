package com.example.bydelivery_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bydelivery_app.handlers.Conta;
import com.example.bydelivery_app.handlers.ContasList;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView t2 = (TextView) findViewById(R.id.label_login_sabermais);
        t2.setMovementMethod(LinkMovementMethod.getInstance());

    }

    public void efetuarLogin(View v){

        EditText textBoxEmail = (EditText) findViewById(R.id.textbox_login_email);
        EditText textBoxPassword = (EditText) findViewById(R.id.textbox_login_password);
        boolean wrongCredentials = false;

        for (Conta c : ContasList.getAllAccounts()){

            if (c.getEmail().equals(textBoxEmail.getText().toString())) {
                if (c.getPassword().equals(textBoxPassword.getText().toString())) {
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    ContasList.setCurrentAccount(c);
                    this.finish();
                    return;
                }
            }

        }

        Toast.makeText(this, "Credenciais inválidas", Toast.LENGTH_SHORT).show();

    }

}

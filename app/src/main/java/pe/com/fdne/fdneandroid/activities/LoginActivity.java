package pe.com.fdne.fdneandroid.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pe.com.fdne.fdneandroid.R;

public class LoginActivity extends AppCompatActivity {
    EditText txtUsername;
    EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtUsername = (EditText) findViewById(R.id.usernameInput);
        txtPassword = (EditText) findViewById(R.id.passwordInput);

        Button logInBtn = (Button) findViewById(R.id.btnLogIn);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean hasError = false;
                if(TextUtils.isEmpty(txtUsername.getText())) {
                    txtUsername.setError("Es Obligatorio!");
                    hasError = true;
                }
                if(TextUtils.isEmpty(txtPassword.getText())) {
                    txtPassword.setError("Es Obligatorio!");
                    hasError = true;
                }
                if(hasError) return;
                if(!TextUtils.equals(txtUsername.getText(),"jinete") || !TextUtils.equals(txtPassword.getText(), "123")) {
                    Snackbar.make(v, "Login incorrecto!", Snackbar.LENGTH_LONG).show();
                    return;
                }
                Context context = v.getContext();
                Intent intent = new Intent(context, PerformanceActivity.class);
                context.startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}

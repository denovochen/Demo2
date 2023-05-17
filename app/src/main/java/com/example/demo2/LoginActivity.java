package com.example.demo2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    Button mButtonRegister;
    TextView mTextViewRegister;
    DatabaseHelper db;
    SharedPreferences sprfMain;
    SharedPreferences.Editor editorMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sprfMain = this.getSharedPreferences("counter", Context.MODE_PRIVATE);

        EditText edittextusername = (EditText) findViewById(R.id.edittext_username);
        Drawable drawable1 = getResources().getDrawable(R.drawable.user_name);
        ((Drawable) drawable1).setBounds(0, 0, 70, 70);
        edittextusername.setCompoundDrawables(drawable1, null, null, null);

        EditText edittextpassword = (EditText) findViewById(R.id.edittext_password);
        Drawable drawable2 = getResources().getDrawable(R.drawable.user_password);
        ((Drawable) drawable2).setBounds(0, 0, 70, 70);
        edittextpassword.setCompoundDrawables(drawable2, null, null, null);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText) findViewById(R.id.edittext_username);
        mTextPassword = (EditText) findViewById(R.id.edittext_password);
        mButtonLogin = (Button) findViewById(R.id.button_login);
        mButtonRegister = (Button) findViewById(R.id.button_register_login);
        mTextViewRegister = (TextView) findViewById(R.id.textview_register);
        mTextViewRegister.setOnClickListener(view -> {
            Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(registerIntent);
        });


        if (sprfMain.getBoolean("loginState", false)) {
            Intent HomePage = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(HomePage);
            finish();
        }

        mButtonLogin.setOnClickListener(view -> {
            String user = mTextUsername.getText().toString().trim();
            String pwd = mTextPassword.getText().toString().trim();
            Boolean res = db.checkUser(user, pwd);
            if (res == true) {
                Intent HomePage = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(HomePage);

                editorMain = sprfMain.edit();
                editorMain.putBoolean("loginState", true);
                editorMain.commit();

                finish();
            } else {
                Toast.makeText(LoginActivity.this, "用户名或密码错误，请重新登陆！", Toast.LENGTH_SHORT).show();
            }
        });

        mButtonRegister.setOnClickListener(view -> {
            Intent RegisterPage = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(RegisterPage);
        });
    }
}

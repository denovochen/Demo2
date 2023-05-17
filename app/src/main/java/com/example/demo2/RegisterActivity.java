package com.example.demo2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText edittextusername = (EditText) findViewById(R.id.edittext_username);
        Drawable drawable1 = getResources().getDrawable(R.drawable.user_name);
        ((Drawable) drawable1).setBounds(0, 0, 70, 70);
        edittextusername.setCompoundDrawables(drawable1, null, null, null);

        EditText edittextpassword = (EditText) findViewById(R.id.edittext_password);
        Drawable drawable2 = getResources().getDrawable(R.drawable.user_password);
        ((Drawable) drawable2).setBounds(0, 0, 70, 70);
        edittextpassword.setCompoundDrawables(drawable2, null, null, null);

        EditText edittextcnfpassword = (EditText) findViewById(R.id.edittext_cnf_password);
        Drawable drawable3 = getResources().getDrawable(R.drawable.user_password);
        ((Drawable) drawable3).setBounds(0, 0, 70, 70);
        edittextcnfpassword.setCompoundDrawables(drawable3, null, null, null);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText) findViewById(R.id.edittext_username);
        mTextPassword = (EditText) findViewById(R.id.edittext_password);
        mTextCnfPassword = (EditText) findViewById(R.id.edittext_cnf_password);
        mButtonRegister = (Button) findViewById(R.id.button_register);
        mTextViewLogin = (TextView) findViewById(R.id.textview_login);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(LoginIntent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextCnfPassword.getText().toString().trim();
                if (user.length() == 0 || pwd.length() == 0 || cnf_pwd.length() == 0) {
                    Toast.makeText(RegisterActivity.this, "请输入用户名和密码!", Toast.LENGTH_SHORT).show();
                } else {
                    if (pwd.equals(cnf_pwd)) {
                        long val = db.addUser(user, pwd);
                        if (val > 0) {
                            Toast.makeText(RegisterActivity.this, "注册成功。", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, "注册失败!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "两次密码输入不一致，请重新输入。", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
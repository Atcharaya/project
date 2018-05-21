package com.example.asus.project;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

public class LoginActivity extends AppCompatActivity {

    private EditText eUserName, ePassWord;
    private Button btnLogin;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eUserName = (EditText) findViewById(R.id.userName);
        ePassWord = (EditText) findViewById(R.id.passWord);
        btnLogin  = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                iniciar();
            }
        });
    }

    private void iniciar() {
        if (!valider()) return;

        username = eUserName.getText().toString();
        password = ePassWord.getText().toString();

        if (username.equals("admin") && password.equals("admin")){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private boolean valider() {
        boolean valid = true;

        String username = eUserName.getText().toString();
        String password = ePassWord.getText().toString();

        if (username.isEmpty() || !username.equals("admin")){
            eUserName.setError("ชื่อผู้ใช้ไม่ถูกต้อง");
            valid = false;
        }else{
            eUserName.setError(null);
        }

        if (password.isEmpty() || !password.equals("admin")){
            ePassWord.setError("รหัสผ่านไม่ถูกต้อง");
            valid = false;
        }else{
            ePassWord.setError(null);
        }

        return valid;
    }
}


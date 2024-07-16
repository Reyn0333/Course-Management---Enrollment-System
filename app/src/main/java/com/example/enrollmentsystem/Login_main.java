package com.example.enrollmentsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.enrollmentsystem.ui.AdminNavigation_main;
import com.example.enrollmentsystem.ui.InstructorNavigation_main;
import com.example.enrollmentsystem.ui.RegistrarNavigation_main;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_main extends AppCompatActivity {
    private Button button;
    private ApiService apiService;
    private EditText usernameEditText;
    private EditText passwordEditText;

    private static final String Username1 = "admin";
    private static final String Password1 = "admin";

    private  static final String Username2 = "registrar";
    private static final  String Password2 = "registrar";

    private static final String Username3 = "instructor";
    private  static final  String Password3 = "instructor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_main);

        button = findViewById(R.id.login_button);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.equals(Username1) && password.equals(Password1)) {
                    Intent intent = new Intent(Login_main.this, AdminNavigation_main.class);
                    startActivity(intent);
                    finish();
                } else if (username.equals(Username2) && password.equals(Password2)) {
                    Intent intent = new Intent(Login_main.this, RegistrarNavigation_main.class);
                    startActivity(intent);
                    finish();
                } else if (username.equals(Username3) && password.equals(Password3)) {
                    Intent intent = new Intent(Login_main.this, InstructorNavigation_main.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(Login_main.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}



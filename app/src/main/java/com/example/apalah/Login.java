package com.example.apalah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = findViewById(R.id.email);
        etPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tv_register);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to register activity
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }
    private void loginUser() {
        // Get values from edit texts
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Validate inputs
        if (TextUtils.isEmpty(username)) {
            etUsername.setError("Username is required");
            etUsername.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return;
        }

        // Perform login authentication
        // For this example, we'll use a simple hardcoded check
        // In a real app, you would validate against a database or API
        if (username.equals("admin") && password.equals("password123")) {
            // Successful login
            Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();

            // Navigate to main activity
            Intent intent = new Intent(Login.this, MainActivity.class);
            intent.putExtra("USERNAME", username);
            startActivity(intent);
            finish();  // Prevents going back to login screen with back button
        } else {
            // Failed login
            Toast.makeText(Login.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
        }
    }
}

package com.example.parcial_testeos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usuarioEditText, passwordEditText;
    Button btn_ingresar;
    private static final String user = "canius";
    private static final String password = "1104";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioEditText = findViewById(R.id.nombreEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        btn_ingresar = findViewById(R.id.btn_ingresar);

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usuarioEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.equals(user) && password.equals(password)) {
                    Intent intent = new Intent(MainActivity.this, Registros.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
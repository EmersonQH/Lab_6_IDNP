package com.example.lab_6_idnp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button botonBarra, botonCircular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonBarra = findViewById(R.id.buttonBarra);
        botonCircular = findViewById(R.id.buttonCicular);

        botonBarra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GraficoBarraActivity.class);
                startActivity(intent);
            }
        });
        botonCircular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GraficoCircularActivity.class);
                startActivity(intent);
            }
        });
    }
}
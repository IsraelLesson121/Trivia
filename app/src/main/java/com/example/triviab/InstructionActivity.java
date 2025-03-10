package com.example.triviab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InstructionActivity extends AppCompatActivity implements View.OnClickListener {
     private Button btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

            btnReturn = findViewById(R.id.btnReturn);
            btnReturn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        finish();
    }
}
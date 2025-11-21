package com.example.myapplicationmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivitySetting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_setting);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        Intent intent = getIntent();
        String message = intent.getExtras().getString("USER_NAME");
        TextView textView3 = findViewById(R.id.textView3);
        textView3.setText(message);


        Switch switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                textView3.setVisibility(View.GONE);
            } else {
                textView3.setVisibility(View.VISIBLE);
            }
        });
    }
}
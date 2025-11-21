package com.example.myapplicationmenu;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplicationmenu.utils.DateUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_test;
    private Button btn_test;
    private String user_name = "Cheung Yu Kei 22056946s";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_enable = findViewById(R.id.btn_enable);
        Button btn_disable = findViewById(R.id.btn_disable);
        Button btn_intent = findViewById(R.id.btn_intent);
        btn_test = findViewById(R.id.btn_test);
        tv_test = findViewById(R.id.tv_test);

        btn_enable.setOnClickListener(this);
        btn_disable.setOnClickListener(this);
        btn_intent.setOnClickListener(this);
        btn_test.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.new_menu, menu);
        Toast.makeText(this, "menu created", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, MainActivitySetting.class);
            intent.putExtra("USER_NAME", user_name);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_search) {
            Toast.makeText(this, "Search selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        String phoneNo = "11112515";
        int id = v.getId();
        if (id == R.id.btn_enable) {
            tv_test.setText("Test Button enabled");
            btn_test.setEnabled(true);
            btn_test.setTextColor(Color.BLACK);
        } else if (id == R.id.btn_disable) {
            tv_test.setText("Test Button disabled");
            btn_test.setEnabled(false);
            btn_test.setTextColor(Color.GRAY);
        }else if (id == R.id.btn_test) {
            String desc = String.format("%s you pressed: %s", DateUtil.getNowTime(), ((Button) v).getText());
            tv_test.setText(desc);
        }else if (id == R.id.btn_intent) {
            //dial
            intent.setAction(Intent.ACTION_DIAL);
            //set Uri
            //Uri uri = Uri.parse("tel:" + phoneNo);
            //claim Uri
            Uri uri_answer = Uri.parse("tel:" + phoneNo);
            intent.setData(uri_answer);
            startActivity(intent);

        }
    }
}
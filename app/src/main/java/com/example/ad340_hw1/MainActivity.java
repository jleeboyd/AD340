package com.example.ad340_hw1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            Context context = getApplicationContext();
            public void onClick(View v) {
                Toast toast = Toast.makeText(this.context, R.string.Question, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}

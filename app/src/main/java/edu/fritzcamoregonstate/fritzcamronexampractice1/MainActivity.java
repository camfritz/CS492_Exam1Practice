package edu.fritzcamoregonstate.fritzcamronexampractice1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button mMangleButton;
    private EditText mFirstNameText;

    private String[] lastNames = new String[] {
            "Simmons",
            "Matthews",
            "Rubin",
            "Nichols",
            "Blair"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMangleButton = (Button) findViewById(R.id.mangle_button);
        mFirstNameText = (EditText) findViewById(R.id.first_name_field);

        mMangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomNumber = random.nextInt(4 + 1 - 0);

                Intent intent = MangleActivity.newIntent(MainActivity.this, lastNames[randomNumber], mFirstNameText.getText().toString(), lastNames);
                startActivity(intent);
            }
        });
    }
}

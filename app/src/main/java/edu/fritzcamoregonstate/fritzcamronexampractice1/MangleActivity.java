package edu.fritzcamoregonstate.fritzcamronexampractice1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MangleActivity extends AppCompatActivity {

    private static final String EXTRA_MANGLE_CONCAT = "edu.fritzcamoregonstate.fritzcamronexampractice1.mangle_name_concat";
    private static final String EXTRA_MANGLE_FIRST = "edu.fritzcamoregonstate.fritzcamronexampratice1.mangle_name_first";
    private static final String EXTRA_MANGLE_ARRAY = "edu.fritzcamoregonstate.fritzcamronexampratice1.mangle_name_array";

    private TextView mMangledNameView;
    private Button mMangleRepeatButton;
    private Button mResetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangle);

        mMangledNameView = (TextView) findViewById(R.id.mangled_name);
        mMangleRepeatButton = (Button) findViewById(R.id.remangle_button);
        mResetButton = (Button) findViewById(R.id.reset_button);

        mMangledNameView.setText(getIntent().getStringExtra(EXTRA_MANGLE_FIRST) + " " + getIntent().getStringExtra(EXTRA_MANGLE_CONCAT));


        //set listener for re-mangle button
        mMangleRepeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if mangle button is clicked, set text to a random last name in array sent from parent.
                Random random = new Random();
                int randomNumber = random.nextInt(4 + 1 - 0);

                mMangledNameView.setText(getIntent().getStringExtra(EXTRA_MANGLE_FIRST) + " " + getIntent().getStringArrayExtra(EXTRA_MANGLE_ARRAY)[randomNumber]);
            }
        });

        //set listener for reset button
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resetIntent = new Intent(MangleActivity.this, MainActivity.class);
                startActivity(resetIntent);
            }
        });

    }

    public static Intent newIntent(Context packageContext, String newNameAddition, String firstName, String[] namesArray) {
        Intent intent = new Intent(packageContext, MangleActivity.class);
        intent.putExtra(EXTRA_MANGLE_CONCAT, newNameAddition);
        intent.putExtra(EXTRA_MANGLE_FIRST, firstName);
        intent.putExtra(EXTRA_MANGLE_ARRAY, namesArray);
        return intent;
    }
}

package edu.fritzcamoregonstate.fritzcamronexampractice1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MangleActivity extends AppCompatActivity {

    private static final String EXTRA_MANGLE_CONCAT = "edu.fritzcamoregonstate.fritzcamronexampractice1.mangle_name_concat";
    private static final String EXTRA_MANGLE_FIRST = "edu.fritzcamoregonstate.fritzcamronexampratice1.mangle_name_first";

    private TextView mMangledNameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangle);

        mMangledNameView = (TextView) findViewById(R.id.mangled_name);

        mMangledNameView.setText(getIntent().getStringExtra(EXTRA_MANGLE_FIRST) + " " + getIntent().getStringExtra(EXTRA_MANGLE_CONCAT));

    }

    public static Intent newIntent(Context packageContext, String newNameAddition, String firstName) {
        Intent intent = new Intent(packageContext, MangleActivity.class);
        intent.putExtra(EXTRA_MANGLE_CONCAT, newNameAddition);
        intent.putExtra(EXTRA_MANGLE_FIRST, firstName);
        return intent;
    }
}

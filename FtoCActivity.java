package com.example.ctofconverter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ctofconverter.databinding.ActivityFtoCactivityBinding;

import java.util.Locale;

public class FtoCActivity extends AppCompatActivity {

    private static final String CONVERTED_VALUE_EXTRA_KEY = "FtoCActivity_Received_Value";

    ActivityFtoCactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFtoCactivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setContentView(R.layout.activity_fto_cactivity);

        double fahrenheit = getIntent().getDoubleExtra(CONVERTED_VALUE_EXTRA_KEY, 0.0);

        binding.FoCEditText.setText(String.format(Locale.ENGLISH, "%.2f",fahrenheit));

        binding.FtoCTitleTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = MainActivity.MainActivityIntentFactory(getApplicationContext(), 42.0);
                startActivity(intent);
                return false;
            }
        });
    }

    public static Intent fToCIntentFactory(Context context, double fahrenheitValue) {
        Intent intent = new Intent(context, FtoCActivity.class);
        intent.putExtra(CONVERTED_VALUE_EXTRA_KEY, fahrenheitValue);
        return intent;
    }
}
package com.han.popuptest;

import android.os.Bundle;
import android.telecom.Call;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.han.popuptest.R;

public class AnimationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

    }

    @Override
    public void onBackPressed() {
        finish();
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.right_in, R.anim.right_out);
    }
}

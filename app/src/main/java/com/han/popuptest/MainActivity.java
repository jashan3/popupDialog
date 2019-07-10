package com.han.popuptest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.button2)
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.button1) public void clickButton1(){
        new PopupDialog(this).show();
    }
    @OnClick(R.id.button2) public void clickButton2(){
        Intent intent = new Intent(this,PopupActivity.class);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, button2, "myTransition");
        startActivity(intent,options.toBundle());
    }
    @OnClick(R.id.button3) public void clickButton3(){
        makeToast();
    }
    @OnClick(R.id.button4) public void clickButton4(){
        makeToast();
    }
    @OnClick(R.id.button5) public void clickButton5(){
        makeToast();
    }
    @OnClick(R.id.button6) public void clickButton6(){
        makeToast();
    }

    public void makeToast(){
        Toast.makeText(this, "???", Toast.LENGTH_SHORT).show();
    }
}

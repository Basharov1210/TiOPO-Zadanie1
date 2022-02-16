package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Activity2 extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        getSupportActionBar().hide();

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BodyBtn:
                Intent intent3 = new Intent(this, TopicActivity.class);
                intent3.putExtra(TopicActivity.TOPIC_CODE,1);
                startActivity(intent3);
                break;
            case R.id.WhetherBtn:
                Intent intent4 = new Intent(this, TopicActivity.class);
                intent4.putExtra(TopicActivity.TOPIC_CODE,4);
                startActivity(intent4);
                break;
            case R.id.BugBtn:
                Intent intent5 = new Intent(this, TopicActivity.class);
                intent5.putExtra(TopicActivity.TOPIC_CODE, 2);
                startActivity(intent5);
                break;
            case R.id.FoodBtn:
                Intent intent7 = new Intent(this, TopicActivity.class);
                intent7.putExtra(TopicActivity.TOPIC_CODE, 3);
                startActivity(intent7);
                break;
            case R.id.Grammar:
                Intent Gram = new Intent(this, AddDB.class);
                startActivity(Gram);
                break;
            default:
                break;
        }

    }

}
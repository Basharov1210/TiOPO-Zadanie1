package com.example.learnlanguage;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import java.util.List;

public class TestActivity extends AppCompatActivity implements TestFragment.Next {
    private List<Words> words;
    private int code;
    private static int position=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        code = getIntent().getIntExtra(TopicActivity.TOPIC_CODE, -1);
        words = Room.databaseBuilder(this , WordsDatabase.class , "Words.db").allowMainThreadQueries().build().getWordsDao().getWordsTopic(code);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment);

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment==null) {
            fragment = createFragment(position);
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }


    public Fragment createFragment(int position) {
        return new TestFragment(position, code,words);
    }

    @Override
    public void nextQuestion() {
        if (position<words.size()-1) {
            position++;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TestFragment(position,code,words)).commit();
        }
        else {position=0;
        exitTest();}
    }

    @Override
    public void exitTest() {

        Intent intent = new Intent(this,TopicActivity.class);
        intent.putExtra(TopicActivity.TOPIC_CODE,code);
        startActivity(intent);
    }



}

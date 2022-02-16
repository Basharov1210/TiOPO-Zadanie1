package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class AddDB extends AppCompatActivity{

    private EditText edtTranWord, edtTrueWord, edtFalseWord1, edtFalseWord2, edtFalseWord3, edtTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_d_b);
        getSupportActionBar().hide();

        edtTranWord = findViewById(R.id.edtTranWord);
        edtTrueWord = findViewById(R.id.edtTrueWord);
        edtFalseWord1 = findViewById(R.id.edtFalseWord1);
        edtFalseWord2 = findViewById(R.id.edtFalseWord2);
        edtFalseWord3 = findViewById(R.id.edtFalseWord3);
        edtTopic = findViewById(R.id.edtTopic);


        Button btnAdd = findViewById(R.id.AddDBbtn);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            Words words;

            @Override
            public void onClick(View v) {

                if (edtTranWord.getText().length() == 0) {
                    Toast t = Toast.makeText(getApplicationContext(), "Введите слово на Английском!", Toast.LENGTH_LONG);
                    t.show();
                } else {

                    words = new Words(edtTranWord.getEditableText().toString(), edtTrueWord.getEditableText().toString(),
                            edtFalseWord1.getEditableText().toString(), edtFalseWord2.getEditableText().toString(),
                            edtFalseWord3.getEditableText().toString(), Integer.parseInt(edtTopic.getEditableText().toString()));
                    MainActivity.newDatabase().getWordsDao().insertWords(words);

                    Toast toastShow = Toast.makeText(getApplicationContext(), "Загрузка прошла успешно", Toast.LENGTH_SHORT);
                    toastShow.show();
                    edtTranWord.setText("");
                    edtTrueWord.setText("");
                    edtFalseWord1.setText("");
                    edtFalseWord2.setText("");
                    edtFalseWord3.setText("");
                    edtTopic.setText("");
                }
            }
        });



    }
}
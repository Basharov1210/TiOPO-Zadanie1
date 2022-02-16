package com.example.learnlanguage;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;
import androidx.room.Entity;


@Entity
public class Words{
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "TransWord")
    public String TransWord;

    @ColumnInfo(name = "TrueWord")
    public String TrueWord;

    @ColumnInfo(name = "FalseWord1")
    public String FalseWord1;

    @ColumnInfo(name = "FalseWord2")
    public String FalseWord2;

    @ColumnInfo(name = "FalseWord3")
    public String FalseWord3;

    @ColumnInfo(name = "Topic")
    public int Topic;

    public Words(@NonNull String TransWord, String TrueWord, String FalseWord1, String FalseWord2, String FalseWord3, int Topic) {
        this.TransWord = TransWord;
        this.TrueWord = TrueWord;
        this.FalseWord1 = FalseWord1;
        this.FalseWord2 = FalseWord2;
        this.FalseWord3 = FalseWord3;
        this.Topic = Topic;
    }

}

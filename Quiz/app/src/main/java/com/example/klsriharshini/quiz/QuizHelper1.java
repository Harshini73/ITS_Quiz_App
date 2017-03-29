package com.example.klsriharshini.quiz;

/**
 * Created by K L SRIHARSHINI on 10-02-2017.
 */

import java.util.ArrayList;

import java.util.List;

import android.content.ContentValues;

import android.content.Context;

import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class QuizHelper1 extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "english";

    private static final String TABLE_QUEST = "quest";

    private static final String KEY_ID = "qid";

    private static final String KEY_QUES = "question";

    private static final String KEY_ANSWER = "answer"; // correct option

    private static final String KEY_OPTA = "opta"; // option a

    private static final String KEY_OPTB = "optb"; // option b

    private static final String KEY_OPTC = "optc"; // option c

    private SQLiteDatabase dbase;

    public QuizHelper1(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    //@Override

    public void onCreate(SQLiteDatabase db) {

        dbase = db;

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "

                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES

                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "

                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";

        db.execSQL(sql);

        addQuestion();

    }

    private void addQuestion() {

        Question q1 = new Question("She … the piano very well.", "playing", "play", "plays", "plays");

        this.addQuestion(q1);

        Question q2 = new Question("My sister … hamburgers: she thinks they’re bad for her.", "is eating", "doesn't eat", "eats", "doesn't eat");

        this.addQuestion(q2);

        Question q3 = new Question("I … my exercise because I didn’t understand the questions.","did", "didn't do", "will do", "didn't do");

        this.addQuestion(q3);

        Question q4 = new Question("Please be quiet! The baby … .", "sleeps", "sleep", "is sleeping", "is sleeping");

        this.addQuestion(q4);

        Question q5 = new Question("Speak up! I can’t hear you because your dog … too much noise.", "is making", "made", "has made", "is making");

        this.addQuestion(q5);

        Question q6 = new Question("A good judge never jumps _________ the conclusion.", "at", "on", "for", "at");

        this.addQuestion(q6);

        Question q7 = new Question("The father was anxious __________ the safety of his daughter.", "at", "with", "about", "about");

        this.addQuestion(q7);

        Question q8 = new Question("He was killed _________ a highway man _______ a dagger.", "by,for", "by,with", "in,for", "by,with");

        this.addQuestion(q8);

        Question q9 = new Question("What is the correct spelling?", "Survaillance", "Surveillance", "Surveilance", "Surveillance");

        this.addQuestion(q9);

        Question q10 = new Question("Bill enjoys reading __________ mystery novels.", "an", "a", "the", "the");

        this.addQuestion(q10);


    }

    //@Override

    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);

        onCreate(db);

    }

    public void addQuestion(Question quest) {

        // SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_QUES, quest.getQUESTION());

        values.put(KEY_ANSWER, quest.getANSWER());

        values.put(KEY_OPTA, quest.getOPTA());

        values.put(KEY_OPTB, quest.getOPTB());

        values.put(KEY_OPTC, quest.getOPTC());

        dbase.insert(TABLE_QUEST, null, values);

    }

    public List<Question> getAllQuestions() {

        List<Question> quesList = new ArrayList<Question>();

        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;

        dbase = this.getReadableDatabase();

        Cursor cursor = dbase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {

            do {

                Question quest = new Question();

                quest.setID(cursor.getInt(0));

                quest.setQUESTION(cursor.getString(1));

                quest.setANSWER(cursor.getString(2));

                quest.setOPTA(cursor.getString(3));

                quest.setOPTB(cursor.getString(4));

                quest.setOPTC(cursor.getString(5));



                quesList.add(quest);

            } while (cursor.moveToNext());

        }

        return quesList;

    }

}

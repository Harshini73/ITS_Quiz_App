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

public class QuizHelper2 extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "aptitude";

    private static final String TABLE_QUEST = "quest";

    private static final String KEY_ID = "qid";

    private static final String KEY_QUES = "question";

    private static final String KEY_ANSWER = "answer"; // correct option

    private static final String KEY_OPTA = "opta"; // option a

    private static final String KEY_OPTB = "optb"; // option b

    private static final String KEY_OPTC = "optc"; // option c

    private SQLiteDatabase dbase;

    public QuizHelper2(Context context) {

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

        Question q1 = new Question("If the price of a sugar is raised by 25%, then by how much per cent should a person reduce his consumption of sugar, so that his expenditure remains same?", "25%", "15%", "20%", "20%");

        this.addQuestion(q1);

        Question q2 = new Question("A town has population of 50,000 in 1988. In one year i.e. by 1989 it increased by 25%. Next year i.e. in 1990, it decreased by 30%. The next year in 1991 there was an increase of 40%. What is the population at end of 1991?", "61250", "60250", "62250", "20");

        this.addQuestion(q2);

        Question q3 = new Question("How to divide 3395 in ratio of 42 : 32 : 23?", "1550, 1235 and 610", "1470, 1120 and 805", "1245, 1150 and 1000 ", "1470, 1120 and 805");

        this.addQuestion(q3);

        Question q4 = new Question("A sum becomes Rs. 3000 at the rate of 12% per annum (simple interest). The same sum becomes Rs. 3300 at the rate of 15% per annum (simple interest) in the same duration. Find the sum and the duration.", "Rs. 2000 and 20 years", "Rs. 1500 and 7 years", "Rs. 1800 and 5.5 years", "Rs. 1800 and 5.5 years");

        this.addQuestion(q4);

        Question q5 = new Question("Find the principal amount invested if the difference between Compound Interest and Simple Interest obtained for 3 years at rate of interest of 25% is Rs. 320?", "Rs. 1550", "Rs. 1575.38", "Rs. 1525.50", "Rs. 1575.38");

        this.addQuestion(q5);


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

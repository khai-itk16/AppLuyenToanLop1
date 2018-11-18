package com.itk16.bk.pc.appluyentoanlop1.Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import com.itk16.bk.pc.appluyentoanlop1.model.Lesson;
import com.itk16.bk.pc.appluyentoanlop1.model.Question;

import java.util.ArrayList;

public class QueryDatabase extends AppCompatActivity {
    private String mNameLesson;
    private boolean mLock;
    private int mContent;
    private int mNumberStar;

    private String  mQuestion;
    private int mAnswer;
    private ArrayList<Question> mListQuestions = new ArrayList<>();

    private int mUnit;
    private Context mContext;
    public ArrayList<Lesson> mArrayLesson = new ArrayList<>();
    String DATABASE_NAME;
    String TABLE_NAME;
    SQLiteDatabase database = null;

    public QueryDatabase(String db, String tb, Context context, int Unit) {
        DATABASE_NAME = db;
        TABLE_NAME = tb;
        mContext = context;
        mUnit = Unit;
        if(TABLE_NAME == "tbLeson"){
            LoadDataUnit();
        }
        else{

        }

    }


    public void LoadDataUnit(){
        try {
            database = mContext.openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
            Cursor cursor = database.rawQuery("select * from " + TABLE_NAME + " where Unit = " + mUnit, null);
            int check = 0;

            while (cursor.moveToNext()){
                mNameLesson = cursor.getString(2);
                check = cursor.getInt(3);
                mLock = (check != 0) ? true : false;
                mContent = cursor.getInt(4);
                mNumberStar = cursor.getInt(5);
                mArrayLesson.add(new Lesson(mNameLesson,mLock,mContent,mNumberStar));
            }
            cursor.close();
        } catch (Exception ex){
            Log.d("ERROR", "error query " + ex.toString() );
        }

    }

    public void LoadDataLesson(){
        try {
            database = mContext.openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
            Cursor cursor = database.rawQuery("select * from " + TABLE_NAME + " where Unit = " + mUnit, null);
            int check = 0;

            while (cursor.moveToNext()){
                mQuestion = cursor.getString(2);
                mAnswer = cursor.getInt(3);

            }
            cursor.close();
        } catch (Exception ex){
            Log.d("ERROR", "error query " + ex.toString() );
        }
    }
//    public void UpdateData(int lesson, int NumberStar){
//        ContentValues newValues = new ContentValues();
//        newValues.put("NumberStar", NumberStar);
//        database.update(TABLE_NAME,newValues, "Content = " + lesson,null);
//    }

}

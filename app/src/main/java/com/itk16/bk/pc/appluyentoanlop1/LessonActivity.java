package com.itk16.bk.pc.appluyentoanlop1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import com.itk16.bk.pc.appluyentoanlop1.Databases.QueryDatabase;
import com.itk16.bk.pc.appluyentoanlop1.adapter.CustomAdapter;
import com.itk16.bk.pc.appluyentoanlop1.model.Lesson;

import java.util.ArrayList;
import java.util.HashMap;

public class LessonActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt_back;
    private ListView listView;
    private Integer chuong;
    private  QueryDatabase queryDatabase;
    private CustomAdapter customAdapter;
    private static HashMap map = new HashMap<Integer, Integer>();
    private ArrayList<Lesson> ArrayLesson = new ArrayList<>();
    static {
        map.put(1, R.layout.activity_bai1);
        map.put(2, R.layout.activity_bai2);
        map.put(3, R.layout.activity_bai3);
        map.put(4, R.layout.activity_bai4);
        map.put(5, R.layout.activity_bai5);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chuong = getIntent().getIntExtra("chuong", -1);
        setContentView((Integer)map.get(chuong));
         queryDatabase = new QueryDatabase("database1.sqlite","tbLesson", this, chuong);
         ArrayLesson.addAll(queryDatabase.mArrayLesson);

        init();
        setevent();
        customAdapter = new CustomAdapter(LessonActivity.this,R.layout.item,ArrayLesson, chuong);
        listView.setAdapter(customAdapter);

    }
    public void init()
    {
        bt_back=(Button)findViewById(R.id.nut_thoat);
        listView=(ListView)findViewById(R.id.lv);
    }
    public void setevent()
    {
        bt_back.setOnClickListener(this);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == 1){
                int sao = data.getIntExtra("sao",-1);
                Toast.makeText(this, "duoc "+sao, Toast.LENGTH_SHORT).show();

                if(ArrayLesson.get(0).getmNumberStar()<sao)
                {
                    ArrayLesson.get(0).setmNumberStar(sao);
                    queryDatabase.UpdateData(ArrayLesson.get(0));
                }
                if(sao >=2) {
                    ArrayLesson.get(1).setmLock(false);
                    queryDatabase.UpdateData(ArrayLesson.get(1));
                }
                customAdapter.notifyDataSetChanged();


            }
            if(resultCode == 2){
                int star = data.getIntExtra("sao",-1);
                Toast.makeText(this, "duoc"+star, Toast.LENGTH_SHORT).show();
                if(ArrayLesson.get(1).getmNumberStar()<star)
                {
                    ArrayLesson.get(1).setmNumberStar(star);
                    queryDatabase.UpdateData(ArrayLesson.get(1));
                }
                if(star >=2) {
                    ArrayLesson.get(2).setmLock(false);
                    queryDatabase.UpdateData(ArrayLesson.get(2));
                }
                customAdapter.notifyDataSetChanged();
            }
            if(resultCode == 3){
                int sao = data.getIntExtra("sao",-1);
                Toast.makeText(this, "dươc"+sao, Toast.LENGTH_SHORT).show();
                if(ArrayLesson.get(2).getmNumberStar()<sao)
                {
                    ArrayLesson.get(2).setmNumberStar(sao);
                    queryDatabase.UpdateData(ArrayLesson.get(2));
                }
                if(sao >=2) {
                    ArrayLesson.get(3).setmLock(false);
                    queryDatabase.UpdateData(ArrayLesson.get(3));
                }
                customAdapter.notifyDataSetChanged();
            }
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
                case R.id.nut_thoat:
                finish();
                break;
        }
    }
}


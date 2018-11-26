package com.itk16.bk.pc.appluyentoanlop1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.itk16.bk.pc.appluyentoanlop1.R;
import com.itk16.bk.pc.appluyentoanlop1.adapter.CustomGridView;
import com.itk16.bk.pc.appluyentoanlop1.adapter.CustomGridViewGame4;
import com.itk16.bk.pc.appluyentoanlop1.model.ItemImage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.widget.AdapterView.*;

public class Game_4 extends AppCompatActivity implements View.OnClickListener {
    private Button btback, btOK;
    private TextView tvQuestion, tvTimeCoundown;
    private GridView grIndexs, grAnswer;
    private ArrayList<ItemImage> ListAnswer;
    ArrayList<ItemImage> ListIndex;
    CustomGridViewGame4 customGridViewIndex;
    CustomGridViewGame4 customGridViewAnswer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game4);
        init();
        kecha();
    }
    public void init()
    {
        btback=(Button)findViewById(R.id.nut_thoat);
        btOK=(Button)findViewById(R.id.bt_OK);
        grIndexs= (GridView)findViewById(R.id.gr_Index);
        grAnswer= (GridView)findViewById(R.id.gr_Answer);
        tvQuestion=(TextView)findViewById(R.id.tv_Question);
        tvTimeCoundown=(TextView)findViewById(R.id.tv_countdown);
        btOK.setOnClickListener(this);
        ListAnswer= new ArrayList<>();
        ListIndex= new ArrayList<>();
    }
    public void kecha()
    {

        ListIndex.clear();
        ListAnswer.clear();
        ListIndex= random();
        customGridViewIndex= new CustomGridViewGame4(this, R.layout.item_text,ListIndex);
        grIndexs.setAdapter(customGridViewIndex);
        customGridViewAnswer= new CustomGridViewGame4(this, R.layout.item_text, ListAnswer);
        grAnswer.setAdapter(customGridViewAnswer);
        grIndexs.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if(ListAnswer.size()<ListIndex.size()){
                          ListAnswer.add(ListIndex.get(position));
                          customGridViewAnswer.notifyDataSetChanged();
                        }
            }
        });
    }
    public ArrayList<ItemImage> random()
    {
        ArrayList<ItemImage> List= new ArrayList<>();
        int check=0;
        Random rd= new Random();
        int i= rd.nextInt(5)+5;
        for (int j= 0 ; j< i; j++)
        {
            String s;
               do{
                   check=0;
                   s=null;
                   int t= rd.nextInt(9)+1;
                  s =t+"";
                  for (int k=0 ;k<List.size();k++)
                  {
                      if (t== Integer.parseInt(List.get(k).getmImageName())) check= 1;
                  }
               }while (check==1);


            List.add(new ItemImage(R.drawable.dapan, s));
        }
        return List;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bt_OK:
                kecha();
                break;
        }

    }
}

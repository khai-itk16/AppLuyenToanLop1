package com.itk16.bk.pc.appluyentoanlop1;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class StartActivity extends AppCompatActivity {
    private Button bt, bt_set_language;
    String language;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        bt = (Button) findViewById(R.id.bt_bd);
        bt_set_language=(Button)findViewById(R.id.settinglanguage) ;
        setevent();

    }
    void setevent()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Setting Language");
        builder.setPositiveButton("Vietnamese", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                language= "vn";
                setLanguage(language);
                dialog.cancel();
            }
        });
        builder.setPositiveButton("English", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                language= "en";
                setLanguage(language);
                dialog.cancel();
            }
        });
        final AlertDialog alertdialog = builder.create();
        bt_set_language=(Button)findViewById(R.id.settinglanguage) ;
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, Menu.class);
                startActivity(intent);
                finish();
            }
        });
        bt_set_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 alertdialog.show();
            }
        });
    }
    public void setLanguage(String lg)
    {
        Locale locale= new Locale(lg);
        Locale.setDefault(locale);

        Resources resources= getResources();
        Configuration con = resources.getConfiguration();
        con.locale= locale;
        resources.updateConfiguration(con, resources.getDisplayMetrics());
    }

}

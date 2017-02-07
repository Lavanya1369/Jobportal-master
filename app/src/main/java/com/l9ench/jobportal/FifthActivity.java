package com.l9ench.jobportal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class FifthActivity extends AppCompatActivity {
Button but,but1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        but=(Button)findViewById(R.id.button3);
        but1=(Button)findViewById(R.id.button4);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                /*intent.addCategory(Intent.CATEGORY_BROWSABLE);*/
                intent.setData(Uri.parse("https://www.paypal.com/signin?country.x=IN&locale.x=en_IN"));
                startActivity(intent);
            }
        });
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(FifthActivity.this,SixthActivity.class);
                startActivity(intent1);
            }
        });

    }

}

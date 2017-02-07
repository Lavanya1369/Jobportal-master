package com.l9ench.jobportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {
    TextView textView1,textView2,textView3,textView4;
    Button b2,b3;
    int count,d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String ing=getIntent().getStringExtra("ids");
        String method=getIntent().getStringExtra("amount");
        String topic_name=getIntent().getStringExtra("discount");
        textView1=(TextView)findViewById(R.id.t1);
        textView2=(TextView)findViewById(R.id.t2);
        textView3=(TextView)findViewById(R.id.t3);
        textView4=(TextView)findViewById(R.id.t4);
        b2=(Button)findViewById(R.id.button2);

        textView1.setText(ing);
        textView2.setText(method);
        textView3.setText(topic_name);
        int o= Integer.parseInt(method);
        int n=Integer.parseInt(topic_name);
        if(o!=0&&n!=0){
             count=(n*o)/100;

        }
        textView4.setText(String.valueOf(count));
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(FourthActivity.this,FifthActivity.class);
                startActivity(intent1);
            }
        });


    }

}

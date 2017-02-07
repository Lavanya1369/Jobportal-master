package com.l9ench.jobportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText name,mail,phone,pass,con,code;
    String s1,s2,s3,s4,s5,s6,s7;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name=(EditText)findViewById(R.id.name);
        mail=(EditText)findViewById(R.id.email);
        phone=(EditText)findViewById(R.id.phone);
        pass=(EditText)findViewById(R.id.password);
        con=(EditText)findViewById(R.id.conform);
        code=(EditText)findViewById(R.id.code);
        button=(Button)findViewById(R.id.button);
        spinner = (Spinner) findViewById(R.id.spinner);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s1=name.getText().toString();
                s2=mail.getText().toString();
                s3=phone.getText().toString();
                s4=pass.getText().toString();
                s5=con.getText().toString();
                s6=code.getText().toString();
                s7=spinner.getSelectedItem().toString();
                if(s1.equals("")&& s2.equals("")&&s3.equals("")&& s4.equals("")&&s5.equals("")&& s6.equals("")&&s7.equals("")) {
                    Toast.makeText(MainActivity.this, "please enter all fields", Toast.LENGTH_LONG).show();
                }
                else {
                    insertme(s1, s2, s3, s4, s5, s6, s7);
                    Intent i = new Intent(getApplicationContext(), Login.class);
                    i.putExtra("getData", s7.toString());
                    startActivity(i);
                }
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
      // spinner.setOnItemSelectedListener(this);

    }
    public void insertme(final String s1,final String s2,final String s3,final String s4,final String s5,final String s6,final String s7)
    {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, "http://lavanya1369.tk/jobportal.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> params =new HashMap<String, String>();
                params.put("na",s1);
                params.put("xx",s2);
                params.put("dd",s3);
                params.put("pas",s4);
                params.put("conn",s5);
                params.put("cod",s6);
                params.put("typ",s7);
                return params;

            }
        };
        Secondclass.getInstance().addToRequestQueue(stringRequest);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

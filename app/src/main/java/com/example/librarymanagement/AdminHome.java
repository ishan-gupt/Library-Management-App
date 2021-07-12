package com.example.librarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;

public class AdminHome extends AppCompatActivity {
    EditText bname, bcode, bauthor, bprice, bcount;
    Button signup;
    Spinner spinner_sem, spinner_depart;
    String n, c, a, p, cn;
    static boolean signal=true;
    int ss, sd;
    StringRequest stringRequest;
    String[] depart = {"Computer", "Mechnical", "Electical", "Civil", "EC", "IC"};
    String[] Sems = {"1", "2", "3", "4", "5", "6", "7", "8"};
    private static final String TAG = "Signup";
    String url = "http://192.168.228.1/android/addbook.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        changeStatusBarColor("#f0f5f5");

        bname = (EditText) findViewById(R.id.Bname);
        bcode = (EditText) findViewById(R.id.Bcode);
        bauthor = (EditText) findViewById(R.id.bauthor);
        bprice = (EditText) findViewById(R.id.bprice);
        bcount = (EditText) findViewById(R.id.bcount);
        spinner_sem = (Spinner) findViewById(R.id.s_sem);
        spinner_depart = (Spinner) findViewById(R.id.s_deptment);

        spinner_depart.setPrompt("Department");
        spinner_sem.setPrompt("Semester");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, depart);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_depart.setAdapter(arrayAdapter);
        spinner_depart.setOnItemSelectedListener(new departs(this,depart));

        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, Sems);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_sem.setAdapter(arrayAdapter2);
        spinner_sem.setOnItemSelectedListener(new Sem(this,Sems));

        signup = (Button) findViewById(R.id.s_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
   }


    private void changeStatusBarColor(String color){
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(color));
        }
    }

    public void registerUser() {
        n = bname.getText().toString().trim();
        a = bauthor.getText().toString().trim();
        c = bcode.getText().toString().trim();
        cn = bcount.getText().toString().trim();
        p = bprice.getText().toString().trim();

        if (c.isEmpty()) {
            bcode.setError("Please fill Code");
            bcode.requestFocus();
        }
        if (n.isEmpty()) {
            bname.setError("Please fill Name");
            bname.requestFocus();
        }
        if (a.isEmpty()) {
            bauthor.setError("Please fill Author Name");
            bauthor.requestFocus();
        }
        if (cn.isEmpty()) {
            bcount.setError("Please fill No of Books");
            bcount.requestFocus();
        }
        if (p.isEmpty()) {
            bprice.setError("Please fill the price");
            bprice.requestFocus();
        }

        ss=Sem.getsem();
        sd= departs.getdepart();


        if (p.equals(c)) {
            Signup_With_volley();
        }
    }

    public void Signup_With_volley()
    {
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.e(TAG, "onResponse: " + response);

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            JSONObject jsonObject = jsonArray.getJSONObject(0);
                            String code = jsonObject.getString("code");
                            String msg = jsonObject.getString("message");
                            Toast.makeText(AdminHome.this, code + "  " + msg, Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplication()   ,MainActivity.class));
                            finish();

                        } catch (JSONException e1) {
                            Log.e(TAG, "onResponse: " + e1);
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> stringStringMap = new HashMap<String, String>();
                stringStringMap.put("bname", n);
                stringStringMap.put("bcode",c);
                stringStringMap.put("bauthor",a);
                stringStringMap.put("bdept",depart[sd]);
                stringStringMap.put("bsem",Sems[ss]);
                stringStringMap.put("bprice", p);
                stringStringMap.put("bcount", cn);
                return stringStringMap;
            }
        };

        MySingleton.getInstance(AdminHome.this).addRequestQue(stringRequest);
    }

}

class Semester implements AdapterView.OnItemSelectedListener
{
    Context context;
    String sem[];
    static int i;
    Semester(){ }
    Semester(Context context,String sem[]){
        this.context=context;
        this.sem=sem;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        this.i=i;

    }

    static int getsem()
    {
        return i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

class departments implements AdapterView.OnItemSelectedListener
{
    Context context;
    String dep[];
    static int i;
    departments(){}
    public departments(Context context,String dep[]) {
        this.context = context;
        this.dep=dep;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        this.i=i;
    }

    static int getdepart()
    {
        return i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
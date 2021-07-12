package com.example.librarymanagement;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Retrofit;

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

public class Signup extends AppCompatActivity{

    EditText enrollment, name, surname, confirm, password, mobiles;
    Button signup;
    Spinner spinner_sem, spinner_depart;
    String e, n, s, c, p, m;
    static boolean signal=true;
    int ss, sd;
    StringRequest stringRequest;
    String[] depart = {"Computer", "Mechnical", "Electical", "Civil", "EC", "IC"};
    String[] Sems = {"1", "2", "3", "4", "5", "6", "7", "8"};
    private static final String TAG = "Signup";
    String url = "http://192.168.68.1/android/Registertion.php";
    Retrofit retrofit;
    Button peyes,ceyes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        changeStatusBarColor("#f0f5f5");

        enrollment = (EditText) findViewById(R.id.binid);
        name = (EditText) findViewById(R.id.s_name);
        surname = (EditText) findViewById(R.id.s_surname);
        mobiles = (EditText) findViewById(R.id.mobile_number);
        confirm = (EditText) findViewById(R.id.s_confirm_password);
        password = (EditText) findViewById(R.id.s_password);
        spinner_sem = (Spinner) findViewById(R.id.s_sem);
        spinner_depart = (Spinner) findViewById(R.id.s_deptment);
        peyes=(Button)findViewById(R.id.passwordeyes);
        ceyes=(Button)findViewById(R.id.confirmeyes);
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

        ceyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(signal){
                    ceyes.setBackgroundResource(R.drawable.eyesopen);
                    peyes.setBackgroundResource(R.drawable.eyesopen);
                    signal=false;
                    if((password.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)||
                            (confirm.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)) {
                        password.setInputType( InputType.TYPE_CLASS_TEXT |
                                InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        confirm.setInputType( InputType.TYPE_CLASS_TEXT |
                                InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    }else {
                        password.setInputType( InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD );
                        confirm.setInputType( InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD );
                    }
                    password.setSelection(password.getText().length());
                    confirm.setSelection(confirm.getText().length());

                }else {
                    ceyes.setBackgroundResource(R.drawable.eyesclose);
                    peyes.setBackgroundResource(R.drawable.eyesclose);

                    signal=true;
                    if((password.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)||
                            (confirm.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)) {
                        password.setInputType( InputType.TYPE_CLASS_TEXT |
                                InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        confirm.setInputType( InputType.TYPE_CLASS_TEXT |
                                InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    }else {
                        password.setInputType( InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD );
                        confirm.setInputType( InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD );
                    }
                    password.setSelection(password.getText().length());
                    confirm.setSelection(confirm.getText().length());
                }
            }
        });

        peyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(signal){
                    peyes.setBackgroundResource(R.drawable.eyesopen);
                    ceyes.setBackgroundResource(R.drawable.eyesopen);

                    signal=false;
                    if((password.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)||
                            (confirm.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)) {
                        password.setInputType( InputType.TYPE_CLASS_TEXT |
                                InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        confirm.setInputType( InputType.TYPE_CLASS_TEXT |
                                InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    }else {
                        password.setInputType( InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD );
                        confirm.setInputType( InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD );
                    }
                    password.setSelection(password.getText().length());
                    confirm.setSelection(confirm.getText().length());

                }else {
                    peyes.setBackgroundResource(R.drawable.eyesclose);
                    ceyes.setBackgroundResource(R.drawable.eyesclose);

                    signal=true;
                    if((password.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)||
                            (confirm.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)) {
                        password.setInputType( InputType.TYPE_CLASS_TEXT |
                                InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        confirm.setInputType( InputType.TYPE_CLASS_TEXT |
                                InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    }else {
                        password.setInputType( InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD );
                        confirm.setInputType( InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD );
                    }
                    password.setSelection(password.getText().length());
                    confirm.setSelection(confirm.getText().length());
                }
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
        e = enrollment.getText().toString().trim();
        n = name.getText().toString().trim();
        s = surname.getText().toString().trim();
        c = confirm.getText().toString().trim();
        p = password.getText().toString().trim();
        m = mobiles.getText().toString().trim();

        if (e.isEmpty()) {
            enrollment.setError("Please fill Email");
            enrollment.requestFocus();
        }
        if (n.isEmpty()) {
            name.setError("Please fill Name");
            name.requestFocus();
        }
        if (s.isEmpty()) {
            surname.setError("Please fill SurName");
            surname.requestFocus();
        }
        if (c.isEmpty()) {
            confirm.setError("Please fill Confirm");
            confirm.requestFocus();
        }
        if (p.isEmpty()) {
            password.setError("Please fill password");
            password.requestFocus();
        }
        if (m.isEmpty()) {
            mobiles.setError("Please fill City");
            mobiles.requestFocus();
        }
        ss=Sem.getsem();
        sd= departs.getdepart();


        if (p.equals(c)) {
          Signup_With_volley();
        }
    }

    //    public void Signup_with_Retrofit()
//    {
//        Log.e(TAG, "Signup_with_Retrofit: " );
//        Call<JSONObject> call=RetrofitClients
//                .getInstance()
//                .getApi()
//                .createuser(e,n,s,p,sd,ss,m);
//        Log.e(TAG, "Signup_with_Retrofit: "+call );
//
//        call.enqueue(new Callback<JSONObject>() {
//            @Override
//            public void onResponse(Call<JSONObject> call, retrofit2.Response<JSONObject> response) {
//                JSONArray jsonArray = null;
//                try {
//                    jsonArray = new JSONArray(response);
//                    JSONObject jsonObject = jsonArray.getJSONObject(0);
//                    Log.e(TAG, "onResponse: -------"+jsonObject );
//                    String code = jsonObject.getString("code");
//                    String msg = jsonObject.getString("message");
//                    Toast.makeText(Signup.this, code + "  " + msg, Toast.LENGTH_SHORT).show();
//                } catch (JSONException e1) {
//                    e1.printStackTrace();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<JSONObject> call, Throwable t) {
//
//            }
//        });
//
//        Log.e(TAG, "Signup_with_Retrofit: Completed " );
//    }

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
                            Toast.makeText(Signup.this, code + "  " + msg, Toast.LENGTH_SHORT).show();
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
                stringStringMap.put("ssenroll", e);
                stringStringMap.put("ssname",n);
                stringStringMap.put("sssurname",s);
                stringStringMap.put("ssdept",depart[sd]);
                stringStringMap.put("sssem",Sems[ss]);
                stringStringMap.put("sspass", p);
                stringStringMap.put("ssmobile", m);
                return stringStringMap;
            }
        };

        MySingleton.getInstance(Signup.this).addRequestQue(stringRequest);
    }

}

class Sem implements AdapterView.OnItemSelectedListener
{
    Context context;
    String sem[];
   static int i;
    Sem(){ }
    Sem(Context context,String sem[]){
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

class departs implements AdapterView.OnItemSelectedListener
{
    Context context;
    String dep[];
    static int i;
    departs(){}
    public departs(Context context,String dep[]) {
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
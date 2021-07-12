package com.example.librarymanagement;

import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    EditText email,password;
    Button login;
    static boolean signal=true;
    TextView sign,lib;
    String e,p;
    String url="http://192.168.68.1/android/login.php";
    AlertDialog.Builder builder;
    StringRequest stringRequest;
    RelativeLayout relativeLayout,relativeLayout2;
    private static final String TAG = "MainActivity";
    Button eyes1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if((Shareprefences.getInstance(this).isLoggedIN())) {

                finish();
                startActivity(new Intent(this, Main_Page.class));
                return;

        }
        setContentView(R.layout.activity_main);

        relativeLayout=(RelativeLayout)findViewById(R.id.relaytive);
        email=(EditText)findViewById(R.id.l_email);
        password=(EditText)findViewById(R.id.l_password);
        login=(Button)findViewById(R.id.login);
        login.setText("Log In");
        eyes1 =(Button)findViewById(R.id.eyes);
        changeStatusBarColor("#f0f5f5");
        sign=(TextView)findViewById(R.id.signup);
        lib=(TextView)findViewById(R.id.student);
        relativeLayout2=(RelativeLayout)findViewById(R.id.relative2);
        builder=new AlertDialog.Builder(MainActivity.this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetch();
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Signup.class));
            }

        });
        lib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LibLogin.class));
            }

        });


        KeyboardVisibilityEvent.setEventListener(
                this,
                new KeyboardVisibilityEventListener() {
                    @Override
                    public void onVisibilityChanged(boolean isOpen) {
                        if(isOpen){ flip(); }else {flipoff();}
                    }
                });



        eyes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(signal){
                    eyes1.setBackgroundResource(R.drawable.eyesopen);
                    signal=false;
                    if(password.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                        password.setInputType( InputType.TYPE_CLASS_TEXT |
                                InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    }else {
                        password.setInputType( InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD );
                    }
                    password.setSelection(password.getText().length());

                }else {
                    eyes1.setBackgroundResource(R.drawable.eyesclose);
                    signal=true;
                    if(password.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                        password.setInputType( InputType.TYPE_CLASS_TEXT |
                                InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    }else {
                        password.setInputType( InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD );
                    }
                    password.setSelection(password.getText().length());
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

    private void flip()
    {
        RelativeLayout.LayoutParams layoutParams = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(0, 650, 0, 100);

        RelativeLayout.LayoutParams layoutParams1 = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams1.setMargins(0, 150, 0, 100);
        relativeLayout.setLayoutParams(layoutParams1);
        relativeLayout2.setLayoutParams(layoutParams);
    }


    private void flipoff()
    {
        RelativeLayout.LayoutParams layoutParams = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(0, 350, 0, 50);

        RelativeLayout.LayoutParams layoutParams1 = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams1.setMargins(0, 850, 0, 50);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout2.setLayoutParams(layoutParams1);
    }

    public void fetch()
    {
        e=email.getText().toString().trim();
        p=password.getText().toString().trim();

        if(e.isEmpty())
        {
            email.setError("Please fill Email");
            email.requestFocus();
            return;
        }
        if(p.isEmpty())
        {
            password.setError("Please fill password");
            password.requestFocus();
            return;
        }

        else {
            stringRequest=new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray jsonArray=new JSONArray(response);
                                JSONObject jsonObject= jsonArray.getJSONObject(0);
                                String code=jsonObject.getString("code");
                                if(code.equals("Login fail or Id Password wrong")){
                                    builder.setTitle("ERROR");
                                    builder.setMessage(jsonObject.getString("code"));
                                    builder.show();
                                }
                                else{

                                    Shareprefences.getInstance(MainActivity.this).userlogin(jsonObject.getString("enroll")
                                    ,jsonObject.getString("name")
                                    ,jsonObject.getString("surname")
                                    ,jsonObject.getString("mobile")
                                    ,jsonObject.getString("sem")
                                    ,jsonObject.getString("dept")
                                    ,jsonObject.getString("news_name"));
                                    Shareprefences.getInstance(MainActivity.this).bookdate(jsonObject.getString("book_code1"),
                                            jsonObject.getString("book_code2"),
                                            jsonObject.getString("book_issue1"),
                                            jsonObject.getString("book_issue2"),
                                            jsonObject.getString("book_submit1"),
                                            jsonObject.getString("book_submit2"),
                                            jsonObject.getString("book1_fine"),
                                            jsonObject.getString("book2_fine")
                                    );

                                    Intent intent=new Intent(MainActivity.this,Main_Page.class);
                                    intent.putExtra("email",e);
                                    intent.putExtra("pass",p);
                                    Shareprefences.getInstance(MainActivity.this).setuser(e,p);
                                    startActivity(intent);
                                    finish();
                                }

                            } catch (JSONException e1) {
                                e1.printStackTrace();
                            }
                        }
                    },new Response.ErrorListener(){

                @Override
                public void onErrorResponse(VolleyError error) {
                    builder.setTitle("ERROR");
                    builder.setMessage("Internet Connection fail !!");
                    builder.show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> stringStringMap=new HashMap<String,String>();
                    stringStringMap.put("enroll",e);
                    stringStringMap.put("pass",p);
                    return stringStringMap;
                }
            };

            MySingleton.getInstance(MainActivity.this).addRequestQue(stringRequest);
        }
    }
}

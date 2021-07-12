package com.example.librarymanagement;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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

import static androidx.core.app.ActivityCompat.finishAffinity;

public class Profile extends Fragment {

    TextView pname,psurname,pmoblie,pdepartment,psem, penroll;
    private static final String TAG = "Profile";
    StringRequest stringRequest;
    String url="http://192.168.68.1/android/login.php";
    AlertDialog.Builder builder;
    Button refr;
    String email=new String();
    String password=new String();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile, container, false);
        pname = (TextView) view.findViewById(R.id.p_name);
        psurname = (TextView) view.findViewById(R.id.p_surname);
        pmoblie = (TextView) view.findViewById(R.id.p_moblie);
        pdepartment = (TextView) view.findViewById(R.id.p_department);
        psem = (TextView) view.findViewById(R.id.p_sem);
        penroll = (TextView) view.findViewById(R.id.p_enroll);
        builder = new AlertDialog.Builder(getContext());
        refr = (Button) view.findViewById(R.id.refreash);
       /* email = getArguments().getString("email");
        password = getArguments().getString("pass");*/
        if ((!Shareprefences.getInstance(getContext()).isLoggedIN())) {
            //startActivity(new Intent(getContext(), MainActivity.class));
            Log.e(TAG, "onCreateView: Profile sign in" );
        }
        else if(Shareprefences.getInstance(getContext()).isLoggedIN())
        {
            penroll.setText(Shareprefences.getInstance(getContext()).getEnroll());
            pname.setText(Shareprefences.getInstance(getContext()).getName());
            psem.setText(Shareprefences.getInstance(getContext()).getSem());
            pdepartment.setText(Shareprefences.getInstance(getContext()).getDepart());
            psurname.setText(Shareprefences.getInstance(getContext()).getSurname());
            pmoblie.setText(Shareprefences.getInstance(getContext()).getKeyMobile());
        }
        else {
            Reload();
        }

        refr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Reload();
            }
        });


        return view;

    }

    private void Reload() {

        stringRequest=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e(TAG, "onResponse: "+response );
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            JSONObject jsonObject= jsonArray.getJSONObject(0);
                            String code=jsonObject.getString("code");
                            Log.e(TAG, "onResponse: json"+jsonObject );
                            Log.e(TAG, "onResponse: "+jsonObject.getString("enroll"));



                            if(code.equals("login fail")){
                                builder.setTitle("ERROR");
                                Log.e(TAG, "onResponse: 1"+code );
                                builder.setMessage(jsonObject.getString("code"));
                                builder.show();
                            }
                            else{
                                Shareprefences.getInstance(getContext()).userlogin(jsonObject.getString("enroll")
                                        ,jsonObject.getString("name")
                                        ,jsonObject.getString("surname")
                                        ,jsonObject.getString("mobile")
                                        ,jsonObject.getString("sem")
                                        ,jsonObject.getString("dept")
                                ,jsonObject.getString("news_name"));

                                penroll.setText(Shareprefences.getInstance(getContext()).getEnroll());
                                pname.setText(Shareprefences.getInstance(getContext()).getName());
                                psem.setText(Shareprefences.getInstance(getContext()).getSem());
                                pdepartment.setText(Shareprefences.getInstance(getContext()).getDepart());
                                psurname.setText(Shareprefences.getInstance(getContext()).getSurname());
                                pmoblie.setText(Shareprefences.getInstance(getContext()).getKeyMobile());
                            }

                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                    }
                },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: ERROR"+error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> stringStringMap=new HashMap<String,String>();
                stringStringMap.put("enroll",Shareprefences.getInstance(getContext()).getEnroll());
                stringStringMap.put("pass",Shareprefences.getInstance(getContext()).getPass());
                Log.e(TAG, "getParams: "+stringStringMap);
                return stringStringMap;
            }
        };

        MySingleton.getInstance(getContext()).addRequestQue(stringRequest);

    }


    /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        pbook1=(TextView)findViewById(R.id.p_name);
        psbook2=(TextView)findViewById(R.id.p_surname);
        pissue1=(TextView)findViewById(R.id.p_moblie);
        pissue2=(TextView)findViewById(R.id.p_department);
        psumit1=(TextView)findViewById(R.id.p_sem);
        psubmit2 =(TextView)findViewById(R.id.p_enroll);

        if(!Shareprefences.getInstance(this).isLoggedIN())
        {
            finish();
            startActivity(new Intent(this,Signup.class));
        }

        psubmit2.setText(Shareprefences.getInstance(this).getEnroll());
        pbook1.setText(Shareprefences.getInstance(this).getName());
        psumit1.setText(Shareprefences.getInstance(this).getSem());
        pissue2.setText(Shareprefences.getInstance(this).getDepart());
        psbook2.setText(Shareprefences.getInstance(this).getSurname());
        pissue1.setText(Shareprefences.getInstance(this).getKeyMobile());

    }*/
}

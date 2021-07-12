package com.example.librarymanagement;

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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class My_books extends Fragment {

    TextView pbook1, psbook2, pissue1, pissue2, psumit1, psubmit2,fine1,fine2;
    private static final String TAG = "My_books";
    StringRequest stringRequest;
    String url="http://192.168.68.1/android/login.php";
    AlertDialog.Builder builder;
    Button refrw;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_books, container, false);
        pbook1 = (TextView) view.findViewById(R.id.p_book1);
        psbook2 = (TextView) view.findViewById(R.id.p_book2);
        pissue1 = (TextView) view.findViewById(R.id.p_book1_issuedate);
        pissue2 = (TextView) view.findViewById(R.id.p_book2_issuedate);
        psumit1 = (TextView) view.findViewById(R.id.p_book1_submitdate);
        psubmit2 = (TextView) view.findViewById(R.id.p_book2_submitdate);
        fine1=(TextView)view.findViewById(R.id.p_fine1);
        fine2=(TextView)view.findViewById(R.id.p_fine2);
        builder = new AlertDialog.Builder(getContext());
        refrw = (Button) view.findViewById(R.id.refreashbook);
        if ((!Shareprefences.getInstance(getContext()).isLoggedIN())) {
            //startActivity(new Intent(getContext(), MainActivity.class));
            Log.e(TAG, "onCreateView: Profile sign in" );
        }
        else if(Shareprefences.getInstance(getContext()).isLoggedIN()) {

            String book1=new String();
                    book1=Shareprefences.getInstance(getContext()).getKeyBook1();
            Log.e(TAG, "onCreateView: Shareprefences.getInstance(getContext()).getKeyBook1()======"+Shareprefences.getInstance(getContext()).getKeyBook1());
            String book2=new String();
                    book2=Shareprefences.getInstance(getContext()).getKeyBook2();
            if(book1.equals("0"))
            {
                pbook1.setText("No books");
            }
            else{
                pbook1.setText(Shareprefences.getInstance(getContext()).getKeyBook1());
            }
            if(book2.equals("0"))
            {
                Log.e(TAG, "onResponse: "+book2 );
                psbook2.setText("No books");
            }
            else{
                psbook2.setText(Shareprefences.getInstance(getContext()).getKeyBook2());
            }
            pissue1.setText(Shareprefences.getInstance(getContext()).getKeyIssue1());
            pissue2.setText(Shareprefences.getInstance(getContext()).getKeyIssue2());
            psumit1.setText(Shareprefences.getInstance(getContext()).getKeySubmit1());
            psubmit2.setText(Shareprefences.getInstance(getContext()).getKeySubmit2());
            fine1.setText(Shareprefences.getInstance(getContext()).getKeyFine1());
            fine2.setText(Shareprefences.getInstance(getContext()).getKeyFine2());
        }
        else {
            Reload();
        }
        refrw.setOnClickListener(new View.OnClickListener() {
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
                                builder.setMessage(jsonObject.getString("code"));
                                builder.show();
                            }
                            else{
                                Shareprefences.getInstance(getContext()).bookdate(jsonObject.getString("book_code1"),
                                        jsonObject.getString("book_code2"),
                                        jsonObject.getString("book_issue1"),
                                        jsonObject.getString("book_issue2"),
                                        jsonObject.getString("book_submit1"),
                                        jsonObject.getString("book_submit2"),
                                        jsonObject.getString("book1_fine"),
                                        jsonObject.getString("book2_fine")
                                        );

                                String book1=Shareprefences.getInstance(getContext()).getKeyBook1();
                                String book2=Shareprefences.getInstance(getContext()).getKeyBook2();
                                if(book1.equals("0"))
                                {
                                    pbook1.setText("No books");
                                }
                                else{
                                    pbook1.setText(Shareprefences.getInstance(getContext()).getKeyBook1());
                                }
                                if(book2.equals("0"))
                                {
                                    Log.e(TAG, "onResponse: "+book2 );
                                    psbook2.setText("No books");
                                }
                                else{
                                    psbook2.setText(Shareprefences.getInstance(getContext()).getKeyBook2());
                                }
                                pissue1.setText(Shareprefences.getInstance(getContext()).getKeyIssue1());
                                pissue2.setText(Shareprefences.getInstance(getContext()).getKeyIssue2());
                                psumit1.setText(Shareprefences.getInstance(getContext()).getKeySubmit1());
                                psubmit2.setText(Shareprefences.getInstance(getContext()).getKeySubmit2());
                                fine1.setText(Shareprefences.getInstance(getContext()).getKeyFine1());
                                fine2.setText(Shareprefences.getInstance(getContext()).getKeyFine2());
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

}

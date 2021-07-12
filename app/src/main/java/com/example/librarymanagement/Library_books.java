package com.example.librarymanagement;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class Library_books extends Fragment {

    Integer integer;
    StringRequest stringRequest;
    String url = "http://192.168.68.1/android/Fetch_books.php";
    String urlimg = "http://192.168.68.1/android/imgbooks/";
    GridView gridView;
    EditText book_search;
    String data;
    Modal_books modal;
    Button button;
    List<Modal_books> modal_books = new ArrayList<>();
    private static final String TAG = "Library_books";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.library_books, container, false);
        gridView = (GridView) view.findViewById(R.id.gridviewl);
        book_search = (EditText) view.findViewById(R.id.book_search);
        book_search.getText().clear();
        button = (Button) view.findViewById(R.id.book_search_button);
        Reload();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = book_search.getText().toString().trim();
                Log.e(TAG, "onCreateView: " + book_search.length());
                Reload();
            }
        });
        return view;
    }

    private void Reload() {

        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            JSONObject jsonObject = jsonArray.getJSONObject(0);
                            String allbook = jsonObject.getString("book_data");
                            Log.e(TAG, "onResponse: " + allbook);
                            JSONArray n = new JSONArray(allbook);
                            String name[] = new String[n.length()];
                            String code[] = new String[n.length()];
                            String author[] = new String[n.length()];
                            String sem[] = new String[n.length()];
                            String price[] = new String[n.length()];
                            String count[] = new String[n.length()];
                            String dept[] = new String[n.length()];
                            String book_img[] = new String[n.length()];
                            Log.e(TAG, "onResponse: length ::" + n.length());

                            for (int i = 0; i < n.length(); i++) {

                                JSONObject objdata = n.getJSONObject(i);
                                name[i] = objdata.getString("b_name");
                                code[i] = objdata.getString("b_code");
                                author[i] = objdata.getString("b_author");
                                sem[i] = objdata.getString("b_sem");
                                price[i] = objdata.getString("b_price");
                                count[i] = objdata.getString("b_count");
                                dept[i] = objdata.getString("b_dept");
                                Log.e(TAG, "onResponse: "+ urlimg.concat(objdata.getString("b_img")) );
                                book_img[i] = urlimg.concat(objdata.getString("b_img"));
                            }
                            Log.e(TAG, "onResponse: END OF LOOP" );
                            Library_book_adapter library_book_adapter = new Library_book_adapter(name, code, author, sem, dept, price, count, book_img, getContext());

                            gridView.setAdapter(library_book_adapter);

                            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    Intent intent = new Intent(getContext(), Books.class);
                                    intent.putExtra("bookname", name[i]);
                                    intent.putExtra("bookauthor", author[i]);
                                    intent.putExtra("bookcode", code[i]);
                                    intent.putExtra("booksem", sem[i]);
                                    intent.putExtra("bookdept", dept[i]);
                                    intent.putExtra("bookcount", count[i]);
                                    intent.putExtra("bookimg", book_img[i]);
                                    intent.putExtra("bookprice", price[i]);
                                    startActivity(intent);
                                }
                            });
                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: ERROR" + error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> stringStringMap = new HashMap<String, String>();

                if (book_search.length() == 1) {
                    stringStringMap.put("book_sem", data);

                } else if (book_search.length() >= 2) {
                    stringStringMap.put("book_code", data);
                    stringStringMap.put("book_name", data);

                } else {

                    stringStringMap.put("data", "data");
                }
                return stringStringMap;
            }
        };


        Singleton_for_books.getInstance(getContext()).addRequestQue(stringRequest);

    }

}

package com.example.librarymanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Books extends AppCompatActivity {

    TextView name,code,author,sem,dept,price,count;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        name=(TextView)findViewById(R.id.library_books_name);
        code=(TextView)findViewById(R.id.library_books_code);
        author=(TextView)findViewById(R.id.library_books_author);
        sem=(TextView)findViewById(R.id.library_books_sem);
        dept=(TextView)findViewById(R.id.library_books_dept);
        imageView=(ImageView)findViewById(R.id.image_books);
        price=(TextView)findViewById(R.id.library_books_price);
        count=(TextView)findViewById(R.id.library_books_count);
        Intent intent=getIntent();

        name.setText(intent.getStringExtra("bookname"));
        code.setText(intent.getStringExtra("bookcode"));
        author.setText(intent.getStringExtra("bookauthor"));
        sem.setText(intent.getStringExtra("booksem"));
        dept.setText(intent.getStringExtra("bookdept"));
        price.setText(intent.getStringExtra("bookprice"));
        count.setText(intent.getStringExtra("bookcount"));

        Glide.with(this).load(intent.getStringExtra("bookimg")).into(imageView);

    }
}

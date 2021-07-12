package com.example.librarymanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class NewsPage extends AppCompatActivity {

    ImageView imageView;
    TextView title,desp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_page);

        imageView=(ImageView)findViewById(R.id.news_img1);
        title=(TextView)findViewById(R.id.title1);
        desp=(TextView)findViewById(R.id.textdesp1);
        Intent intent=getIntent();
        Glide.with(this).load(intent.getStringExtra("newsimg")).into(imageView);
        title.setText(intent.getStringExtra("newstitle"));
        desp.setText(intent.getStringExtra("newsdesp"));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
    }
}

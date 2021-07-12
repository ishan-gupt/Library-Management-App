package com.example.librarymanagement;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import static android.content.ContentValues.TAG;

public class Library_book_adapter extends BaseAdapter {

    String books[],code[],author[],sem[],dept[],price[],count[],url[];
    List<Modal_books> modal_books;
    Context context;
    View v;
    LayoutInflater layoutInflater;

    public Library_book_adapter(String[] books, String[] code, String[] author, String[] sem, String[] dept, String[] price, String[] count,String url[], Context context) {
        this.books = books;
        this.code = code;
        this.author = author;
        this.sem = sem;
        this.dept = dept;
        this.price = price;
        this.count = count;
        this.context = context;
        this.url=url;
    }

//    public Library_book_adapter(List<Modal_books> modal_books, Context context) {
//        this.modal_books = modal_books;
//        this.context = context;
//    }

    @Override
    public int getCount() {
        return books.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.e(TAG, "getView: addpter " );
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        v=new View(context);
        v= (View) layoutInflater.inflate(R.layout.inflate_library_books,null);
        TextView book_name=(TextView)v.findViewById(R.id.library_books_name);
        TextView book_code=(TextView)v.findViewById(R.id.library_books_code);
        TextView book_author=(TextView)v.findViewById(R.id.library_books_author);
        TextView book_sem=(TextView)v.findViewById(R.id.library_books_sem);
        TextView book_dept=(TextView)v.findViewById(R.id.library_books_dept);
        TextView book_price=(TextView)v.findViewById(R.id.library_books_price);
        TextView book_count=(TextView)v.findViewById(R.id.library_books_count);
        ImageView book_image=(ImageView) v.findViewById(R.id.image_books);
        Log.e("", "Library_book_adapter: "+this.books[0] );

        book_name.setText(books[i]);
        book_code.setText(code[i]);
        book_author.setText(author[i]);
        book_count.setText(count[i]);
        book_dept.setText(dept[i]);
        Glide.with(context).load(url[i]).into(book_image);
        book_price.setText(price[i]);
        book_sem.setText(sem[i]);
        return v;
    }


}

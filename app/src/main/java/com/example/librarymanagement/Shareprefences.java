package com.example.librarymanagement;

import android.content.Context;
import android.content.SharedPreferences;

public class Shareprefences {

    private static  Shareprefences instance;
    Context context;

    private final static String SHAREPREFENCE_NAME="SHAREPREFENCE_NAME";
    private final static String KEY_SURNAME="surname";
    private final static String KEY_USER_EMAIL="Email";
    private final static String KEY_USERNAME ="username";
    private final static String KEY_MOBILE ="mobile";
    private final static String KEY_DEPART ="depart";
    private final static String KEY_SEM ="sem";
    private final static String KEY_PASS ="pass";
    private final static String KEY_NEWS ="news";
    private final static String KEY_BOOK1 ="book1";
    private final static String KEY_BOOK2 ="book2";
    private final static String KEY_ISSUE1 ="issue1";
    private final static String KEY_ISSUE2 ="issue2";
    private final static String KEY_SUBMIT1 ="submit1";
    private final static String KEY_SUBMIT2 ="submit2";
    private final static String KEY_FINE1 ="fine1";
    private final static String KEY_FINE2 ="fine2";

    private Shareprefences() {
    }

    public Shareprefences(Context context) {
        this.context=context;
    }

    static synchronized Shareprefences getInstance(Context context)
    {
        if(instance==null)
        {
            instance=new Shareprefences(context);
        }
        return  instance;
    }

    public boolean setuser(String email,String pass)
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        // editor.putString(KEY_ID, String.valueOf(id));
        editor.putString(KEY_USER_EMAIL,email);
        editor.putString(KEY_PASS,pass);

        editor.apply();
        return true;
    }

    public boolean bookdate(String book1,String book2,String issue1,String issue2,String submit1,String submit2,String fine1,String fine2)
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(KEY_BOOK1,book1);
        editor.putString(KEY_BOOK2,book2);
        editor.putString(KEY_ISSUE1,issue1);
        editor.putString(KEY_ISSUE2,issue2);
        editor.putString(KEY_SUBMIT1,submit1);
        editor.putString(KEY_SUBMIT2,submit2);
        editor.putString(KEY_FINE1,fine1);
        editor.putString(KEY_FINE2,fine2);
        editor.apply();
        return true;
    }



    public boolean userlogin(String email,String name,String surname,String moblie,String sem,String depart,String news)
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
       // editor.putString(KEY_ID, String.valueOf(id));
        editor.putString(KEY_USER_EMAIL,email);
        editor.putString(KEY_USERNAME,name);
        editor.putString(KEY_DEPART,depart);
        editor.putString(KEY_SEM,sem);
        editor.putString(KEY_MOBILE,moblie);
        editor.putString(KEY_SURNAME,surname);
        editor.putString(KEY_NEWS,news);
        editor.apply();
        return true;
    }

    public boolean isLoggedIN()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_USERNAME,null)!=null)
        {
            return  true;
        }
        return  false;
    }

    public boolean isLoggedOUT()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();

        return  true;
    }

    public String getKeyBook1()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_BOOK1,null);
    }

    public String getKeyBook2()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_BOOK2,null);
    }
    public String getKeyIssue1()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_ISSUE1,null);
    }public String getKeyIssue2()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_ISSUE2,null);
    }public String getKeySubmit2()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_SUBMIT2,null);
    }public String getKeySubmit1()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_SUBMIT1,null);
    }

    public String getKeyFine1()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_FINE1,null);
    }

    public String getKeyFine2()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_FINE2,null);
    }

    public String getEnroll()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_EMAIL,null);
    }

    public String getSurname()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_SURNAME,null);
    }

    public String getKeyMobile()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_MOBILE,null);
    }

    public String getSem()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_SEM,null);
    }

    public String getDepart()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_DEPART,null);
    }

    public String getNews()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_NEWS,null);
    }

    public String getName()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME,null);
    }
    public String getPass()
    {
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHAREPREFENCE_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_PASS,null);
    }
}

package com.example.productappmzc;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    static String Dbname="Product.db";
    static String Tablename="products";
    static String col1="id";
    static String col2="productcode";
    static String col3="productprice";
    static String col4="productname";

    public DbHelper( Context context) {
        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table "+Tablename+
                " ("+col1+" integer primary key autoincrement,"+
                col2+" text,"+
                col3+" text,"+
                col4+" text)";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insert(String code,String price,String name){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put(col2,code);
        content.put(col3,price);
        content.put(col4,name);
        long status=db.insert(Tablename,null,content);
        if (status==-1)
        {
            return false;
        }
        else{
            return true;
        }


    }



}

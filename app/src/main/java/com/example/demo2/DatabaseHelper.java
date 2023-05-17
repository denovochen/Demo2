package com.example.demo2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.demo2.bean.BwlBean;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "register.db";
    public static final String TABLE_NAME = "registeruser";
    public static final String TABLE_BWL = "bwl";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "username";
    public static final String COL_3 = "password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY  KEY AUTOINCREMENT, username TEXT, password TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE bwl (bwlID INTEGER PRIMARY  KEY AUTOINCREMENT, bwlTitle TEXT, bwlText TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_BWL);
        onCreate(sqLiteDatabase);
    }

    public long addBwl(String bwlTitle, String bwlText) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("bwlTitle", bwlTitle);
        contentValues.put("bwlText", bwlText);
        long res = db.insert("bwl", null, contentValues);
        db.close();
        return res;
    }

    public List<BwlBean> bwlList() {
        //查询全部数据
        Cursor cursor = getWritableDatabase().query(TABLE_BWL, null, null, null, null, null, null, null);
        List<BwlBean> list = new ArrayList<>();
        if (cursor.getCount() > 0) {
            //移动到首位
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                Long id = cursor.getLong(cursor.getColumnIndex("bwlID"));
                String bwlTitle = cursor.getString(cursor.getColumnIndex("bwlTitle"));
                String bwlText = cursor.getString(cursor.getColumnIndex("bwlText"));

                BwlBean model = new BwlBean();
                model.setId(id);
                model.setBwlTitle(bwlTitle);
                model.setBwlText(bwlText);

                list.add(model);
                //移动到下一位
                cursor.moveToNext();
            }
        }

        cursor.close();
        getWritableDatabase().close();
        return list;
    }

    //删除备忘录
    public void deleteBwl(Long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        if (db.isOpen()) {
            String sql = "delete from bwl where bwlID = " + id;
            db.execSQL(sql);
        }
    }

    public long addUser(String user, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", user);
        contentValues.put("password", password);
        long res = db.insert("registeruser", null, contentValues);
        db.close();
        return res;
    }

    public boolean checkUser(String username, String password) {
        String[] columns = {COL_1};
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0)
            return true;
        else
            return false;
    }
}
package com.example.foodator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActionBarContextView;

import com.example.foodator.Models.groceryOrdersModel;

import java.util.ArrayList;

public class DBHelper_Grocery extends SQLiteOpenHelper {

    final static String DBNAME = "Foodator.db";
    final static int DBVERSION = 2;

    public DBHelper_Grocery(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table groceryOrders " +
                        "(id integer primary key autoincrement," +
                        "name text," +
                        "phone text," +
                        "price int," +
                        "image int," +
                        "quantity int," +
                        "description text," +
                        "groceryname text)"
        );

    }

    @Override
    public void onUpgrade(@NonNull SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP table if exists groceryOrders ");
        onCreate(sqLiteDatabase);
    }

    public boolean insertOrder(String name, String phone, int price, int image, String desc, String GroceryName, int quantity ){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        /*
        id = 0
        name = 1
        phone = 2
        price = 3
        image = 4
        desc = 5
        groceryname = 6
        quantity = 7
        */
        values.put("name",name);
        values.put("phone",phone);
        values.put("image",image);
        values.put("price",price);
        values.put("description",desc);
        values.put("groceryname",GroceryName);
        values.put("quantity",quantity);

        long id = database.insert("groceryOrders ", null, values);
        if(id <= 0){
            return false;
        }else {
            return true;
        }
    }
    public ArrayList<groceryOrdersModel> getOrders(){
        ArrayList<groceryOrdersModel> groceryOrders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id, groceryname,image,price from groceryOrders ",null);
        if (cursor.moveToFirst()){
            while (cursor.moveToNext()){
                groceryOrdersModel model = new groceryOrdersModel();
                model.setOrderNumber(cursor.getInt(0)+"");
                model.setSoldItemName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3)+"");
                groceryOrders.add(model);
            }
        }
        cursor.close();
        database.close();
        return groceryOrders;
    }



    public Cursor getOrderById(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from groceryOrders  where id ="+id,null);

        if (cursor != null)
            cursor.moveToFirst();

        return cursor;
    }

    public boolean updateOrder(String name, String phone, int price, int image, String desc, String GroceryName, int quantity, int id){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        /*
        id = 0
        name = 1
        phone = 2
        price = 3
        image = 4
        desc = 5
        groceryname = 6
        quantity = 7
        */
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("description",desc);
        values.put("groceryname",GroceryName);
        values.put("quantity",quantity);
        long row = database.update("groceryOrders ", values, "id="+id, null);
        if(row <= 0){
            return false;
        }else {
            return true;
        }
    }

    public int deleteOrder(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("groceryOrders ","id="+id,null);
    }

}
// lalalala
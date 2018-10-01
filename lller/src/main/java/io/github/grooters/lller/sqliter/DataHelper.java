package io.github.grooters.lller.sqliter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper{

    private static final String TAG=DataHelper.class.getSimpleName();
    private UpdateCreateInter updateCreateInter;
    private SQLiteDatabase db;

    public DataHelper(Context context,String libraryName,int Version){
        super(context,libraryName,null,Version);
        db=getWritableDatabase();
    }

    public void execute(String sql){
        db.execSQL(sql);
    }

    public void update(String tableName, ContentValues values,String selection,String[] args){
        db.update(tableName,values,selection,args);
    }

    public Cursor query(String tableName, String selection, String[] args){
        return db.query(tableName,null,selection,args,null,null,null);
    }

    public Cursor query(String tableName, String selection, String[] args,String groupBy,String having,String orderBy){
        return db.query(tableName,null,selection,args,groupBy,having,orderBy);
    }

    public void insert(String tableName,ContentValues values){
        db.insert(tableName,null,values);
    }

    public void delect(String tableName,String where,String[] args){
        db.delete(tableName,where,args);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        if(updateCreateInter!=null){
            updateCreateInter.onCreate(sqLiteDatabase);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(updateCreateInter!=null){
            updateCreateInter.onUpgrade(sqLiteDatabase, i, i1);
        }
    }

    public interface UpdateCreateInter{
        public void onCreate(SQLiteDatabase sqLiteDatabase);
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1);
    }

    public void setUpdateCreateInter(UpdateCreateInter updateCreateInter){
        this.updateCreateInter=updateCreateInter;
    }

}

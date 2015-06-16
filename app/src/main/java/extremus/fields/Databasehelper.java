package extremus.fields;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Divya on 15-06-2015.
 */
public class Databasehelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Extremus_db.db";
    public String QUERY_STRING;
    public SQLiteDatabase db;
    public Databasehelper(Context context, String Query_String)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        QUERY_STRING = Query_String;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUERY_STRING);
        this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void executeSQL(String Query){
        db = this.getWritableDatabase();
        db.execSQL(Query);
        db.close();
    }
    public Cursor rawSQL(String Query){
        db = this.getReadableDatabase();
        Cursor c = db.rawQuery(Query,null);
        return c;
    }
}

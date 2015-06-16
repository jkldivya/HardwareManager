package extremus;

import android.app.ActionBar;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.divya.addition.models.Controller;

import extremus.data.DataField;
import extremus.data.DataFieldList;
import extremus.fields.Databasehelper;

/**
 * Created by kittuov on 13/6/15.
 */
public class Model {
    private DataFieldList BufferData = new DataFieldList();
    private boolean FromDB = false;
    public String TableName;
    private Databasehelper db;
    private Context context;
//    private SQLiteDatabase db;
    public int id;
    public Model(Context context, String TableName){
        this.TableName = TableName;
        this.context = context;
//        db = db1.db;
    }

    public void Register(DataField...fields){
        for (DataField field:fields){
            BufferData.push(field);
        }
        String TABLE_FIELDS="CREATE TABLE "+ TableName;
        TABLE_FIELDS+="(id INTEGER PRIMARY KEY,";
        for(int i=0;i<BufferData.length();i++)
        {
            DataField curr_field=BufferData.get(i);
            TABLE_FIELDS+=" "+curr_field.column_name+" "+" "+curr_field.type;
            switch(curr_field.type)
            {
                case "VARCHAR":
                    TABLE_FIELDS+="("+curr_field.max_length+") ";
                    break;
            }
            if(!(curr_field.isNull))
            {
                TABLE_FIELDS+=" not null " ;
            }
            if (i!=BufferData.length()-1)
                TABLE_FIELDS+=", ";
        }
        TABLE_FIELDS+=" )";
        System.out.println(TABLE_FIELDS);
        System.out.println(TABLE_FIELDS);
        System.out.println(TABLE_FIELDS);
        db=new Databasehelper(context, TABLE_FIELDS);
    }
    public void save(){
        String Query="";
        String query1 = "";
        if(!FromDB)
        {
            String Fields = "";
            String Values = "";
            for (int i = 0;i<BufferData.length();i++){
                Fields+= "`"+BufferData.get(i).column_name+"`";
                switch (BufferData.get(i).type){
                    case "VARCHAR":
                        Values+=" '"+BufferData.get(i).CharObject.value+"' ";
                        break;
                    case "BOOLEAN":
                        if (BufferData.get(i).BoolObject.value)
                            Values+=" 1 ";
                        else
                            Values+=" 0 ";
                        break;
                    case "INT":
                        Values+=" "+BufferData.get(i).IntObject.value;
                        break;
                }
                if (i!=BufferData.length()-1)
                {
                    Values+=" , ";
                    Fields+=" , ";
                }
            }
//            Fields += " , `id`";
//            Values += " , 75";
            query1="INSERT INTO " +TableName+" ("+Fields+") VALUES("+Values+")";
        }
        else{
            for (int i = 0;i<BufferData.length();i++){
                Query+=BufferData.get(i).to_sql();
                if (i!=BufferData.length()-1)
                    Query+=" , ";
            }
            query1="UPDATE TABLE "+TableName+" SET "+Query+" where `id` = "+this.id;
        }
        db.executeSQL(query1);
        if(!FromDB)
            for (int i = 0;i<BufferData.length();i++) {
                Query += BufferData.get(i).to_sql();
                if (i != BufferData.length() - 1)
                    Query += " , ";
            }
            this.get(Query);
        FromDB = true;

    }
    public void get(String Query){
        //TODO: handle DoesNotExist Exception
        FromDB = true;
        String Query_Fields = "`id`, ";
        for (int i=0;i<BufferData.length();i++){
            Query_Fields += BufferData.get(i).column_name;
            if (i!=BufferData.length()-1) Query_Fields+=", ";
        }
        Query = Query.replace(","," and ");
        String Query_Final = "SELECT "+Query_Fields+" FROM "+TableName+" WHERE "+Query;
        Cursor cursor = db.rawSQL(Query_Final);
        String a,b;
        b="not Fount";
        if (cursor.moveToFirst()){
            this.id = cursor.getInt(0);
            for (int i = 0;i<BufferData.length();i++){
                DataField Field=BufferData.get(i);
                switch (Field.type){
                    case "VARCHAR":
                        Field.CharObject.value = cursor.getString(i+1);
                        break;
                    case "INT":
                        Field.IntObject.value = cursor.getInt(i+1);
                        break;
                    case "BOOLEAN":
                        if (cursor.getString(i+1)=="true")
                            Field.BoolObject.value = true;
                        else
                            Field.BoolObject.value = false;
                }
            }
        }

    }
    public void delete(){
        String Query = "DELETE FROM "+TableName+" WHERE `id` = "+this.id;
        db.executeSQL(Query);
    }
}
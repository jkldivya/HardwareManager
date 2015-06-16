package extremus.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import extremus.fields.BoolField;
import extremus.fields.CharField;
import extremus.fields.IntField;

/**
 * Created by kittuov on 13/6/15.
 */
public class DataField {
    public String column_name;
    public String type;
    public int max_length;
    public IntField IntObject;
    public CharField CharObject;
    public BoolField BoolObject;
    public boolean isNull=false;
    public String to_sql(){
        switch (type){
            case "VARCHAR":
                return "`"+column_name+"` = "+"'"+CharObject.value+"'";
            case "INT":
                return "`"+column_name+"` = "+IntObject.value;
            case "BOOLEAN":
                if(BoolObject.value) {
                    return "`" + column_name + "` = 1";
                }if(!BoolObject.value) {
                    return "`" + column_name + "` = 0";
                }
            default:
                return "error";
        }
    }
}

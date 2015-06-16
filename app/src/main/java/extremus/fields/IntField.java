package extremus.fields;

import extremus.data.DataField;

/**
 * Created by kittuov on 13/6/15.
 */
public class IntField extends DataField {
    //TODO:check the data field type String
    public int value;
    public IntField (String name){
        this.column_name = name;
        this.type = "INT";
        this.max_length = 30;
        this.IntObject = this;
    }
    public IntField (String name, int Default){
        this.column_name = name;
        this.type = "INT";
        this.max_length = 30;
        this.IntObject = this;
        this.value = Default;
    }
}

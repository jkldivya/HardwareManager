package extremus.fields;

import extremus.data.DataField;

/**
 * Created by kittuov on 13/6/15.
 */
public class BoolField extends DataField{
    //TODO:check the data field type String
    public boolean value;
    public BoolField (String name){
        this.column_name = name;
        this.type = "BOOLEAN";
        this.max_length = 30;
        this.BoolObject = this;
    }
    public BoolField (String name, boolean Default){
        this.column_name = name;
        this.type = "BOOLEAN";
        this.max_length = 30;
        this.BoolObject = this;
        this.value = Default;
    }
}

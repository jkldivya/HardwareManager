package extremus.fields;

import extremus.data.DataField;

/**
 * Created by kittuov on 13/6/15.
 */
public class CharField extends DataField{
    //TODO:check the data field type String
    public String value;
    public CharField (String name){
        this.column_name = name;
        this.type = "VARCHAR";
        this.max_length = 30;
        this.CharObject = this;
    }
    public CharField (String name,int max_length, String Default){
        this.column_name = name;
        this.type = "VARCHAR";
        this.max_length = max_length;
        this.value = Default;
        this.CharObject = this;
    }
    public CharField (String name, String Default){
        this.column_name = name;
        this.type = "VARCHAR";
        this.max_length = 30;
        this.value = Default;
        this.CharObject = this;
    }
    public CharField (String name, int max_length){
        this.column_name = name;
        this.type = "VARCHAR";
        this.max_length = max_length;
        this.CharObject = this;
    }
}

package com.example.divya.addition.models;
import android.content.Context;


import extremus.Model;
import extremus.fields.BoolField;
import extremus.fields.CharField;

/**
 * Created by Divya on 11-06-2015.
 */
public class Controller extends Model {

    public BoolField status = new BoolField("status");
    public CharField name= new CharField("name",30);
    public CharField last_contact = new CharField("last_contact",50);
    public Controller(Context context){
        super(context, "controller");
        super.Register(name,status,last_contact);
        super.TableName="controller";
    }
}

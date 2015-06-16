package extremus.data;

/**
 * Created by kittuov on 14/6/15.
 */
public class DataFieldList {
    private DataField[] datalist = new DataField[10];
    private int counter = 0;
    public void push(DataField DataFieldObject){
        datalist[counter]=DataFieldObject;
        counter++;
    }
    public int length(){
        return counter;
    }
    public DataField get(int index){
        return datalist[index];
    }
}

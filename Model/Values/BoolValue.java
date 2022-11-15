package Model.Values;

import Model.Types.BoolType;
import Model.Types.Type;

public class BoolValue implements Value{
    boolean value;

    public BoolValue(boolean _value){
        value = _value;
    }

    public boolean getValue(){
        return value;
    }

    @Override
    public String toString(){
        if(value)
            return "True";
        else return "False";
    }

    public Type getType(){
        return new BoolType();
    }
}

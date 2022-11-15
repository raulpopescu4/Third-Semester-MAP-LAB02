package Model.Types;

import Model.Values.IntValue;

public class IntType implements Type{
    public boolean equals(Object another){
        return another instanceof IntType;
    }

    public IntValue getDefaultValue(){
        return new IntValue(0);
    }

    @Override
    public String toString(){
        return "int";
    }
}

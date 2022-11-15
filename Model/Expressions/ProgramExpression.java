package Model.Expressions;

import Exceptions.MyException;
import Model.DataStructures.MyiDictionary;
import Model.Values.Value;

public interface ProgramExpression {
    Value evaluate(MyiDictionary<String, Value> table) throws MyException;

    ProgramExpression createDeepCopy();
}

package Model.Statements;

import Exceptions.MyException;
import Model.DataStructures.MyiDictionary;
import Model.DataStructures.MyiStack;
import Model.Expressions.ProgramExpression;
import Model.ProgramState;
import Model.Types.Type;
import Model.Values.Value;

import java.beans.Expression;

public class AssignStatement implements iStatement{
    String id;
    ProgramExpression expression;

    public AssignStatement(String _id, ProgramExpression _expression){
        id = _id;
        expression = _expression;

    }

    public ProgramState execute(ProgramState state) throws MyException {
        MyiStack<iStatement> stack = state.getExecutionStack();
        MyiDictionary<String, Value> symbolTable = state.getSymbolsTable();

        if (symbolTable.isDefined(id)){
            Value value = expression.evaluate(symbolTable);
            Type idType = (symbolTable.lookUp(id).getType());
            if(value.getType().equals(idType))
                symbolTable.update(id, value);
            else throw new MyException("declared type of variable" + id + " and type of the assigned expression do not match");


        }
        else throw new MyException("the used variable" + id + "was not declared before");

        return state;
    }

    public iStatement createDeepCopy() {
        return new AssignStatement(id, expression.createDeepCopy());
    }

    @Override
    public String toString(){
        return id + " = " + expression.toString();
    }


}

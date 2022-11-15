package Model.Statements;

import Exceptions.MyException;
import Model.DataStructures.MyiDictionary;
import Model.DataStructures.MyiStack;
import Model.Expressions.ProgramExpression;
import Model.ProgramState;
import Model.Values.BoolValue;
import Model.Values.Value;

import java.beans.Expression;

public class IfStatement implements iStatement{
    ProgramExpression expression;
    iStatement thenS;
    iStatement elseS;

    public IfStatement(ProgramExpression _expression, iStatement _thenS, iStatement _elseS){
        expression = _expression;
        thenS = _thenS;
        elseS = _elseS;
    }

    @Override
    public String toString(){
        return "(IF(" + expression.toString() + ") THEN(" + thenS.toString() + ") ELSE(" + elseS.toString() + "))";
    }

    public ProgramState execute(ProgramState state) throws MyException {
        MyiDictionary<String, Value> symbolsTable = state.getSymbolsTable();

        Value expressionValue = expression.evaluate(symbolsTable);

        if(expressionValue instanceof BoolValue booleanExpression) {
            MyiStack<iStatement> executionStack = state.getExecutionStack();

            if (booleanExpression.getValue())
                executionStack.push(thenS);
            else executionStack.push(elseS);

            state.setExecutionStack(executionStack);

            return state;
        }
        else
            throw new MyException("Conditional expression is not a boolean!");
    }

    public iStatement createDeepCopy() {
        return new IfStatement(expression.createDeepCopy(), thenS.createDeepCopy(), elseS.createDeepCopy());
    }
}

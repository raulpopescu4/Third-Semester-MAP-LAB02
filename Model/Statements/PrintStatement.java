package Model.Statements;

import Exceptions.MyException;
import Model.DataStructures.MyiList;
import Model.Expressions.ProgramExpression;
import Model.ProgramState;
import Model.Values.Value;

public class PrintStatement implements iStatement{
    ProgramExpression expression;

    public PrintStatement(ProgramExpression _expression){
        expression = _expression;
    }

    public ProgramState execute(ProgramState state) throws MyException {
        MyiList<Value> outputValues = state.getOutputValues();

        outputValues.add(expression.evaluate(state.getSymbolsTable()));

        state.setOutputValues(outputValues);

        return state;
    }

    public iStatement createDeepCopy() {
        return new PrintStatement(expression.createDeepCopy());
    }

    @Override
    public String toString(){
        return "print(" + expression.toString() + ")";
    }


}

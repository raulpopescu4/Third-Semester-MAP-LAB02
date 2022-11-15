package Model;

import Model.DataStructures.*;
import Model.Statements.iStatement;
import Model.Values.Value;

public class ProgramState {
    MyiStack<iStatement> executionStack;
    MyiList<Value> outputValues;
    MyiDictionary<String, Value> symbolsTable;

    iStatement originalProgram;

    public ProgramState(iStatement _program){
        executionStack = new MyStack<>();
        symbolsTable = new MyDictionary<>();
        outputValues = new MyList<>();

        originalProgram = _program.createDeepCopy();

        executionStack.push(originalProgram);
    }

    public MyiStack<iStatement> getExecutionStack() {
        return executionStack;
    }

    public MyiList<Value> getOutputValues(){
        return outputValues;
    }


    public MyiDictionary<String, Value> getSymbolsTable() {
        return symbolsTable;
    }

    public void setOutputValues(MyiList<Value> newOutputValues) {
        outputValues = newOutputValues;
    }

    public void setExecutionStack(MyiStack<iStatement> newExecutionStack) {
        executionStack = newExecutionStack;
    }

    public void setSymbolsTable(MyiDictionary<String, Value> newSymbolsTable) {
        symbolsTable = newSymbolsTable;
    }

    public void resetToOriginalProgram() {
        executionStack = new MyStack<>();
        symbolsTable = new MyDictionary<>();
        outputValues = new MyList<>();

        executionStack.push(originalProgram.createDeepCopy());
    }

    @Override
    public String toString(){
        return "Execution stack: \n" + executionStack.toString() + "\nSymbols table: \n" + symbolsTable.toString() + "\nOutput values: \n" + outputValues.toString();
    }
}

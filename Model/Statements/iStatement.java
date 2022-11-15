package Model.Statements;

import Exceptions.MyException;
import Model.ProgramState;

public interface iStatement {
    ProgramState execute(ProgramState state) throws MyException;

    public iStatement createDeepCopy();
}
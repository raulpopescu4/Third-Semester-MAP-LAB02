package Repository;

import Model.ProgramState;

public class Repository implements iRepository{

    ProgramState programState;

    public Repository(ProgramState _programState){
        programState = _programState;
    }

    public ProgramState getCurrentProgramState() {
        return programState;
    }

    public void setProgramState(ProgramState newProgramState){
        programState = newProgramState;
    }
}

package model;


import exception.InvalidInput;

public class Ladder extends Jump{
    public Ladder(int from, int to) throws Exception {
        super(from, to);
        validateInputs();
    }

    @Override
    protected void validateInputs() throws Exception {
        if(from >= to)
            throw new InvalidInput("'from' should be less than 'to' on Ladder");
    }
}

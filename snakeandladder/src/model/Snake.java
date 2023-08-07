package model;


import exception.InvalidInput;

public class Snake extends Jump{
    public Snake(int from, int to) throws Exception {
        super(from, to);
        validateInputs();
    }

    @Override
    protected void validateInputs() throws Exception {
        if(from <= to)
            throw new InvalidInput("'to' should be less than 'from' on Snake");
    }
}

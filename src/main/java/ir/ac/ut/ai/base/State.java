package ir.ac.ut.ai.base;

public class State<S> {

    private S data;

    public State(S state) {
        this.data = state;
    }

    public S getData() {
        return data;
    }
}
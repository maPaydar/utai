package ir.ut.ai.base;

public class Action<A> {

    private A action;

    public Action(A action) {
        this.action = action;
    }

    public A getAction() {
        return action;
    }
}
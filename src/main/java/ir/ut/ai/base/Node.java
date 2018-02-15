package ir.ut.ai.base;

public class Node<S, A> {

    private State<S> state;
    private Node<S, A> parent;
    private Action<A> action;
    private double pathCost;

    public Node(State<S> state, Node<S, A> parent,
                Action<A> action, double pathCost) {
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.pathCost = pathCost;
    }

    public Action<A> getAction() {
        return action;
    }

    public double getPathCost() {
        return pathCost;
    }

    public State<S> getState() {
        return state;
    }

    public Node<S, A> getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "{" +
                "State: " + state.getData() +
                "}";
    }
}
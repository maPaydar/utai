package ir.ac.ut.ai.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Problem<S, A> {

    protected Node<S, A> initialNode;
    protected Map<Node<S, A>, ArrayList<Node<S, A>>> nextNodes;
    protected Map<Node<S, A>, ArrayList<Action<A>>> actions;

    public Problem(Node<S, A> initialNode, Map<Node<S, A>, ArrayList<Node<S, A>>> nextNodes) {
        this.initialNode = initialNode;
        this.nextNodes = nextNodes;
        this.actions = new HashMap<>();
        for (Node node : nextNodes.keySet()) {
            ArrayList listActions = new ArrayList();
            for (Node<S, A> nn : nextNodes.get(node)) {
                listActions.add(nn.getAction());
            }
            actions.put(node, listActions);
        }
    }

    public Map<Node<S, A>, ArrayList<Action<A>>> getActions() {
        return actions;
    }

    public Node<S, A> getInitialNode() {
        return initialNode;
    }

    public abstract Node<S, A> result(Node<S, A> parentNode, Action<A> action);
    public abstract double stepCost(Node<S, A> parentNode, Action<A> action);
    public abstract boolean isGoal(Node<S, A> node);
}

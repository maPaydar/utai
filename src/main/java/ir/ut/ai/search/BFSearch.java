package ir.ut.ai.search;

import ir.ut.ai.base.Action;
import ir.ut.ai.base.Node;
import ir.ut.ai.base.Problem;

import java.util.ArrayList;
import java.util.List;

public class BFSearch<S, A> extends SearchBase<S, A> {

    private List<Node<S, A>> frontier;
    private List<Node<S, A>> explored;

    public BFSearch(Problem<S, A> problem) {
        super(problem);
        this.frontier = new ArrayList<>();
        this.explored = new ArrayList<>();
    }

    @Override
    protected List<Node<S, A>> solution(Node<S, A> node) {
        return explored;
    }

    @Override
    public List<Node<S, A>> run() {
        Node node = problem.getInitialNode();
        if (problem.isGoal(node)) {
            return new ArrayList<Node<S, A>>() {{
                add(node);
            }};
        }
        frontier.add(node);
        while (!frontier.isEmpty()) {
            Node cNode = frontier.remove(0);
            explored.add(cNode);
            if (problem.isGoal(cNode)) {
                return solution(cNode);
            }
            ArrayList<Action<A>> actionList = problem.getActions().get(cNode);
            if (actionList == null)
                actionList = new ArrayList<>();
            for (Action action : actionList) {
                Node nextNode = nexNode(cNode, action);
                if (nextNode != null) {
                    if (!frontier.contains(nextNode) || !explored.contains(nextNode)) {
                        frontier.add(nextNode);
                    }
                }
            }
        }
        return new ArrayList<>();
    }
}

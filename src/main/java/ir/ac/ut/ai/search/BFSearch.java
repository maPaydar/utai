package ir.ac.ut.ai.search;

import ir.ac.ut.ai.base.Action;
import ir.ac.ut.ai.base.Node;
import ir.ac.ut.ai.base.Problem;

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
    public List<Node<S, A>> run() {
        Node node = problem.getInitialNode();
        if (problem.isGoal(node)) {
            return new ArrayList<Node<S, A>>() {{
                add(node);
            }};
        }
        frontier.add(node);
        while (true) {
            if (frontier.isEmpty()) {
                return new ArrayList<>();
            }
            Node cNode = frontier.remove(frontier.size() - 1);
            explored.add(cNode);
            ArrayList<Action<A>> actionList = problem.getActions().get(cNode);
            if (actionList == null)
                actionList = new ArrayList<>();
            for (Action action : actionList) {
                Node nextNode = nexNode(cNode, action);
                if (nextNode != null) {
                    if (!frontier.contains(nextNode) || !explored.contains(nextNode)) {
                        if (problem.isGoal(nextNode))
                            return solution(nextNode);
                        frontier.add(nextNode);
                    }
                }
            }
        }
    }
}

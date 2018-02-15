package ir.ut.ai.search;

import ir.ut.ai.base.Action;
import ir.ut.ai.base.Node;
import ir.ut.ai.base.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSearch<S, A> extends SearchBase<S, A> {

    private Stack<Node<S, A>> frontier;
    private ArrayList<Node<S, A>> explored;

    public DFSearch(Problem<S, A> problem) {
        super(problem);
        explored = new ArrayList<>();
        frontier = new Stack<>();
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
            Node currentNode = frontier.pop();
            if (explored.contains(currentNode))
                continue;
            explored.add(currentNode);
            if (problem.isGoal(currentNode)) {
                return solution(currentNode);
            }
            ArrayList<Action<A>> actionsList = problem.getActions().get(currentNode);
            if (actionsList == null)
                actionsList = new ArrayList<>();
            for (Action action : actionsList) {
                Node nextNode = nexNode(currentNode, action);
                if (nextNode != null) {
                    frontier.push(nextNode);
                }
            }
        }
        return new ArrayList<>();
    }
}

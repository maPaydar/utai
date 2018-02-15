package ir.ut.ai.problems;

import ir.ut.ai.base.Action;
import ir.ut.ai.base.Node;
import ir.ut.ai.base.Problem;

import java.util.ArrayList;
import java.util.Map;

public class WordProblem extends Problem<String, Integer> {

    public WordProblem(Node initialNode, Map<Node<String, Integer>, ArrayList<Node<String, Integer>>> nextNodes) {
        super(initialNode, nextNodes);
    }

    @Override
    public Node result(Node parentNode, Action action) {
        for (Node n : nextNodes.get(parentNode)) {
            if (n.getAction() == action)
                return n;
        }
        return null;
    }

    @Override
    public double stepCost(Node parentNode, Action action) {
        return 1;
    }

    @Override
    public boolean isGoal(Node node) {
        return node.getState().getData() == "B";
    }
}

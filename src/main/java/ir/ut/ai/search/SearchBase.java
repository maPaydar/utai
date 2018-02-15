package ir.ut.ai.search;

import ir.ut.ai.base.Action;
import ir.ut.ai.base.Node;
import ir.ut.ai.base.Problem;

import java.util.ArrayList;
import java.util.List;

public abstract class SearchBase<S, A> {

    protected Problem<S, A> problem;

    public SearchBase(Problem<S, A> problem) {
        this.problem = problem;
    }

    protected Node<S, A> nexNode(Node<S, A> parentNode, Action<A> action) {
        Node<S, A> resultedNode = problem.result(parentNode, action);
        if (resultedNode != null) {
            double pathCost = parentNode.getPathCost() + problem.stepCost(parentNode, action);
            Node<S, A> node = new Node(resultedNode.getState(), parentNode, action, pathCost);
            return node;
        }
        return null;
    }

    protected List<Node<S, A>> solution(Node<S, A> node) {
        List<Node<S, A>> nodes = new ArrayList();
        Node tempNode = node;
        while(tempNode != null) {
            nodes.add(tempNode);
            tempNode = tempNode.getParent();
        }
        return nodes;
    }

    public abstract List<Node<S, A>> run();
}

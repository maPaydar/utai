package ir.ut.ai.problems

import ir.ut.ai.base.Action
import ir.ut.ai.base.Node
import ir.ut.ai.base.Problem

import java.util.ArrayList

class WordProblem(initialNode: Node<String, Int>, nextNodes: Map<Node<String, Int>, ArrayList<Node<String, Int>>>) : Problem<String, Int>(initialNode, nextNodes) {

    override fun result(parentNode: Node<String, Int>, action: Action<Int>): Node<String, Int>? {
        for (n in nextNodes[parentNode]!!) {
            if (n.action == action)
                return n
        }
        return null
    }

    override fun stepCost(parentNode: Node<String, Int>, action: Action<Int>): Double {
        return 1.0
    }

    override fun isGoal(node: Node<String, Int>): Boolean {
        return node.state.data === "B"
    }
}

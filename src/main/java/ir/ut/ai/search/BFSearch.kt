package ir.ut.ai.search

import ir.ut.ai.base.Action
import ir.ut.ai.base.Node
import ir.ut.ai.base.Problem

import java.util.ArrayList

class BFSearch<S, A>(problem: Problem<S, A>) : SearchBase<S, A>(problem) {

    private val frontier: MutableList<Node<S, A>> = ArrayList<Node<S, A>>()
    private val explored: MutableList<Node<S, A>> = ArrayList<Node<S, A>>()

    override fun solution(node: Node<S, A>): List<Node<S, A>> {
        return explored
    }

    override fun run(): List<Node<S, A>> {
        val node = problem.initialNode
        if (problem.isGoal(node)) {
            return object : ArrayList<Node<S, A>>() {
                init {
                    add(node)
                }
            }
        }
        frontier.add(node)
        while (!frontier.isEmpty()) {
            val cNode = frontier.removeAt(0)
            explored.add(cNode)
            if (problem.isGoal(cNode)) {
                return solution(cNode)
            }
            var actionList: ArrayList<Action<A>>? = problem.actions[cNode]
            for (action in actionList!!) {
                val nextNode = nexNode(cNode, action)
                if (nextNode != null) {
                    if (!frontier.contains(nextNode) || !explored.contains(nextNode)) {
                        frontier.add(nextNode)
                    }
                }
            }
        }
        return ArrayList()
    }
}

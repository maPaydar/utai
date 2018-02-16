package ir.ut.ai.search

import ir.ut.ai.base.Action
import ir.ut.ai.base.Node
import ir.ut.ai.base.Problem

import java.util.ArrayList
import java.util.Stack

class DFSearch<S, A>(problem: Problem<S, A>) : SearchBase<S, A>(problem) {

    private val frontier: Stack<Node<S, A>> = Stack()
    private val explored: ArrayList<Node<S, A>> = ArrayList()

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
            val currentNode = frontier.pop()
            if (explored.contains(currentNode))
                continue
            explored.add(currentNode)
            if (problem.isGoal(currentNode)) {
                return solution(currentNode)
            }
            var actionsList: ArrayList<Action<A>>? = problem.actions[currentNode]
            if (actionsList != null)
                for (action in actionsList) {
                    val nextNode = nexNode(currentNode, action)
                    if (nextNode != null) {
                        frontier.push(nextNode)
                    }
                }
        }
        return ArrayList()
    }
}

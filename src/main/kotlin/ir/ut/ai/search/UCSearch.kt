package ir.ut.ai.search

import ir.ut.ai.base.Action
import ir.ut.ai.base.Node
import ir.ut.ai.base.Problem
import java.util.*
import kotlin.collections.ArrayList


/**
 * Uniform Cost Search
 */
class UCSearch<S, A>(problem: Problem<S, A>) : SearchBase<S, A>(problem) {

    private val frontier: PriorityQueue<Node<S, A>>
    private val explored: MutableList<Node<S, A>> = ArrayList<Node<S, A>>()

    init {
        frontier = PriorityQueue<Node<S, A>>(kotlin.Comparator { o1, o2 ->
            if (o1.pathCost > o2.pathCost)
                1
            else
                -1
        })
    }

    override fun run(): List<Node<S, A>> {
        frontier.add(problem.initialNode)

        while (!frontier.isEmpty()) {
            val currentNode = frontier.remove() // pop min cost node
            explored.add(currentNode)
            if (problem.isGoal(currentNode))
                return solution(currentNode)
            val actionList: ArrayList<Action<A>>? = problem.actions[currentNode]
            if (actionList != null) {
                for (action in actionList) {
                    val nextNode = nextNode(currentNode, action)
                    if (nextNode != null) {
                        if (!frontier.contains(nextNode) || !explored.contains(nextNode)) {
                            frontier.add(nextNode)
                        }
                    }
                }
            }
        }
        return ArrayList<Node<S, A>>()
    }

}
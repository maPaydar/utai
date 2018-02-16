package ir.ut.ai.base

import java.util.ArrayList
import java.util.HashMap

abstract class Problem<S, A>(initialNode: Node<S, A>, protected var nextNodes: Map<Node<S, A>, ArrayList<Node<S, A>>>) {

    var initialNode: Node<S, A> protected set
    var actions: HashMap<Node<S, A>, ArrayList<Action<A>>>

    init {
        this.initialNode = initialNode
        this.actions = HashMap()
        for (node in nextNodes.keys) {
            val res : ArrayList<Node<S, A>>? = nextNodes.get(node)
            val listActions = res?.map { nn -> nn.action }
            actions.put(node, listActions as ArrayList<Action<A>>)
        }
    }

    abstract fun result(parentNode: Node<S, A>, action: Action<A>): Node<S, A>?
    abstract fun stepCost(parentNode: Node<S, A>, action: Action<A>): Double
    abstract fun isGoal(node: Node<S, A>): Boolean
}

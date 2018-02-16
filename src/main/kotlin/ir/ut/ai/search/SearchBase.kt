package ir.ut.ai.search

import ir.ut.ai.base.Action
import ir.ut.ai.base.Node
import ir.ut.ai.base.Problem

import java.util.ArrayList

abstract class SearchBase<S, A>(protected var problem: Problem<S, A>) {

    protected fun nextNode(parentNode: Node<S, A>, action: Action<A>): Node<S, A>? {
        val resultedNode = problem.result(parentNode, action)
//        val pathCost = parentNode.pathCost + problem.stepCost(parentNode, action)
//        resultedNode?.pathCost = pathCost
        return resultedNode
    }

    protected open fun solution(node: Node<S, A>): List<Node<S, A>> {
        val nodes = ArrayList<Node<S, A>>()
        var tempNode: Node<S, A>? = node
        while (tempNode != null) {
            nodes.add(tempNode)
            tempNode = tempNode.parent
        }
        return nodes
    }

    abstract fun run(): List<Node<S, A>>
}

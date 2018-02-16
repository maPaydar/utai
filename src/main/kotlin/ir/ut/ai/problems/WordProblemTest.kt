package ir.ut.ai.problems

import ir.ut.ai.base.Action
import ir.ut.ai.base.Node
import ir.ut.ai.base.State
import ir.ut.ai.search.DFSearch

import java.util.ArrayList

fun main(args: Array<String>) {
    val s0 = State("A")
    val s1 = State("B")
    val s2 = State("C")
    val s3 = State("D")
    val s4 = State("E")
    val s5 = State("F")
    val s6 = State("G")

    val n0 = Node<String, Int>(s0, null, null, 0.0)

    val n1 = Node(s1, n0, Action(0), 1.0)
    val n2 = Node(s2, n0, Action(1), 10.0)

    val n3 = Node(s3, n1, Action(0), 4.0)
    val n4 = Node(s4, n1, Action(1), 3.0)

    val n5 = Node(s5, n2, Action(0), 20.0)
    val n6 = Node(s6, n2, Action(1), 7.0)

    val wordProblem = WordProblem(n0,
            hashMapOf(n0 to arrayListOf(n1, n2),
                    n1 to arrayListOf(n3, n4),
                    n2 to arrayListOf(n5, n6)))
    val dfSearch = DFSearch(wordProblem)
    val solution = dfSearch.run() as ArrayList<*>
    println(solution)
}


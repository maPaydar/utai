package ir.ut.ai.base

class Node<S, A>(val state: State<S>, val parent: Node<S, A>?,
                 val action: Action<A>?, var pathCost: Double) {

    override fun toString(): String {
        return "{" +
                "State: " + state.data +
                "}"
    }
}
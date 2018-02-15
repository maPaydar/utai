package ir.ac.ut.ai;

import ir.ac.ut.ai.base.Action;
import ir.ac.ut.ai.base.Node;
import ir.ac.ut.ai.base.State;
import ir.ac.ut.ai.problems.WordProblem;
import ir.ac.ut.ai.search.BFSearch;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        State<String> s0 = new State<>("A");
        State<String> s1 = new State<>("B");
        State<String> s2 = new State<>("C");

        Node<String, Integer> n0 = new Node<>(s0, null, null, 0);
        Node<String, Integer> n1 = new Node<>(s1, n0, new Action<>(0), 0);
        Node<String, Integer> n2 = new Node<>(s2, n0, new Action<>(1), 0);

        WordProblem wordProblem = new WordProblem(n0, new HashMap<Node<String, Integer>, ArrayList<Node<String,Integer>>>() {{
            put(n0, new ArrayList<Node<String, Integer>>() {{
                add(n1);
                add(n2);
            }});
        }});

        BFSearch<String, Integer> bfSearch = new BFSearch<>(wordProblem);
        ArrayList solution = (ArrayList) bfSearch.run();
        System.out.println(solution);
    }
}

package ir.ut.ai.problems;

import ir.ut.ai.base.Action;
import ir.ut.ai.base.Node;
import ir.ut.ai.base.State;
import ir.ut.ai.problems.WordProblem;
import ir.ut.ai.search.DFSearch;

import java.util.ArrayList;
import java.util.HashMap;

public class WordProblemTest {

    public static void main(String[] args) {
        State<String> s0 = new State<>("A");
        State<String> s1 = new State<>("B");
        State<String> s2 = new State<>("C");
        State<String> s3 = new State<>("D");
        State<String> s4 = new State<>("E");
        State<String> s5 = new State<>("F");
        State<String> s6 = new State<>("G");

        Node<String, Integer> n0 = new Node<>(s0, null, null, 0);

        Node<String, Integer> n1 = new Node<>(s1, n0, new Action<>(0), 0);
        Node<String, Integer> n2 = new Node<>(s2, n0, new Action<>(1), 0);

        Node<String, Integer> n3 = new Node<>(s3, n1, new Action<>(0), 0);
        Node<String, Integer> n4 = new Node<>(s4, n1, new Action<>(1), 0);

        Node<String, Integer> n5 = new Node<>(s5, n2, new Action<>(0), 0);
        Node<String, Integer> n6 = new Node<>(s6, n2, new Action<>(1), 0);

        WordProblem wordProblem = new WordProblem(n0, new HashMap<Node<String, Integer>, ArrayList<Node<String,Integer>>>() {{
            put(n2, new ArrayList<Node<String, Integer>>() {{
                add(n5);
                add(n6);
            }});
            put(n0, new ArrayList<Node<String, Integer>>() {{
                add(n1);
                add(n2);
            }});
            put(n1, new ArrayList<Node<String, Integer>>() {{
                add(n3);
                add(n4);
            }});
        }});

        DFSearch<String, Integer> dfSearch = new DFSearch<>(wordProblem);
        ArrayList solution = (ArrayList) dfSearch.run();
        System.out.println(solution);
    }
}

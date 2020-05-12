package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node{

    private final String name;
    private final List<Node> nodeLink = new ArrayList<>();
    private List<Node> nodeAnswer = new ArrayList<>();
    private Node next;

    /** Constructor */
    public Node(String nm){
        this.name = nm;
        setNext(Node.this);
    }

    /** Setters **/
    public void setNodeLink(Node ... n) {
        this.nodeLink.addAll(Arrays.asList(n));
    }

    public void setNodeAnswer(Node n) {
        this.nodeAnswer.add(n);
    }

    public void setNext(Node next) {
        this.next = next;
    }

    /** Getters **/
    public String getname() {
        return name;
    }

    public List<Node> getNodeLink() {
        return nodeLink;
    }

    public List<String> getNodeAnswer() {
        ArrayList<String> names = new ArrayList<>();
        for (Node i : nodeAnswer){
            names.add(i.getname());
        }
        return names;
    }

    public Node getNext() {
        return next;
    }

    public List<String> input(String ... N){
        Node current = getNext(); //get node s0
        setNodeAnswer(current);
        for (String i : N){
            if(i.equals("B")){
                List<Node> currentNodeList = current.getNodeLink();
                setNext(currentNodeList.get(0)); //Ga naar de volgende node
                setNodeAnswer(getNext()); //Sla de node op
            }else if (i.equals("A")){
                try {
                    List<Node> currentNodeList = current.getNodeLink();
                    setNext(currentNodeList.get(1)); //Herhaal de node.
                    setNodeAnswer(getNext()); // Sla de node op.
                }catch (Exception e){
                    System.out.println("Node s2 werkt niet met invoer 'A', probeer een andere waarde.");
                    return getNodeAnswer();
                }
            }
            current = getNext(); // Sla op bij welke node je op dit moment bent.
        }
        return getNodeAnswer();
    }

}

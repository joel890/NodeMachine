package com.company;

public class Main {

    public static void main(String[] args) {

        Node s0 = new Node("s0");
        Node s1 = new Node("s1");
        Node s2 = new Node("s2");
        Node s3 = new Node("s3");

        /* Maak de verbindingen tussen de nodes zoals is aangegeven in de opdracht */
        s0.setNodeLink(s1,s2);
        s1.setNodeLink(s2,s1);
        s2.setNodeLink(s3);
        s3.setNodeLink(s0,s3);

        System.out.println(s0.input("B","A","B","A"));

    }
}

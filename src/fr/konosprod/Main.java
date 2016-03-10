package fr.konosprod;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args)
    {
	Node A = new Node(1);
	Node B = new Node(2);
	Node C = new Node(3);
	Node D = new Node(4);
	
	A.addInbound(C);
	B.addInbound(A);
	C.addInbound(A);
	C.addInbound(B);
	C.addInbound(D);
	
	A.setNumberOfOutbounds(2);

	List<Node> graphe = new ArrayList<Node>();
	
	graphe.add(A);
	graphe.add(B);
	graphe.add(C);
	graphe.add(D);
	
	for(int j = 0; j < 40; j++)
	{
	    for(int i = 0; i < graphe.size(); i++)
	    {
		graphe.get(i).computeRank();
	    }
	}
	
	for(int i = 0; i < graphe.size(); i++)
	{
	    System.out.println(graphe.get(i));
	}
	
    }
}

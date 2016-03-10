package fr.konosprod;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private int number;
    private double rank;
    private List<Node> inbounds;
    private int numberOfOutbounds = 1;
    
    public Node(int number)
    {
	this.number = number;
	inbounds = new ArrayList<Node>();
	rank = 1.0;
    }
    
    public int getNumber()
    {
	return number;
    }
    
    public List<Node> getInbounds()
    {
	return inbounds;
    }
    
    public int numberOfOutbounds()
    {
	return numberOfOutbounds;
    }
    
    public void setNumberOfOutbounds(int numberOfOutbounds)
    {
	this.numberOfOutbounds = numberOfOutbounds;
    }
    
    public void addInbound(Node n)
    {
	inbounds.add(n);
    }
    
    public double getRank()
    {
	return rank;
    }
    
    public void setRank(double rank)
    {
	this.rank = rank;
    }
    
    @Override
    public String toString()
    {
	return "Node : " + number + " Rank : " + String.format("%.2f", rank);
    }
    
    public void computeRank()
    {
	double sum = 0;
	
	for(int i = 0; i < inbounds.size(); i++)
	{
	    sum += inbounds.get(i).getRank()/inbounds.get(i).numberOfOutbounds();
	}
	
	rank = 0.15+0.85*sum;
    }
}

package fr.konosprod;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a node in a graphe
 * @author Konosprod
 *
 */
public class Node {

    
    
    /**
     * Node's number
     */
    private int number;
    
    /**
     * Actual pagerank of the current node
     */
    private double rank;
    
    /**
     * List of inbounds nodes
     */
    private List<Node> inbounds;
    
    /**
     * Number of outbounds connections
     */
    private int numberOfOutbounds = 1;
    
    /**
     * Construct a empty node without any outbounds
     * @param number Node's number
     */
    public Node(int number)
    {
	this.number = number;
	inbounds = new ArrayList<Node>();
	rank = 1.0;
    }
    
     
    /**
     * Get the node's number of outbounds connection
     * @return number of outbounds connection
     */
    public int numberOfOutbounds()
    {
	return numberOfOutbounds;
    }
    
    /**
     * Set the node's outbounds connetions
     * @param numberOfOutbounds Number of the node's outbounds connetions
     */
    public void setNumberOfOutbounds(int numberOfOutbounds)
    {
	this.numberOfOutbounds = numberOfOutbounds;
    }
    
    /**
     * Add a node to the inbound node's list of the current node
     * @param n Node to be added as a inbound node
     */
    public void addInbound(Node n)
    {
	inbounds.add(n);
    }
    
    /**
     * Get the node's current rank
     * @return Node's current rank
     */
    public double getRank()
    {
	return rank;
    }
    
    
    @Override
    public String toString()
    {
	return "Node : " + number + " Rank : " + String.format("%.2f", rank);
    }
    
    /**
     * Compute the pagerank of the current node
     * based on the formula : P
     * ageRank(N) = 0.15*0.85(sum of (inbounds node/ number of outbounds of the inbound node))
     */
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

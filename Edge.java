/**
* This is my Edge class for my 
* @author Kevin Chow
* @version 4/27/16
*/
public class Edge<E>
{
	//Vertex that the edge leads to 
	private Vertex<E> vertex;
	
	//The cost/gas price/walking distance/whatever you want of the edge
	private Integer cost;
	
	/*
	* Constructor for edge
	* @param Vertex<E> v The Vertex that the edge connects to
	* @param Integer c The cost of the edge
	*/
	public Edge(Vertex<E> v, Integer c)
	{
		vertex = v;
		cost = c;
	}
	
	/*
	* Returns the vertex the edge is connected to.
	* @return Vertex<e> The Vertex that the Edge leads to
	*/
	public Vertex<E> getVertex()
	{
		return vertex;
	}
	
	/*
	* Returns the cost of the edge
	* @return Integer The cost of the edge
	*/
	public Integer getCost()
	{
		return cost;
	}
	
	/*
	* Returns a String representation of the Edge.
	* @return String  a String representation of the Edge
	*/
	public String toString()
	{
		return vertex + "-" + cost;
	}
}
import java.util.ArrayList;
/**
* Contains a Vertex class with many methods for interacting with the Vertex. 
* Each Vertex wil contain an arraylist of edges that it is connected to.
* Thank you to Sam Scherl for walking me through this program.
* @author Kevin Chow
* @version 4/27/16
*/
public class Vertex<E>
{
	//The vertex's value (eg. name)
	private E value;
	
	// The an arraylist of Edges connecting to the Vertex.
	private ArrayList<Edge<E>> routes;
	
	// Shows whether the Vertex has been visited or not. 
	private boolean visited;
	
	/*
	* A constructor that takes in a value for the vertex
	* @param E v The value of the vertex
	*/
	public Vertex(E v)
	{
		value = v;
		visited = false;
		routes = new ArrayList<Edge<E>>();
	}
	
	/*
	* Returns the value of the vertex
	* @return E The value the vertex
	*/
	public E getValue()
	{
		return value;
	}
	
	/*
	* Changes a vertex's visited variable to true, marking that it has been visited
	*/
	public void visit()
	{
		visited = true;
	}
	
	/*
	* Returns arrayList of all Edges connecting to the Vertex.
	* @return ArrayList<Edge<E>> the edges connecting to the Vertex
	*/
	public ArrayList<Edge<E>> routes()
	{
		return routes;
	}	
	
	/* 
	* Adds the given vertex and cost to the ArrayList of Edges.
	* @param Vertex<E> vertex  Vertex that will be added
	* @param Integer cost The cost of the Vertex that will be added
	*/
	public void addVertex(Vertex<E> vertex, Integer cost)
	{
		routes.add(new Edge<E>(vertex, cost));
		vertex.routes().add(new Edge<E>(this, cost));
	}
	
	/* 
	* Adds the vertex and cost to the ArrayList of Edges that can only be traversed one way.
	* @param Vertex<E> vertex  Vertex that will be added
	* @param Integer cost The cost of the Vertex to be added
	*/
	public void addOneWayVertex(Vertex<E> vertex, Integer cost)
	{
		routes.add(new Edge<E>(vertex, cost));
	}
	
	/*
	* Returns a String representation of the Vertex.
	* @return String A String representation of the Vertex
	*/
	public String toString()
	{
		return value.toString();
	}
	
	/*
	* Returns true if all connected vertices have been visited, false otherwise
	* @return boolean if all connected vertices are connected
	*/

	public boolean done()
	{
		for (Edge edge : routes)
		{
			if (edge.getVertex().visited == false)
				return false;
		}
		return true;
	}
	
	/*
	* Returns the Edge with the least value and a connected unvisited vertex.
	* @return Edge<E> The edge in question
	*/
	public Edge<E> least()
	{
		int edgeIndex = -1;
		int least = Integer.MAX_VALUE;
		for (int i = 0; i < routes.size(); i++)
		{
			if (routes.get(i).getCost()<least)
			{
				if(routes.get(i).getVertex().visited == false)
				{
					edgeIndex = i;
					least = routes.get(i).getCost();
				}
			}
		}
		return routes.get(edgeIndex);
	}
	
	
}
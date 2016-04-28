//Thank you for the tester Sam.

public class RunnerTraveling
{
	public static void main(String[] args)
	{
		Vertex<String> point1 = new Vertex<String>("New York");
		Vertex<String> point2 = new Vertex<String>("San Francisco");
		Vertex<String> point3 = new Vertex<String>("Houston");
		Vertex<String> point4 = new Vertex<String>("Boston");
		point1.addVertex(point2, 10);
		point2.addVertex(point3, 121);
		point3.addVertex(point4, 30);
		point4.addVertex(point1, 17);
		Vertex<String> current = point1;
		int sum = 0;
		while (!current.done())
		{
			current.visit();
	 		System.out.println(current);
			sum += current.least().getCost();
			current = current.least().getVertex();
		}
		System.out.println(current);
		System.out.println(sum);
	}		
}
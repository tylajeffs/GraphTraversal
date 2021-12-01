import java.util.ArrayList;

public class Node
{
    
    public String name;
    public boolean visited = false;
    public ArrayList<Node> neighbors = new ArrayList<>();
    
    
    
    public Node(String letter)
    {
        name = letter;
    }


    /**
     * method to change the node's status to visited = true
     */
    public void visit()
    {
        visited = true;
    }



    /**
     * method to add neighbors to the node
     */
    public void addNeighbor(Node n)
    {
        neighbors.add(n);
    }



    /**
     * helper method to return the neighbors of the node
     * @return arraylist of neighbors
     */
    public ArrayList<Node> getNeighbors()
    {
        return neighbors;
    }



    /**
     * helper method to print neighbors
     */
    public void printNeighbors()
    {
        for(Node n: neighbors)
        {
            System.out.print(n.name);
        }

        //print an extra line
        System.out.println(" ");
    }


    /**
     * method to sort the neighbors alphabetically
     */
    public void sortNeighbors()
    {
        //neighbors.sort();
    }


    /**
     * method to reset vistited to false
     */
    public void resetVisit()
    {
        visited = false;
    }

}

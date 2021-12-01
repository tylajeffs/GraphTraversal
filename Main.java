import java.util.*;

public class Main
{
    //fields
    public ArrayList<Node> nodes;


    //stupid static method that is required, just calls constructor
    public static void main(String[] args)
    {
        //call the main constructor
        new Main();
    }





    //constructor, takes care of everything
    public Main()
    {
        //variables
        ArrayList<String> inputLines = new ArrayList<>();
        String currentLine = "";
        String nodeString;
        String firstNodeName;
        nodes = new ArrayList<>();
        ArrayList<String> letters = new ArrayList<>();



        //create scanner to read file
        Scanner s = new Scanner(System.in);

        //store the first line of nodes
        nodeString = s.nextLine();

        //split the nodes into an array
        String[] lettersArray = nodeString.split(" ");


        //store the data in arraylist
        while(!currentLine.contains("***"))
        {
            currentLine = s.nextLine();
            inputLines.add(currentLine);
        }

        //close scanner
        s.close();

        firstNodeName = inputLines.get(0);


        //create the node objects and store them in an arraylist
        for(String letter: lettersArray)
        {
            letters.add(letter);

            Node newNode = new Node(letter);
            nodes.add(newNode);

        }









        //print out the node neighbors
        System.out.println("Node Neighbors:");


        //find all of the neighbors of each node
        for(Node n: nodes)
        {
            //print out which letter's neighbors we are looking for
            System.out.print(n.name + ": ");


            //go through each of the input lines to find the neighbors
            for(String line: inputLines)
            {

                //check to see if the line has the letter we are looking for in the first spot
                if(line.contains(n.name))
                {
                    //if it does, take that letter away and print the neighbor left over
                    String toPrint = line.replace(n.name,"");
                    toPrint = toPrint.replace(" ","");

                    int indexOfNeighbor = letters.indexOf(toPrint);


                    //make sure the index is there
                    if(indexOfNeighbor > -1)
                    {
                        //add the adjacent nodes to the arraylist to keep track of them
                        n.addNeighbor(nodes.get(indexOfNeighbor));
                    }


                    if(toPrint.length() > 0)
                    {
                        System.out.print(toPrint + " ");
                    }

                }

            }

            //print a new line
            System.out.println(" ");



        }











        //print the depth first search results
        System.out.println(" ");
        System.out.println("Depth-First Search:");


        //do the depth first search
        depthFirst(findNodeFromName(firstNodeName));






        //reset the nodes back to not visited
        resetVisitedNodes();

        //put an extra line to separate
        System.out.println("");






        //print the breadth first search results
        System.out.println(" ");
        System.out.println("Breadth-First Search:");


        //do the depth first search
        breadthFirst(findNodeFromName(firstNodeName));








    }


    /**
     * method for depth first traversal of a graph
     * @param nod the current node
     */
    public void depthFirst(Node nod)
    {

        //mark the node as "visited"
        nod.visit();

        //print the node name
        System.out.print(nod.name + " ");

        //get the neighbors of the node
        ArrayList<Node> neigh = nod.getNeighbors();

        //go through all the neighbors of the node we are looking at
        for(Node n: neigh)
        {
            //get the neighbors of the node
            neigh = nod.getNeighbors();

            if(!n.visited)
            {
                //call the method again
                depthFirst(n);
            }

        }

    }





    /**
     * method for breadth first traversal of a graph
     * @param nod takes in the current node
     */
    public void breadthFirst(Node nod)
    {
        Queue<Node> q = new ArrayDeque<>();

        //mark the node as "visited"
        nod.visit();

        //print the node name
        System.out.print(nod.name + " ");

        //add the node to the queue
        q.add(nod);


        //loop while queue is not empty
        while(!q.isEmpty())
        {
            for(var n:q.element().neighbors)
            {
                //check to see if the neighbor has been visited yet
                if(!n.visited)
                {
                    //set n to be visited
                    n.visit();

                    //print the node
                    System.out.print(n.name + " ");

                    q.add(n);
                }
            }

            //remove the top?
            q.remove();
        }

    }


    /**
     * method to find the starter node from the name
     * @param s the string name of the node
     * @return the node
     */
    public Node findNodeFromName(String s)
    {
        //find the node to start with
        for(Node n: nodes)
        {
            //check if the names match
            if(s.equals(n.name))
            {
                //return the node
                return n;
            }
        }

        return null;
    }


    /**
     * method to reset the visited nodes back to not visisted
     */
    public void resetVisitedNodes()
    {
        for(Node n: nodes)
        {
            n.resetVisit();
        }

    }


}
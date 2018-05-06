

import java.util.Iterator;
import java.util.*;

public class Jd {
    static BinarySearchTree<Integer> binarySearchTree=new BinarySearchTree<>();

    public static void main(String[] args) throws Exception{


        computeRandomAverageDepth();

        //Integer[] arr=new Integer[]{6,4,3,5,9,7,15};
        Integer[] arr=new Integer[]{1,2,3,4,5,6,7};
        Integer[] arr1=new Integer[]{7,2,8,9,2,1,3,2,4,5};
        for(Integer currentInt:arr) binarySearchTree.add(currentInt);
        Iterator it=binarySearchTree.iterator();

        /*
        while(it.hasNext()){
          System.out.println(it.next());
        }
        */

        //binarySearchTree.computeAverageDepth(binarySearchTree);
        //binarySearchTree.findAverageDepth();
        //computeRandomAverageDepth();



        Graph myGraph=new Graph();


        Vertex v=new Vertex(0);
        Vertex v1=new Vertex(1);
        Vertex v2=new Vertex(2);
        Vertex v3=new Vertex(3);

        myGraph.addVertex(v);
        myGraph.addVertex(v1);
        myGraph.addVertex(v2);
        myGraph.addVertex(v3);

        myGraph.getVertices();

        Edge myEdge =new Edge(v1,v2,3);
        Edge myEdge1=new Edge(v1,v3,5);
        Edge myEdge2=new Edge(v,v1,7);

        myGraph.addEdge(myEdge);
        myGraph.addEdge(myEdge1);
        myGraph.addEdge(myEdge2);

        List<Edge> edges=myGraph.getNeighbours().get(v1);

        for(Edge edge:edges) System.out.println(edge.getVertex1().getId() + "--> " + edge.getVertex2().getId()+" weight ="+edge.getWeight());






        myGraph.getVertices();



    }


    /**
     * Method that computes AverageDepth of BST
     * For different samples ofrandom numbers
     */
    public static void computeRandomAverageDepth(){
        /** The number of nodes */
        Integer[] numberNodes={1,10,50,100,500,1000,5000,10000,50000,100000,1000000,5000000,10000000};
        BinarySearchTree<Integer> binarySearchTree=new BinarySearchTree<>();

        for(Integer currentNumberNodes:numberNodes){
            Random random=new Random();
            while(binarySearchTree.size()<currentNumberNodes){
                /** Adding the random int */
                binarySearchTree.add(random.nextInt());
            }

            /** Printing the size and the average depth */
            System.out.println("The binary search tree has "+currentNumberNodes+" and size of"+binarySearchTree.size());
            binarySearchTree.findAverageDepth();
            binarySearchTree.clear();
        }
    }

}

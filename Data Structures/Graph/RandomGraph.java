

import javafx.geometry.Pos;

import java.util.*;

public class RandomGraph {


    public static void main(String[] args) throws Exception {


        //randomGraph(14,0.1);
        Graph graph = randomGraph(20, 1);
        drawGraph(graph);


        //Graph mst = primAlgorithm(graph);
        Graph mst = Prim(graph);
        Graph kruskalMst = Kruskal(graph);
        drawGraph(mst);
        drawGraph(kruskalMst);


    }


    public static Graph randomGraph(int n, double p) throws Exception {

        Random random = new Random();

        Vertex[] vertices = new Vertex[n];
        Graph randomGraph = new Graph();

        for (int i = 0; i < n; i++) {

            int x = random.nextInt(400);
            int y = random.nextInt(400);

            vertices[i] = new Vertex(i, new Position(x, y));

            randomGraph.addVertex(vertices[i]);
        }

        randomGraph.getVerticesID();


        for (int i = n - 1; i > 1; i--) {
            for (int j = i - 1; j >= 0; j--) {

                System.out.println(i + "--->" + j);
                Double randomProbability = random.nextDouble();
                System.out.println(randomProbability + " " + p);
                if (randomProbability <= p) {


                    int weight = pitagor(vertices[i].getPosition(), vertices[j].getPosition());

                    Edge edgeToAdd = new Edge(vertices[j], vertices[i], weight);
                    randomGraph.addEdge(edgeToAdd);
                    System.out.println("Edge added between " + vertices[i] + " and " + vertices[j] + " has the weight of " + weight);
                }
            }
            System.out.println();
        }

        /*
        GraphDisplay graphDisplay = new GraphDisplay();
        graphDisplay.showInWindow(400, 400, "A Random Graph");

        for (Vertex vertexToAdd : randomGraph.getVertices())
            graphDisplay.addNode(vertexToAdd, vertexToAdd.getPosition().getX(), vertexToAdd.getPosition().getY());
        for (Edge edgeToAdd : randomGraph.getEdges()) {

            Vertex firstVertex = edgeToAdd.getVertex1();
            Vertex secondVertex = edgeToAdd.getVertex2();
            graphDisplay.addEdge(firstVertex, secondVertex);
            Thread.sleep(100);
        }
        */
        return randomGraph;

    }


    public static int pitagor(Position one, Position two) {
        int c = (int) Math.sqrt((one.getX() - two.getX()) * (one.getX() - two.getX()) + (one.getY() - two.getY()) * (one.getY() - two.getY()));
        return c;
    }


    public static Graph prim(Graph g) {

        if (g == null) throw (new NullPointerException("Graph must be non-NULL."));

        Set<Vertex> unVisitedVertices = new HashSet<>();
        Map<Vertex, List<Edge>> neighbours = g.getNeighbours();
        boolean[] isVisited = new boolean[g.getVertices().size()];
        Graph MST = new Graph();

        Queue<Edge> weightedEdges = new PriorityQueue<>(1, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                // System.out.println(o1.getWeight()+" "+o2.getWeight());
                return o1.getWeight() - o2.getWeight();
            }
        });

        for (Vertex currentVertex : g.getVertices()) {
            unVisitedVertices.add(currentVertex);
            MST.addVertex(currentVertex);
        }

        Vertex startVertex = g.getVertices().get(0);
        List<Edge> neighboursOfFirst = neighbours.get(startVertex);
        isVisited[startVertex.getId()] = true;

        //  System.out.println(neighbours.size());
        for (Edge currentEdge : neighboursOfFirst) {
            System.out.println(currentEdge.getVertex1().getId() + "--> " + currentEdge.getVertex2().getId() + " weight =" + currentEdge.getWeight());
            weightedEdges.add(currentEdge);
            neighbours.get(currentEdge.getVertex2()).remove(currentEdge);
        }
        unVisitedVertices.remove(startVertex);
        neighbours.remove(startVertex);

        System.out.println("Unvisited vertices");

        for (Vertex currentVertex : unVisitedVertices) {
            System.out.println(currentVertex);
        }

        while (!unVisitedVertices.isEmpty()) {

            Edge minimumEdge = weightedEdges.poll();
            MST.addEdge(minimumEdge);

            Vertex firstVertex = minimumEdge.getVertex1();
            Vertex secondVertex = minimumEdge.getVertex2();

            if (neighbours.containsKey(firstVertex)) neighbours.get(firstVertex).remove(minimumEdge);
            if (neighbours.containsKey(secondVertex)) neighbours.get(secondVertex).remove(minimumEdge);

            System.out.println(minimumEdge.getWeight());
            System.out.println(firstVertex.getId());
            System.out.println(secondVertex.getId());

            if (isVisited[firstVertex.getId()] == false && isVisited[secondVertex.getId()] == false) {

                System.out.println("First vertex is not visited");
                List<Edge> unvisitedEdges1 = neighbours.get(firstVertex);
                for (Edge currentEdge : unvisitedEdges1) {


                    System.out.println(currentEdge.getVertex1().getId() + "--> " + currentEdge.getVertex2().getId() + " weight =" + currentEdge.getWeight());

                    if (isVisited[currentEdge.getVertex1().getId()] == false && isVisited[currentEdge.getVertex2().getId()] == false)
                        weightedEdges.add(currentEdge);

                }
                unVisitedVertices.remove(firstVertex);
                isVisited[firstVertex.getId()] = true;

                neighbours.remove(firstVertex);


            } else if (isVisited[secondVertex.getId()] == false) {
                System.out.println("Second vertex is not visited");
                List<Edge> unvisitedEdges2 = neighbours.get(secondVertex);
                for (Edge currentEdge : unvisitedEdges2) {

                    System.out.println(currentEdge.getVertex1().getId() + "--> " + currentEdge.getVertex2().getId() + " weight =" + currentEdge.getWeight());
                    if (isVisited[currentEdge.getVertex1().getId()] == false && isVisited[currentEdge.getVertex2().getId()] == false)
                        weightedEdges.add(currentEdge);
                }
                unVisitedVertices.remove(secondVertex);
                isVisited[secondVertex.getId()] = true;
                neighbours.remove(secondVertex);
            }

        }
        return MST;
    }


    public static void drawGraph(Graph g) throws Exception {

        GraphDisplay graphDisplay = new GraphDisplay();
        graphDisplay.showInWindow(400, 400, "A Random Graph");

        for (Vertex vertexToAdd : g.getVertices())
            graphDisplay.addNode(vertexToAdd, vertexToAdd.getPosition().getX(), vertexToAdd.getPosition().getY());
        for (Edge edgeToAdd : g.getEdges()) {

            Vertex firstVertex = edgeToAdd.getVertex1();
            Vertex secondVertex = edgeToAdd.getVertex2();
            graphDisplay.addEdge(firstVertex, secondVertex);
            Thread.sleep(50);
        }


    }

    public static Graph primAlgorithm(Graph g) {

        if (g == null) throw (new NullPointerException("Graph must be non-NULL."));

        Graph MST = new Graph();


        // Source Vertex
        Vertex sourceVertex = null;

        // The cost of the MST
        int cost = 0;
        int numberVertices = g.getVertices().size();

        int sizeTree = 1;

        // Boolean array
        boolean[] vertexAdded = new boolean[numberVertices];

        boolean[] edgesSearched = new boolean[numberVertices];

        // The priority queue
        Queue<Edge> weightedEdges = new PriorityQueue<>(1, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                // System.out.println(o1.getWeight()+" "+o2.getWeight());
                return o1.getWeight() - o2.getWeight();
            }
        });

        List<Vertex> notVisited = g.getVertices();


        for (Vertex vertex : notVisited) MST.addVertex(vertex);

        sourceVertex = g.getVertices().get(0);
        edgesSearched[sourceVertex.getId()] = true;


        Map<Vertex, List<Edge>> neighbours = g.getNeighbours();

        for (Edge edge : neighbours.get(sourceVertex)) {
            weightedEdges.add(edge);
            System.out.println(" Edge x:" + edge.getVertex1().getId() + " y:" + edge.getVertex2().getId());

        }

        Vertex oppositeVertex = null;
        while (sizeTree <= numberVertices) {

            Edge currentEdge = weightedEdges.remove();


            //System.out.println(" Current edge:"+currentEdge.getVertex1().getId()+" y:"+currentEdge.getVertex2().getId());
            System.out.println(currentEdge.getVertex1().getId() + "--> " + currentEdge.getVertex2().getId() + " weight =" + currentEdge.getWeight());


            if (vertexAdded[currentEdge.getVertex1().getId()] && vertexAdded[currentEdge.getVertex2().getId()])
                continue;
            MST.addEdge(currentEdge);

            if (vertexAdded[currentEdge.getVertex1().getId()]) {
                oppositeVertex = currentEdge.getVertex2();
                vertexAdded[oppositeVertex.getId()] = true;
                sizeTree++;
            } else {
                oppositeVertex = currentEdge.getVertex1();
                vertexAdded[oppositeVertex.getId()] = true;
                sizeTree++;
            }

            List<Edge> edgesToAdd = neighbours.get(oppositeVertex);

            Vertex otherVertex = null;

            for (Edge edge : edgesToAdd) {
                if (edge.getVertex1() == oppositeVertex) otherVertex = edge.getVertex2();
                else otherVertex = edge.getVertex1();

                if (vertexAdded[otherVertex.getId()] == false) weightedEdges.add(edge);
                else System.out.println("not added");
            }

        }


        return MST;

    }


    /**
     * Kruskal's algorithm to compute the MST
     * I use the DisjointSets class
     */
    public static Graph Kruskal(Graph g) {

        /** MST graph */
        Graph MST = new Graph();

        /** The priority queue we used to store every edge */
        Queue<Edge> weightedEdges = new PriorityQueue<>(1, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                // System.out.println(o1.getWeight()+" "+o2.getWeight());
                return o1.getWeight() - o2.getWeight();
            }
        });

        /** For every edge we add it to the priority queue */
        for (Edge edge : g.getEdges()) {
            weightedEdges.add(edge);
            System.out.println(" Edge x:" + edge.getVertex1().getId() + " y:" + edge.getVertex2().getId());
        }

        /** Edges accepted and n is equal to the size of the BST */
        int edgesAccepted = 0;
        int n = g.getVertices().size();

        /** For every vertex we add it to the MST */
        for (Vertex vertex : g.getVertices()) MST.addVertex(vertex);

        /** Initialise disjointSets dj*/
        DisjointSets dj = new DisjointSets(n);

        /** While the acceptedEdges < n- 1 */
        while (edgesAccepted < n - 1) {
            /** We remove the top edge */
            Edge currentEdge = weightedEdges.remove();


            int finda = dj.find(currentEdge.getVertex1().getId());
            int findb = dj.find(currentEdge.getVertex2().getId());

            /** If the current edge forms an acyclic graph with the set of the edges */
            if (finda != findb) {
                /** We union it and increment the edges Acceoted */
                dj.union(finda, findb);
                edgesAccepted++;
                /** Add it to the MST */
                MST.addEdge(currentEdge);
            }
        }
        /** Return the MST */
        return MST;
    }

    /**
     * Prim's Algorithm to compute
     * Minimum spanning tree
     * @param g
     */
    public static Graph Prim(Graph g) {
        /** Create a MST Graph */
        Graph MST = new Graph();

        /** Size of give graph g */
        int n = g.getVertices().size();

        /** Array used to store the distance */
        int[] d = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);

        /** Priority Queue that will hold the edgs */
        Queue<Edge> weightedEdges = new PriorityQueue<>(1, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                // System.out.println(o1.getWeight()+" "+o2.getWeight());
                return o1.getWeight() - o2.getWeight();
            }
        });

        /** Neighbours of all vertices */
        Map<Vertex, List<Edge>> neighbours = g.getNeighbours();
        /** Adding them to the MST */
        for (Vertex vertex : g.getVertices()) MST.addVertex(vertex);
        /** Get the first node */
        Vertex node = g.getVertices().get(0);
        /** Setting the inital distance */
        d[0] = 0;

        /** Until we have every node - 1 */
        for (int i = 0; i < n - 1; i++) {

            /** We have visited the node */
            d[node.getId()] = 0;
            /**
             * For every edge we get the neighbours
             */
            for (Edge edge : neighbours.get(node)) {
                Vertex neighbourVertex = null;
                /** We get the node that is not visited */
                if (edge.getVertex2().getId() == node.getId()) neighbourVertex = edge.getVertex1();
                else neighbourVertex = edge.getVertex2();

                /** Check for the weight */
                if (edge.getWeight() < d[neighbourVertex.getId()]) d[neighbourVertex.getId()] = edge.getWeight();
                weightedEdges.add(edge);
            }
            Vertex nextNode = node;
            Edge minEdge = null;

            /** While we do not have a not visited node */
            while (d[nextNode.getId()] <= 0) {

                /** We remove the top edge and check if we have not visited the nextNode*/
                minEdge = weightedEdges.remove();
                if (d[minEdge.getVertex2().getId()] > 0) {
                    nextNode = minEdge.getVertex2();
                    break;
                    //minEdge=weightedEdges.remove();

                } else if (d[minEdge.getVertex1().getId()] > 0) {
                    nextNode = minEdge.getVertex1();
                    break;
                    //minEdge=weightedEdges.remove();
                }
                System.out.println(nextNode.getId() + " d is " + d[nextNode.getId()]);
            }
            /** To the MST add the minimum Edge */
            MST.addEdge(minEdge);
            node = nextNode;
        }
        /** Return MST */
        return MST;
    }
}

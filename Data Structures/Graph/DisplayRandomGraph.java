import java.util.Random;

/** Display Random Graph Class */
public class DisplayRandomGraph {

    public static void main(String[] args) throws Exception{
        /** We create a random graph and display it */
        Graph graph=randomGraph(10,0.10);
        drawGraph(graph);
    }

    /**
     * Method that Generated random Graph
     * Given nodes - n
     * Given probability - p
     */
    public static Graph randomGraph(int n, double p) throws Exception {
        Random random = new Random();

        /** Initialising the vertices and the Graph */
        Vertex[] vertices = new Vertex[n];
        Graph randomGraph = new Graph();

        /**
         * Initialising n vertices with random posX and posY
         * posX and posY<=400
         */
        for (int i = 0; i < n; i++) {
            int x = random.nextInt(400);
            int y = random.nextInt(400);

            vertices[i] = new Vertex(i, new Position(x, y));
            /** Adding the vertices to the graph */
            randomGraph.addVertex(vertices[i]);
        }

        randomGraph.getVerticesID();
        /**
         * For every pair of vertices we have a random probability
         * If random probability <= p then we have a edge
         */
        for (int i = n - 1; i > 1; i--) {
            for (int j = i - 1; j >= 0; j--) {

                System.out.println(i + "--->" + j);
                Double randomProbability = random.nextDouble();
                System.out.println(randomProbability + " " + p);
                if (randomProbability <= p) {
                    int weight = pitagor(vertices[i].getPosition(), vertices[j].getPosition());

                    Edge edgeToAdd = new Edge(vertices[j], vertices[i], weight);
                    // We add the edge to the random graph
                    randomGraph.addEdge(edgeToAdd);
                    System.out.println("Edge added between " + vertices[i] + " and " + vertices[j] + " has the weight of " + weight);
                }
            }
            System.out.println();
        }
        return randomGraph;
    }

    /** Method used to calculate the distance between two positions */
    public static int pitagor(Position one, Position two) {
        int c = (int) Math.sqrt((one.getX() - two.getX()) * (one.getX() - two.getX()) + (one.getY() - two.getY()) * (one.getY() - two.getY()));
        return c;
    }

    /**
     * Method that draws a given Graph
     */
    public static void drawGraph(Graph g) throws Exception {
        GraphDisplay graphDisplay = new GraphDisplay();
        graphDisplay.showInWindow(400, 400, "A Random Graph");
        /** For every vertex we add it to the graphDisplay */
        for (Vertex vertexToAdd : g.getVertices())
            graphDisplay.addNode(vertexToAdd, vertexToAdd.getPosition().getX(), vertexToAdd.getPosition().getY());
        /** For every edge we add it to the graphDisplay */
        for (Edge edgeToAdd : g.getEdges()) {
            Vertex firstVertex = edgeToAdd.getVertex1();
            Vertex secondVertex = edgeToAdd.getVertex2();
            graphDisplay.addEdge(firstVertex, secondVertex);
            Thread.sleep(50);
        }
    }
}


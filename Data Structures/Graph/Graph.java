import java.lang.reflect.Array;
import java.util.*;

public class Graph {

    /** List of edges */
    private List<Edge> edges;
    /** List of edges */
    private List<Vertex> vertices;
    /** List of neighbours for every vertex */
    private Map<Vertex, List<Edge>> neighbours;

    /** Constructor for graph */
    public Graph() {
        this.edges = new ArrayList<>();
        this.vertices = new ArrayList<>();
        this.neighbours = new HashMap<>();
    }

    /** Add Vertex Method */
    public boolean addVertex(Vertex vertex) {
        if (vertices.contains(vertex)) return false;
        else {
            vertices.add(vertex);
            return true;
        }
    }

    /** Add Edge Method */
    public boolean addEdge(Edge edgeToAdd) {
        if(edges.contains(edgeToAdd)) return false;

        edges.add(edgeToAdd);

        Vertex vertex1 = edgeToAdd.getVertex1();
        Vertex vertex2 = edgeToAdd.getVertex2();

        neighbours.putIfAbsent(vertex1, new ArrayList<>());
        neighbours.putIfAbsent(vertex2, new ArrayList<>());

        neighbours.get(vertex1).add(edgeToAdd);
        neighbours.get(vertex2).add(edgeToAdd);

        return true;
    }

    /** Remove Vertex Method */
    public boolean removeVertex(Vertex vertex) {
        if (!vertices.contains(vertex)) return false;
        else {
            vertices.remove(vertex);
            for (Edge edge : edges) {
                if (edge.getVertex1() == vertex) {
                    edges.remove(edge);
                    neighbours.get(edge.getVertex2()).remove(edge);
                }
                if (edge.getVertex2() == vertex) {
                    edges.remove(edge);
                    neighbours.get(edge.getVertex1()).remove(edge);
                }
                neighbours.remove(vertex);
            }
            return true;
        }
    }

    /**
     * RemoveEdge Method
     * @param edgeToRemove
     */
    public boolean removeEdge(Edge edgeToRemove) {
        if(!edges.contains(edgeToRemove)) return false;
        edges.remove(edgeToRemove);
        Vertex firstVertex = edgeToRemove.getVertex1();
        Vertex secondVertex = edgeToRemove.getVertex2();

        neighbours.get(firstVertex).remove(edgeToRemove);
        neighbours.get(secondVertex).remove(edgeToRemove);
        return true;
    }

    /** Position method that gets the position of Vertex */
    public Position position(Vertex vertex) throws Exception {
        if (!vertices.contains(vertex)) throw new Exception("Vertex not found");
        int indexOfVertex = vertices.indexOf(vertex);
        Position vertexPosition = vertices.get(indexOfVertex).getPosition();
        return vertexPosition;
    }

    /** Method that checks if edge exists */
    public boolean edgeExist(Vertex vertex1, Vertex vertex2, int weight) {
        Edge toSearch = new Edge(vertex1, vertex2, weight);
        if (edges.contains(toSearch)) return true;
        else return false;
    }


    /**
     * Method that returns the weight between two vertices
     * @throws Exception
     */
    public int weight(Vertex vertex1, Vertex vertex2) throws Exception {
        if (neighbours.containsKey(vertex1)) throw new Exception("Edge not found");
        if (neighbours.containsKey(vertex2)) throw new Exception("Edge not found");
        List<Edge> edges = neighbours.get(vertex1);
        for (Edge currentEdge : edges) {
            if (currentEdge.getVertex2() == vertex2) return currentEdge.getWeight();
        }
        return 0;
    }

    /** Get vertices method returns list with vertices */
    public List<Vertex> getVertices() {
        return vertices;
    }

    /** Get edge method returns list with edges */
    public List<Edge> getEdges() {
        return edges;
    }

    /** Neighbours of every vertex */
    public Map<Vertex, List<Edge>> getNeighbours() {
        return neighbours;
    }

    /** Method that prints the vertices id */
    public void getVerticesID() {
        for (Vertex currentVertex : vertices) {
            System.out.println(currentVertex.getId());
        }
    }
}

/** Class for Position */
class Position {

    /** X and Y for Position */
    private int x;
    private int y;
    /** Constuctor */
    public Position() {
        this.x = 0;
        this.y = 0;
    }
    /** Constuctor */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /** Getters and Setters */
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}

/**
 * Class Vertex
 * @param <T>
 */
class Vertex<T> {

    /** Member variables of the Vertex */
    private int id;
    private Position position;
    private T value;

    /** Constructor for Vertex */
    public Vertex(int id) {
        this.id = id;
        this.position = new Position();
        this.value = null;
    }
    /** Constructor for Vertex */
    public Vertex(int id, Position position) {
        this.id = id;
        this.position = position;
        this.value = null;
    }

    /** Constructor for Vertex */
    public Vertex(int id, Position position, T value) {
        this.id = id;
        this.position = position;
        this.value = value;
    }
    public int getId() {
        return id;
    }
    public Position getPosition() {
        return position;
    }
}

/**
 * Edge class
 */
class Edge {
    /** Member variables */
    private Vertex vertex1;
    private Vertex vertex2;
    private int weight;

    /** Constructor for Edge */
    public Edge(Vertex vertex1, Vertex vertex2, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }
    /** Getters and Setters */
    public Vertex getVertex1() {
        return vertex1;
    }
    public Vertex getVertex2() {
        return vertex2;
    }
    public int getWeight() {
        return weight;
    }
    public void setVertex1(Vertex vertex1) {
        this.vertex1 = vertex1;
    }
    public void setVertex2(Vertex vertex2) {
        this.vertex2 = vertex2;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}


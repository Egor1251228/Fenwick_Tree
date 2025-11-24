public class DirectedGraph<T> {
    private final int vertices;
    private final T[] data;
    private final int[][] adjacencyMatrix;

    @SuppressWarnings("unchecked")
    public DirectedGraph(int vertices) {
        this.vertices = vertices;
        this.data = (T[]) new Object[vertices];
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    public void setVertexData(int vertex, T data) {
        if (vertex < 0 || vertex >= vertices) {
            throw new IllegalArgumentException("Неверный индекс вершины: " + vertex);
        }
        this.data[vertex] = data;
    }

    public T getVertexData(int vertex) {
        if (vertex < 0 || vertex >= vertices) {
            throw new IllegalArgumentException("Неверный индекс вершины: " + vertex);
        }
        return data[vertex];
    }

    public void addEdge(int from, int to, int weight) {
        if (from < 0 || from >= vertices || to < 0 || to >= vertices) {
            throw new IllegalArgumentException("Неверные индексы вершин: " + from + ", " + to);
        }
        adjacencyMatrix[from][to] = weight;
    }

    public void removeEdge(int from, int to) {
        if (from < 0 || from >= vertices || to < 0 || to >= vertices) {
            throw new IllegalArgumentException("Неверные индексы вершин: " + from + ", " + to);
        }
        adjacencyMatrix[from][to] = 0;
    }

    public boolean hasEdge(int from, int to) {
        if (from < 0 || from >= vertices || to < 0 || to >= vertices) {
            throw new IllegalArgumentException("Неверные индексы вершин: " + from + ", " + to);
        }
        return adjacencyMatrix[from][to] != 0;
    }

    public int getEdgeWeight(int from, int to) {
        if (from < 0 || from >= vertices || to < 0 || to >= vertices) {
            throw new IllegalArgumentException("Неверные индексы вершин: " + from + ", " + to);
        }
        return adjacencyMatrix[from][to];
    }

    public int getVerticesCount() {
        return vertices;
    }

    public void printGraph() {
        System.out.println("Ориентированный граф (" + vertices + " вершин):");
        for (int i = 0; i < vertices; i++) {
            System.out.print("Вершина " + i + " (" + data[i] + "): ");
            for (int j = 0; j < vertices; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    System.out.print("→" + j + "[" + adjacencyMatrix[i][j] + "] ");
                }
            }
            System.out.println();
        }
    }
}
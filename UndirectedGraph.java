public class UndirectedGraph<T> {
    private final int vertices;
    private final T[] data;
    private final int[][] adjacencyMatrix;

    @SuppressWarnings("unchecked")
    public UndirectedGraph(int vertices) {
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

    public void addEdge(int vertex1, int vertex2, int weight) {
        if (vertex1 < 0 || vertex1 >= vertices || vertex2 < 0 || vertex2 >= vertices) {
            throw new IllegalArgumentException("Неверные индексы вершин: " + vertex1 + ", " + vertex2);
        }
        adjacencyMatrix[vertex1][vertex2] = weight;
        adjacencyMatrix[vertex2][vertex1] = weight;
    }

    public void removeEdge(int vertex1, int vertex2) {
        if (vertex1 < 0 || vertex1 >= vertices || vertex2 < 0 || vertex2 >= vertices) {
            throw new IllegalArgumentException("Неверные индексы вершин: " + vertex1 + ", " + vertex2);
        }
        adjacencyMatrix[vertex1][vertex2] = 0;
        adjacencyMatrix[vertex2][vertex1] = 0;
    }

    public boolean hasEdge(int vertex1, int vertex2) {
        if (vertex1 < 0 || vertex1 >= vertices || vertex2 < 0 || vertex2 >= vertices) {
            throw new IllegalArgumentException("Неверные индексы вершин: " + vertex1 + ", " + vertex2);
        }
        return adjacencyMatrix[vertex1][vertex2] != 0;
    }

    public int getEdgeWeight(int vertex1, int vertex2) {
        if (vertex1 < 0 || vertex1 >= vertices || vertex2 < 0 || vertex2 >= vertices) {
            throw new IllegalArgumentException("Неверные индексы вершин: " + vertex1 + ", " + vertex2);
        }
        return adjacencyMatrix[vertex1][vertex2];
    }

    public int getVerticesCount() {
        return vertices;
    }

    public void printGraph() {
        System.out.println("Неориентированный граф (" + vertices + " вершин):");
        for (int i = 0; i < vertices; i++) {
            System.out.print("Вершина " + i + " (" + data[i] + "): ");
            for (int j = i + 1; j < vertices; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    System.out.print("-" + j + "[" + adjacencyMatrix[i][j] + "] ");
                }
            }
            System.out.println();
        }
    }
}
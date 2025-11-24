public class Main {
    static void main(String[] args) {
        demonstrateFenwickTree();
        demonstrateGraphs();
        runAdditionalTests();
    }

    /**
     * Дерево Фенвика
     */
    private static void demonstrateFenwickTree() {
        System.out.println("=== ДЕМОНСТРАЦИЯ ДЕРЕВА ФЕНВИКА ===");

        FenwickTree tree = new FenwickTree();
        int[] testArray = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
        tree.build(testArray);

        //getSize() и getTreeState()
        printTreeInfo(tree, "Исходное дерево");
        System.out.println("Префиксная сумма [0-5]: " + tree.prefixSum(5));
        System.out.println("Сумма на отрезке [2-7]: " + tree.rangeSum(2, 7));

        tree.update(3, 6); // Обновляем элемент с индексом 3
        System.out.println("После обновления:");
        System.out.println("Префиксная сумма [0-5]: " + tree.prefixSum(5));
        System.out.println("Сумма на отрезке [2-7]: " + tree.rangeSum(2, 7));
        printTreeInfo(tree, "Дерево после обновления");
    }

    /**
     * Графы
     */
    private static void demonstrateGraphs() {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ ГРАФОВ ===");

        DirectedGraph<String> directedGraph = new DirectedGraph<>(4);
        directedGraph.setVertexData(0, "A");
        directedGraph.setVertexData(1, "B");
        directedGraph.setVertexData(2, "C");
        directedGraph.setVertexData(3, "D");

        directedGraph.addEdge(0, 1, 5);
        directedGraph.addEdge(0, 2, 3);
        directedGraph.addEdge(1, 3, 2);
        directedGraph.addEdge(2, 3, 7);

        directedGraph.printGraph();

        //removeEdge и getVerticesCount
        System.out.println("Количество вершин в графе: " + directedGraph.getVerticesCount());
        System.out.println("Проверка ребра 0→1 до удаления: " + directedGraph.hasEdge(0, 1));

        //getEdgeWeight и getVertexData
        System.out.println("Вес ребра 0→1: " + directedGraph.getEdgeWeight(0, 1));
        System.out.println("Данные вершины 2: " + directedGraph.getVertexData(2));

        // Удаляем ребро и проверяем
        directedGraph.removeEdge(0, 1);
        System.out.println("Проверка ребра 0→1 после удаления: " + directedGraph.hasEdge(0, 1));

        // Восстанавливаем ребро
        directedGraph.addEdge(0, 1, 5);

        //Неориентированный граф
        UndirectedGraph<String> undirectedGraph = new UndirectedGraph<>(4);
        undirectedGraph.setVertexData(0, "X");
        undirectedGraph.setVertexData(1, "Y");
        undirectedGraph.setVertexData(2, "Z");
        undirectedGraph.setVertexData(3, "W");

        undirectedGraph.addEdge(0, 1, 4);
        undirectedGraph.addEdge(0, 2, 6);
        undirectedGraph.addEdge(1, 3, 3);
        undirectedGraph.addEdge(2, 3, 5);

        undirectedGraph.printGraph();

        System.out.println("Количество вершин в неориентированном графе: " + undirectedGraph.getVerticesCount());
        System.out.println("Проверка ребра 1-3 до удаления: " + undirectedGraph.hasEdge(1, 3));

        //getEdgeWeight и getVertexData для неориентированного графа
        System.out.println("Вес ребра 0-2: " + undirectedGraph.getEdgeWeight(0, 2));
        System.out.println("Данные вершины 1: " + undirectedGraph.getVertexData(1));

        undirectedGraph.removeEdge(1, 3);
        System.out.println("Проверка ребра 1-3 после удаления: " + undirectedGraph.hasEdge(1, 3));
    }

    private static void runAdditionalTests() {
        System.out.println("\n=== ДОПОЛНИТЕЛЬНЫЕ ТЕСТЫ ===");
        testFenwickTreeOperations();
        testGraphOperations();
    }

    /**
     * Операции дерева Фенвика
     */
    private static void testFenwickTreeOperations() {
        System.out.println("--- Тестирование операций дерева Фенвика ---");
        FenwickTree fenwick = new FenwickTree(8);
        fenwick.update(0, 1);
        fenwick.update(1, 2);
        fenwick.update(2, 3);
        fenwick.update(3, 4);
        fenwick.update(4, 5);

        printTreeInfo(fenwick, "Тестовое дерево");
        System.out.println("Prefix sum [0-3]: " + fenwick.prefixSum(3));
        System.out.println("Range sum [1-4]: " + fenwick.rangeSum(1, 4));
    }

    /**
     * Операции с графами
     */
    private static void testGraphOperations() {
        System.out.println("--- Тестирование операций с графами ---");

        DirectedGraph<Integer> dirGraph = new DirectedGraph<>(3);
        dirGraph.setVertexData(0, 100);
        dirGraph.setVertexData(1, 200);
        dirGraph.setVertexData(2, 300);

        dirGraph.addEdge(0, 1, 1);
        dirGraph.addEdge(1, 2, 2);

        System.out.println("Есть ребро 0→1: " + dirGraph.hasEdge(0, 1));
        System.out.println("Вес ребра 1→2: " + dirGraph.getEdgeWeight(1, 2));
        System.out.println("Данные вершины 0: " + dirGraph.getVertexData(0));
        System.out.println("Количество вершин: " + dirGraph.getVerticesCount());
    }

    /**
     * Доп информация о дереве Фенвика
     */
    private static void printTreeInfo(FenwickTree tree, String description) {
        System.out.println(description + ":");
        System.out.println("Размер дерева: " + tree.getSize());
        tree.printTree();


    }
}


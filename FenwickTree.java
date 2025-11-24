public class FenwickTree {
    private int[] tree;
    private int size;

    public FenwickTree() {
        // Инициализация пустого дерева
    }

    public FenwickTree(int size) {
        this.size = size;
        this.tree = new int[size + 1]; // Дерево индексируется с 1
    }

    public void build(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Массив не может быть null");
        }

        this.size = arr.length;
        this.tree = new int[size + 1];

        // Инициализируем дерево нулями
        for (int i = 1; i <= size; i++) {
            tree[i] = 0;
        }

        // Построение дерева через обновления
        for (int i = 0; i < size; i++) {
            update(i, arr[i]);
        }
    }

    public void update(int index, int delta) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Индекс вне границ: " + index);
        }

        int pos = index + 1;

        while (pos <= size) {
            tree[pos] += delta;
            pos += pos & -pos;
        }
    }

    public int prefixSum(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Индекс вне границ: " + index);
        }

        int sum = 0;
        int pos = index + 1;

        while (pos > 0) {
            sum += tree[pos];
            pos -= pos & -pos; // Переход к родительскому узлу
        }

        return sum;
    }

    public int rangeSum(int left, int right) {
        if (left < 0 || right >= size || left > right) {
            throw new IllegalArgumentException("Некорректные границы: left=" + left + ", right=" + right);
        }

        if (left == 0) {
            return prefixSum(right);
        } else {
            return prefixSum(right) - prefixSum(left - 1);
        }
    }

    public int getSize() {
        return size;
    }

    public int[] getTreeState() {
        return tree.clone();
    }

    public void printTree() {
        System.out.print("Дерево Фенвика: [");
        for (int i = 1; i <= size; i++) {
            System.out.print(tree[i]);
            if (i < size) System.out.print(", ");
        }
        System.out.println("]");
    }
}
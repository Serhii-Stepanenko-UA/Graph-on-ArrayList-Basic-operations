package app;

import java.util.ArrayList;

// Список суміжності (Adjacency List)
class Graph {

    public static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) {
        // Створюємо граф
        int vertex = 0;
        list = new ArrayList<>(vertex);

        // Додаємо вершини
        addVertex(5);
        System.out.println("1) After creation Graph and addition Vertexes");
        printGraph(list);

        // Додаємо ребра
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(0, 3);
        addEdge(1, 2);
        addEdge(4, 2);
        System.out.println("\n2) After addition adjacency");
        printGraph(list);

        // Видаляємо ребро
        removeEdge(0, 2);
        System.out.println("\n3) After removing Edge");
        printGraph(list);

        // Перевіряємо наявність ребра
        System.out.print("\n4)");
        hasEdge(2, 1);
        hasEdge(3, 2);

        // Видаляємо вершину по індексу із здвигом елементів до начала списка
        removeVertex(3);
        System.out.println("\n5) After removing vertex " + vertex);
        printGraph(list);

        // Перевіряємо наявність вершини по індексу
        System.out.print("\n6)");
        hasVertex(1);
        hasVertex(4);
    }

    // Метод addVertex(int vertex), що додає вершину до графу.
    public static void addVertex(int vertex) {
        for (int i = 0; i < vertex; i++)
            list.add(new ArrayList<>());
        System.out.println("\nAdded " + vertex + " new vertex");
    }

    // Метод removeVertex(int vertex), що видаляє вершину з графу.
    public static void removeVertex(int vertex) {
        list.remove(vertex);
    }

    // Метод hasVertex(int vertex), що перевіряє чи існує вершина у графі.
    public static void hasVertex(int vertex) {
        if (vertex >= 0 && vertex < list.size())
            System.out.println("\nThe Graph contains vertex " + vertex);
        else
            System.out.println("\nThe graph does not contain vertex " + vertex);
    }

    // Метод addEdge(int source, int destination), що додає ребро між двома вершинами.
    public static void addEdge(int source, int destination) {
        list.get(source).add(destination);
        list.get(destination).add(source);
    }

    // Метод removeEdge(int source, int destination), що видаляє ребро між двома вершинами.
    public static void removeEdge(int source, int destination) {
        list.get(source).remove(destination);
        list.get(destination).remove(source);
    }

    // Метод hasEdge(int source, int destination), що перевіряє чи існує ребро між двома вершинами у графі.
    public static void hasEdge(int source, int destination) {
        if (list.get(source).contains(destination) && list.get(destination).contains(source)) {
            System.out.println("\nThe Graph contains edge " + source + " -> " + destination);
        } else
            System.out.println("\nThe Graph does not contains edge " + source + " -> " + destination);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("Vertex " + i + ":");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(" -> " + list.get(i).get(j));
            }
            System.out.println();
        }
    }
}
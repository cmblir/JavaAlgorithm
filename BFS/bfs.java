package BFS;
import java.util.LinkedList;
public class dfsRecursion {

    public static void main(String[] args) {
        boolean[] visited = new boolean[9];
        int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};

        System.out.println(bfs(1, graph, visited));
    }

    static String bfs(int start, int[][] graph, boolean[] visited) {
        MyStringBuilder sb = new MyStringBuilder();
        MyQueue<Integer> q = new MyQueue<>();

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int nodeIndex = q.poll();
            sb.append(nodeIndex + " -> ");
            for (int temp : graph[nodeIndex]) {
                if (!visited[temp]) {
                    visited[temp] = true;
                    q.offer(temp);
                }
            }
        }
        return sb.toString();
    }
}

class MyStringBuilder {
    private StringBuilder sb;

    public MyStringBuilder() {
        sb = new StringBuilder();
    }

    public MyStringBuilder(String str) {
        sb = new StringBuilder(str);
    }

    public void append(String str) {
        sb.append(str);
    }

    public void append(char c) {
        sb.append(c);
    }

    public void insert(int index, String str) {
        sb.insert(index, str);
    }

    public String toString() {
        return sb.toString();
    }

    public int length() {
        return sb.length();
    }

    public void delete(int start, int end) {
        sb.delete(start, end);
    }
}


class MyQueue<T> {
    private LinkedList<T> queue;

    public MyQueue() {
        queue = new LinkedList<>();
    }

    public void enqueue(T item) {
        queue.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.removeFirst();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.getFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public boolean offer(T item) {
        return queue.offerLast(item);
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        return queue.pollFirst();
    }
}

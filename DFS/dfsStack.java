package DFS;

public class dfsStack {
    static boolean[] visited = new boolean[9];

    static int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};

    static ArrayStack stack = new ArrayStack(9);
    public static void main(String[] args) {
        stack.push(1);
        visited[1] = true;

        while(!stack.isEmpty()) {
            int nodeIndex = stack.pop();

            System.out.print(nodeIndex);
            System.out.println(" -> ");

            for (int linkedNode : graph[nodeIndex]) {
                if(!visited[linkedNode]) {
                    stack.push(linkedNode);
                    visited[linkedNode] = true;
                }
            }
        }
    }
}

class ArrayStack {
    private int top;
    private int size;
    private int[] stack;

    public ArrayStack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public void push(int item) {
        stack[++top] = item;
    }

    public int pop() {
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

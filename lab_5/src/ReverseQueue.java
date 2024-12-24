import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    private Queue<Integer> queue;

    public ReverseQueue(Queue<Integer> queue) {
        this.queue = queue;
    }

    public void printReverse() {
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста.");
            return;
        }

        Stack<Integer> stack = new Stack<>();

        // Переносим элементы из очереди в стек
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        // Печатаем элементы из стека (в обратном порядке)
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

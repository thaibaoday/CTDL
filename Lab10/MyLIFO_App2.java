package Lab10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyLIFO_App2 {
	public static <E> void stutter(Queue<E> input) {
		int size = input.size();
		for (int i = 0; i < size; i++) {
			E element = input.poll();
			input.add(element);
			input.add(element);
		}
	}

	public static <E> void mirror(Queue<E> input) {
        int size = input.size();
        Stack<E> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            E element = input.poll();
            input.add(element);
            stack.push(element);
        }
        while (!stack.isEmpty()) {
            input.add(stack.pop());
        }
    }
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println("Original queue: " + queue);
		stutter(queue);
		System.out.println("After stutter: " + queue);
		mirror(queue);
		System.out.println("After mirror: " + queue);
	}


}

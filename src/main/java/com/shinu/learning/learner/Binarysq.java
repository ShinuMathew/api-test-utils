package com.shinu.learning.learner;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.PriorityBlockingQueue;

public class Binarysq {
	public static void main(String[] args) {
		Queue<String> queue = new PriorityBlockingQueue<>();
		queue.add("Raja");
		queue.add("Sam");
		queue.add("Shinu");
		queue.add("Raj");
		queue.add("Praga");
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
	}
}

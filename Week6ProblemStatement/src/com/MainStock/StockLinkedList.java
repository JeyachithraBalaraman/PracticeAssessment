package com.MainStock;

class Node {
	public double value;
	public boolean yn;
	public Node nextNode;
}
// Class StockedLinkedList
public class StockLinkedList {
	private Node head = new Node();
// get head
	public Node getHead() {
		return head;
	}

// inserting values
	public void insertValues(double v, boolean y) {
		Node currentNode = head;
		while (currentNode.nextNode != null) {
			currentNode = currentNode.nextNode;
		}
		Node newNode = new Node();
		currentNode.value = v;
		currentNode.yn = y;
		currentNode.nextNode = newNode;
	}

// display list
	public void displayLinkedList() {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print("(" + currentNode.value + " , " + currentNode.yn + ")" + "-->");
			currentNode = currentNode.nextNode;
		}
		System.out.println("NULL");
	}

	public void displayLinkedList(Node sl) {
		Node currentNode = sl;
		while (currentNode != null) {
			System.out.print("(" + currentNode.value + " , " + currentNode.yn + ")" + "-->");
			currentNode = currentNode.nextNode;
		}
		System.out.println("NULL");
	}

// sorting ascending order
	Node sortedMerge(Node a, Node b) {
		Node result = null;
		// base case
		if (a == null)
			return b;
		if (b == null)
			return a;
		// pick either a or b and recur
		if (a.value <= b.value) {
			result = a;
			result.nextNode = sortedMerge(a.nextNode, b);

		} else {
			result = b;
			result.nextNode = sortedMerge(a, b.nextNode);
		}
		return result;
	}

	Node mergeSort(Node h) {
		// base case : if head is null

		if (h == null || h.nextNode == null) {
			return h;
		}
		// Get the middle of the list
		Node middle = getMiddle(h);
		Node nextofmiddle = middle.nextNode;
		// Set the next of middle node to null
		middle.nextNode = null;
		// Apply mergesort on left list
		Node left = mergeSort(h);
		// Apply mergesort on right list
		Node right = mergeSort(nextofmiddle);
		// Merge the left and right lists
		Node sortedlist = sortedMerge(left, right);
		return sortedlist;
	}

	public static Node getMiddle(Node head) {
		if (head == null)
			return head;
		Node slow = head, fast = head;
		while (fast.nextNode != null && fast.nextNode.nextNode != null) {
			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;
		}
		return slow;
	}

// Decending order
	Node sortedMergeDecending(Node a, Node b) {
		Node result = null;
		// base case
		if (a == null)
			return b;
		if (b == null)
			return a;
		// pick either a or b and recur
		if (a.value >= b.value) {
			result = a;
			result.nextNode = sortedMergeDecending(a.nextNode, b);

		} else {
			result = b;
			result.nextNode = sortedMergeDecending(a, b.nextNode);
		}
		return result;
	}

	Node mergeSortDecending(Node h) {
		// base case : if head is null

		if (h == null || h.nextNode == null) {
			return h;
		}
		// Get the middle of the list
		Node middle = getMiddle(h);
		Node nextofmiddle = middle.nextNode;
		// Set the next of middle node to null
		middle.nextNode = null;
		// Apply mergesort on left list
		Node left = mergeSortDecending(h);
		// Apply mergesort on right list
		Node right = mergeSortDecending(nextofmiddle);
		// Merge the left and right lists
		Node sortedlist = sortedMergeDecending(left, right);
		return sortedlist;
	}

//Binary search
	static Node middleNode(Node start, Node last) {
		if (start == null)
			return null;
		Node slow = start;
		Node fast = start.nextNode;
		while (fast != last) {
			fast = fast.nextNode;
			if (fast != last) {
				slow = slow.nextNode;
				fast = fast.nextNode;
			}
		}//while
		return slow;
	}

	public Node binarySearch(Node N, double element) {
		Node start = N;
		Node last = null;
		do {
			// find middle
			Node mid = middleNode(start, last);
			
			// if mid is empty
			if (mid == null) 
				return null;
			
			// If value is present at middle
			if (mid.value == element) {
				
				return mid;
			}
			// If value is less than mid
			else if (mid.value > element) 
				start = mid.nextNode;
			
			// If the value is more than mid
			else
				last = mid;
		} while (last == null || last != start);
		// value not present
		return null;
	}

}// class

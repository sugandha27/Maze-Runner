import java.util.*;
public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor to initialize the heap
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    // Helper method to get the parent index
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Helper method to get the left child index
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // Helper method to get the right child index
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Insert a new element into the heap
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Max capacity reached.");
            return;
        }

        // Insert the new value at the end of the heap
        heap[size] = value;
        size++;

        // Fix the max heap property if it's violated
        int current = size - 1;
        while (current != 0 && heap[parent(current)] < heap[current]) {
            // Swap current node with its parent
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Heapify the subtree rooted at index 'i'
    private void heapify(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        // If left child is larger than root
        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        // If largest is not the root
        if (largest != i) {
            swap(i, largest);
            // Recursively heapify the affected subtree
            heapify(largest);
        }
    }

    // Method to build the max heap from an unsorted array
    public void buildMaxHeap(int[] array) {
        this.heap = array;
        this.size = array.length;
        this.capacity = array.length;

        // Start from the last non-leaf node and heapify each node
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    //method to delete element in heap
    public int delete() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty, nothing to delete.");
        }

        // The root element to be removed
        int root = heap[0];

        // Move the last element to the root
        heap[0] = heap[size - 1];
        size--; // Decrease the size

        // Heapify from the root to restore max heap property
        heapify(0);

        return root; // Return the deleted root element
    }

    // Swap elements at indices i and j
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Display the heap
    public void displayHeap() {
        System.out.println(Arrays.toString(heap));
    }

    // Main method to test the MaxHeap implementation
    public static void main(String[] args) {
        int[] array = {3, 9, 2, 1, 4, 5}; // Example input array

        MaxHeap maxHeap = new MaxHeap(array.length);

        // Building max heap from the input array
        maxHeap.buildMaxHeap(array);

        System.out.println("Max Heap after building from the array:");
        maxHeap.displayHeap();

        // Inserting a new element into the heap
        maxHeap.insert(10);
        System.out.println("Max Heap after inserting element 10:");
        maxHeap.displayHeap();
    }
}

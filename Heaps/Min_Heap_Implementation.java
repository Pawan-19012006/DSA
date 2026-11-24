// Implement a class MinHeap that supports the following operations:

// push(x) – push element x into the heap
// pop() – remove the top element from the heap
// peek() – return top element from the heap, if empty return -1
// size() - return the no of elements in the heap.
// There will be a sequence of queries queries[][]. The queries are represented in numeric form:

// 1 x : call push(x)
// 2: call pop()
// 3: call peek()
// 4: call size()
// The driver code will process the queries, call the corresponding functions, and print the outputs of peek(), size() operation.

// You only need to implement the above four functions.

// Examples :

// Input: queries[][] = [[1, 3], [1, 7], [3], [1, 2], [3]]
// Output: [3, 2]
// Explanation:
// push(3): heap is [3]
// push(7): heap is [3, 7]
// peek(): return top element 3
// push(2): heap is [2, 3, 7]
// peek(): return top element 2
// Input: queries[][] = [[1, 4], [1, 8], [1, 7], [2], [3], [4]]
// Output: [7, 2]
// Explanation:
// push(4): heap is [4]
// push(8): heap is [4, 8]
// push(7): heap is [4, 7, 8]
// pop(): remove top element 4, now heap is [7, 8]
// peek(): return top element 7
// size(): return no of elements in the heap
// Constraints:

// 1 ≤ queries.size() ≤ 103
// 1 ≤ queries[i].size() ≤ 2
// 1 ≤ x ≤ 105


class MinHeap {

    ArrayList<Integer> heap; // creating an empty arraylist
    public MinHeap() {
        heap = new ArrayList<>(); // initiating the arraylist in order to create a heap
    }

    public void push(int x) {
        heap.add(x); // add the element into the heap
        int i = heap.size() - 1; // we keep the last element as the i, so we go from bottom to top
        while(i>0){
            int parent = (i-1)/2; // formula to find the parent of each element
            if(heap.get(parent)<=heap.get(i)){ // if in case the parent is smaller, no change required, so break the loop
                break;
            }
            
            int temp = heap.get(parent); //if not, then it means the parent is a bigger element than the child, therefore swapping needs to be done
            heap.set(parent, heap.get(i)); //.set(index to be changed, changed into) is the function used swap the elements in an Arraylist, we swao the value of the child at the index of the parent
            heap.set(i, temp); //swapping the child index with the old parent value 
            
            i = parent; //we need to again start checking for i's parent whther is is smaller 
        }
        // Insert x into the heap
    }

    public void pop() {
        if(heap.isEmpty()){ // if the heap is empty no need to return anything
            return;
        }
        
        int last = heap.size() - 1; // first step is to find the last element, then swap the last element with the root element, ie the first element
        heap.set(0, heap.get(last));
        heap.remove(last); // once swapped the last element is removed from the heap itself, ie, the root(smallest value) will be swapped to last and then popped, this is how the pop operation take place in a heap
        
        int i = 0; // now the next step starts from the top, top to bottom approach
        while(true){
            int left = 2 * i + 1; // formula to find the left node
            int right = 2 * i + 2; //formula to find the right node
            int smallest = i; // initially value at index i(0) will be the smallest until another smaller element is found
            
            if(left < heap.size() && heap.get(left)<heap.get(smallest)){ // check the left child whether its value is smaller than the current smallest, if yes, then change the smallest to the index of left
                smallest = left;
            }
            
            if(right < heap.size() && heap.get(right)< heap.get(smallest)){ // check the right child whether its value is smaller than the current smallest, if yes, then change the smallest to the index of right
                smallest = right;
            }
            
            if(smallest == i){ // if both left and right are not small, then there is no need of swap, hence break
                break;
            }
            
            int temp = heap.get(i); // now we gonna swap the current i, which is the parent with the smaller child node, could be left or right child value
            heap.set(i, heap.get(smallest)); // at index i, swapping value of smallest
            heap.set(smallest, temp); // at index smallest, swapping value of i
            
            i = smallest;
        }
    }

    public int peek() {
        if(heap.size()==0){ //if there is no elements in heap, return -1
            return -1;
        }
        
        return heap.get(0); // the topmost root node will always be the peek element, returned in O(1) time
    }

    public int size() {
        // Return the number of elements in the heap
        return heap.size();
    }
}

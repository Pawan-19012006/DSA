// Implement a class maxHeap that supports the following operations:

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

// Input: q = 5, queries[][] = [[1, 3], [1, 7], [3], [1, 2], [3]]
// Output: [7, 7]
// Explanation:
// push(3): heap is [3]
// push(7): heap is [7, 3]
// peek(): return top element 7
// push(2): heap is [7, 3, 2]
// peek(): return top element 7
// Input: q = 6, queries[][] = [[1, 4], [1, 8], [1, 7], [2], [3], [4]]
// Output: [7, 2]
// Explanation:
// push(4): heap is [4]
// push(8): heap is [8, 4]
// push(7): heap is [8, 7, 4]
// pop(): remove top element 8, now heap is [7, 4]
// peek(): return top element 7
// size(): return no of elements in the heap
// Constraints:
// 1 ≤ q ≤ 103
// 1 ≤ x ≤ 105

class maxHeap {

    // Constructor
    ArrayList<Integer> heap;
    public maxHeap() {
        heap = new ArrayList<>();
    }

    public void push(int x) {
        heap.add(x);
        int i = heap.size() - 1;
        while(i>0){
            int parent = (i-1)/2;
            if(heap.get(parent)>heap.get(i)){ // check whether the parent is already bigger
                break;
            }
            
            int temp = heap.get(i);
            heap.set(i, heap.get(parent));
            heap.set(parent, temp);
            
            i = parent;
        }
    }

    public void pop() {
        
        if(heap.isEmpty()){
            return;
        }
        int last = heap.size() -1;
        heap.set(0, heap.get(last));
        heap.remove(last);
        
        int i = 0;
        
        while(true){
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;
            int biggest = i;
            
            if(left<heap.size() && heap.get(left)>heap.get(biggest)){ // if the left is bigger, biggest becomes the value in left
                biggest = left;
            }
            
            if(right<heap.size() && heap.get(right)>heap.get(biggest)){ //if the right is bigger, biggest becomes the value in right
                biggest = right;
            }
            
            if(biggest == i){
                break;
            }
            
            int temp = heap.get(i);
            heap.set(i, heap.get(biggest));
            heap.set(biggest, temp);
            
            i = biggest;
        }
    }

    public int peek() {
        if(heap.size()==0){
            return -1;
        }
        
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }
}


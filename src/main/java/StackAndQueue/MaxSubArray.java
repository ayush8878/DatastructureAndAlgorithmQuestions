package StackAndQueue;

import java.util.ArrayDeque;

public class MaxSubArray {
    public static void main(String[] args) {
        int []arr = new int[]{1,2,3,1,4,5,2,3,5};
        int k = 3;
        maxSubArrayK(arr,k);
    }

    private static void maxSubArrayK(int[] arr, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>(k);
        // process first k elements of array

        int i=0;
        for(;i<k;i++)
        {
            // logic
            // for first k elements check if there is something
            // at the end of queue that is lesser than current
            // and remove it for the new element that is greater
            // NOTE: if the last element is greater than current
            // then keep both
            while (!deque.isEmpty() && arr[i] > arr[deque.getLast()])
            {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        // remaining elements of array

        for( ; i< arr.length;i++)
        {
            System.out.print(arr[deque.getFirst()]+" ");
            // remove elements from left(contraction when any index lies outside the current window)
            while(!deque.isEmpty() && deque.getFirst() <= i - k)
            {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && arr[i] >= arr[deque.getLast()])
            {
                deque.removeLast();
            }

            // always add new element at last
            deque.addLast(i);
        }


    }
}

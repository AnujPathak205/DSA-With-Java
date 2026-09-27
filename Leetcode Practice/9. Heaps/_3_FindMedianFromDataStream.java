/*
    295. Find Median from Data Stream
    (Hard)

    The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

    For example, for arr = [2,3,4], the median is 3.
    For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
    Implement the MedianFinder class:

    MedianFinder() initializes the MedianFinder object.
    void addNum(int num) adds the integer num from the data stream to the data structure.
    double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 
*/

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> firstHalf;
    private PriorityQueue<Integer> secondHalf;

    public MedianFinder() {
        firstHalf = new PriorityQueue<>(Comparator.reverseOrder());
        secondHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (firstHalf.size() == secondHalf.size()) {
            if (firstHalf.isEmpty() || num <= secondHalf.peek()) {
                firstHalf.add(num);
            } else {
                firstHalf.add(secondHalf.remove());
                secondHalf.add(num);
            }
        } else {
            if (num >= firstHalf.peek()) {
                secondHalf.add(num);
            } else {
                secondHalf.add(firstHalf.remove());
                firstHalf.add(num);
            }
        }
    }
    
    public double findMedian() {
        if (firstHalf.size() == secondHalf.size()) {
            return (double) (firstHalf.peek() + secondHalf.peek()) / 2;
        } else {
            return firstHalf.peek();
        }
    }
}

public class _3_FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(5);
        double param_2 = obj.findMedian();
    }
}

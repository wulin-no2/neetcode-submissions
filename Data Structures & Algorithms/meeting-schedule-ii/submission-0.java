/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return 0;

        // Step 1: Sort meetings by start time
        intervals.sort(Comparator.comparingInt(a -> a.start));

        // Step 2: Use a Min-Heap to track end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Interval interval : intervals) {
            // Remove meetings that have ended before this one starts
            if (!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
                minHeap.poll(); // Free up a room
            }
            
            // Add current meeting's end time
            minHeap.add(interval.end);
        }

        // Step 3: The heap size is the number of rooms needed
        return minHeap.size();
        
    

    }
}

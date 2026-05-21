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
    public boolean canAttendMeetings(List<Interval> intervals) {
        // check if any two of the intervals overlapping
        // Sort them by their start time, then compare their end time
        Collections.sort(intervals, Comparator.comparing(a -> a.start));
        for(int i = 0; i < intervals.size() - 1; i++){
            if(intervals.get(i).end > intervals.get(i+1).start) return false;
        }
        return true;


    }
}

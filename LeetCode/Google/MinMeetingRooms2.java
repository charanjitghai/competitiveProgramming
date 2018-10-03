/**
* author: charanjitghai
* question: https://leetcode.com/problems/meeting-rooms-ii/description/
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

enum EventType {
    START, END;
}

class Event implements Comparable<Event>{
    int time;
    EventType type;
    Event(int time, EventType type) {
        this.time = time;
        this.type = type;
    }
    public int compareTo(Event other) {
        if(this.time != other.time)
            return this.time - other.time;
        if(this.type.equals(other.type))
            return 0;
        if(this.type.equals(EventType.START))
            return 1;
        return -1;
    }
}

class Solution {
    public static boolean debug = true;
    private boolean isOrganizationPossible(List<Event> events, int numMeetingRooms) {

        for(Event event : events) {
            if(event.type.equals(EventType.START))
                numMeetingRooms--;
            else
                numMeetingRooms++;
            if(numMeetingRooms < 0)
                return false;
        }
        return true;
    }

    public int minMeetingRooms(Interval[] intervals) {
        List<Event> events = new ArrayList<>();
        for(Interval interval : intervals) {
            int start = interval.start;
            int end = interval.end;
            events.add(new Event(start, EventType.START));
            events.add(new Event(end, EventType.END));
        }
        Collections.sort(events);

        if(debug) {
            for(Event event : events)  {
                System.out.println("time - " + event.time + " type - " + event.type);
            }
        }

        int s = 0;
        int e = events.size();
        int ans = events.size();

        while (s <= e) {

            int m = (s + e)/2;
            if(debug)
                System.out.println("trying with - " + m);
            if(isOrganizationPossible(events, m)) {
                ans = m;
                e = m-1;
            }
            else {
                s = m+1;
            }
        }
        return ans;
    }
}

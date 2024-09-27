import java.util.ArrayList;
import java.util.List;

class Event {
    int start;
    int end;

    public Event(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class MyCalendarTwo {
    List<Event> overLap;
    List<Event> nonOverlap;

    public MyCalendarTwo() {
        overLap = new ArrayList<>();
        nonOverlap = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        for (Event e : overLap) {
            if (isOverlap(e, start, end))
                return false;
        }

        for (Event e : nonOverlap) {
            if (isOverlap(e, start, end)) {
                overLap.add(getOverlapRegion(e, start, end));
            }
        }
        nonOverlap.add(new Event(start, end));

        return true;
    }

    public boolean isOverlap(Event e, int start, int end) {
        return Math.max(e.start, start) < Math.min(e.end, end);
    }

    public Event getOverlapRegion(Event e, int start, int end) {
        return new Event(Math.max(e.start, start), Math.min(e.end, end));
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
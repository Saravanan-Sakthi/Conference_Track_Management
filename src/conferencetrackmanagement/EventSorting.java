package conferencetrackmanagement;

import conferencetrackmanagement.details.Event;

import java.util.Comparator;

public class EventSorting implements Comparator<Event> {
    @Override
    public int compare(Event o1, Event o2) {
        return o2.getDuration() - o1.getDuration();
    }
}

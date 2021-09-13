package conferencetrackmanagement;

import conferencetrackmanagement.details.Event;
import conferencetrackmanagement.details.Track;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrackManager {

    private List<Track> filledTracks = new ArrayList<>();
    private List<Track> unfilledTracks = new ArrayList<>();

    public List<Track> getFilledTracks() {
//        System.out.println(filledTracks);
        return filledTracks;
    }

    public List<Track> getUnfilledTracks() {
//        System.out.println(unfilledTracks);
        return unfilledTracks;
    }

    public void scheduleEvents(List<String> events){

//        System.out.println("Inside scheduler");

        EventSorting comparator = new EventSorting();
        List<Event> eventList = new ArrayList<Event>();
        for (String name : events){
            Event event = createEvent(name);
            eventList.add(event);
        }
//        Collections.sort(eventList , comparator);
        createTrack(eventList);
    }

    private void createTrack(List<Event> eventList){

//        System.out.println("Inside Creator");

//        List<Track> trackList = new ArrayList<>();
        Track track = new Track();
        List<Event> morningSessions = track.getMorningSession();
        List<Event> afternoonSessions = track.getAfternoonSession();
        for(Event event : eventList){
//            System.out.println(event.getDuration());
            if(event.getDuration()>240){
                continue;
            }
            if(checkUnfilledTracks(event)){
                continue;
            }
            if(event.getDuration() <= 240 && track.getMorningTime()+event.getDuration()>180 && track.getAfternoonTime() + event.getDuration()>480){
                if(track.getMorningTime() >= 175 && track.getAfternoonTime() >= 475){
                    filledTracks.add(track);
                } else {
                    unfilledTracks.add(track);
                }
                track = new Track();
                morningSessions = track.getMorningSession();
                afternoonSessions = track.getAfternoonSession();
            }
            if(track.getMorningTime()+event.getDuration()>180){
                afternoonSessions.add(event);
                event.setTime(track.getAfternoonTime());
                track.setAfternoonTime(track.getAfternoonTime()+event.getDuration());
            } else /*if(track.getMorningTime() + event.getDuration() <=180)*/{
                morningSessions.add(event);
                event.setTime(track.getMorningTime());
                track.setMorningTime(track.getMorningTime()+event.getDuration());
            }
        }
        unfilledTracks.add(track);
    }

    private boolean checkUnfilledTracks(Event event){
        int duration  = event.getDuration();
        for(Track unfilledTrack : unfilledTracks){
            if(unfilledTrack.getMorningTime()+duration <=180){
                List<Event> morningSessions = unfilledTrack.getMorningSession();
                morningSessions.add(event);
                event.setTime(unfilledTrack.getMorningTime());
                unfilledTrack.setMorningTime(unfilledTrack.getMorningTime()+duration);
                return true;
            } else if(unfilledTrack.getAfternoonTime()+duration <=480){
                List<Event> afternoonSessions = unfilledTrack.getAfternoonSession();
                afternoonSessions.add(event);
                event.setTime(unfilledTrack.getAfternoonTime());
                unfilledTrack.setAfternoonTime(unfilledTrack.getAfternoonTime()+duration);
                return true;
            }
        }
        return false;
    }

    private Event createEvent(String name){
        String [] eventName = name.split(" ");
        int length = eventName.length;
        int duration = 0;
        String time = eventName[length-1];

//        System.out.println(time);

        if(time.equals("lightning")){
            duration = 5;
        } else {
            int i=0;
            while(time.charAt(i) != 'm'){
                duration = (duration*10)+((int) time.charAt(i) - (int)'0');
                i++;
            }
        }
        Event event = new Event();
        event.setDuration(duration);
        event.setName(name);
        return event;
    }
}

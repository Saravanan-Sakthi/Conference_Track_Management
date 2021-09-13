package conferencetrackmanagement;

import conferencetrackmanagement.details.Track;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrackManagingDriver {
    public static void main(String[] args) {
        System.out.println("Enter the Events ");
        List<String> events = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String event = scan.nextLine();
        while (!event.equals("end")){
            events.add(event);
            event = scan.nextLine();
        }

//        System.out.println(events);

        TrackManager manager = new TrackManager();
        manager.scheduleEvents(events);
        List<Track> filledTracks = manager.getFilledTracks();
        List<Track> unfilledTracks = manager.getUnfilledTracks();
        int i=1;
//        System.out.println("filled");
        for(Track track : filledTracks){
            System.out.println("Track "+i);
            System.out.println(track+"\n");
            i++;
        }
//        System.out.println("unfilled");
        for (Track track : unfilledTracks){
            System.out.println("Track "+i);
            System.out.println(track+"\n");
            i++;
        }
    }
}

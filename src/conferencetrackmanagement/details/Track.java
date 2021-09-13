package conferencetrackmanagement.details;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private List<Event> morningSession = new ArrayList<>();
    private List<Event> afternoonSession = new ArrayList<>();
    private int morningTime = 0;
    private int afternoonTime = 240;

    public List<Event> getMorningSession() {
        return morningSession;
    }
/*
    public void setMorningSession(List<Event> morningSession) {
        this.morningSession = morningSession;
    }*/

    public List<Event> getAfternoonSession() {
        return afternoonSession;
    }
/*
    public void setAfternoonSession(List<Event> afternoonSession) {
        this.afternoonSession = afternoonSession;
    }*/

    public int getMorningTime() {
        return morningTime;
    }

    public void setMorningTime(int morningTime) {
        this.morningTime = morningTime;
    }

    public int getAfternoonTime() {
        return afternoonTime;
    }

    public void setAfternoonTime(int afternoonTime) {
        this.afternoonTime = afternoonTime;
    }

    @Override
    public String toString() {
        String out="";
        for(Event event :morningSession){
            out = out+ event.toString() +"\n";
        }
        out = out+"Lunch " +"12:0 PM\n";
        for (Event event : afternoonSession){
            out = out +event.toString() + "\n";
        }
//        out = out+afternoonTime+" ";
        if(afternoonTime<420){
            afternoonTime = 420;
        }
        out = out+"Networking Session "+((afternoonTime/60)-3)+":"+ (afternoonTime%60)+" PM";
        return out;
    }
}


/*
 a 180min
         b 250min
         c 200min
         d 123min
         e 128min
         f 257min
         g 350min
         h lightning
         i lightning
         j 98min
         k 23min
         end
         Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 3
         at java.lang.String.charAt(String.java:658)
         at conferencetrackmanagement.TrackManager.createEvent(TrackManager.java:107)
         at conferencetrackmanagement.TrackManager.scheduleEvents(TrackManager.java:32)
         at conferencetrackmanagement.TrackManagingDriver.main(TrackManagingDriver.java:23)

         Process finished with exit code 1
*/

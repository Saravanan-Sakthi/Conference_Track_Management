package conferencetrackmanagement.details;

public class Event {
    private String name;
    private int duration;
    private int time;

/*    public String getName() {
        return name;
    }*/

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
/*
    public int getTime() {
        return time;
    }*/

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        String out="";
        out = out+name+"  ";
        int startTime = 9+(time/60);
        if(startTime>12){
            startTime = startTime-12;
            out = out+startTime+":"+(time%60)+" PM";
        } else {
            out = out + startTime + ":" + (time % 60)+" AM";
        }
        return out;
    }
}

package ua.sumdu.j2se.Belokon.tasks;

public class Task {
    private String title;
    private int time;
    private int start;
    private int end;
    private int interval;
    private boolean repeat;
    private boolean active;

    public Task(String title, int time) {
        this.title = title;
        this.time = time;
        this.repeat = false;
    }
    public Task(String title, int start, int end, int interval){
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.active = false;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public boolean isActive(){
        return active;
    }
    public void setActive(boolean active){
        this.active = active;
    }
    public int getTime(){
        if (repeat) {
            return start;
        } else {
            return time;
        }
    }
    public void setTime(int time){
        this.time = time;
        if (repeat){
            repeat = false;
        }

    }
    public int getStartTime(){
        if (repeat){
            return start;
        } else {
            return time;
        }
    }
    public int getEndTime(){
        if (repeat){
            return end;
        } else {
            return time;
        }
    }
    public int getRepeatInterval(){
        if (repeat){
            return interval;
        } else {
            return 0;
        }
    }
    public void setTime(int start, int end, int interval){
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.repeat = true;
    }
    public boolean isRepeated(){
        return repeat;
    }
    public int nextTimeAfter(int current){
        int next;
        if(active){
            if(repeat) {
                if (start > current) {
                    return start;
                } else {
                    next = start;
                    while (current >= next) {
                        next = next + interval;
                    }
                    if (next <= end) {
                        return next;
                    } else {
                        return -1;
                    }
                }
            }  else {
                if (current < time){
                    return time;
                } else {
                    return -1;
                }
            }
        }else {
            return -1;
        }
    }
}

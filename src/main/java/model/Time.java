package model;

import java.util.Timer;
import java.util.TimerTask;

public class Time {
    private Timer timer = new Timer();
    private double clock = 0;
    
    public void start() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                clock += 0.001;
            }
        }, 1, 1);
    }
    
    public void stop() {
        timer.cancel();
    }
    
    public double getTime() {
        return clock;
    }
    
    public void reset() {
        clock = 0;
        this.timer = new Timer();
    }
    
}

package edu.chalmers_gu_cse.oopd.exercises.polygonModel.polygon;

import edu.chalmers_gu_cse.oopd.exercises.polygonModel.polygon.internal.TimerObserver;

import java.util.Collection;
import java.util.LinkedList;

public class PolygonTimer {

    private final Collection<TimerObserver> observers = new LinkedList<>();

    // msBetweenTicks is the number of milliseconds between each tick
    private int msBetweenTicks;


    public PolygonTimer(int msBetweenTicks) {
        this.msBetweenTicks = msBetweenTicks;
    }

    private void notifyObservers() {
        for (TimerObserver observer : observers) {
            observer.changeOnTimerUpdate();
        }
    }

    public void addObserver(TimerObserver observer) {
    this.observers.add(observer);
    }

    public void run() {
        boolean running = true;
        while (running) {
            try {
                Thread.sleep(msBetweenTicks);
                notifyObservers();
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }
}


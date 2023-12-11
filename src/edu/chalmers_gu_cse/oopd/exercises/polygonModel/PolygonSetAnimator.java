package edu.chalmers_gu_cse.oopd.exercises.polygonModel;

import edu.chalmers_gu_cse.oopd.exercises.polygonModel.polygon.PolygonTimer;
import edu.chalmers_gu_cse.oopd.exercises.polygonModel.polygon.internal.TimerObserver;

import java.util.ArrayList;
import java.util.List;

/* package-private */ class PolygonSetAnimator implements TimerObserver {
    private final PolygonSet polygonSet;
    private int ticker = 0;
    private boolean moveForwards = true;

    private PolygonTimer timer;

    public PolygonSetAnimator(PolygonSet polygonSet, PolygonTimer timer) {
        this.polygonSet = polygonSet;
        this.timer = timer;
        timer.addObserver(this);
    }

    // TODO: Step 2f: Update this method to use a Macro, instead of the current
    //   fixed behavior. What's the name of this design pattern?
    public void update(){
        ticker++;
        int value = moveForwards ? 10 : -10;
        polygonSet.translate(value, value);
        if (ticker > 10) {
            moveForwards = !moveForwards;
            ticker = 0;
        }
        notifyListeners();
    }
    // TODO 1: Observer Pattern: Put the clock in a separate class, and let
    //  PolygonModel have, and start, such a clock. Make the clock observable,
    //  and let this animator be an observer so that update is called on
    //  each tick.
    public void animate(){
        timer.run();
    }

    private final List<ModelUpdateListener> listeners = new ArrayList<>();
    public void addListener(ModelUpdateListener l){
        listeners.add(l);
    }
    protected void notifyListeners(){
        for (ModelUpdateListener l : listeners)
            l.actOnModelUpdate();
    }

    @Override
    public void changeOnTimerUpdate() {
        update();
    }
}

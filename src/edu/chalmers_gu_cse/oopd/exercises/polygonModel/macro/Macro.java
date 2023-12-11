package edu.chalmers_gu_cse.oopd.exercises.polygonModel.macro;

import edu.chalmers_gu_cse.oopd.exercises.polygonModel.polygon.Polygon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niklas on 2016-03-02.
 */
public class Macro implements Transform{
    private final List<Transform> transforms = new ArrayList<>();

    // TODO: Step 2c: Implement this method (should be trivial)
    public void addTransform(Transform t){
        transforms.add(t);
    }

    public void addTransformHard(){
        transforms.add(new BIGTransform());
        transforms.add(new ExampleTransform());
    }

    // TODO: Step 2d: Implement a method transform. What signature should it have?
     public Polygon transform(Polygon p){
        for (Transform t : transforms)
            t.transform(p);
        return p;
     }

    // TODO: Step 2e: What design pattern have we just implemented?
    // Composite!!
}

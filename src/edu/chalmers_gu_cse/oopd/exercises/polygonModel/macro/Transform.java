package edu.chalmers_gu_cse.oopd.exercises.polygonModel.macro;

import edu.chalmers_gu_cse.oopd.exercises.polygonModel.polygon.Polygon;
import edu.chalmers_gu_cse.oopd.exercises.polygonModel.polygon.internal.DecoratedPolygon;

/**
 * Created by Niklas on 2016-03-02.
 */
//@FunctionalInterface
public interface Transform {
    // TODO: Step 2a: What is the representation of a transform?
     Polygon transform(Polygon polygon);
}

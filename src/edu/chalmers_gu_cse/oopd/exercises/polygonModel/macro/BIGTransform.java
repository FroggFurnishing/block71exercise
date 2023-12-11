package edu.chalmers_gu_cse.oopd.exercises.polygonModel.macro;

import edu.chalmers_gu_cse.oopd.exercises.polygonModel.polygon.Polygon;

public class BIGTransform implements Transform{
    @Override
    public Polygon transform(Polygon polygon) {
        return polygon.scale(1000, 1000);
    }
}

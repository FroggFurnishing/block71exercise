package edu.chalmers_gu_cse.oopd.exercises.controller;

import edu.chalmers_gu_cse.oopd.exercises.polygonModel.PolygonModel;
import edu.chalmers_gu_cse.oopd.exercises.polygonModel.macro.Macro;
import edu.chalmers_gu_cse.oopd.exercises.polygonModel.polygon.PolygonFactory;
import edu.chalmers_gu_cse.oopd.exercises.polygonModel.polygon.Polygon;
import edu.chalmers_gu_cse.oopd.exercises.view2d.PolygonViewer;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Niklas on 2016-02-21.
 */
public class PolygonClicker {

    private final PolygonModel model;

//    public final LinkedList<Macro> macros = new LinkedList<>();
    public final Macro macro = new Macro();

    void addToMakro(){
        macro.addTransformHard();
    }

    public PolygonClicker(PolygonModel model, PolygonViewer view) {
        this.model = model;
        initInteraction(view);
    }

    private void initInteraction(PolygonViewer view) {
        view.addMouseListener(new PolygonCreator());
    }

    private class PolygonCreator implements MouseListener {
        public void mouseEntered(MouseEvent e) {
            List<Polygon> list = model.getPolygonsToTransform();
            for (Polygon m : list)
                macro.transform(m);
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {
            Point pointClicked = e.getPoint();
            Polygon py = PolygonFactory.createRectangle(pointClicked.x, pointClicked.y);
            model.addPolygon(py);
        }

    }

}
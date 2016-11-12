package myClass;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * Created by Johnny on 2016/11/9.
 */
public class VisualAccumulator extends Accumulator{
    public VisualAccumulator(int trials, double max) {
        StdDraw.setXscale(0,trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(0.005);
    }

    @Override
    public void addDataValue(double val) {
        super.addDataValue(val);
        StdDraw.setPenColor(Color.darkGray);
        StdDraw.point(getN(), val);

        StdDraw.setPenColor(Color.red);
        StdDraw.point(getN(), super.mean());
    }
}

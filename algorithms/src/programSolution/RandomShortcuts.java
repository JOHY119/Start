package programSolution;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

/**Q 1.1.31
 * Created by Johnny on 2016/11/7.
 */

class point{
    public double x;
    public double y;

    public point(double x, double y) {
        this.x=x;
        this.y=y;
    }
}

public class RandomShortcuts {

    public static void main(String[] args) {
        StdDraw.setXscale(-1,1);
        StdDraw.setYscale(-1,1);
        StdDraw.circle(0,0,1);
        int n=300;
        double p=0.02;
        point[] points = new point[n];
        for (int i=0;i<n;i++) {
            points[i] = new point(Math.cos((2 * Math.PI) / n * i), Math.sin((2 * Math.PI) / n * i));
        }

        StdDraw.setPenColor(Color.red);
        StdDraw.setPenRadius(0.01);
        for (point a :
                points) {
            StdDraw.point(a.x, a.y);
        }

        StdDraw.setPenColor(Color.GRAY);
        StdDraw.setPenRadius();
        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                if (StdRandom.bernoulli(p))
                    StdDraw.line(points[i].x,points[i].y,points[j].x,points[j].y);
            }
        }




    }
}

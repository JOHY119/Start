package programSolution;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

/**
 * Created by Johnny on 2016/11/9.
 */

class Point{
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x=x;
        this.y=y;
    }

    public double distance(Point p){
        return Math.sqrt(Math.pow(x-p.x,2)+Math.pow(y-p.y,2));
    }

    public void drawPoint(){
        StdDraw.point(x,y);
    }
    public void connect(Point p){
        StdDraw.line(x,y,p.x,p.y);
    }
}
public class ShortestDistance {

    public static void main(String[] args) {
        int n=100;
        Point[] a=new Point[n];

        StdDraw.setXscale(0,1);
        StdDraw.setYscale(0,1);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(Color.darkGray);




        for (int i = 0; i < a.length; i++) {
            a[i]=new Point(StdRandom.uniform(),StdRandom.uniform());
            a[i].drawPoint();
        }
        int minI=0;
        int minJ=1;
        double shortestDistance=1.5;

        for (int i = 0; i < n; i++) {
            for (int j=i+1;j<n;j++){
                double distance=a[i].distance(a[j]);

                //a[i].connect(a[j]);

                if (shortestDistance>distance){
                    minI=i;
                    minJ=j;
                    shortestDistance=distance;
                }
            }
        }

        StdDraw.setPenColor(Color.red);
        a[minI].connect(a[minJ]);
        System.out.println(minI);
        System.out.println(minJ);
        System.out.println(shortestDistance);
    }
}

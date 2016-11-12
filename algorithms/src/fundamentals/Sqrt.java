package fundamentals;

/**
 * 牛顿迭代法求平方根.
 * Created by Johnny on 2016/11/7.
 */
public class Sqrt {
    public static double sqrt(double c){
        if(c<0) return Double.NaN;
        double err=1e-10;
        double t=c;
        int count=0;
        while (Math.abs(t * t - c) > err) {
            t=(t+c/t)/2;
            count++;
        }
        System.out.println("count: "+count);
        return t;

    }

    public static void main(String[] args) {
        System.out.println(sqrt(3584395));
    }
}

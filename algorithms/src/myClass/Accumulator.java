package myClass;

/**
 * 累加器.
 * 不需要存储被累加数据.
 * Created by Johnny on 2016/11/9.
 */
public class Accumulator {
    //累加数据数量
    private int n;
    //实时平均值
    private double m;
    //实时方差
    private double s;


    public int getN() {
        return n;
    }

    /**
     * 添加被累加数据.
     *
     * @param val 被累加数据
     */
    public void addDataValue(double val) {
        n++;
        //  递推式求方差
        s = s + 1.0 * (n - 1) / n * (n - m) * (n - m);
        //递推式求均值
        m = m + (val - m) / n;
    }

    /**
     * 求平均值.
     *
     * @return 平均值
     */
    public double mean() {
        return m;
    }

    /**
     * 求方差.
     * @return 方差
     */
    public double var(){
        return s / (n - 1);
    }

    /**
     * 标准差.
     * @return 标准差.
     */
    public double stdDev(){
        return Math.sqrt(var());
    }

    /**
     * @return Mean ([数据总数] values): [平均值]
     */
    @Override
    public String toString() {
        return "Mean(" + n + " values): " +
                String.format("%7.5f", mean())+
                "  var: "+var();
    }
}

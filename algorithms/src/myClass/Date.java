package myClass;

/**
 * Created by Johnny on 2016/11/9.
 */
public class Date {
    private final int year;
    private final int month;
    private final int day;

    public Date(int y, int m, int d) {
        year = y;
        month = m;
        day = d;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return getYear() + "/" + getMonth() + "/" + getDay();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Date that = (Date) obj;
        if (year == that.year
                && month == that.month
                && day == that.day) return true;

        return false;
    }
}

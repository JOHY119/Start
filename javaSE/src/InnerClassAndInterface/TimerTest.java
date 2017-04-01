package InnerClassAndInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 定时打印信息
 * Created by Johnny on 2017/2/21.
 */

public class TimerTest {


//        public void start(int interval,boolean beep) {
//
//            int[] a = new int[1];
//            a[0]=10;
//            class TimerPrinter implements ActionListener {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    if (beep)
//                        System.out.println(new Date());
//                    a[0] = a[0] + 1;
//
//                }
//            }
//            ActionListener listener =new TimerPrinter();
//            Timer timer = new Timer(interval,listener);
//
//            timer.start();
//        }
//
//
//
//    public static void main(String[] args) {
//        TimerTest timerTest = new TimerTest();
//        timerTest.start(1000, true);
//    }

    public void start(int interval, boolean beep) {
        Timer timer = new Timer(interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (beep) {
                    System.out.println(new Date());
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        TimerTest timerTest = new TimerTest();
        timerTest.start(1000,true);
    }

}

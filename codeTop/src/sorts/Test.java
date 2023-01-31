package sorts;

import com.sun.source.tree.IfTree;

import java.util.Scanner;

/**
 * FileName: Test
 * author: gxs
 * Date: 2021/12/1  17:02
 */
public class Test {
//    state transfer
  //  String[] states = {"ni","ei","se","si","fi","fo","th","tw","on","ze"};
    static String state = "";
    public static void main(String[] args) {
//        读入一个输入，并给状态机赋值
        Scanner sc = new Scanner(System.in);

        int count = 0;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (state.equals("ni")) {
                    System.out.println("nine");
                    state = "ei";
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (state.equals("ei")) {
                    System.out.println("eight");
                    state = "se";
                } try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (state.equals("se")) {
                    System.out.println("seven");
                    state = "si";
                } try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (state.equals("si")) {
                    System.out.println("six");
                    state = "fi";
                } try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (state.equals("fi")) {
                    System.out.println("five");
                    state = "fo";
                } try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (state.equals("fo")) {
                    System.out.println("four");
                    state = "th";
                } try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (state.equals("th")) {
                    System.out.println("three");
                    state = "tw";
                } try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (state.equals("tw")) {
                    System.out.println("two");
                    state = "on";
                } try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (state.equals("on")) {
                    System.out.println("one");
                    state = "ze";
                } try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (state.equals("ze")) {
                    System.out.println("zero");
                    state = "ze";
                } try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        int key; // 表示输入开关
        int tMode = 0; // 表示当前输入模式
        int screen = 0; // 表示当前屏幕的开关状态
        String trans = "";
        while (true) {
            key = sc.nextInt();
            if (key == 1) {
                if (screen == 0) {
                    System.out.println("开灯了---------------------");
                    if (tMode == 0)
                        state = "ni";
                    if (tMode == 1) {
                        state = "si";
                    }
                } else if (screen == 1) {
                    System.out.println("关灯了=======================");
                    state = "ze";
                }
                screen = (screen + 1) & 1;
            }
            if (key == 2) {
                System.out.println("刷新屏幕时间----------------------");
                if (!state.equals("ze"))
                    if (tMode == 0)
                        state = "ni";
                if (tMode == 1) {
                    state = "si";
                }
            }
            if (key == 3) {
                System.out.println("改变了时间模式----------------------");
                if (!state.equals("ze"))
                if (tMode == 0) {
                    tMode = 1;
                    state = "si";
                } else if (tMode == 1) {
                    tMode = 0;
                    state = "ni";
                }
            }
            new Thread(t1).start();

            if (screen == 1) trans = " 亮";
            if (screen == 0) trans = " 灭";
                count = (count + 1) & 1;
                System.out.println("输入为：" + "key " + key
                + " 时间模式为 "+ tMode + "\n当前倒计时状态为 " + state
                        + " 当前屏幕为 " + trans );
            }
        }
}

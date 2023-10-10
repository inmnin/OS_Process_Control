package Root_Page;

import Lamport.*;
import Dekker.Typical.*;
import Dekker.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Root_Page extends JFrame {
    private Listener_Button decision;
    private Listener_Begin begin;
    private int NUM_THREADS;
    private int sign;
    public JFrame f = new JFrame("并发进程控制");
    private JButton ok = new JButton("开始运行算法");
    private JButton a1 = new JButton("Dekker算法");
    private JButton a2 = new JButton("Peterson算法");
    private JButton a3 = new JButton("Lamport算法");
    private JButton a4 = new JButton("Eisenberg/Mcgouire算法");


    public Root_Page(){
        f.setSize(500,500);
        f.setLocation(400,150);
        f.setLayout(null);


        //保持a1-ok居中
        int buttonWidth = 270;
        int buttonHeight = 60;
        int gap = 10;  // 两个按钮之间的间隔

        int centerX = (f.getWidth() - buttonWidth) / 2;  // 水平居中的x坐标
        a1.setBounds(centerX, 50, buttonWidth, buttonHeight);
        a2.setBounds(centerX, 50 + buttonHeight + gap, buttonWidth, buttonHeight);
        a3.setBounds(centerX, 50 + 2 * (buttonHeight + gap), buttonWidth, buttonHeight);
        a4.setBounds(centerX, 50 + 3 * (buttonHeight + gap), buttonWidth, buttonHeight);
        ok.setBounds(centerX, 50 + 4 * (buttonHeight + gap)+20, buttonWidth, 40);

        Panel mp = new Panel();
        mp.setBounds(centerX,50+4 * (buttonHeight + gap)-2,270,1);
        mp.setBackground(Color.BLACK);

        decision = new Listener_Button();
        begin = new Listener_Begin();
        a1.addActionListener(decision);
        a2.addActionListener(decision);
        a3.addActionListener(decision);
        a4.addActionListener(decision);
        ok.addActionListener(begin);

        f.add(a1);
        f.add(a2);
        f.add(a3);
        f.add(a4);
        f.add(ok);
        f.add(mp);
        f.setVisible(true);


        JLabel ch1 = new JLabel("基于软件互斥算法的临界区进程互斥的模拟实现");
        Font newFont = new Font("站酷酷黑", Font.BOLD, 18);
        ch1.setFont(newFont);

        ch1.setForeground(Color.BLACK);
        ch1.setBounds(50,10,400,30);
        f.add(ch1);





    }

    class Listener_Button implements ActionListener{              //根据按钮，用sign来保存要调用哪个算法函数
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(actionEvent.getSource().equals(a1)){
                sign = 1;
            }
            if(actionEvent.getSource().equals(a2)){
                sign = 2;
            }
            if(actionEvent.getSource().equals(a3)){
                sign = 3;
            }
            if(actionEvent.getSource().equals(a4)){
                sign = 4;
            }
        }
    }

    class Listener_Begin implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            try{
                switch (sign){
                    case 1:
                        Dekker();

                        break;
                    case 2:
//                    Peterson();
                        break;
                    case 3:

                        Lamport();
                        break;
                    case 4:
//                    Eisenberg();
                        break;
                }
              }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"错误输入！");
            }


        }
    }

    private void Dekker(){
        f.dispose();
        Dekker_Option_Page dekker_option_page = new Dekker_Option_Page();
        dekker_option_page.setVisible(true);
    }
//    private void Peterson(){
//        Peterson_Resource resource = new Peterson_Resource(f);
//        new Thread((new Peterson(0,resource))).start();
//        new Thread((new Peterson(1,resource))).start();
//    }
    private void Lamport(){
        f.dispose();
        Lamport_Option_Page lamport_option_page = new Lamport_Option_Page();
        lamport_option_page.setVisible(true);
    }
//    private void Eisenberg(){
//        Eisenberg_Resource resource = new Eisenberg_Resource(NUM_THREADS,f);
//        for(int i=0;i<NUM_THREADS;i++){
//            new Thread((new Eisenberg(i,resource))).start();
//        }
//
//    }


}



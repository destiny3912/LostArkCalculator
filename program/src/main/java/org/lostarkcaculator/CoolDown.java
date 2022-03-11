package org.lostarkcaculator;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

public class CoolDown extends JFrame{
    private int jewel, tripod, originCoolTime, width = 360, height = 90;
    private double speed;

    private JFrame mainFrame;
    private JTextField jewelText, tripodText, speedText, originText;
    private JButton submitButton;
    private JPanel jewelPane, tripodPane, speedPane, originPane, submitPane, resultPane = new JPanel();;
    private JLabel jewelLabel, tripodLabel, speedLabel, originLabel, resultLabel;
    private Font mainFont = new Font("나눔맑은고딕", Font.PLAIN, 15);

    public CoolDown() 
    {   
        mainFrame = new JFrame();
        mainFrame.setSize(width, 540);
        mainFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(6, 1));
        mainFrame.setVisible(true);

        jewelPane = new JPanel();
        jewelPane.setSize(width, height);
        jewelPane.setLayout(new FlowLayout());
        jewelLabel = new JLabel();
        jewelLabel.setText("보석 레벨");
        jewelLabel.setFont(mainFont);
        jewelText = new JTextField();
        jewelText.setColumns(10);
        jewelPane.add(jewelLabel);
        jewelPane.add(jewelText);

        tripodPane = new JPanel();
        tripodPane.setSize(width, height);
        tripodPane.setLayout(new FlowLayout());
        tripodLabel = new JLabel();
        tripodLabel.setText("트포 쿨감");
        tripodLabel.setFont(mainFont);
        tripodText = new JTextField();
        tripodText.setColumns(10);
        tripodPane.add(tripodLabel);
        tripodPane.add(tripodText);
    
        speedPane = new JPanel();
        speedPane.setSize(width, height);
        speedPane.setLayout(new FlowLayout());
        speedLabel = new JLabel();
        speedLabel.setText("신속 수치");
        speedLabel.setFont(mainFont);
        speedText = new JTextField();
        speedText.setColumns(10);
        speedPane.add(speedLabel);
        speedPane.add(speedText);

        originPane = new JPanel();
        originPane.setSize(width, height);
        originPane.setLayout(new FlowLayout());
        originLabel = new JLabel();
        originLabel.setText("최초 쿨타임");
        originLabel.setFont(mainFont);
        originText = new JTextField();
        originText.setColumns(10);
        originPane.add(originLabel);
        originPane.add(originText);

        submitPane = new JPanel();
        //submitPane.setSize(width, height);
        submitButton = new JButton("확인");

        submitPane.add(submitButton);
        submitButton.addActionListener(new Actions());

        mainFrame.add(jewelPane);
        mainFrame.add(tripodPane);
        mainFrame.add(speedPane);
        mainFrame.add(originPane);
        mainFrame.add(submitPane);
    }

    public void getData(int jewel, int tripod, int speed, int originCoolTime)
    {
        
        this.jewel = convertJewelToCoolDown(jewel);
        this.tripod = tripod;
        this.speed = convertSpeedToCoolDown(speed);
        this.originCoolTime = originCoolTime;
    }

    public double computeCoolTime()
    {
        double result = (originCoolTime - tripod)*(100 - (jewel/100))/100*(100 - (speed/100))/100;
        return result;
    }

    private double convertSpeedToCoolDown(int speed)
    {
        return 2.15 * speed;
    }

    private int convertJewelToCoolDown(int jewel)
    {
        return 2 * jewel * 100;
    }

    public class Actions implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == submitButton)
            {
                if(resultLabel != null)
                    resultPane.remove(resultLabel);
                getData(Integer.parseInt(jewelText.getText()), Integer.parseInt(tripodText.getText()), Integer.parseInt(speedText.getText()), Integer.parseInt(originText.getText()));

                double result = computeCoolTime();
                String resultStr = "쿨타임 : " + result + "초";
                resultLabel = new JLabel();
                resultLabel.setText(resultStr);
                resultLabel.setFont(mainFont);
                resultPane.setSize(width, height);
                resultPane.add(resultLabel);
                mainFrame.add(resultPane);

                mainFrame.revalidate();
                mainFrame.repaint();
            }
        }
    }
}

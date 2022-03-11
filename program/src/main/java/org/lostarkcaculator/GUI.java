package org.lostarkcaculator;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

public class GUI extends JFrame{
    private JFrame mainFrame;
    private JPanel northPane, southPane, westPane, eastPane, centerPane;
    private JLabel introText, copyRightText;
    private JButton coolDownButton;
    private Font introFont = new Font("나눔맑은고딕", Font.PLAIN, 15);

    public GUI()
    {
        mainFrame = new JFrame("LostArk Calculator");
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setSize(360, 720);
        mainFrame.setLayout(new BorderLayout());

        northPane = new JPanel();
        northPane.setLayout(new FlowLayout());
        southPane = new JPanel();
        southPane.setLayout(new FlowLayout());
        westPane = new JPanel();
        eastPane = new JPanel();
        centerPane = new JPanel();
        centerPane.setLayout(new FlowLayout());

        mainFrame.add(northPane, BorderLayout.NORTH);
        mainFrame.add(southPane, BorderLayout.SOUTH);
        mainFrame.add(westPane, BorderLayout.WEST);
        mainFrame.add(eastPane, BorderLayout.EAST);
        mainFrame.add(centerPane, BorderLayout.CENTER);

        introText = new JLabel();
        introText.setText("로스트아크 스펙 효율 계산기 입니다.");
        introText.setFont(introFont);
        northPane.add(introText);

        copyRightText = new JLabel();
        copyRightText.setText("Made my 버프쓰는사람@루페온");
        copyRightText.setFont(introFont);
        southPane.add(copyRightText);

        coolDownButton = new JButton("쿨타임 계산");
        centerPane.add(coolDownButton);
        coolDownButton.addActionListener(new Actions());

        
    }

    class Actions implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == coolDownButton)
            {
                new CoolDown();
            }
        }
    }
    
}

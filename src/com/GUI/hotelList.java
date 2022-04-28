package com.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Image;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class hotelList {
	JLayeredPane layerpanel = new JLayeredPane();
	menu mn = new menu();
	
		public hotelList(JFrame mf, String id) {		
			Font font1 = new Font("맑은 고딕", Font.BOLD, 14);
			Font font2 = new Font("맑은 고딕", Font.BOLD, 13);
		
		mf.setTitle("호텔선택");
	    mf.setBounds(300, 200, 366, 669);
		layerpanel.setBounds(0,0,360,640);
		layerpanel.setLayout(null);
		mf.setResizable(false);
		mf.setLocationRelativeTo(null);
		
		
		////////////////////////////////////////////////////////////////// 타이틀 옆 아이콘 변경
		try {
			mf.setIconImage(ImageIO.read(new File("image/0_titleIcon.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		JPanel panel = new JPanel();
		panel.setSize(360,640);
		panel.setLayout(null);
		panel.setBackground(Color.white);

	
		Image top = new ImageIcon("image/H_list_top.PNG").getImage();
		JLabel lb_top = new JLabel(new ImageIcon(top));
		lb_top.setBounds(18,4,360,110);
		panel.add(lb_top);
		
		
		Image hotel1 = new ImageIcon("image/H_list_hotel1.PNG").getImage().getScaledInstance(280, 120, 0);
		Image hotel2 = new ImageIcon("image/H_list_hotel2.PNG").getImage().getScaledInstance(280, 120, 0);
		Image hotel3 = new ImageIcon("image/H_list_hotel3.PNG").getImage().getScaledInstance(280, 120, 0);	
		Image reserveButton = new ImageIcon("image/H_reserveButton.PNG").getImage().getScaledInstance(90, 25, 0);
		
		////////////////////////////////////////////////////////////////// 메인화면으로 리턴
		JButton returnmain = new JButton(new ImageIcon(top));
		returnmain.setBounds(18,4,360,90);
		returnmain.setFocusPainted(false);
		returnmain.setBorderPainted(false); 
		returnmain.setContentAreaFilled(false);
		panel.add(returnmain);
		
		////////////////////////////////////////////////////////////////// 호텔 1
		JLabel lb1 = new JLabel(new ImageIcon(hotel1));
		JLabel alabel = new JLabel("롯데호텔  250,000원~ ");
		lb1.setBounds(40,110,280,120);
		alabel.setBounds(44,188,280,120);
		alabel.setFont(font1);

		JButton but1 = new JButton(new ImageIcon(reserveButton));
		but1.setBounds(227,236,90,25);
		but1.setFocusPainted(false);
		but1.setBorderPainted(false); 
		but1.setContentAreaFilled(false);
		
		panel.add(lb1);
		panel.add(alabel);
		panel.add(but1);
		
		
		////////////////////////////////////////////////////////////////// 호텔 2
		JLabel lb2 = new JLabel(new ImageIcon(hotel2));
		JLabel blabel = new JLabel("신라호텔  280,000원~ ");		
		lb2.setBounds(40,285,280,120);		
		blabel.setBounds(44,363,280,120);
		blabel.setFont(font1);
		
		JButton but2 = new JButton(new ImageIcon(reserveButton));
		but2.setBounds(227,411,90,25);
		but2.setFocusPainted(false);
		but2.setBorderPainted(false); 
		but2.setContentAreaFilled(false);
		
		panel.add(lb2);
		panel.add(blabel);
		panel.add(but2);

		
		////////////////////////////////////////////////////////////////// 호텔 3
		JLabel lb3 = new JLabel(new ImageIcon(hotel3));
		JLabel clabel = new JLabel("힐튼호텔  230,000원~ ");		
		lb3.setBounds(40,460,280,120);		
		clabel.setBounds(44,538,280,120);
		clabel.setFont(font1);
		
		JButton but3 = new JButton(new ImageIcon(reserveButton));
		but3.setBounds(227,586,90,25);
		but3.setFocusPainted(false);
		but3.setBorderPainted(false); 
		but3.setContentAreaFilled(false);
		
		panel.add(lb3);
		panel.add(clabel);
		panel.add(but3);		
		
		
		////////////////////////////////////////////////////////////////// 호텔1 선택
		but1.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				toOp1(mf,id);
			}
		});	
		
		////////////////////////////////////////////////////////////////// 호텔2 선택
		but2.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				toOp2(mf,id);
			}
		});
		
		////////////////////////////////////////////////////////////////// 호텔3 선택
		but3.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				toOp3(mf,id);
			}
		});
		
		////////////////////////////////////////////////////////////////// 메인화면으로 리턴
		returnmain.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {	
				 backtoMenu(mf,id);
			}
		});
		
		layerpanel.add(panel);	
		mf.add(layerpanel);
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		}
		
		public void toOp1(JFrame mf, String id) {	///////////////////// 호텔1 옵션선택화면
			mf.remove(layerpanel);
			new option_hotel1(mf,id);
			mf.revalidate();
			
		}		
		
		public void toOp2(JFrame mf, String id) {	///////////////////// 호텔2 옵션선택화면
			mf.remove(layerpanel);
			new option_hotel2(mf,id);
			mf.revalidate();
			
		}	
		
		public void toOp3(JFrame mf, String id) {	///////////////////// 호텔3 옵션선택화면
			mf.remove(layerpanel);
			new option_hotel3(mf,id);
			mf.revalidate();
			
		}	
		
		public void backtoMenu(JFrame mf, String id) {
			mf.remove(layerpanel);
			mn.menu(mf,id);
			mf.revalidate();
			
		}
	
	

}

package com.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
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

//////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////

public class menu {
	JLayeredPane layerpanel = new JLayeredPane();

	

		public void menu(JFrame mf,String id) {
		
		mf.setTitle("메뉴조회");
		mf.setSize( 366, 669);
		layerpanel.setBounds(0,0,360,640);
		layerpanel.setLayout(null);
		mf.setResizable(false);
		mf.setLocationRelativeTo(null);
	
		
		////////////////////////////////////////////////////////////// 타이틀 옆 아이콘 변경
		try {
			mf.setIconImage(ImageIO.read(new File("image/0_titleIcon.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0,0,360,640);
		panel.setBackground(Color.white);

		Image top = new ImageIcon("image/H_menu_top.PNG").getImage().getScaledInstance(320, 145, 0);
		JLabel lb = new JLabel(new ImageIcon(top));
		panel.add(lb);
		
		
		Image hotellist = new ImageIcon("image/H_menu_hotellist.PNG").getImage().getScaledInstance(132, 148, 0);
		Image search = new ImageIcon("image/H_menu_search.PNG").getImage().getScaledInstance(123, 141, 0);
		Image home = new ImageIcon("image/H_menu_home.PNG").getImage().getScaledInstance(130, 149, 0);
		Image setting = new ImageIcon("image/H_menu_setting.PNG").getImage().getScaledInstance(130, 149, 0);	
				
		JButton but1 = new JButton(new ImageIcon(hotellist));
		JButton but2 = new JButton(new ImageIcon(search));
		JButton but3 = new JButton(new ImageIcon(home));
		JButton but4 = new JButton(new ImageIcon(setting));
		
		but1.setPreferredSize(new Dimension(135, 150)); // 버튼 크기조절
		but2.setPreferredSize(new Dimension(135, 150));
		but3.setPreferredSize(new Dimension(135, 150));
		but4.setPreferredSize(new Dimension(135, 150));
		
		but1.setBorderPainted(false); // 버튼 외곽선 없애기
		but2.setBorderPainted(false); 
		but3.setBorderPainted(false); 
		but4.setBorderPainted(false); 
		
		but1.setFocusPainted(false); // 버튼 선택시 생기는 테두리 사용 안함
		but2.setFocusPainted(false);
		but3.setFocusPainted(false);
		but4.setFocusPainted(false); 
		
		but1.setContentAreaFilled(false); // 버튼 내용영역 채우기 안함
		but2.setContentAreaFilled(false);
		but3.setContentAreaFilled(false);
		but4.setContentAreaFilled(false);
		
		//////////////////////////////////////////////////////////////	호텔선택
		but1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				toHotel(mf,id);
			}
		});
		
		/////////////////////////////////////////////////////////////	예약조회
		but2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toSearchHotel(mf, id);
				
			}
		});
		
		//////////////////////////////////////////////////////////////	로그인화면으로 돌아가기
		but3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				backtolog(mf);
				         
			}
		});
		
		//////////////////////////////////////////////////////////////	회원정보수정
		but4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				toCheckPw(mf,id);
			}
		});	
		
		//////////////////////////////////////////////////////////////	
		
		panel.add(but1);
		panel.add(but2);
		panel.add(but3);
		panel.add(but4);
		
		layerpanel.add(panel);
		mf.add(layerpanel);
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
		public void toHotel(JFrame mf, String id) {
			mf.remove(layerpanel);
			new hotelList(mf,id);
			mf.revalidate();
	
		}
		public void toCheckPw(JFrame mf, String id) {
			mf.remove(layerpanel);
			new checkPw(id);
			mf.dispose();
			
		}
		
		public void toSearchHotel(JFrame mf, String id) {
			mf.revalidate();
			new SearchHotel(id);
		
		}
		
		public void backtolog(JFrame mf) {
			mf.remove(layerpanel);
			new newLogin();
			mf.dispose();
			
		}

}

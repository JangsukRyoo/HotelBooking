package com.GUI;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.controller.UserManager;
import com.GUI.menu;

public class newLogin  {
//	HotelMenu HM = new HotelMenu();
	UserManager UM = new UserManager();
	searchPass SP = new searchPass();
	JFrame mf = new JFrame();
	JLayeredPane layeredPane = new JLayeredPane();
//	Test ts =new Test();
	SignUp SU = new SignUp();
	menu mn = new menu();

	
	BufferedImage img = null;
	JTextField idField;
	JPasswordField pwField;
	JButton logbt;
	JButton signbt;
	JButton forbt;		
	int ct=0;
	private int loginct = 0;


	public newLogin() {
		
		mf.setTitle("Login");
		mf.setBounds(300,200, 366, 669);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setLayout(null);
		mf.setResizable(false);
		mf.setLocationRelativeTo(null);
		
		//타이틀 아이콘 변경
		try {
			mf.setIconImage(ImageIO.read(new File("image/0_titleIcon.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//이미지 받아오기
		try {
			img = ImageIO.read(new File("images/U_Login_Main.png"));
			
		}catch(IOException e) {
			System.out.println("배경 이미지 불러오기 실패");
		}
		
		
		//////////////////////////전체 패널 설정//////////////////////

		layeredPane.setBounds(0,0,360,640);
		layeredPane.setLayout(null);
		 
	

		
		//////////////////바탕화면 패널 이미지 받아오기 ///////////////////
		ImagePanel Ipanel = new ImagePanel();
		Ipanel.setBounds(0,0,360,640);
		
		///////////////////// textfield 및 버튼 설정  ////////////////
		idField = new JTextField(15);
		idField.setBounds(138,323,180,30);
		idField.setOpaque(false);
		idField.setFont(new Font("맑은 고딕",Font.PLAIN,16));
		idField.setForeground(Color.white);
		idField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layeredPane.add(idField);
		
		pwField = new JPasswordField(15);
		pwField.setBounds(138,374,180,30);
		pwField.setOpaque(false);
		pwField.setFont(new Font("맑은 고딕",Font.PLAIN,16));
		pwField.setForeground(Color.white);
		pwField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layeredPane.add(pwField);
		
		logbt = new JButton(new ImageIcon("images/U_Login_Button.png"));
		logbt.setBounds(35,440,290,55);
		logbt.setBorderPainted(false);
		logbt.setFocusPainted(false);
		logbt.setContentAreaFilled(false);
		layeredPane.add(logbt);
		
		signbt = new JButton(new ImageIcon("images/U_SignUp_Button.png"));
		signbt.setBounds(35,495,290,55);
		signbt.setBorderPainted(false);
		signbt.setFocusPainted(false);
		signbt.setContentAreaFilled(false);
		layeredPane.add(signbt);
		
		forbt = new JButton(new ImageIcon("images/U_Forgot_Button.png"));
		forbt.setBounds(42,540,290,55);
		forbt.setBorderPainted(false);
		forbt.setFocusPainted(false);
		forbt.setContentAreaFilled(false);
		layeredPane.add(forbt);
		
		/////다얼로그 추가///////
//		 Dialog warn = new Dialog(mf,"Dialog");
//		 warn.setBounds(250,250,350,150);
//		 JButton check = new JButton("확인");
//			warn.add(check,"South");
			
	/////////////////////////////////////////////////////////	
	//버튼 액션
		
		signbt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(mf);
			}
		});
		
//		check.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				warn.dispose();
//			}});
//		
		
		logbt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			String logid = idField.getText();
			String logPw = new String(pwField.getPassword());
			 boolean result = UM.userLogin(logid, logPw);	
				
			 
			 if(result) {
					toMainMenu(mf,logid);
				    //Mn.menu(mf);
				}else {
					loginct++;
					JOptionPane.showMessageDialog(null,"입력하신 정보가 "+loginct+"회 틀렸습니다. \n 3회이상 틀릴시 종료됩니다.","경고",JOptionPane.INFORMATION_MESSAGE);
					
				}				
				if(loginct==4) {
					System.exit(0);		
			}
		
			}
		});
		
		forbt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SP.searchPass();
			}
		});
		
	///////////////////////////////////////	
		
		layeredPane.add(Ipanel);
		
		mf.add(layeredPane);
		mf.setVisible(true);
	}
	
	class ImagePanel extends JPanel{
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
			
		}
	}

	
	public void changePanel(JFrame mf) {
		mf.remove(layeredPane); //현재패널 지우기
		SU.SignUp(mf); //다음 클래스에 넘겨주기
		mf.revalidate(); //새로고침
		
	}
	
	public void toMainMenu(JFrame mf, String id) {
		mf.remove(layeredPane); //현재패널 지우기
		mn.menu(mf,id); //다음 클래스에 넘겨주기
		mf.revalidate(); //새로고침
	}


	
	

	
}
	







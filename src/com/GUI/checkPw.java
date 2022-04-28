package com.GUI;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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

import com.controller.UserManager;

public class checkPw extends JFrame {
	
	JFrame mf=new JFrame();
	BufferedImage img = null;
	JLayeredPane lp=new JLayeredPane();
//////////////////////////////////////////////
	JButton confirmbt = new JButton();
	JButton backbt = new JButton();
	JPasswordField jf1;
///////////////////////////////////////////////	
	ChangeMenu cm = new ChangeMenu();
	menu mn = new menu();
	UserManager UM = new UserManager();
	
	//////////////////////////////////////////////

	public checkPw(String id)
	{
		try {
			mf.setIconImage(ImageIO.read(new File("image/0_titleIcon.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	mf.setTitle("Infomation");
	mf.setBounds(300,200,366,669);
	mf.setLocationRelativeTo(null);
/////////////////////////백그라운드이미지//////////////////////////////
	try {
		img = ImageIO.read(new File("images/U_Check_Pass.png"));
	}catch(IOException e) {
		System.out.println("이미지 불러오기 실패");
		System.exit(0);
	}
	Image icon=new ImageIcon("images/A_Back.png").getImage().getScaledInstance(23, 39, 0);
	////////////////////////////////////////////////////////
	
	lp.setBounds(0,0, 360, 640);
	lp.setLayout(null);
	mf.setResizable(false);
	
	BackGroundPanel Ipanel = new BackGroundPanel();
	Ipanel.setBounds(0,0,360,640);

	JPanel jp1=new JPanel();
	jp1.setSize(360, 640);
	
	//////////////패스워드필드/////////////////
	
    jf1=new JPasswordField(15);
	jf1.setLocation(125, 329);
	jf1.setSize(200, 30);
	jf1.setOpaque(false);
	jf1.setForeground(Color.WHITE);
	jf1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
	jf1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	
	lp.add(jf1);
	
	//////////////////버튼넣기/////////////////
	
	confirmbt = new JButton(new ImageIcon("images/A_Confirm.png"));
	confirmbt.setBounds(75,370,200,50);
	confirmbt.setBorderPainted(false);
	confirmbt.setFocusPainted(false);
	confirmbt.setContentAreaFilled(false);
	lp.add(confirmbt);
	
	backbt = new JButton(new ImageIcon(icon));
	backbt.setBounds(10,10,23,39);
	backbt.setBorderPainted(false);
	backbt.setFocusPainted(false);
	backbt.setContentAreaFilled(false);
	lp.add(backbt);
	

	
	confirmbt.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String newPw = new String(jf1.getPassword());
			boolean result = UM.checkPw(id, newPw);
			
			
			if(result) {
				toChangeMenu(mf,newPw,id);
			}else { 
				
				JOptionPane.showMessageDialog(null, "입력하신 정보가 틀리셨습니다.\n 다시 입력해주세요", "ERROR",JOptionPane.ERROR_MESSAGE);
			}
		  
		}
	});
	
	backbt.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
            
			BacktoMain(mf,id);
		}
	});
	

////////////////////////////////////////////////////////	
 	lp.add(Ipanel);
	mf.add(lp);


	mf.setLayout(null);
	mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	mf.setVisible(true);
	////////////////////////////////////////////////////////////////
	}
	class BackGroundPanel extends JPanel{
		public void paint(Graphics g) {
			g.drawImage(img,0,0,null);
		}
	}
	///////////////////////////changemenu 받아오기--->버튼액션에 대입/////////////////////////////////////
	public void toChangeMenu(JFrame mf,String newPw, String id) {
		mf.remove(lp);
		cm.ChangeMenu(mf,newPw,id);
		mf.revalidate();
	}
	public void BacktoMain(JFrame mf, String id) {
		mf.remove(lp);
		mn.menu(mf,id);
		mf.revalidate();
	}
	
	
}


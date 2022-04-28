package com.GUI;

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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

	public class ChangeMenu extends JFrame {
		ChangePass cp=new ChangePass();
		ChangeEmail ce=new ChangeEmail();
		ChangeAdd ca=new ChangeAdd();
//	    checkPw cpw=new checkPw();
		//////////////////////////////////////////////////
		BufferedImage img = null;
		JLayeredPane lp=new JLayeredPane();
		///////////////////////////////////////////////////////////////////
		JButton chpassbt = new JButton();
		JButton chemailbt = new JButton();
		JButton chaddbt = new JButton();
		JButton backbt = new JButton();
		/////////////////////////////////////////////////////////////////////
//		public static void main(String[] args) {
//
//		}
		public void ChangeMenu(JFrame mf, String oldPw, String id)
		{
		mf.setBounds(300,200,366,669);
		mf.setResizable(false);
		mf.setLocationRelativeTo(null);
	/////////////////////////백그라운드이미지//////////////////////////////
		try {
			img = ImageIO.read(new File("images/U_Change_Main.png"));
		}catch(IOException e) {
			System.out.println("이미지 불러오기 실패");
			System.exit(0);
		}
		Image icon=new ImageIcon("images/A_back.png").getImage().getScaledInstance(23, 39, 0);
		////////////////////////////////////////////////////////
		
		lp.setBounds(0, 0, 360, 640);
		lp.setLayout(null);
		
		BackGroundPanel Ipanel = new BackGroundPanel();
		Ipanel.setBounds(0,0,360,640);
		
		JPanel jp1=new JPanel();
		jp1.setSize(360, 640);
		
		//////////////////버튼넣기/////////////////
		
		chpassbt = new JButton(new ImageIcon("images/U_Change_PassBt.png"));
		chpassbt.setBounds(145,166,70,70);
		chpassbt.setBorderPainted(false);
		chpassbt.setFocusPainted(false);
		chpassbt.setContentAreaFilled(false);
		lp.add(chpassbt);
		
		chemailbt = new JButton(new ImageIcon("images/U_Change_EmailBt.png"));
		chemailbt.setBounds(145,286,70,70);
		chemailbt.setBorderPainted(false);
		chemailbt.setFocusPainted(false);
		chemailbt.setContentAreaFilled(false);
		lp.add(chemailbt);
		
		chaddbt = new JButton(new ImageIcon("images/U_Change_AddBt.png"));
		chaddbt.setBounds(145,405,70,70);
		chaddbt.setBorderPainted(false);
		chaddbt.setFocusPainted(false);
		chaddbt.setContentAreaFilled(false);
		lp.add(chaddbt);
		
		backbt = new JButton(new ImageIcon(icon));
		backbt.setBounds(10,10,23,39);
		backbt.setBorderPainted(false);
		backbt.setFocusPainted(false);
		backbt.setContentAreaFilled(false);
		lp.add(backbt);
		////////////////////////////////이벤트 발생///////////////////////////////////////////////
		chpassbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 toChangePass(mf,oldPw,id);
			}
		});
		chemailbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 toChangeEmail(mf,oldPw,id);
			}
		});
		chaddbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 toChangeAdd(mf,oldPw,id);
			}
		});
		backbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkPw cpw=new checkPw(id);
				mf.dispose();
			}
		});
	//////////////////////////////////////////////////////////////////////////////
	 	lp.add(Ipanel);
		mf.add(lp);

	    //mf.setResizable(false);
		mf.setLayout(null);
		mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mf.setVisible(true);
	}
		///////////////////////////////////////////////////////////////////////////////
		class BackGroundPanel extends JPanel{
			public void paint(Graphics g) {
				g.drawImage(img,0,0,null);
			}
		}

		///////////////////////////////////////////////////////////////////////////
		public void toChangePass(JFrame mf, String oldPw, String id) {
			mf.remove(lp);
			cp.ChangePass(mf,oldPw,id);
			mf.revalidate();
		}	
		public void toChangeEmail(JFrame mf, String oldPw, String id) {
			mf.remove(lp);
			ce.ChangeEmail(mf,oldPw,id);
			mf.revalidate();
		}	
		public void toChangeAdd(JFrame mf,String oldPw, String id) {
			mf.remove(lp);
			ca.ChangeAdd(mf,oldPw,id);
			mf.revalidate();
		}	

	
	
	}
	



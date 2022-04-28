package com.GUI;

import java.awt.Color;
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
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.GUI.ChangePass.BackGroundPanel;
import com.controller.UserManager;

public class ChangeEmail extends JFrame {
	UserManager UM = new UserManager();
	 menu mn = new menu();
	BufferedImage img = null;
	JLayeredPane lp=new JLayeredPane();
	/////////////////////////////////////////////////////////////////////////////////
	JButton backbt = new JButton();
	JButton yes = new JButton();
	JTextField jf1;
/////////////////////////////////////////////////////////////////////////////////

	public void ChangeEmail(JFrame mf, String oldPw, String id)
	{
	mf.setBounds(300,200,366,669);
	mf.setResizable(false);
	mf.setLocationRelativeTo(null);
/////////////////////////백그라운드이미지//////////////////////////////
	try {
		img = ImageIO.read(new File("images/U_Enter_Email.png"));
	}catch(IOException e) {
		System.out.println("이미지 불러오기 실패");
		System.exit(0);
	}
	Image icon=new ImageIcon("images/A_Back.png").getImage().getScaledInstance(23, 39, 0);
	////////////////////////////////////////////////////////
	
	lp.setBounds(0, 0, 360, 640);
	lp.setLayout(null);
	
	BackGroundPanel Ipanel = new BackGroundPanel();
	Ipanel.setBounds(0,0,360,640);
	

	JPanel jp1=new JPanel();
	jp1.setSize(360, 640);
    ////////////////////////////////////////
	
	//////////////텍스트필드/////////////////
	
	jf1=new JTextField(15);
	jf1.setLocation(110, 330);
	jf1.setSize(200, 30);
	jf1.setOpaque(false);
	jf1.setForeground(Color.white);
	jf1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
	jf1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	lp.add(jf1);
	
	/////////////////버튼////////////////////
	
	backbt = new JButton(new ImageIcon(icon));
	backbt.setBounds(10,10,23,39);
	backbt.setBorderPainted(false);
	backbt.setFocusPainted(false);
	backbt.setContentAreaFilled(false);
	lp.add(backbt);
	
	yes = new JButton(new ImageIcon("images/A_Confirm.png"));
	yes.setBounds(75,380,200,50);
	yes.setBorderPainted(false);
	yes.setFocusPainted(false);
	yes.setContentAreaFilled(false);
	lp.add(yes);
  
	//////////////////////////////////////////////////////////////
	backbt.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			checkPw cpw=new checkPw(id);
			mf.dispose();
		}
	  });

	yes.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String newEmail = jf1.getText();
		UM.setEmail(oldPw, newEmail);
		JOptionPane.showMessageDialog(null,"고객님의 이메일 주소가 \n"+newEmail+"로 변경되었습니다.","확인",JOptionPane.INFORMATION_MESSAGE);
		BacktoMain(mf,id);
	}
});
	
	///////////////////////////////////////////////////////////
 	lp.add(Ipanel);
	mf.add(lp);

    //mf.setResizable(false);
	mf.setLayout(null);
	mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	mf.setVisible(true);
	
}
	class BackGroundPanel extends JPanel{
		public void paint(Graphics g) {
			g.drawImage(img,0,0,null);
		}
	}
	public void BacktoMain(JFrame mf, String id) {
		mf.remove(lp);
		mn.menu(mf,id);
		mf.revalidate();
	}
}


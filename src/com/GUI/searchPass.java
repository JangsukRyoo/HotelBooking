package com.GUI;

import java.awt.Color;
import java.awt.Dialog;
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
import javax.swing.JTextField;

import com.controller.UserManager;

public class searchPass {
	UserManager UM = new UserManager();
	JFrame mf = new JFrame();
	BufferedImage img = null;
	JLayeredPane layerPanel = new JLayeredPane();
	JTextField idField;
	JTextField emailField;
	JButton confirmbt;

	
	public void searchPass() {
		try {
			mf.setIconImage(ImageIO.read(new File("image/0_titleIcon.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		mf.setTitle("SearchPassword");
		mf.setSize(365, 499);
		mf.setLocation(300, 200);
		mf.setResizable(false);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setLayout(null);
		mf.setLocationRelativeTo(null);
		
		/////////// 이미지 가져오기 ////////////////
		try {
			img = ImageIO.read(new File("images/U_Forgot_Pw.png"));
		} catch (IOException e) {
			System.out.println("이미지를 찾을수 없습니다.");
			System.exit(0);
		}

		////////// 패널 작업///////////////////

		layerPanel.setBounds(0, 0, 380, 480);
		layerPanel.setLayout(null);

		dwPanel dpanel = new dwPanel();
		dpanel.setBounds(0, 0, 360, 470);

		//////////// Textfield / button설정//////////////

		idField = new JTextField(15);
		idField.setBounds(115, 250, 180, 25);
		idField.setOpaque(false);
		idField.setFont(new Font("맑은 고딕	", Font.PLAIN, 16));
		idField.setForeground(Color.white);
		idField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layerPanel.add(idField);

		emailField = new JTextField(15);
		emailField.setBounds(115, 295, 180, 25);
		emailField.setOpaque(false);
		emailField.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		emailField.setForeground(Color.white);
		emailField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layerPanel.add(emailField);

		confirmbt = new JButton(new ImageIcon("images/U_Forgot_Confirm.png"));
		confirmbt.setBounds(80, 350, 190, 44);
		confirmbt.setBorderPainted(false);
		confirmbt.setFocusPainted(false);
		confirmbt.setContentAreaFilled(false);
		layerPanel.add(confirmbt);

		Dialog findPw = new Dialog(mf, "Dialog");
		findPw.setBounds(250, 250, 350, 150);
		JButton check = new JButton("Confirm");
		check.setSize(32, 100);
		check.setLocation(300, 200);
		findPw.add(check, "South");

		///////// 버튼 액션 ////////

		confirmbt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String logid = idField.getText();
				String logemail = emailField.getText();

				Boolean tf = UM.searchPw(logid, logemail);

				String result = UM.finalResult();

				if (tf) {

					JOptionPane.showMessageDialog(null,"고객님의 비밀번호는 \n"+result+"입니다.","확인",JOptionPane.INFORMATION_MESSAGE);
				
					idField.setText("");
					emailField.setText("");
					mf.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "입력하신 정보가 틀리셨습니다.\n 다시 입력해주세요", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				idField.setText("");
				emailField.setText("");
				findPw.dispose();
				mf.dispose();

			}
		});

		//////////// 메인 프레임에 추가 //////////////////////

		layerPanel.add(dpanel);
		mf.add(layerPanel);

		mf.setVisible(true);
	}

	class dwPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}


}
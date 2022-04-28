package com.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.model.User;

public class SignUp {
	BufferedImage img = null;

	JLayeredPane layerPanel = new JLayeredPane();
	JTextField idField;
	JPasswordField pwField;
	JTextField nameField;
	JTextField addressField;
	JTextField phoneField;
	JTextField emailField;
	JTextField ageField;
	JButton resetbt;
	JButton signUpbt;
	JButton backbt;
	User user;
	ArrayList <User> getList = new ArrayList<>();
	ArrayList <User> sendList = new ArrayList<>();

	

	
	public  void SignUp(JFrame mf) {
		
		mf.setTitle("SignUP");
		mf.setSize(366,669);
		mf.setLayout(null);
		mf.setResizable(false);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setLocationRelativeTo(null);

		////////////////////사진 넣기///////////////////
		
		try {
			img = ImageIO.read(new File("images/U_Sign_Panel.png"));
		}catch(IOException e) {
			System.out.println("이미지 불러오기 실패");
			System.exit(0);
		}
		Image icon1 = new ImageIcon("images/A_Back_Black.png").getImage().getScaledInstance(23,39,0);
		
		///////////////////패널짜기////////////////////
		
		layerPanel.setBounds(0,0,360,640);
		layerPanel.setLayout(null);
		
		BackGroundPanel Ipanel = new BackGroundPanel();
				Ipanel.setBounds(0,0,360,640);
		
		//////////////textfield / button설정///////////
		
		idField = new JTextField(15);
		idField.setBounds(145,98,180,25);
		idField.setOpaque(false);
		idField.setFont(new Font("맑은 고딕",Font.PLAIN,16));
		idField.setForeground(Color.white);
		idField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layerPanel.add(idField);
		
		pwField = new JPasswordField(15);
		pwField.setBounds(145,145,180,25);
		pwField.setOpaque(false);
		pwField.setFont(new Font("맑은 고딕",Font.PLAIN,16));
		pwField.setForeground(Color.white);
		pwField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layerPanel.add(pwField);
		
		nameField = new JTextField(15);
		nameField.setBounds(145,194,180,25);
		nameField.setOpaque(false);
		nameField.setFont(new Font("맑은 고딕",Font.PLAIN,16));
		nameField.setForeground(Color.white);
		nameField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layerPanel.add(nameField);
		
		addressField = new JTextField(15);
		addressField.setBounds(145,237,180,25);
		addressField.setOpaque(false);
		addressField.setFont(new Font("맑은 고딕",Font.PLAIN,16));
		addressField.setForeground(Color.white);
		addressField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layerPanel.add(addressField);
		
		phoneField = new JTextField(15);
		phoneField.setBounds(145,282,180,25);
		phoneField.setOpaque(false);
		phoneField.setFont(new Font("맑은 고딕",Font.PLAIN,16));
		phoneField.setForeground(Color.white);
		phoneField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layerPanel.add(phoneField);
		
		emailField = new JTextField(15);
		emailField.setBounds(145,321,180,25);
		emailField.setOpaque(false);
		emailField.setFont(new Font("맑은 고딕",Font.PLAIN,16));
		emailField.setForeground(Color.white);
		emailField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layerPanel.add(emailField);
		
		ageField = new JTextField(15);
		ageField.setBounds(145,367,180,25);
		ageField.setOpaque(false);
		ageField.setFont(new Font("맑은 고딕",Font.PLAIN,16));
		ageField.setForeground(Color.white);
		ageField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layerPanel.add(ageField);
		
		resetbt = new JButton(new ImageIcon("images/U_Sign_ResetButton.png"));
		resetbt.setBounds(35,465,290,55);
		resetbt.setBorderPainted(false);
		resetbt.setFocusPainted(false);
		resetbt.setContentAreaFilled(false);
		layerPanel.add(resetbt);
		
		signUpbt = new JButton(new ImageIcon("images/U_SignUp_confirm.png"));
		signUpbt.setBounds(35,520,290,55);
		signUpbt.setBorderPainted(false);
		signUpbt.setFocusPainted(false);
		signUpbt.setContentAreaFilled(false);
		layerPanel.add(signUpbt);
		
		backbt = new JButton(new ImageIcon(icon1));
		backbt.setBounds(10,10,23,39);
		backbt.setBorderPainted(false);
		backbt.setFocusPainted(false);
		backbt.setContentAreaFilled(false);
		layerPanel.add(backbt);
		 
		
		//////////////////버튼엑션///////////////////////////
		
		signUpbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
			
				
				////확인///
				
				File file = new File("User.txt");
				
				String getId = idField.getText();
				String getpw = new String(pwField.getPassword());
				
				String getname = nameField.getText();
				String getadd = addressField.getText();
				String getphoneNum = phoneField.getText();
				String getemail = emailField.getText();
				String text1 = ageField.getText();
				int getage = Integer.parseInt(text1);

				user = new User(getId,getpw,getname,getadd,getphoneNum,getemail,getage);
				
				if(file.exists()) {
					try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("User.txt"));){
							getList = (ArrayList<User>) ois.readObject();							

						getList.add(user);
					
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}

					try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("User.txt"));) {
						objOut.writeObject(getList);
				
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}	
					
				backtolog(mf);
				
				
				//없을때 추가
				}else {
					
				sendList.add(user);
				try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("User.txt"));) {		
						objOut.writeObject(sendList);
						
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}	
				backtolog(mf);
				}
				}			
		
			});
		
		resetbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				idField.setText("");
				pwField.setText("");
				nameField.setText("");
				addressField.setText("");
				phoneField.setText("");
				emailField.setText("");
				ageField.setText("");
			}
		});
		
		backbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				backtolog(mf);
			}
		});
		
		layerPanel.add(Ipanel);
		mf.add(layerPanel);
		mf.setVisible(true);
	}
	
	
	///////////////////////////////////////////////////////////////////
	
	class BackGroundPanel extends JPanel{
		public void paint(Graphics g) {
			g.drawImage(img,0,0,null);
		}
	}
	
	
	public void backtolog(JFrame mf) {
		mf.remove(layerPanel);
		new newLogin();
		mf.dispose();
		
		
	}
	

}

package com.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.model.Hotel_GUI;

public class check {

	Hotel_GUI hotel = new Hotel_GUI();
	menu mn = new menu();
	JLayeredPane layerpanel = new JLayeredPane();
	String hotelName;
	String roomType;
	String roomFee;
	String bfs;
	String bfPrice;
	String str4;
	String ciday;
	String coday;
	String day;
	int indexNum;
	List<Hotel_GUI> getList = new ArrayList<>();

	public  check(JFrame mf, int reserveNum,String id) {
		
		
		mf.setTitle("예약확인");
		mf.setBounds(300, 200, 366, 669);
		mf.setResizable(false);
		mf.setLocationRelativeTo(null);
		
		layerpanel.setBounds(0,0,360,640);
		layerpanel.setLayout(null);
		
		try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("hotelList.txt"))) {

			getList = (ArrayList<Hotel_GUI>) objIn.readObject();

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		for (int i = 0; i < getList.size(); i++) {
			
			if (getList.get(i).getReserveNum() == reserveNum) {
				indexNum = i;
			}
		}
		
		for (Hotel_GUI saveHotel : getList) {
			if (saveHotel.getReserveNum() == reserveNum) {
				hotelName = saveHotel.getHotelName();
				roomType = saveHotel.getRoomType();
				roomFee = String.valueOf(saveHotel.getRoomFee());
				bfs = saveHotel.getBfs();
				bfPrice = String.valueOf(saveHotel.getBfPrice());
				str4 = saveHotel.getStr4();
				ciday = saveHotel.getCiday();
				coday = saveHotel.getCoday();
				day = saveHotel.getDay();
			}
		}
		
		String reNum = String.valueOf(reserveNum);
		

		
		// 상단이미지
		JPanel topPanel = new JPanel();
		Image topImage = new ImageIcon("image/H_check_topImage.PNG").getImage();
		JLabel topImageLabel = new JLabel(new ImageIcon(topImage));
		topPanel.add(topImageLabel);
		topPanel.setSize(360, 40);
		topPanel.setLocation(0, 0);
		topPanel.setBackground(Color.WHITE);

		/////////////////////////////////////////////////////////// 정보
		Font font = new Font("Noto Sans CJK KR", Font.BOLD, 30);
		JLabel hotelNameLabel = new JLabel(hotelName); // 호텔이름
		hotelNameLabel.setFont(font);
		hotelNameLabel.setSize(360, 100);
		hotelNameLabel.setLocation(10, 40);
		hotelNameLabel.setLayout(null);
		hotelNameLabel.setBackground(Color.WHITE);
		Font optionFont = new Font("나눔 고딕", Font.PLAIN, 17);
		Font optionFont2 = new Font("고딕", Font.BOLD, 17);

		JLabel resNum = new JLabel("예약번호: " + reNum); // 예약번호
		resNum.setFont(optionFont2);
		resNum.setSize(360, 20);
		resNum.setLocation(10, 120);
		// 중간이미지
		Image middleImage = new ImageIcon("image/H_check_middleImage.PNG").getImage();
		JLabel middleImageLabel = new JLabel(new ImageIcon(middleImage));
		middleImageLabel.setSize(340, 50);
		middleImageLabel.setLocation(10, 140);
		// 옵션정보
		JLabel room = new JLabel(roomType); // 등급
		room.setSize(200, 30);
		room.setLocation(10, 0);
		room.setFont(optionFont);

		JLabel roomPrice = new JLabel(roomFee); // 방가격
		roomPrice.setSize(100, 30);
		roomPrice.setLocation(250, 0);
		roomPrice.setFont(optionFont);
		
		String a = "조식 "+bfs;
		JLabel bob = new JLabel(a); // 조식포함여부
		bob.setSize(200, 30);
		bob.setLocation(10, 40);
		bob.setFont(optionFont);
		JLabel bobPrice = new JLabel(bfPrice); // 조식가격
		bobPrice.setSize(100, 30);
		bobPrice.setLocation(259, 40);
		bobPrice.setFont(optionFont);
		Font dayFont = new Font("Noto Sans CJK KR", Font.PLAIN, 13);
		JLabel day = new JLabel(ciday + " ~ " + coday); // 날짜
		day.setSize(300, 30);
		day.setLocation(10, 80);
		day.setFont(dayFont);
 
		Font resPriceFont = new Font("Noto Sans CJK KR", Font.BOLD, 18);
		JLabel res = new JLabel("총 가격 : ");
		res.setSize(200, 30);
		res.setLocation(10, 150);
		res.setFont(resPriceFont);
		JLabel resPrice = new JLabel(str4); // 총액
		resPrice.setSize(200, 30);
		resPrice.setLocation(230, 150);
		resPrice.setFont(resPriceFont);

		JPanel optionPanel = new JPanel();
		optionPanel.setLayout(null);
		optionPanel.add(room);
		optionPanel.add(roomPrice);
		optionPanel.add(day);
		optionPanel.add(bob);
		optionPanel.add(bobPrice);
		optionPanel.add(res);
		optionPanel.add(resPrice);
		optionPanel.setSize(340, 200);
		optionPanel.setLocation(10, 200);
		optionPanel.setBackground(Color.WHITE);

		Image check = new ImageIcon("image/H_check_확인.PNG").getImage().getScaledInstance(308, 57, 0);
		JButton checkButton = new JButton(new ImageIcon(check));
		checkButton.setLocation(20, 440);
		checkButton.setSize(308, 57);
		checkButton.setBorderPainted(false);
		checkButton.setContentAreaFilled(false);
		checkButton.setFocusPainted(false);
		checkButton.setBackground(Color.WHITE);
		checkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				backtoMain(mf, id);
			}
		});
		
		
		Image cancel = new ImageIcon("image/H_check_예약취소.PNG").getImage().getScaledInstance(308, 57, 0);
		JButton cancelButton = new JButton(new ImageIcon(cancel));
		cancelButton.setLocation(20, 500);
		cancelButton.setSize(308, 57);
		cancelButton.setBorderPainted(false);
		cancelButton.setContentAreaFilled(false);
		cancelButton.setFocusPainted(false);
		cancelButton.setBackground(Color.WHITE);
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getList.remove(indexNum);
				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("hotelList.txt"));) {

					oos.writeObject(getList);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				backtoMain(mf, id);
				
			}
		});
		JPanel panel = new JPanel();	
		panel.setSize(360, 640);
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		panel.add(topPanel);
		panel.add(hotelNameLabel);
		panel.add(resNum);
		panel.add(middleImageLabel);
		panel.add(optionPanel);
		panel.add(checkButton);
		panel.add(cancelButton);
		
		layerpanel.add(panel);
		mf.add(layerpanel);
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void backtoMain(JFrame mf,String id) {
		mf.remove(layerpanel);
		mn.menu(mf,id);
		mf.revalidate();
		
		
	}
	
	
	
	
}

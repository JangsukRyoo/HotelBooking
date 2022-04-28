package com.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import com.controller.HotelManager_GUI;
import com.model.Hotel_GUI;

public class option_hotel2 {
	JLayeredPane layerpanel = new JLayeredPane();
	static HotelManager_GUI hm = new HotelManager_GUI();
	Hotel_GUI hotel;
	
	
	ArrayList<Hotel_GUI> getList = new ArrayList();
	ArrayList<Hotel_GUI> sendList = new ArrayList();
	
	String mon="";
	String dat="";
	String day="";
	int total=0;
	JComboBox dateList;
	String[] date;
	
	int roomFee;
	int bfPrice;
	String str4;
	
	public option_hotel2(JFrame mf, String id) { 
	
		Font font1 = new Font("맑은 고딕", Font.BOLD, 15);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 12);
		Font font3 = new Font("맑은 고딕", Font.BOLD, 14);

		mf.setTitle("옵션선택");
		mf.setBounds(300, 200, 366, 669);
		mf.setResizable(false);
		mf.setLocationRelativeTo(null);
		
		//////////////////////////////////////////////////////////////////////// 타이틀 옆 아이콘 변경
		try {
			mf.setIconImage(ImageIO.read(new File("image/0_titleIcon.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		////////////////////////////////////////////////////////////////////////

		layerpanel.setBounds(0,0,360,640);
		layerpanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setSize(360, 640);
		panel.setLayout(null);
			
		////////////////////////////////////////////////////////////////////////	뒤로가기 버튼		
		Image returnbutton = new ImageIcon("image/H_back_black.PNG").getImage().getScaledInstance(25, 25, 0);
		JButton back = new JButton(new ImageIcon(returnbutton));
		back.setBounds(15,15,25,25);
		back.setFocusPainted(false);
		back.setBorderPainted(false); 
		back.setContentAreaFilled(false);
		panel.add(back);
		
		////////////////////////////////////////////////////////////////////////	상단 호텔이미지	
		Image hotel1 = new ImageIcon("image/H_option_hotel2.PNG").getImage();
		JLabel hoteloption = new JLabel(new ImageIcon(hotel1));
		hoteloption.setBounds(0,0,360,211);
		panel.add(hoteloption);
	
		////////////////////////////////////////////////////////////////////////	객실타입 선택
		JLabel lb1 = new JLabel("객실타입 선택");
		lb1.setBounds(40,245,150,25);
		lb1.setFont(font1);
		panel.add(lb1);
		
		JPanel roomType = new JPanel();
		roomType.setBounds(155,240,200,25);
		
		JRadioButton standard = new JRadioButton("스탠다드");
		JRadioButton deluxe = new JRadioButton("디럭스");
		standard.setFont(font2);
		deluxe.setFont(font2);
		standard.setFocusPainted(false);
		deluxe.setFocusPainted(false);
		
		ButtonGroup room = new ButtonGroup();
		room.add(standard);
		room.add(deluxe);
		roomType.add(standard);
		roomType.add(deluxe);
		
		panel.add(roomType);

		////////////////////////////////////////////////////////////////////////	체크인 일자 선택
		JLabel lb2 = new JLabel("체크인 날짜");
		lb2.setBounds(40,290,150,25);
		lb2.setFont(font1);
		panel.add(lb2);		

		String[] month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
		JComboBox monthList = new JComboBox(month);
		monthList.setBounds(190,290,60,25);
		monthList.setFont(font2);
		panel.add(monthList);

		String m = (String)monthList.getSelectedItem();
		date = hm.date(m);		
		dateList = new JComboBox(date);
		
		dateList.setBounds(260,290,60,25);
		dateList.setFont(font2);
		panel.add(dateList);
		
		////////////////////////////////////////////////////////////////////////	숙박일수
		JLabel lb3 = new JLabel("숙박일수 선택");
		lb3.setBounds(40,335,150,25);
		lb3.setFont(font1);
		panel.add(lb3);
		
		String[] days = {"선택", "1박","2박","3박","4박","5박","6박","7박"};
		
		JComboBox dayList = new JComboBox(days);
		dayList.setSelectedIndex(0); // 시작값 설정. 미설정시 기본값 0
		dayList.setBounds(190,335,130,25);
		dayList.setFont(font2);
		panel.add(dayList);
		
		JLabel lb4 = new JLabel("(*) 그 외 옵션은 호텔로 문의 바랍니다");
		lb4.setBounds(115,360,250,25);
		lb4.setFont(font2);
		panel.add(lb4);

		////////////////////////////////////////////////////////////////////////	조식
		JLabel lb5 = new JLabel("조식 선택");
		lb5.setBounds(40,395,150,25);
		lb5.setFont(font1);
		panel.add(lb5);	

		JPanel bfChoice = new JPanel();
		bfChoice.setBounds(155,390,200,25);
		
		JRadioButton yes = new JRadioButton("포함");
		JRadioButton no = new JRadioButton("미포함");
		JRadioButton not = new JRadioButton();	// 선택초기화 버튼추가 - 논리적 추가
		yes.setFont(font2);
		no.setFont(font2);
		yes.setFocusPainted(false);
		no.setFocusPainted(false);
		
		ButtonGroup bf = new ButtonGroup();
		bf.add(yes);
		bf.add(no);
		bf.add(not);		// 선택초기화 버튼추가 - 논리적 추가
		bfChoice.add(yes);
		bfChoice.add(no);
		
		panel.add(bfChoice);
	
		////////////////////////////////////////////////////////////////////////
		JTextArea text = new JTextArea(10,30);
		text.setBounds(40,447,80,115);
		text.setFont(font2);
		text.setBackground(Color.white);
		
		panel.add(text);		
		text.setText("\n     객실타입\n     체크인\n     숙박일수\n     체크아웃\n     조식");
			
		////////////////////////////////////////////////////////////////////////	선택옵션별 텍스트 삽입영역		
		JPanel cpanel= new JPanel();
		cpanel.setBounds(120,447,136,118);
		cpanel.setBackground(Color.white);
		cpanel.setLayout(new GridLayout(7,1));
		
		JTextArea bt = new JTextArea();
		JTextArea rt = new JTextArea();
		JTextArea ci = new JTextArea();
		JTextArea sd = new JTextArea();
		JTextArea co = new JTextArea();
		JTextArea bp = new JTextArea();
		JTextArea bb = new JTextArea();
		
		bt.setBackground(Color.white);
		rt.setBackground(Color.white);
		ci.setBackground(Color.white);
		sd.setBackground(Color.white);
		co.setBackground(Color.white);
		bp.setBackground(Color.white);
		bb.setBackground(Color.white);
		
		bt.setFont(font2);
		rt.setFont(font2);
		ci.setFont(font2);
		sd.setFont(font2);
		co.setFont(font2);
		bp.setFont(font2);
		bb.setFont(font2);
				
		cpanel.add(bt);
		cpanel.add(rt);
		cpanel.add(ci);
		cpanel.add(sd);
		cpanel.add(co);
		cpanel.add(bp);
		cpanel.add(bb);
		panel.add(cpanel);
		
		////////////////////////////////////////////////////////////////////////	총 결제금액 텍스트상자
		JTextArea text3 = new JTextArea(10,30);
		text3.setBounds(40,562,216,34);
		text3.setFont(font3);
		text3.setBackground(Color.white);

		panel.add(text3);
		text3.setText("    총 결제금액      ");

		////////////////////////////////////////////////////////////////////////	결제하기 버튼생성
		JPanel bpanel= new JPanel();
		bpanel.setLayout(null);
		bpanel.setBounds(256,447,66,149);
		bpanel.setBackground(Color.white);
		
		Image paybutton = new ImageIcon("image/H_payButton.PNG").getImage().getScaledInstance(60, 25, 0);
		JButton but = new JButton(new ImageIcon(paybutton));
		but.setBounds(0,116,60,25);
		but.setFocusPainted(false);
		but.setBorderPainted(false); 
		but.setContentAreaFilled(false);
		
		bpanel.add(but, "South");
		panel.add(bpanel);	
		
		////////////////////////////////////////////////////////////////////////	객실 선택		
		int standardPrice = 280000;
		
		standard.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {		
				
				monthList.setSelectedIndex(0);
				dateList.setSelectedIndex(0);
				dayList.setSelectedIndex(0);
				not.setSelected(true);
				
				ci.setText("");
				sd.setText("");
				co.setText("");
				bp.setText("");
				text3.setText("");

				rt.setText("       스탠다드");
				
				String str1 = String.format("%,d",standardPrice);
				text3.setText("    총 결제금액     "+str1+"원");
				total = standardPrice;
				roomFee = standardPrice;
			}
		});
		
		deluxe.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				monthList.setSelectedIndex(0);
				dateList.setSelectedIndex(0);
				dayList.setSelectedIndex(0);
				not.setSelected(true); //선택 - 이로써 다른 버튼 선택해제
				
				ci.setText("");
				sd.setText("");
				co.setText("");
				bp.setText("");
				text3.setText("");
				
				rt.setText("       디럭스");
				
				int deluxePrice = (int)(standardPrice*1.2);	
				String str2 = String.format("%,d",deluxePrice);
				text3.setText("    총 결제금액     "+ str2 +"원");
				total = deluxePrice;
				roomFee = deluxePrice;
			}
		});
		
		////////////////////////////////////////////////////////////////////////	체크인/숙박일수/체크아웃	
		monthList.addActionListener(new ActionListener() {	/////////////////////	월 선택		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				not.setSelected(true);
						
				if (standard.isSelected()) {
					String str1 = String.format("%,d",standardPrice);
					text3.setText("    총 결제금액      "+str1+"원");
					total = standardPrice;
				} else if (deluxe.isSelected()) {
					int deluxePrice = (int)(standardPrice*1.2);	
					String str2 = String.format("%,d",deluxePrice);
					text3.setText("    총 결제금액     "+ str2 +"원");
					total = deluxePrice;
				}
						
				ci.setText("");
				sd.setText("");
				co.setText("");
				bp.setText("");
				
				JComboBox cb = (JComboBox)e.getSource();
				mon = (String) cb.getSelectedItem();			
				ci.setText("       2020년  "+mon+"월  ");
				
				dateList.removeAllItems();
				date = hm.date(mon);
				
				for(int i=0; i<date.length; i++) {
					dateList.addItem(date[i]);
				}
		
			}
		});
		
		dateList.addActionListener(new ActionListener() {	/////////////////	일 선택		
			@Override
			public void actionPerformed(ActionEvent e) {

				not.setSelected(true);
				
				if (standard.isSelected()) {
					String str1 = String.format("%,d",standardPrice);
					text3.setText("    총 결제금액      "+str1+"원");
					total = standardPrice;
				} else if (deluxe.isSelected()) {
					int deluxePrice = (int)(standardPrice*1.2);	
					String str2 = String.format("%,d",deluxePrice);
					text3.setText("    총 결제금액     "+ str2 +"원");
					total = deluxePrice;
				}
				
				ci.setText("");
				sd.setText("");
				co.setText("");
				bp.setText("");
				
				JComboBox cb = (JComboBox)e.getSource();
				dat = (String)cb.getSelectedItem();
				
				ci.setText("       2020년  "+mon+"월  "+dat+"일");
			}
		});	
		
		dayList.addActionListener(new ActionListener() {	///////////////		숙박일수 선택	
			@Override
			public void actionPerformed(ActionEvent e) {				
				not.setSelected(true);
				
				sd.setText("");
				co.setText("");
				bp.setText("");
				text3.setText("");
				
				JComboBox cb = (JComboBox)e.getSource();
				day = (String)cb.getSelectedItem();
				sd.setText("       "+day);
	
				String cod = hm.checkOut(mon, dat, day);						
				co.setText(cod);
				
				int pday = day.charAt(0)-48;
				int roomPrice = hm.hotelPrice(total, pday);
				
				if (day.equals("선택")) {
					sd.setText("       미선택");
					roomPrice = 0;
				} else {
					roomPrice = hm.hotelPrice(total, pday);
				}
							
				text3.setText("");
				String str3 = String.format("%,d",roomPrice);
				text3.setText("    총 결제금액     "+ str3 +"원");
			}
		});	
				////////////////////////////////////////////////////////////////////////	조식포함여부			
		yes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bp.setText("       포함");
				
				bfPrice = 30000;
				int pday = day.charAt(0)-48;
				int roomPrice = hm.hotelPrice(total, pday);
				int sumPrice = roomPrice+(pday*bfPrice);
							
				text3.setText("");
				str4 = String.format("%,d",sumPrice);
				text3.setText("    총 결제금액     "+ str4 +"원");	
			}
		});
				
		no.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				bp.setText("       미포함");
				
				bfPrice = 0;
				int pday = day.charAt(0)-48;
				int sumPrice = hm.hotelPrice(total, pday);
							
				text3.setText("");
				str4 = String.format("%,d",sumPrice);
				text3.setText("    총 결제금액     "+ str4 +"원");		
			}
		});

		//////////////////////////////////////////////////////////////////////// 결제하기 버튼
		//////////////////////////////////////////////////////////////////////// 전체 예약정보 출력
		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int reserveNum = (int)(Math.random()*999999)+1;
				
				//호텔이름
				String hotelName = "신라호텔";

				//방타입
				String roomSelect = rt.getText();
				String roomType = roomSelect.substring(7);

				//체크인
				String checkin = ci.getText();
				String ciday = checkin.substring(7);
				
				//체크아웃
				String checkout = co.getText();
				String coday = checkout.substring(7);
				 
				//조식포함여부
				String bfSelect = bp.getText();
				String bfs = bfSelect.substring(7);
				
				
				hotel = new Hotel_GUI(id, hotelName, roomType, roomFee, ciday,
									day, coday, bfs, bfPrice, str4, reserveNum);
				
		
				File file = new File("hotelList.txt");
				
				if (file.exists()) {
					try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("hotelList.txt"))) {
						
						getList = (ArrayList<Hotel_GUI>)objIn.readObject();
						getList.add(hotel);
						
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
			
					try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("hotelList.txt"))) {
						
						objOut.writeObject(getList);	
						
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				} else {
					
					sendList.add(hotel);
					
					try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("hotelList.txt"))) {
						
						objOut.writeObject(sendList);
						
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					///////////////////////// 결제확인 메소드로 넘기기 /////////////////////////
					///////////////////////// 결제확인 메소드로 넘기기 /////////////////////////
					///////////////////////// 결제확인 메소드로 넘기기 /////////////////////////
					//option_hotel4 check = new opiont_hotel4();
					//check.checkpayment(reserveNum);
					
					
				}
				
				toCheck(mf, reserveNum,id);
					
			}
		});
		
		////////////////////////////////////////////////////////////////////////	뒤로가기		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				backtoHotelList(mf,id);
			}
		});

		layerpanel.add(panel);
		mf.add(layerpanel);
		
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void backtoHotelList(JFrame mf, String id) {
		mf.remove(layerpanel); //현재패널 지우기
		new hotelList(mf,id); //다음 클래스에 넘겨주기
		mf.revalidate(); //새로고침
		
	}

	public void toCheck(JFrame mf, int reserveNum,String id) {
		mf.remove(layerpanel);
		new check(mf,reserveNum,id);
		mf.revalidate();
	}
	
	
	
}

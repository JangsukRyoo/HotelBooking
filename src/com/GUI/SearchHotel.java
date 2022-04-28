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
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.model.Hotel_GUI;

public class SearchHotel {

   Hotel_GUI hotel = new Hotel_GUI();
   Refresh rf = new Refresh();
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
   int reserveNum;
   Hotel_GUI saveObject;
   JLayeredPane pan = new JLayeredPane();
   JPanel mainPanel = new JPanel();
   JPanel listGrid = new JPanel();
   List<Hotel_GUI> getList = new ArrayList<>();
   List<Hotel_GUI> searchList = new ArrayList<>();

   public SearchHotel(String id) {

      // 텍스트 불러오기
      try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("hotelList.txt"))) {

         getList = (ArrayList<Hotel_GUI>) objIn.readObject();

      } catch (FileNotFoundException e1) {
         e1.printStackTrace();
      } catch (IOException e1) {
         e1.printStackTrace();
      } catch (ClassNotFoundException e1) {
         e1.printStackTrace();
      }
      for (Hotel_GUI saveHotel : getList) {
         if (saveHotel.getId().equals(id)) {
            searchList.add(saveHotel);
            saveObject = saveHotel;
         }
      }
      
      // 메인패널
      JFrame mf = new JFrame();
      mf.setTitle("예약 조회");
      mf.setLayout(null);
      mf.setBounds(300, 200, 366, 669);
      mf.setResizable(false);
      mf.setLocationRelativeTo(null);
      
		//////////////////////////////////////////////////////////////////////// 타이틀 옆 아이콘 변경
		try {
			mf.setIconImage(ImageIO.read(new File("image/0_titleIcon.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
      
      // 상단이미지패널
      JPanel searchPanel = new JPanel();
      searchPanel.setSize(360, 80);
      Image topImage = new ImageIcon("image/H_search_topImage.PNG").getImage();
      JLabel searchImage = new JLabel(new ImageIcon(topImage));
      searchPanel.add(searchImage);
      

      //////////////////////////////////////////// A호텔
      
      // 예약리스트 이미지

      for (int i = 0; i < searchList.size(); i++) {

         Image hotelImage = null;
         JPanel listImagePanel = new JPanel();
         switch (searchList.get(i).getHotelName()) {
         case "롯데호텔":
            hotelImage = new ImageIcon("image/H_search_hotel1.PNG").getImage();
            break;
         case "신라호텔":
            hotelImage = new ImageIcon("image/H_search_hotel2.PNG").getImage();
            break;
         case "힐튼호텔":
            hotelImage = new ImageIcon("image/H_search_hotel3.PNG").getImage();
            break;
         }
         
         JLabel hotelImageLabel = new JLabel(new ImageIcon(hotelImage));
         listImagePanel.setBackground(Color.WHITE);
         listImagePanel.add(hotelImageLabel);
         listImagePanel.setLocation(0, 0);
         listImagePanel.setSize(150, 150);
         // 예약리스트 텍스트
         JPanel listTextPanel = new JPanel();
         Font font = new Font("a", Font.PLAIN, 13);
         JLabel option1 = new JLabel(" 예약호텔: \t" + searchList.get(i).getHotelName());
         JLabel option2 = new JLabel(" 객실타입: \t" + searchList.get(i).getRoomType());
         JLabel option3 = new JLabel(" 날짜: \t" + searchList.get(i).getCiday() + "~");
         JLabel option4 = new JLabel("             " + searchList.get(i).getCoday());
         JLabel option5 = new JLabel(" 조식: \t" + searchList.get(i).getBfs());
         JLabel option6 = new JLabel(" 총액: \t" + searchList.get(i).getStr4());
         option1.setFont(font);
         option2.setFont(font);
         option3.setFont(font);
         option4.setFont(font);
         option5.setFont(font);
         option6.setFont(font);
         listTextPanel.setBackground(Color.WHITE);
         listTextPanel.setLayout(new GridLayout(8, 1));
         listTextPanel.add(option1);
         listTextPanel.add(option2);
         listTextPanel.add(option3);
         listTextPanel.add(option4);
         listTextPanel.add(option5);
         listTextPanel.add(option6);

         listTextPanel.setSize(180, 150);
         listTextPanel.setLocation(150, 0);
         // 예약취소 버튼
         Image cancel = new ImageIcon("Image/H_search_Cancel.PNG").getImage();
         JButton button = new JButton(new ImageIcon(cancel));
         button.setLocation(220, 120);
         button.setSize(90, 25);
         button.setBackground(Color.WHITE);
         button.setBorderPainted(false);
//         button.setContentAreaFilled(false);
//         button.setFocusPainted(false);

         JPanel listPanel = new JPanel();
         listPanel.add(listImagePanel);
         listPanel.add(listTextPanel);
         listPanel.add(button);
         listPanel.setLayout(null);
         listPanel.setLocation(0, 80);
         listPanel.setSize(320, 150);
         listPanel.setBackground(Color.WHITE);
         button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               reserveNum = saveObject.getReserveNum();
               int index = 0;
               int index2 = 0;
               for (int i = 0; i < getList.size(); i++) {
                  if (getList.get(i).getReserveNum() == reserveNum) {
                     index = i;
                  }
               }
               for (int i = 0; i < searchList.size(); i++) {
                  if (searchList.get(i).getReserveNum() == reserveNum) {
                     index2 = i;
                  }
               }
               getList.remove(index);
               searchList.remove(index2);
               try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("hotelList.txt"));) {

                  oos.writeObject(getList);
               } catch (FileNotFoundException e1) {
                  e1.printStackTrace();
               } catch (IOException e1) {
                  e1.printStackTrace();
               }
               mf.remove(listPanel);
               refresh(id);
               mf.dispose();
            }
         });

         listGrid.setLayout(new GridLayout(3, 1));
         listGrid.add(listPanel);
         listGrid.setSize(320, 450);
         listGrid.setLocation(22, 80);
         pan.setBounds(0, 0, 340, 640);
      }
      
      // 확인
      Image check = new ImageIcon("image/H_check_확인.PNG").getImage();
      JButton checkButton = new JButton(new ImageIcon(check));
      checkButton.setLocation(22, 540);
      checkButton.setSize(308, 57);
      checkButton.setBorderPainted(false);
      checkButton.setContentAreaFilled(false);
      checkButton.setFocusPainted(false);
      checkButton.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {

            mf.dispose();
         }
      });
      
      mf.add(checkButton);
      mf.add(searchPanel);
      mf.add(listGrid);
      mf.setVisible(true);
      mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }
   
   public void refresh(String id) {
	   rf.refreshHotel(id);
	   
   }
   
   

}

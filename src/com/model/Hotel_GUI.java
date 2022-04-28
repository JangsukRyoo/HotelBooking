package com.model;

import java.io.Serializable;

public class Hotel_GUI implements Serializable {


	private static final long serialVersionUID = 1L;
	String id;			//회원ID
	String hotelName;	//호텔이름(롯데호텔/힐튼호텔/신라호텔)
	String roomType;	//방 타입(스탠다드/디럭스)
	int roomFee;		//방 금액
	String ciday;		//체크인
	String day;			//숙박일수
	String coday; 		//체크아웃
	String bfs;			//조식 포함여부(포함/미포함)
	int bfPrice;		//조식 금액
	String str4;		//총 금액
	int reserveNum;		//예약번호
	
	public Hotel_GUI() {}
	
	public Hotel_GUI(String id, String hotelName, String roomType, int roomFee, String ciday,
			String day, String coday, String bfs, int bfPrice, String str4, int reserveNum) {
		
		this.id = id;
		this.hotelName = hotelName;
		this.roomType = roomType;
		this.roomFee = roomFee;
		this.ciday = ciday;
		this.day = day;
		this.coday = coday;
		this.bfs = bfs;
		this.bfPrice = bfPrice;
		this.str4 = str4;
		this.reserveNum = reserveNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomFee() {
		return roomFee;
	}

	public void setRoomFee(int roomFee) {
		this.roomFee = roomFee;
	}

	public String getCiday() {
		return ciday;
	}

	public void setCiday(String ciday) {
		this.ciday = ciday;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getCoday() {
		return coday;
	}

	public void setCoday(String coday) {
		this.coday = coday;
	}

	public String getBfs() {
		return bfs;
	}

	public void setBfs(String bfs) {
		this.bfs = bfs;
	}

	public int getBfPrice() {
		return bfPrice;
	}

	public void setBfPrice(int bfPrice) {
		this.bfPrice = bfPrice;
	}

	public String getStr4() {
		return str4;
	}

	public void setStr4(String str4) {
		this.str4 = str4;
	}

	public int getReserveNum() {
		return reserveNum;
	}

	public void setReserveNum(int reserveNum) {
		this.reserveNum = reserveNum;
	}

	
	@Override
	public String toString() {
		return "id=" + id + ", hotelName=" + hotelName + ", roomType=" + roomType + ", roomFee=" + roomFee
				+ ", ciday=" + ciday + ", day=" + day + ", coday=" + coday + ", bfs=" + bfs + ", bfPrice=" + bfPrice
				+ ", str4=" + str4 + ", reserveNum=" + reserveNum;
	}

	
}
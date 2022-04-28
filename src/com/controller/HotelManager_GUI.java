package com.controller;

import java.util.ArrayList;
import java.util.List;


public class HotelManager_GUI {
	
	int nextday;

	public String[] date(String m) {

		int mon = Integer.parseInt(m);
		String[] str = new String[31];
		
		int d = 1;

		/////////////////////////// 1~7월 ///////////////////////////
		
		if (mon <= 7) {
			if (mon % 2 == 0) {			// 짝수달
				if (mon == 2) {			// 2월(29)
					for (int i = 0; i < str.length-2; i++) {
						str[i] = Integer.valueOf(d + i).toString();
					}
					
				} else {				// 그 외 짝수달(30)
					for (int i = 0; i < str.length-1; i++) {
						str[i] = Integer.valueOf(d + i).toString();
					}
				}
	
			} else if (mon % 2 == 1) {		// 홀수달(31)
				for (int i = 0; i < str.length; i++) {
					str[i] = Integer.valueOf(d + i).toString();
				}
			}
			
		/////////////////////////// 8~12월 ///////////////////////////
			
		} else if (mon >= 8) {
			if (mon % 2 == 0) {				// 짝수달(31)
				for (int i = 0; i < str.length; i++) {
						str[i] = Integer.valueOf(d + i).toString();
					}
				
			} else if (mon % 2 == 1) {		// 홀수달(30)
				for (int i = 0; i < str.length-1; i++) {
					str[i] = Integer.valueOf(d + i).toString();
				}
			}
		}

		return str;
	}

	
	public String checkOut(String month, String date, String day) {

		int mon = Integer.parseInt(month);
		int datei = Integer.parseInt(date);
		int dayi = day.charAt(0);	
		int nextmon = mon;
		int year = 2020;

		int checkoutday = (datei + dayi) - 48;
	
		while(true) {

		/////////////////////////// 1~7월 ///////////////////////////
			if (day.equals("선택")){
				return " ";
			} else if (mon <= 7) {
				if (mon % 2 == 0) {					// 짝수달
					if (mon == 2) {					// 2월(29)
						if (checkoutday>29) {
							nextday = checkoutday-29;
							nextmon += 1;
							break;				
						} else {
							nextday = checkoutday;
							break;
						}
					} else {						// 그 외 짝수달(30)
						if (checkoutday>30) {
							nextday = checkoutday-30;
							nextmon += 1;
							break;
						} else {
							nextday = checkoutday;
							break;
						}
					}
				} else if (mon % 2 == 1) {			// 홀수달(31)
					if (checkoutday>31) {
						nextday = checkoutday-31;
						nextmon += 1;
						break;
					} else {
						nextday = checkoutday;
						break;
					}		
				}
				
			/////////////////////////// 8~12월 ///////////////////////////
							
			} else if (mon >= 8) {
				
				if (mon % 2 == 0) {					// 짝수달(31)
					if (mon == 12) {				// 12월(31)
						if (checkoutday > 31) {
							nextday = checkoutday-31;
							year = year+1;
							nextmon = 1;
							break;
						} else {
							nextday = checkoutday;
							break;
						}
							
					} else {						// 그 외 짝수달(31)
						if (checkoutday>31) {
							nextday = checkoutday-31;
							nextmon += 1;
							break;
						} else {
							nextday = checkoutday;
							break;
						}
					}	
				} else if (mon % 2 == 1) {		// 홀수달(30)
					if (checkoutday>30) {
						nextday = checkoutday-30;
						nextmon += 1;
						break;
					} else {
						nextday = checkoutday;
						break;
					}
				}
			}
		
		}

		return "       " + year + "년  "+ nextmon + "월  " + nextday + "일";
		
		
//		int datei = Integer.parseInt(date);
//		int dayi = day.charAt(0);		
//
//		int checkoutday = (datei + dayi) - 48;
//		String cod = Integer.valueOf(checkoutday).toString();
//
//		return "       2020년  " + month + "월  " + cod + "일";

	}

	
	public int hotelPrice(int price, int pday) {
		int roomPrice = 0;
		roomPrice += price*pday;
		return roomPrice;
	}

}

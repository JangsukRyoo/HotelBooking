package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.model.User;

public class UserManager {
	Scanner sc = new Scanner(System.in);
	private int memberCount;
	String result = " ";
	ArrayList <User> userList = new ArrayList<>();
	ArrayList <User> saveList = new ArrayList<>(); 
	String addpanel[] = new String[3]; 
	int getindex;

	//아이디 생성
	//public void userInput() {
		public void userInput(User user) {
			
		

		}
		////////////      비밀번호 찾기          //////////////
		
	public Boolean searchPw(String id, String email) {
		///일단 담기 //
		try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("User.txt"));) {	
			
			userList =  (ArrayList<User>) objIn.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		///
		
		boolean tf = false;
		
		for(Object saveUser:userList) {
			if(((User) saveUser).getId().equals(id)) {
				if(((User) saveUser).getEmail().contentEquals(email)){
					result = ((User) saveUser).getPassword();
					
					tf = true; break;
				}else {
					tf = false;
				}
			}else {
				tf = false;
			}
		}
		return tf;
	}

		///////////////    정보 수정           ///////////////////
	
	//비밀번호 변경 
	
	public String setPassword(String oldPassword, String newPassword) {
			//////////////TXT에서   정보 꺼내기           ////////////////
		try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("User.txt"));) {	
			userList =  (ArrayList<User>) objIn.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//////// 인덱스번호 찾아주기   ///////
			for(int i = 0; i<userList.size();i++) {
				if(userList.get(i).getPassword().equals(oldPassword)) {
					getindex = i;
					break;
				}
			}
		//비번 변경 계산
		for(Object saveUser:userList) {
			if(((User) saveUser).getPassword().equals(oldPassword)) {
				((User) saveUser).setPassword(newPassword);
				result = ((User) saveUser).getPassword();
				
				/// 바뀐 비번  교체 ///
				userList.set(getindex,(User) saveUser);
				System.out.println("변경된 유저 정보:"+saveUser);
				///리스트에 넣어주기//
				try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("User.txt"));){
					objOut.writeObject(userList);
	
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}	
					break;
					}
			
			}	
		return result;
		} 

	
	
	
	
	//이메일 변경
	public String setEmail(String oldPassword, String newEmail) {

		 //////////////     TXT에서   정보 꺼내기           ////////////////
		try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("User.txt"));) {	
			
			userList =  (ArrayList<User>) objIn.readObject();
			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		//////// 인덱스번호 찾아주기   ///////
		for(int i = 0; i<userList.size();i++) {
			if(userList.get(i).getPassword().equals(oldPassword)) {
				getindex = i;
				break;
			}
		}
		
		/////   이메일 변경 계산    //////
		for(Object saveUser:userList) {
			if(((User) saveUser).getPassword().equals(oldPassword)) {
				((User) saveUser).setEmail(newEmail);
				result = ((User) saveUser).getEmail();
				/// 바뀐 이메일 교체 ///
				userList.set(getindex,(User) saveUser);
				System.out.println("변경된 유저 정보:"+saveUser);
				///리스트에 넣어주기//
				try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("User.txt"));){
					objOut.writeObject(userList);
	
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}	
					break;
					}
			}	
		return result;
		} 

	
	
	

	///////////////////주소변경 메소드 /////////////
	@SuppressWarnings("unchecked")
	public String setAdd(String oldPassword,String newAdd) {
		
		 //////////////     TXT에서   정보 꺼내기           ////////////////
		try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("User.txt"));) {	
			userList =  (ArrayList<User>) objIn.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
		//////// 인덱스번호 찾아주기   ///////
		for(int i = 0; i<userList.size();i++) {
			if(userList.get(i).getPassword().equals(oldPassword)) {
				getindex = i;
				break;
			}
		}
		

		////////      주소변경  계산                  //////
		for(Object saveUser:userList) {
			if(((User) saveUser).getPassword().equals(oldPassword)) {
				((User) saveUser).setAddress(newAdd);
				result = ((User) saveUser).getAddress();
				
				//// 리스에인덱스 번호를 Address를 바꾼 saveUser로 변경 ///////
				userList.set(getindex,(User) saveUser);
				System.out.println("변경된 유저 정보:"+saveUser);
				
				///////       바뀐 객체값 넣어주기            //////		
				try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("User.txt"));){
					objOut.writeObject(userList);
	
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
					 break;
			}
		}
		
		return result;
	}
		

	///비번 체크 
	
	@SuppressWarnings("unchecked")
	public boolean checkPw(String id,String Password) {
		
		try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("User.txt"));) {	
			userList =  (ArrayList<User>) objIn.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		boolean tf = false;
		
		for(Object saveUser:userList) {
			if(((User) saveUser).getId().equals(id)) {
				if(((User) saveUser).getPassword().equals(Password)) {
					System.out.println("현재 정보 입력된 정보:"+saveUser);
						tf = true; break;
				}else {
					tf = false; 
				}
			}else {
				tf = false; 
			}
		}
		return tf;
	}

	
	/////////////       로그인        ////////////////
	
	public boolean userLogin(String id,String password)  {
		File file = new File("User.txt");
		boolean tf = false;
		
		if(file.exists()) {
			
		///userList에 일단 담기 ///
		try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("User.txt"));) {	
			userList =  (ArrayList<User>) objIn.readObject();
			
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		////정보확인////
		for(Object saveUser:userList) {
			if(((User) saveUser).getId().equals(id)) {
				
				if(((User) saveUser).getPassword().equals(password)){
					
					tf = true; break;
				}else {
					tf = false;
				}
			}else {
				tf = false; 
			}
		}
		}else {
			tf = false;
		}
		return tf;	
	}
	

	///////////////   변경 값들  가져오기         //////////////////////	
		
	public String finalResult() {
		return result;
	}

}

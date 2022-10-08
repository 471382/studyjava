package com.human.accountSystem;

public class class_student {

	// 학생 정보를 담는 클래스
	// 클래스를 토대로 학생정보 객체를 만드는 인스턴스를 대량으로 만듬
	// 학생마다 저장해야 할 정보를 변수로 만들어야함 = 필드
	private String id;
	private String pw;
	private String name;

	class_student() {

	}

	class_student(String name, String id, String pw) {
		this.name = name;
		this.id = id;
		this.pw = pw;
	}

	public boolean checkID(String inputID) {
		if (id.equals(inputID)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkPW(String inputPW) {
		if (pw.equals(inputPW)) {
			return true;
		} else {
			return false;
		}
	}

	public void changePW(String inputPW) {
		pw = inputPW;
	}

//	public void changePW(String inputID, String inputPW) {
//		
//		if(inputID.equals(id)) {
//			pw = inputPW;
//		}
//		
//	}

	public void outputInfo() {
		System.out.println("Name : " + name);
		System.out.println("ID : " + id);
		System.out.println("PW : " + pw);
	}

}

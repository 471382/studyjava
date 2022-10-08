package com.human.accountSystem;

import java.util.ArrayList;

public class class_studentList {

	// static 을 사용하면 인스턴스를 여러개 만들어도
	// 변수는 하나의 주소를 가지므로 어떻게 값이 변하든 공유하게됨
	static ArrayList<class_student> studentList;

	class_studentList() {
		studentList = new ArrayList<>();
	}

	public void addStudent(class_student student) {
		studentList.add(student);
	}

	public void viewStudentList() {
		for (class_student item : studentList) {
			item.outputInfo();
		}
	}

	// id를 찾아서 pw를 바꾸는 메소드
	public void changePW(String id, String pw) {
		for (class_student item : studentList) {
			if (item.checkID(id)) {
				item.changePW(pw);
			}
		}
	}

	public boolean checkID(String id) {
		for (class_student item : studentList) {
			if (item.checkID(id)) {
				System.out.println("중복된 ID입니다. 다시 입력해주세요");
				return false;
			}
		}
		return true;
	}

	public boolean logIn(String id, String pw) {
		for (class_student item : studentList) {
			if (item.checkID(id) && item.checkPW(pw)) {
				System.out.println(id + "님 환영합니다.");
				return true;
			} else {
				System.out.println("로그인 정보가 다릅니다.");
				return false;
			}
		}
		return false;
	}

}

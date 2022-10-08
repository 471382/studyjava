package com.human.accountSystem;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// 회원가입 시스템
		// 1)학생 정보를 입력받는 시스템 (student클래스, studentList클래스의 포함관계)
		// 회원정보들을 관리하는 객체와 회원의 정보를 담는 인스턴스의 조합
		// studentList
		// - 인스턴스를 만들어서 회원정보관리 객체를 여러개 만들 필요가 있는가 (그룹별)
		// - 만일, 여러개 만들 필요가 없다면 어떻게 처리를 하는가(static, 싱글톤)
		// *static 런타임 시점에서 이미 할당(heap)되어있는 객체
		// ***********************싱글톤 : 런타임 이후에 코드가 실행되면서 단 하나의 인스턴스를 만드는 것********************
		// student
		// - 회원 한명당 인스턴스 하나씩 만들어서
		// - 회원정보를 관리하는 객체에 저장하는 시스템을 어떤방식으로 구현?
		// (배열<고정,가변>로 관리할지 혹은 객체를 또 만들어서 관리할지)
		// 2)비밀번호를 바꾸는 시스템 (student클래스 안의 필드값 id,pw,name 생성)
		// 메소드를 통해 name과 id출력
		// 메소드를 통해 pw변경
		// 3)학생 모든 정보를 출력하는 메소드를 studentlist에 작성하고 출력
		boolean logState = false;
		String inputID;
		String inputPW;
		String inputName;
		class_student student = new class_student();
		class_studentList list = new class_studentList();
		for (;;) {
			outputMenu();
			System.out.print("원하시는 메뉴를 입력하세요 : ");
			int choiceMenu = sc.nextInt();
			sc.nextLine();
			if (choiceMenu == 1) {
				System.out.println("--------------------------------------");
				System.out.println("회원 가입 메뉴입니다.");
				System.out.println("--------------------------------------");
				System.out.print("이름을 입력하세요 : ");
				inputName = sc.nextLine();
				for (;;) {
					System.out.print("사용하실 ID를 입력하세요 : ");
					inputID = sc.nextLine();
					if (list.checkID(inputID)) {
						break;
					}
				}
				System.out.print("사용하실 PW를 입력하세요 : ");
				inputPW = sc.nextLine();
				student = new class_student(inputName, inputID, inputPW);
				student.outputInfo();
				list.addStudent(student);
			}else if (choiceMenu == 2) {
				System.out.println("--------------------------------------");
				System.out.println("회원 목록 출력 메뉴입니다.");
				System.out.println("--------------------------------------");
				list.viewStudentList();
			}else if (choiceMenu == 3) {
				System.out.println("--------------------------------------");
				System.out.println("로그인 메뉴입니다.");
				System.out.println("--------------------------------------");
				System.out.print("ID를 입력하세요 : ");
				inputID = sc.nextLine();
				System.out.print("PW를 입력하세요 : ");
				inputPW = sc.nextLine();
				logState = list.logIn(inputID, inputPW);
			}else if (choiceMenu == 4) {
				System.out.println("--------------------------------------");
				System.out.println("비밀번호 변경 메뉴입니다.");
				System.out.println("--------------------------------------");
				System.out.print("ID를 입력하세요 : ");
				inputID = sc.nextLine();
				System.out.print("PW를 입력하세요 : ");
				inputPW = sc.nextLine();
				logState = list.logIn(inputID, inputPW);
				if(logState) {
					System.out.print("변경하실 PW를 입력하세요 : ");
					inputPW = sc.nextLine();
					list.changePW(inputID, inputPW);
				}
			}else if (choiceMenu == 0) {
				System.out.println("--------------------------------------");
				System.out.println("프로그램을 종료합니다.");
				System.out.println("--------------------------------------");
				break;
			}

		}

	}

	private static void outputMenu() {
		System.out.println("--------------------------------------");
		System.out.println(" 회원가입 시스템");
		System.out.println("-----------------메뉴------------------");
		System.out.println(" 1.회원 가입");
		System.out.println(" 2.회원 목록 출력");
		System.out.println(" 3.로그인");
		System.out.println(" 4.비밀번호 변경");
		System.out.println(" 0.프로그램 종료");
		System.out.println("--------------------------------------");
	}
}

package com.human.ex;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = 0;
		int n = 7;
		int a = n-1;//1을 제외한 2부터 n까지 수
		for (int i = 1; i <= n; i++) {//1부터 n까지 반복 (i)
			for (int j = 1; j <= i; j++) {//1부터 i까지 반복 (j)
				if (i % j == 0 && i / j != 1 && i / j != i) {//나누어 떨어지는 수가 1과 자기 자신이 아니라면
					a--;//2부터 n까지의 수 총갯수 -1
					break;//j반복문 탈출
				}
			}
		}
		answer = a;
		System.out.println(answer);

	}

}

package study_2021_7_week3;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.07.19
 * @summary 
 * BOJ-silver4  128MB/1s (12844KB/124ms)
 * 시계수 : 입력받은 숫자 시계방향으로 돌렸을 때 가장 작은 수
 * 입력받은 시계수가 몇 번째로 작은 시계수인지 계산
 * 
 * minNum : 현재 입력받은 시계수
 * answer : 몇 번째로 작은 수인가
 */
public class Main_2659_십자카드문제 {

	static int minNum, answer;
	static int[] number;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		number = new int[4];
		for (int i = 0; i < 4; i++) {
			number[i] = scann.nextInt();
		}
		//시계수 구하기
		minNum = card(1000*number[0]+100*number[1]+10*number[2]+number[3]);
		//몇 번째로 작은 시계수인지 계산 (중복 제거)
		for (int i = 1111; i <= minNum; i++) {
			if(i==card(i)) answer++;
		}
		System.out.println(answer);
	}
	
	//시계수 구하기
	private static int card(int num) {
		int a = num / 1000;
		int b = num / 100 % 10;
		int c = num / 10 % 10;
		int d = num % 10;
		int n1 = num;
		int n2 = 1000*b + 100*c + 10*d + a;
		int n3 = 1000*c + 100*d + 10*a + b;
		int n4 = 1000*d + 100*a + 10*b + c;
		return Math.min(Math.min(n1, n2), Math.min(n3, n4));
	}

}

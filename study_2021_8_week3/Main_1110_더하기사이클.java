package study_2021_8_week3;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.08.17
 * @summary 
 * BOJ-bronze1  128MB/2s (12880KB/116ms)
 * 1~99 정수
 * 주어진 수가 10보다 작으면 앞에 0 붙여 두자리 수 만들기
 * 각 자리 숫자 더하기
 * 주어진 수 오른쪽 + 합 오른쪽 이어붙이기
 * 몇 번 반복하면 처음 수가 나오는가?
 */
public class Main_1110_더하기사이클 {

	static int N, answer;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		check(N);
		System.out.println(answer);
		scann.close();
	}
	
	private static void check(int n) {
		int now = n;
		while(true) {
			int sum = (now/10) + (now%10);
			int next = (now%10)*10 + (sum%10);
			answer++;
			if(next==n) break;
			now = next;
		}
		
	}

}

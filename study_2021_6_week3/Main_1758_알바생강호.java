package study_2021_6_week3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author anna
 * @date 2021.06.15
 * @summary 
 * BOJ-silver4  256MB/2s (95672KB/700ms)
 * 팁 : 손님이 생각한 돈 - (커피 받는 순서-1)
 * 팁이 음수인 경우 0원
 * 팁을 최대로 받을 경우 얼마?
 * 
 * N : 손님 수 (<100,000)
 * tip : 손님이 생각한 돈 (≤100,000)
 */
public class Main_1758_알바생강호 {

	static int N;
	static long answer;
	static int[] tip;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		tip = new int[N];
		for (int i = 0; i < N; i++) {
			tip[i] = scann.nextInt();
		}
		Arrays.sort(tip); //int배열의 경우 reverse 불가능
		for (int i = 0; i < N; i++) {
			int now = tip[N-1-i] - i; //큰 수부터 고려
			if(now>0) {				
				answer += now;
			}else break;
		}
		System.out.println(answer);
	}

}

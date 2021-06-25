package study_2021_6_week4;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.06.25
 * @summary 
 * BOJ-silver3  128MB/2s (12836KB/112ms)
 * 이친수 조건
 * 1. 0으로 시작하지 않는다.
 * 2. 1이 두 번 연속으로 나오지 않는다.
 * N자리 이친수의 개수 구하기
 * 
 * number[i] : i자리 이친수 개수 배열
 */
public class Main_2193_이친수 {
	
	static int N;
	static long number[];
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		number = new long[N+1];
		number[1] = 1;
		if(N>=2) number[2] = 1;
		if(N>=3) {			
			for (int i = 3; i < N+1; i++) {
				//피보나치
				number[i] = number[i-1] + number[i-2];
			}
		}
		System.out.println(number[N]);
	}
}

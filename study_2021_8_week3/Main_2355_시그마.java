package study_2021_8_week3;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.08.18
 * @summary 
 * BOJ-bronze3  128MB/2s (12864KB/108ms)
 * 정수 A, B
 * 두 정수 사이에 있는 수의 합 구하기
 */
public class Main_2355_시그마 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		long a = scann.nextLong();
		long b = scann.nextLong();
		long answer = 0;
		if(a > b) answer = a*(a+1)/2 - b*(b-1)/2; 
		else answer = b*(b+1)/2  - a*(a-1)/2;
		System.out.println(answer);
		scann.close();
	}

}

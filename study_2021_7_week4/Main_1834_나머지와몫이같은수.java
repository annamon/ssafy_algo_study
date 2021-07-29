package study_2021_7_week4;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.07.29
 * @summary 
 * BOJ-bronze1  256MB/2s (12820KB/124ms)
 * N으로 나누었을 때 나머지와 몫이 같은 모든 자연수의 합 구하기
 * 
 * N : 2,000,000 이하
 */
public class Main_1834_나머지와몫이같은수 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		long N = scann.nextLong();
		long answer = (N-1)*N*(N+1)/2;
		System.out.println(answer);
	}

}

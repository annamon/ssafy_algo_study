package study_2021_11_week5;

import java.util.*;

/**
 * @author anna
 * @date 2021.11.29
 * @summary 
 * BOJ-bronze1  256MB/1s (12848KB/108ms)
 * N, K 주어질 때 이항계수 구하기
 * N : 1~10
 * K : 0~N
 */
public class Main_11050_이항계수1 {

	static int N, K, answer = 1;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		K = scann.nextInt();
		int count = 0;
		while(count<K) {
			answer *= N;
			N--;
			count++;
		}
		while(count!=0) {
			answer /= K;
			K--;
			count--;
		}
		System.out.println(answer);
		scann.close();
	}

}

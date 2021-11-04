package study_2021_11_week1;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author anna
 * @date 2021.11.04
 * @summary 
 * BOJ-silver4  256MB/1s (19252KB/160ms)
 * n번째 피보나치 수 구하기
 * n : 0~10,000
 */
public class Main_10826_피보나치수4 {

	static BigInteger[] arr;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N = scann.nextInt();
		arr = new BigInteger[N+2];
		arr[0] = BigInteger.ZERO;
		arr[1] = BigInteger.ONE;
		for (int i = 2; i <= N; i++) {
			arr[i] = arr[i-2].add(arr[i-1]);
		}
		System.out.println(arr[N]);
		scann.close();
	}

}

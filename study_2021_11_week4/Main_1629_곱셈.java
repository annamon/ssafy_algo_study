package study_2021_11_week4;

import java.util.*;

/**
 * @author anna
 * @date 2021.11.24
 * @summary 
 * BOJ-silver1  128MB/0.5s (12840KB/108ms)
 * 자연수 A를 B번 곱한 수를 C로 나눈 나머지 구하기
 * A, B, C < 21억
 */
public class Main_1629_곱셈 {

	static long A, B, C;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		A = scann.nextLong();
		B = scann.nextLong();
		C = scann.nextLong();
		System.out.println(div(A, B));
		scann.close();
	}
	
	private static long div(long A, long B) {
		if(B==1) return A%C;
		long temp = div(A, B/2);
		if(B%2==1) {
			return (temp * temp % C) * A % C;
		}
		return temp * temp % C;
	}

}

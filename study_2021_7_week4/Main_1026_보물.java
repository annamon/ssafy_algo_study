package study_2021_7_week4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author anna
 * @date 2021.07.27
 * @summary 
 * BOJ-silver4  128MB/2s (12992KB/128ms)
 * S = A[0]xB[0]+...+A[N-1]B[N-1]
 * A수 재배열, B는 재배열 금지
 * S최솟값 출력
 * 
 * N : 수 개수, 1~50
 */
public class Main_1026_보물 {
	
	static int N, S;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		int[] A = new int[N];
		int[] B = new int[N];
		for (int i = 0; i < N; i++) A[i] = scann.nextInt();
		for (int i = 0; i < N; i++) B[i] = scann.nextInt();
		Arrays.sort(A);
		Arrays.sort(B);
		for (int i = 0; i < N; i++) {
			S += A[i]*B[N-1-i];
		}
		System.out.println(S);
	}

}

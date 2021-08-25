package study_2021_8_week4;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.08.25
 * @summary 
 * BOJ-gold4  256MB/1s (175104KB/444ms)
 * 규칙 유추하여 별 찍기
 * N : 3*2^k, k:0~10
 * 재귀
 */
public class Main_2448_별찍기11 {

	static int N;
	static StringBuilder sb;
	static String[] tree;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		tree = new String[N];
		tree[0] = "  *  ";
		tree[1] = " * * ";
		tree[2] = "*****";
		for (int k = 1; 3 * (int)Math.pow(2, k) <= N; k++) {
			make(k);
		}
		for (int i = 0; i < N; i++) {
			System.out.println(tree[i]);
		}
		scann.close();
	}
	
	private static void make(int k) {
		int bottom = 3 * (int)Math.pow(2, k);
		int middle = bottom / 2;
		//이전 모양 두 개 붙이기
		for (int i = middle; i < bottom; i++) {
			tree[i] = tree[i-middle] + " " + tree[i-middle];
		}
		//공백
		sb = new StringBuilder();
		while(sb.length() < middle) {
			sb.append(" ");
		}
		//앞뒤 공백 붙이기
		for (int i = 0; i < middle; i++) {
			tree[i] = sb.toString() + tree[i] + sb.toString();
		}
	}
	
}

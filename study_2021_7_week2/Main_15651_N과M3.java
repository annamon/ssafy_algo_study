package study_2021_7_week2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @author anna
 * @date 2021.07.17
 * @summary 
 * BOJ-silver3  512MB/1s (165068KB/604ms)
 * 1~N 자연수 중 M개 고른 수열 전부 출력
 * 같은 수 여러번 고르기 가능
 * 
 * N,M : (1≤M≤N≤8)
 * num[] : M개 고른 수열
 * 중복순열, print는 시간초과
 */
public class Main_15651_N과M3 {

	static int N, M;
	static int[] num;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		num = new int[M];
		nPir(0);
		bw.flush();
		scann.close();
	}
	
	//중복순열
	private static void nPir(int cnt) throws IOException {
		//M개 선택완료시
		if(cnt==M) {
			for (int i : num) bw.write(i+" ");
			bw.newLine();
			return;
		}
		for (int i = 1; i <= N; i++) {
			num[cnt] = i;
			nPir(cnt+1);
		}
	}

}

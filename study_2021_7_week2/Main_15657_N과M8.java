package study_2021_7_week2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author anna
 * @date 2021.07.17
 * @summary 
 * BOJ-silver3  512MB/1s (21380KB/176ms)
 * 1~N 자연수 중 M개 고른 수열 전부 출력
 * 중복 가능
 * 비내림차순
 * 
 * N,M : (1≤M≤N≤8)
 * num[] : 수 목록
 * selectNum[] : M개 고른 수열
 * 중복순열
 */
public class Main_15657_N과M8 {

	static int N, M;
	static int[] num, selectNum;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		num = new int[N];
		selectNum = new int[M];
		for (int i = 0; i < N; i++) {
			num[i] = scann.nextInt();
		}
		Arrays.sort(num);
		nPr(0, 0);
		bw.flush();
		scann.close();
	}
	
	//중복순열
	private static void nPr(int cnt, int start) throws IOException {
		//M개 선택완료시
		if(cnt==M) {
			for (int i : selectNum) bw.write(i+" ");
			bw.newLine();
			return;
		}
		for (int i = start; i < N; i++) {
			selectNum[cnt] = num[i];
			nPr(cnt+1, i);
		}
	}

}
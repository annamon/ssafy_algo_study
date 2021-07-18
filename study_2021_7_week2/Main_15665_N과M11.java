package study_2021_7_week2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * @author anna
 * @date 2021.07.18
 * @summary 
 * BOJ-silver2  512MB/1s (82228KB/412ms)
 * 1~N 자연수 중 M개 고른 수열 전부 출력
 * 중복 가능
 * 
 * N,M : (1≤M≤N≤8)
 * num : 수 목록(중복x)
 * selectNum[] : M개 고른 수열
 * 중복순열
 */
public class Main_15665_N과M11 {

	static int N, M;
	static List<Integer> num = new ArrayList<>();
	static int[] selectNum;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		selectNum = new int[M];
		for (int i = 0; i < N; i++) {
			int n = scann.nextInt();
			if(!num.contains(n)) num.add(n);
		}
		Collections.sort(num);
		nPir(0);
		bw.flush();
		scann.close();
	}
	
	//중복순열
	private static void nPir(int cnt) throws IOException {
		//M개 선택완료시
		if(cnt==M) {
			for (int i : selectNum) bw.write(i+" ");
			bw.newLine();
			return;
		}
		for (int i = 0; i < num.size(); i++) {
			selectNum[cnt] = num.get(i);
			nPir(cnt+1);
		}
	}

}
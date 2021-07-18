package study_2021_7_week2;

import java.util.*;

/**
 * @author anna
 * @date 2021.07.18
 * @summary 
 * BOJ-silver2  512MB/1s (12900KB/112ms)
 * 1~N 자연수 중 M개 고른 수열 전부 출력
 * 비내림차순
 * 
 * N,M : (1≤M≤N≤8)
 * num[] : 수 목록
 * selectNum[] : M개 고른 수열
 * isSelected[] : 선택 처리
 * answer : 중복 제거
 * 조합
 */
public class Main_15664_N과M10 {

	static int N, M;
	static int[] num, selectNum;
	static boolean[] isSelected;
	static HashSet<String> answer = new HashSet<>();
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		num = new int[N];
		selectNum = new int[M];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			num[i] = scann.nextInt();
		}
		Arrays.sort(num);
		nCr(0, 0);
		scann.close();
	}
	
	//조합
	private static void nCr(int cnt, int start) {
		//M개 선택완료시
		if(cnt==M) {
			//현재 고른 놈들 문자열로 바꾸기
			StringBuilder sb = new StringBuilder();
			for (int i : selectNum) sb.append(i).append(" ");
			//현재 문자열 이미 출력한 경우 리턴
			if(answer.contains(sb.toString())) return;
			else { //그 외
				System.out.println(sb.toString());
				answer.add(sb.toString());
			}
			return;
		}
		for (int i = start; i < N; i++) {
			if(isSelected[i]) continue;
			selectNum[cnt] = num[i];
			isSelected[i] = true;
			nCr(cnt+1, i+1);
			isSelected[i] = false;
		}
	}

}
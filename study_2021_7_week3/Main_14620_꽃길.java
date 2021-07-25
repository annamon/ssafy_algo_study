package study_2021_7_week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author anna
 * @date 2021.07.25
 * @summary 
 * BOJ-silver2  256MB/2s (12932KB/108ms)
 * 씨앗 3개 심기
 * 씨앗 사방으로 꽃잎 펼쳐짐
 * 3개 꽃이 서로 겹치지 않도록 하기
 * 이 때 최소 비용?
 * 
 * N : 화단 (6≤N≤10)
 * answer : 정답
 * cost[][] : 지점당 가격 0~200
 * blooming[] : 씨앗 3개 위치
 * dr[], dc[] : 사방탐색
 */
public class Main_14620_꽃길 {

	static int N, answer = Integer.MAX_VALUE;
	static int[][] cost;
	static int[] blooming;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		blooming = new int[3];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		find(0,1);
		System.out.println(answer);
	}
	
	//씨앗 심을 곳  찾기
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = { 0, 1, 0,-1};
	private static void find(int cnt, int start) {
		//세 곳 정한 경우
		if(cnt==3) {
			int sum = 0;
			//씨앗이 겹치는지 비교, 0-1,2 / 1-2 겹치는지 비교
			for (int i = 0; i < 2; i++) {
				//i번째 씨앗의 r, c 찾기
				int r = (blooming[i]+N-3)/(N-2);
				int c = blooming[i]%(N-2);
				if(c==0) c+=(N-2); //c가 0이면 N-2의 배수이므로 N-2넣기
				for (int j = i+1; j < 3; j++) {
					//j번째 씨앗의 r,c 찾기
					int nr = (blooming[j]+N-3)/(N-2);
					int nc = blooming[j]%(N-2);
					if(nc==0) nc+=(N-2);
					//두 씨앗이 겹치는지 비교 (기준 j씨앗)
					if((c==nc && r>=nr-2 && r<=nr+2) ||
						(r==nr && c>=nc-2 && c<nc+2) ||
						(r>=nr-1 && r<=nr+1 && (c==nc-1 || c==nc+1))) return;
				}
			}
			//씨앗이 모두 겹치지 않는 경우 비용 계산하기
			for (int i = 0; i < 3; i++) {
				//씨앗 부분
				int r = (blooming[i]+N-3)/(N-2);
				int c = blooming[i]%(N-2);
				if(c==0) c+=(N-2);
				sum += cost[r][c];
				//꽃잎 부분
				for (int d = 0; d < 4; d++) {
					sum += cost[r+dr[d]][c+dc[d]];
				}
			}
			//비용 최소값
			answer = Math.min(answer, sum);
			return;
		}
		
		//(n-2)^2 C 3
		for (int i = start; i <= (N-2)*(N-2); i++) {
			blooming[cnt] = i;
			find(cnt+1, i+1);
		}
	}

}

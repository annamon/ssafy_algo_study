package study_2021_8_week4;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.08.29
 * @summary 
 * BOJ-gold4  256MB/2s (71544KB/468ms)
 * 모든 작업 완료하기 위한 최소 시간 구하기
 * 서로 선행관계 없는 작업들은 동시 수행 가능
 * K번 선행 관계 작업 = 1~K-1 번호
 * 
 * N : 작업 수, 3~10,000
 * answer : 최소 시간
 * time[] : 작업별 소요 시간
 * dp[] : 작업별 걸리는 시간 메모
 * work[] : 작업별 선행 작업 목록
 */
public class Main_2056_작업 {

	static int N, answer;
	static int[] time, dp;
	static ArrayList<Integer>[] work;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		time = new int[N+1];
		dp = new int[N+1];
		//작업별 선행 리스트 만들기
		work = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) work[i] = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken());
			//선행작업 없는 경우
			if(Integer.parseInt(st.nextToken())==0) continue;
			//선행작업 있는 경우 리스트에 추가
			while(st.hasMoreTokens()) {
				work[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		//1번 작업은 선행작업이 없다.
		dp[1] = time[1];
		//2~N번 작업 시간 계산
		for (int i = 2; i <= N; i++) {
			int max = 0;
			//선행 작업들 중 가장 오래 걸리는 시간 찾기
			for (int j = 0; j < work[i].size(); j++) {
				int before = work[i].get(j);
				max = Math.max(max, dp[before]); 
			}
			//가장 오래 걸리는 시간 + 현재 작업 수행 시간 메모
			dp[i] = max + time[i];
		}
		//전체 작업 중 가장 오래 걸린 시간이 정답
		for (int i = 1; i <= N; i++) answer = Math.max(answer, dp[i]);
		System.out.println(answer);
	}
}

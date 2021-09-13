package study_2021_9_week3;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.13
 * @summary 
 * BOJ-silver4  256MB/1s (53356KB/388ms)
 * 최대한 적은 종류 비행기 타고 이동
 * 이미 방문한 국가 재방문 가능
 * 
 * T : 테스트케이스 수, 1~100
 * N : 국가 수 2~1,000
 * M : 비행기 종류 1~10,000
 * fight[] : 간선 정보
 */
public class Main_9372_상근이의여행 {

	static int T, N, M;
	static List<Integer>[] flight;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			//간선 정보 저장
			flight = new ArrayList[N+1];
			for (int i = 1; i <= N; i++) {
				flight[i] = new ArrayList<>();
			}
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				flight[a].add(b);
				flight[b].add(a);
			}
			//그러나.. 가중치가 같다면, n개의 노드는 n-1개의 간선을 갖는다. 
			System.out.println(N-1);
		}
		
	}

}

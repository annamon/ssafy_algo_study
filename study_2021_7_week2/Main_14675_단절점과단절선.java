package study_2021_7_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author anna
 * @date 2021.07.13
 * @summary 
 * BOJ-gold5  512MB/1s (62148KB/1516ms)
 * 단절점 : 정점 제거시 그래프가 2개 이상으로 나뉘는 경우
 * 단절선 : 간선 제거시 그래프가 2개 이상으로 나뉘는 경우
 * 트리 : 사이클X, 모든 정점이 연결되어 있는 그래프
 * 
 * N개의 정점, N-1개의 간선 정보
 * Q개의 질문, T, K
 * T=1 : K번 정점이 단절점인가
 * T=2 : K번 간선이 단절선인가
 * 대답은 yes or no
 * 
 * points[] : 각 점에 연결된 간선 개수 저장 배열
 */
public class Main_14675_단절점과단절선 {

	static int N, Q, T, K;
	static int[] points;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		points = new int[N+1];
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			points[Integer.parseInt(st.nextToken())]++;
			points[Integer.parseInt(st.nextToken())]++;
		}
		Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			T = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			//단절점인지 체크
			if(T==1) {
				//연결된 간선이 1개일 경우 단절점이 아니다.
				//트리는 모든 점이 최소 1개 이상의 간선으로 연결되어 있다.
				if(points[K]==1) System.out.println("no");
				else System.out.println("yes");
			}
			//단절선인지 체크
			else {
				//트리는 사이클을 이루지 않으므로 어느 선을 제거하던 2개 이상의 새로운 트리가 된다.
				System.out.println("yes");
			}
		}
	}

}

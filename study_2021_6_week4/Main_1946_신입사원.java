package study_2021_6_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author anna
 * @date 2021.06.24
 * @summary 
 * BOJ-silver1  256MB/2s (308500KB/2376ms)
 * 서류, 면접 심사
 * 두 항목 다 다른 사람보다 등수가 낮다면 탈락
 * 동석차 없음
 * 신입사원 최대 인원 수 구하기
 * 
 * T : 테스트케이스 수 (1≤T≤20)
 * N : 지원자 수 (1≤N≤100,000)
 * score : 서류, 면접 등수
 * answer : 합격자수
 * secondCut : 면접 커트라인
 * list : 후보 배열
 */
public class Main_1946_신입사원 {

	static class score implements Comparable<score>{
		int first, second;
		public score(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
		//서류 등수 순으로 정렬
		@Override
		public int compareTo(score o) {
			return this.first - o.first;
		};
	}
	static int T, N, answer, secondCut;
	static score[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new score[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				list[i] = new score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(list);
			answer = 1;
			secondCut = list[0].second; //서류1등의 면접등수
			//서류1등보다 면접등수가 높은 사람들만 합격 가능
			for (int i = 1; i < N; i++) {
				if(list[i].second < secondCut) {
					answer++;
					secondCut = list[i].second; //면접컷 갱신
				}
			}
			System.out.println(answer);
		}
	}
}

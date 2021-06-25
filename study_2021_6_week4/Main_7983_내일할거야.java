package study_2021_6_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author anna
 * @date 2021.06.26
 * @summary 
 * BOJ-gold5  256MB/2s (282200KB/2016ms)
 * 과제 n개 (1≤n≤10^6)
 * 과제 d일 걸리고, 오늘로부터 t일 안에 끝내야 함
 * d, t (1≤d,t≤10^9)
 * 과제는 한 번 시작하면 쉬지 않고 계속 해서 끝낸다.
 * 내일부터 최대한 며칠 놀 수 있는가
 * 
 * N : 과제 개수
 * homework : 걸리는 날, 마감일
 * hw : 과제 정보 배열
 * answer : 최대 놀 수 있는 날
 */
public class Main_7983_내일할거야 {
	
	static class homework implements Comparable<homework>{
		int day, deadline;
		public homework(int day, int deadline) {
			super();
			this.day = day;
			this.deadline = deadline;
		}
		//마감일 내림차순 정렬
		@Override
		public int compareTo(homework o) {
			return o.deadline - this.deadline;
		}
	}
	static int N, answer=Integer.MAX_VALUE;
	static homework[] hw;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		hw = new homework[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			hw[i] = new homework(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(hw);
		for (int i = 0; i < N; i++) {
			//놀 수 있는 최대 날짜보다 마감일이 이른 경우
			if(hw[i].deadline <= answer) {
				//놀 수 있는 날 = 마감일 - 숙제하는데 걸리는 날
				answer = hw[i].deadline - hw[i].day; 
			}
			//마감일이 뒤인 경우 : 놀 수 있는 날 - 숙제하는데 걸리는 날
			else answer -= hw[i].day;
		}
		System.out.println(answer);
	}

}

package study_2021_9_week5;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.10.03
 * @summary 
 * BOJ-gold3  128MB/1s (18552KB/312ms)
 * 본부 : 0번
 * 본부에서 출발하여 마지막 마을까지 물건 배송
 * 1. 박스 트럭에 실으면 받는 마을에서만 내리기
 * 2. 지나온 마을 되돌아가지 않기
 * 3. 박스 중 일부만 배송 가능
 * 
 * N : 마을 수, 2~2,000
 * C : 트럭 용량, 1~10,000
 * M : 보내는 박스 정보 개수, 1~10,000
 * answer : 전체 배송 박스 수
 * delivery[] : 배송 정보
 * moveBox[] : 해당 마을에서 싣고 있는 박스 수
 */
public class Main_8980_택배 {

	static class Box implements Comparable<Box> {
		int from;
		int to;
		int count;
		public Box(int from, int to, int count) {
			super();
			this.from = from;
			this.to = to;
			this.count = count;
		}
		//목적지-출발지 순으로 오름차순, 
		@Override
		public int compareTo(Box o) {
			int d = this.to - o.to;
			return d==0? this.from - o.from : d;
		}
	}
	
	static int N, C, M, answer;
	static Box[] delivery;
	static int[] moveBox;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		//배송 정보
		delivery = new Box[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			delivery[i] = new Box(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		//목적지 - 출발지 순으로 오름차순 정렬
		Arrays.sort(delivery);
		//마을마다 싣고 있는 박스 수 (마을 index 1부터 시작)
		moveBox = new int[N+1];
		//배송 시작 : 해당 배송 루트에서 최대로 실을 수 있는 박스 개수 찾기
		for (int i = 0; i < M; i++) {
			//이전 배송까지 이미 실은 최대 박스 수 찾기
			int max = 0;
			for (int j = delivery[i].from; j < delivery[i].to; j++) {
				max = Math.max(moveBox[j], max);
			}
			//이번 배송에 추가로 실을 수 있는 박스 수 : 요청 박스와 실을 수 있는 최대 수 - 이미 실은 수 중 작은 것
			int possible = Math.min(delivery[i].count, C-max);
			//모든 마을에 추가로 실은 박스 개수 추가
			for (int j = delivery[i].from; j < delivery[i].to; j++) {
				moveBox[j]+=possible;
			}
			//정답 = 추가로 실은 박스 합
			answer += possible;
		}
		System.out.println(answer);
	}

}

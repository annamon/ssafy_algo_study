package study_2021_9_week3;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.20
 * @summary 
 * BOJ-gold3  128MB/2s (KB/ms)
 * 탱크 연료 제한 x
 * 주유소 N개, 주유소 최소화
 * 각 주유소 위치, 연료 양 주어질 경우 주유소에서 멈추는 최소 횟수?
 * 정글 일직선, 주유소 : 트럭 기준 오른쪽에 위치
 * 주유소 정보 : 시작 위치에서 주유소까지 거리 1~1,000,000 
 * 			  + 채울 수 있는 연료 양 1~100
 * 마을 도착 못 하는 경우 -1 출력
 * 
 * N : 주유소 개수, 1~10,000
 * L : 성경이 위치에서 마을까지 거리 1~1,000,000
 * P : 트럭에 있던 원래 연료의 양 1~1,000,000
 * 
 * 반례
 * 
 * 2
 * 2 3
 * 4 7
 * 14 4
 */
public class Main_1826_연료채우기 {

	static public class Station implements Comparable<Station>{
		int distance;
		int oil;
		public Station(int distance, int oil) {
			super();
			this.distance = distance;
			this.oil = oil;
		}
		//거리 순 정렬
		@Override
		public int compareTo(Station o) {
			return this.distance - o.distance;
		}
	}
	
	static int N, L, P, now, count, index;
	static Station[] banks;
	static StringTokenizer st;
	static PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		//주유소 정보
		banks = new Station[N];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			banks[n] = new Station(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		//주유소 정렬
		Arrays.sort(banks);
		//마을까지 달리기
		while(now<=L) {
			//연료 바닥난 경우
			if(P<=0) {
				//중간에 들릴 수 있는 주유소가 없던 경우 종료
				if(que.isEmpty()) {
					System.out.println(-1);
					System.exit(0);
				}
				//주유소 들 릴 수 있던 경우 -> 최대 연료 채우기
				P += que.poll();
				count++; //방문 횟수 증가
			}
			//연료 충분한 경우
			else {
				for (int i = index; i < N; i++) {
					//큐에 등록하지 않은 지나온 주유소
					if(banks[i].distance <= now) {
						//해당 주유소의 연료 넣기
						que.add(banks[i].oil);
					}
					//지나온 주유소가 없는 경우
					else {
						index = i;
						break;
					}
				}
				//1칸 이동 및 연료 1 감소
				now++;
				P--;
			}
		}
		//멈춘 횟수 출력
		System.out.println(count);
	}

}

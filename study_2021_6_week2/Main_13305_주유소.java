package study_2021_6_week2;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.06.09
 * @summary 
 * BOJ-silver4  512MB/2s (164180KB/980ms)
 * 도시 N개. 각 도시마다 기름값 다름
 * 왼쪽의 도시에서 제일 오른쪽의 도시로 자동차를 이용하여 이동
 * 처음 출발할 때 주유소에서 기름을 넣고 출발
 * 1km마다 1리터의 기름 사용
 * 기름통의 크기는 무제한
 * 제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소의 비용?
 * 
 * N : 도시 수  (1≤N≤100,000) 
 * 제일 왼쪽 도시~오른쪽 도시 거리 : 1이상 10억이하
 * 기름값 : 1이상 10억이하
 * 
 * city : {현재 도시에서 다음 도시까지 거리, 기름값}
 */
public class Main_13305_주유소 {

	static int N;
	static long oil, money;
	static long[][] city;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		city = new long[N][2];
		// 거리 정보
		for (int i = 0; i < N-1; i++) {
			city[i][0] = scann.nextLong();
		}
		// 기름값 정보
		for (int i = 0; i < N; i++) {
			city[i][1] = scann.nextLong();
		}
		for (int i = 0; i < N-1; i++) {
			// 차에 기름 있는 경우
			if(oil!=0) {
				oil -= city[i][0];
			}
			// 차에 기름 없는 경우
			else {
				fill(i); 			// 기름 채우기
				oil -= city[i][0];  // 현재 도시 기름 쓰기
			}
		}
		System.out.println(money);
	}
	
	// 기름 채우기
	private static void fill(int index) {
		// index : 현재 도시, next : 다음 도시
		int next = index+1;
		// 일단 현재-다음 거리만큼 기름 채우기
		oil+= city[index][0];
		money += city[index][0] * city[index][1];
		while(true) {
			if(next==N) break; // 도착시 종료
			// 현재 도시가 다음 도시보다 기름값이 싸면 기름 채우기
			if(city[index][1]<=city[next][1]) {
				oil += city[next][0];
				money += city[next][0] * city[index][1];
				next++;
			}
			else break;
		}
	}
	
	/*
	 * 아래는 클린코딩.. 어렵게 생각하지 말자
		public static void main(String[] args) {
			Scanner scann = new Scanner(System.in);
			N = scann.nextInt();
			city = new long[N][2];
			// 거리 정보
			for (int i = 0; i < N-1; i++) {
				city[i][0] = scann.nextLong();
			}
			// 기름값 정보
			for (int i = 0; i < N; i++) {
				city[i][1] = scann.nextLong();
			}
			// 현재랑 다음 도시랑 기름값 비교
			for (int i = 0; i < N-1; i++) {
				// 현재가 더 싸면 바꿔주기
				if(city[i][1]<=city[i+1][1]){
	                city[i+1][1] = city[i][1];
	            }
			}
			// 총액 계산
	        for (int i = 0; i < N-1; i++) {
	            money += city[i][0] * city[i][1];
	        }
			System.out.println(money);
		}
	 */
	
	
}

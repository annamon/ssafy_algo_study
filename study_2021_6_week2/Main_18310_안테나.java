package study_2021_6_week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author anna
 * @date 2021.06.08
 * @summary 
 * BOJ-silver3  256MB/1s (160096KB/2600ms)
 * 한 집에 안테나 설치
 * 안테나로부터 모든 집까지의 거리의 총 합이 최소가 되도록 
 * 여러 개의 값이 도출될 경우 가장 작은 값
 * 
 * N : 집 수  (1≤N≤200,000) 
 * house : 집 위치 배열, 집 위치 1이상 100,000이하
 * 
 * 1시간초과 2실패 -> 성공
 * 주의점!!!!
 * 집이 1, 100000에만 있는 경우 int 범위를 넘어버린다. sum 계산시 long 타입으로 해야한다.
 */
public class Main_18310_안테나 {

	static int N, answer;
	static long antenna;
	static int[] house = new int[100001];
	static List<int[]> houseList = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		for (int i = 0; i < N; i++) {
			house[scann.nextInt()]++;
		}
		for (int i = 0; i < house.length; i++) {
			if(house[i]!=0) {
				houseList.add(new int[] {i, house[i]});
			}
		}
		for (int i = 0; i < houseList.size(); i++) {
			int nowHouse = houseList.get(i)[0];
			long sum = 0;
			for (int j = 0; j < houseList.size(); j++) {
				sum += Math.abs(nowHouse - houseList.get(j)[0]) * houseList.get(j)[1];
			}
			if(sum!=0 && antenna==0) {
				antenna = sum;
				answer = nowHouse;
			}
			else if(sum < antenna) {
				antenna = sum;
				answer = nowHouse;
			}
			else if(sum==antenna) {
				if(nowHouse < answer) answer = nowHouse;
			}
		}
		System.out.println(answer);
	}
	
	
	
	
	/* 이렇게 풀면 망함
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		house = new int[N];
		for (int i = 0; i < N; i++) {
			house[i] = scann.nextInt();
		}
		for (int i = 0; i < N; i++) {
			int now = house[i];
			int sum = 0;
			for (int j = 0; j < N; j++) {
				sum += Math.abs(now - house[j]);
			}
			if(sum < antenna) {
				antenna = sum;
				answer = now;
			}
			if(sum == antenna) {
				if(answer > now) {
					answer = now;
				}
			}
		}
		System.out.println(answer);
	}
	 */

}

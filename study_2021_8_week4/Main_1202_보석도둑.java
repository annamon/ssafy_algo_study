package study_2021_8_week4;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.08.26
 * @summary 
 * BOJ-gold2  256MB/1s (129176KB/1896ms)
 * 보석 N개, 각 보석은 무게 M, 가격 V
 * 상덕이는 가방 K개 가지고 있고 각 가방에 담을 수 있는 무게 최대 C
 * 가방에는 한 개 보석만 넣을 수 있다.
 * 훔칠 수 있는 보석 최대 가격 구하기
 * 
 * N, K : 1~300,000
 * M, V : 0~1,000,000
 * C : 1~100,000,000
 * jewelleryList[] : 보석 배열
 * bagList[] : 가방 무게 배열
 */
public class Main_1202_보석도둑 {

	//보석 무게 오름차순 정렬
	public static class Jewellery implements Comparable<Jewellery>{
		int weight;
		int price;
		public Jewellery(int weight, int price) {
			super();
			this.weight = weight;
			this.price = price;
		}
		@Override
		public int compareTo(Jewellery o) {
			return this.weight - o.weight;
		}
	}
	
	static int N, bag;
	static long answer;
	static Jewellery[] jewelleryList;
	static int[] bagList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		bag = Integer.parseInt(st.nextToken());
		jewelleryList = new Jewellery[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			jewelleryList[i] = new Jewellery(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		bagList = new int[bag];
		for (int i = 0; i < bag; i++) {
			bagList[i] = Integer.parseInt(br.readLine());
		}
		//보석, 가방 모두 무게 기준 오름차순
		Arrays.sort(jewelleryList);
		Arrays.sort(bagList);
		
		//가방에 넣을 수 있는 보석 고르기
		PriorityQueue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0, start = 0; i < bag; i++) {
			//가방 무게보다 적은 보석 큐에 담기
			while(start<N && jewelleryList[start].weight <= bagList[i]) {
				que.add(jewelleryList[start++].price);
			}
			//담을 수 있는 보석만 모은 큐에서 가장 비싼 것 담기
			if(!que.isEmpty()) {
				answer += que.poll();
			}
		}
		System.out.println(answer);
	}

}

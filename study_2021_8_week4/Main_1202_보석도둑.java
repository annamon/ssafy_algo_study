package study_2021_8_week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @author anna
 * @date 2021.08.26
 * @summary 
 * BOJ-gold2  256MB/1s (KB/ms)
 * 보석 N개, 각 보석은 무게 M, 가격 V
 * 상덕이는 가방 K개 가지고 있고 각 가방에 담을 수 있는 무게 최대 C
 * 가방에는 한 개 보석만 넣을 수 있다.
 * 훔칠 수 있는 보석 최대 가격 구하기
 * 
 * N, K : 1~300,000
 * M, V : 0~1,000,000
 * C : 1~100,000,000
 */
public class Main_1202_보석도둑 {

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
			int d = this.weight - o.weight;
			return d==0? o.price - this.price : d;
		}
	}
	
	static int N, bag;
	static long answer;
	static Jewellery[] jewelleryList;
	static int[] bagList;
	static boolean[] isSelected;
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
		isSelected = new boolean[N];
		bagList = new int[bag];
		for (int i = 0; i < bag; i++) {
			bagList[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(jewelleryList);
		Arrays.sort(bagList);
		for (int i = 0; i < bag; i++) {
			if(i>0) before = bagList[i-1];
			check(bagList[i]);
		}
		System.out.println(answer);
	}
	
	static int before;
	static int start = -1;
	private static void check(int bagWeight) {
		int maxPrice = -1;
		System.out.print("현재 가방 무게:" + bagWeight);
		if(before == bagWeight) start = -1;
		int index = start;
		for (int i = start+1; i < N; i++) {
			if(isSelected[i]) continue;
			if(jewelleryList[i].weight > bagWeight) break;
			if(jewelleryList[i].price > maxPrice) {
				maxPrice = jewelleryList[i].price;
				index = i;
			}
		}
		if(index != start) {
			System.out.println(" / 고른 가격 : "+maxPrice);
			isSelected[index] = true;
			start = index;
			answer += maxPrice;			
		}
	}

}

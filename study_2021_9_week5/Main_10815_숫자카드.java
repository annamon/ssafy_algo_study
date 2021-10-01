package study_2021_9_week5;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.10.01
 * @summary 
 * BOJ-silver4  256MB/2s (168312KB/4024ms)
 * 숫자 카드 N개 가지고 있음
 * 정수 M개 주어졌을 때 이 수의 카드를 가지고 있는지 확인
 * 숫자 카드에 적힌 수 : -10,000,000~10,000,000
 * 같은 수 없음
 * 
 * N : 가지고 있는 카드 수 1~500,000
 * M : 정수 개수, 1~500,000
 * 
 */
public class Main_10815_숫자카드 {

	static int N, M, left, right, mid;
	static int[] card;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		card = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(card);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());
			boolean exist = false;
			left = 0;
			right = N-1;
			while(left<=right) {
				mid = (left+right)/2;
				if(card[mid]==now) {
					exist = true;
					break;
				}
				else {
					if(card[mid]<now) {
						left = mid+1;
					}
					else right = mid-1;
				}
			}
			if(exist) System.out.print("1 ");
			else System.out.print("0 ");
		}
	}

}

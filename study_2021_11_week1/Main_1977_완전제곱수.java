package study_2021_11_week1;

import java.util.*;

/**
 * @author anna
 * @date 2021.10.06
 * @summary 
 * BOJ-bronze1  128MB/2s (12864KB/112ms)
 * M이상 N이하 자연수 중 완전제곱수인 것 모두 골라
 * 그 합 구하고 최솟값 찾기
 * 완전제곱수가 없는 경우 -1 출력
 * 
 * N, M : 1~10,000
 */
public class Main_1977_완전제곱수 {

	static int M, N;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		M = scann.nextInt();
		N = scann.nextInt();
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=100; i++) {
			int val = (int)Math.pow(i,2);
			if(val<=N && val>=M) list.add(val);
			if(val>N) break;
		}
		if(list.size()==0) System.out.println(-1);
		else {
			int sum = 0;
			for(int i=0;i<list.size();i++)
				sum += list.get(i);
			System.out.println(sum);
			System.out.println(list.get(0));
		}
		scann.close();
	}

}

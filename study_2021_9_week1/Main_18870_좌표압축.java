package study_2021_9_week1;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.08.30
 * @summary 
 * BOJ-silver2  512MB/2s (355304KB/2392ms)
 * 좌표 N개
 * 좌표 압축 결과 : 서로 다른 좌표의 개수
 * 
 * N : 1~1,000,000
 */
public class Main_18870_좌표압축 {

	static int N;
	static int[] point, order;
	static Map<Integer, Integer> map = new TreeMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		point = new int[N];
		order = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			point[i] = Integer.parseInt(st.nextToken());
			order[i] = point[i];
		}
		Arrays.sort(order);
		//map에 순서 처리하기 (중복x)
		int index = 0;
		for (int i = 0; i < N; i++) {
			if(!map.containsKey(order[i])) {
				map.put(order[i], index);
				index++;
			}
		}
		for (int i = 0; i < N; i++) {
			bw.write(map.get(point[i]) + " ");
		}
		bw.flush();
	}

}

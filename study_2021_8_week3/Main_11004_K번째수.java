package study_2021_8_week3;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.08.16
 * @summary 
 * BOJ-silver5  512MB/2s (669248KB/3644ms)
 * N개 숫자 순서대로 정렬 후 K번째 수 출력
 * 
 * Quick select
 */
public class Main_11004_K번째수 {

	static int N, K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		System.out.println(list.get(K-1));
	}

}

package study_2021_9_week1;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.02
 * @summary 
 * BOJ-silver5  256MB/2s (184232KB/1640ms)
 * N개 수, 오름차순 정렬
 * 
 * N : 1~1,000,000
 * BufferedWriter 이용
 * StringBuilder + print 이용시 222968KB/1604ms
 */
public class Main_2751_수정렬하기2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Set<Integer> number = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			number.add(Integer.parseInt(br.readLine()));
		}
		for (int i : number) {
			bw.write(i + "\n");
		}
		bw.flush();
	}

}

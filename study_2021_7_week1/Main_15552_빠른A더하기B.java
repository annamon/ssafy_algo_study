package study_2021_7_week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * @author anna
 * @date 2021.07.08
 * @summary 
 * BOJ-bronze2  512MB/1.5s (260244KB/784ms)
 * BufferedReader 사용하기
 * 
 * T : 테스트케이스 수 (최대 1,000,000)
 * A, B : 1~1,000
 */
public class Main_15552_빠른A더하기B {

	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			bw.write((A+B) + "\n");
		}
		bw.flush();
	}
}

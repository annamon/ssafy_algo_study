package study_2021_9_week3;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.16
 * @summary 
 * BOJ-silver3  1536MB/2s (38908KB/324ms)
 * 집합 S : 문자열 N개
 * 입력 문자열 M개 중에 집합 S에 포함된 게 몇 개인지 구하기
 * 알파벳 소문자로만 이루어짐, 길이 500 이하
 * 
 * N : 집합 문자열 개수, 1~10,000
 * M : 입력 문자열 개수, 1~10,000
 */
public class Main_14425_문자열집합 {

	static int N, M, answer;
	static Set<String> word;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		word = new HashSet<>();
		for (int i = 0; i < N; i++) word.add(br.readLine());
		for (int i = 0; i < M; i++) if(word.contains(br.readLine())) answer++;
		System.out.println(answer);
	}

}

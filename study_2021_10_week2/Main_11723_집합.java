package study_2021_10_week2;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.10.11
 * @summary 
 * BOJ-silver5  448MB/1.5s (297572KB/1236ms)
 * add 추가, remove 제거
 * check 있으면1 없으면0 출력
 * toggle 있으면 제거, 없으면 추가
 * all 1~20 집합으로 바꾸기
 * empty 공집합으로 바꾸기
 * 
 * M : 연산 수, 1~3,000,000
 * 
 */
public class Main_11723_집합 {

	static int M, bit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String word = st.nextToken();
			int num = 0;
			if(st.hasMoreTokens()) {
				num = Integer.parseInt(st.nextToken());
			}
			switch(word) {
				case "add":
					bit |= (1<<num-1);
					break;
				case "remove":
					bit &= ~(1<<num-1);
					break;
				case "check":
					bw.append((bit&(1<<(num-1)))!=0 ? "1" : "0");
					bw.newLine();
					break;
				case "toggle":
					bit ^= (1<<num-1);
					break;
				case "all":
					bit |= (~0);
					break;
				case "empty":
					bit=0;
					break;
			}
		}
		bw.flush();
	}

}

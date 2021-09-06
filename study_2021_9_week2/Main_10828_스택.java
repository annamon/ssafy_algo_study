package study_2021_9_week2;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.06
 * @summary 
 * BOJ-silver4  256MB/0.5s (16096KB/364ms)
 * 명령 처리하는 스택
 * push X : X 스택에 넣기
 * pop : 스택 맨 위 정수 빼서 출력 -> 없는 경우 -1 출력
 * size : 스택에 들은 정수 개수 출력
 * empty : 비어있으면1, 아니면0 출력
 * top : 스택 맨 위 정수 출력, 없는 경우 -1
 * 
 * N : 명령 수, 1~10,000
 */
public class Main_10828_스택 {

	static int N;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> s = new Stack<>();
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {
			case "push":
				s.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(!s.isEmpty()) System.out.println(s.pop());
				else System.out.println(-1);
				break;
			case "size":
				System.out.println(s.size());
				break;
			case "empty":
				if(s.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "top":
				if(s.isEmpty()) System.out.println(-1);
				else System.out.println(s.peek());
				break;
			}
		}
	}

}

package study_2021_9_week2;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.11
 * @summary 
 * BOJ-silver4  256MB/1s (21840KB/224ms)
 * 0 외치면 가장 최근에 쓴 수 지우기
 * 모든 수 받아 적고 그 수 합 구하기
 * 
 * K : 수 부르기 1~100,000
 * answer : 정답
 */
public class Main_10773_제로 {

	static int K, answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		Stack<Integer> number = new Stack<>();
		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());
			//0인데 스택에 없는 경우 스택 pop
			if(n==0 && !number.isEmpty()) number.pop();
			//그 외 경우 push
			else number.push(n);
		}
		//총합 구하기
		while(!number.isEmpty()) answer += number.pop();
		System.out.println(answer);
	}

}

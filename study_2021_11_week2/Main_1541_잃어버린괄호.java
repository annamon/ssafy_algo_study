package study_2021_11_week2;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.11.08
 * @summary 
 * BOJ-silver2  128MB/2s (11544KB/80ms)
 * +,-,() 로 식 만들고 괄호 지움
 * 괄호를 적절하게 쳐서 이 식의 값 최소로 만들기
 * 식 길이 50보다 작거나 같음
 */
public class Main_1541_잃어버린괄호 {

	static int sum = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer minus = new StringTokenizer(br.readLine(), "-");
		while(minus.hasMoreTokens()) {
			int temp = 0;
			StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+");
			while(plus.hasMoreTokens()) {
				temp += Integer.parseInt(plus.nextToken());
			}
			if(sum==Integer.MAX_VALUE) sum = temp;
			else sum -= temp;
		}
		System.out.println(sum);
	}

}

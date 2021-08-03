package study_2021_8_week1;

import java.io.*;
import java.util.Stack;

/**
 * @author anna
 * @date 2021.08.03
 * @summary 
 * BOJ-silver3  128MB/2s (KB/ms)
 * Buffer는 8192 char 넘어버리면 자동으로 방출한다.
 */
public class Main_1874_스택수열 {

	static int N;
	static int[] permu;
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		permu = new int[N];
		for (int i = 0; i < N; i++) {
			permu[i] = Integer.parseInt(br.readLine());
		}
		int index = 0;
		int start = 1;
		int max = 0;
		while(index<N) {
			int n = permu[index];
			if(n <= max && !stack.isEmpty()) {
				if(stack.peek()!=n) {
					System.out.println("NO");
					System.exit(0);					
				}
				else {
					stack.pop();	
					sb.append("-\n");
					index++;
				}
			}
			else {
				stack.add(start);
				max = start;
				start++;
				sb.append("+\n");
			}
		}
		System.out.println(sb);
	}
}

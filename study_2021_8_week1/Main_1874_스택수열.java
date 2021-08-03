package study_2021_8_week1;

import java.io.*;
import java.util.Stack;

/**
 * @author anna
 * @date 2021.08.03
 * @summary 
 * BOJ-silver3  128MB/2s (26336KB/328ms)
 * 1~n 으로 이루어진 수열
 * push시 +, pop시 - 출력
 * 수열을 만들 수 없는 경우 NO 출력
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
		int index = 0; //permu index
		int start = 1; //stack에 input할 값
		int max = 0;   //stack에 넣은 최대값
		while(index<N) {
			int n = permu[index];
			//n을 스택에 넣은 적 있는 경우
			if(n <= max && !stack.isEmpty()) {
				//스택의 peek가 아닌 경우 수열을 계속 진행할 수 없다.
				if(stack.peek()!=n) {
					System.out.println("NO");
					System.exit(0);					
				}
				//스택의 peek인 경우 pop하고 계속 진행
				else {
					stack.pop();	
					sb.append("-\n");
					index++;
				}
			}
			//n을 스택에 넣은 적 없는 경우 -> 추가
			else {
				stack.push(start);
				max = start;
				start++;
				sb.append("+\n");
			}
		}
		System.out.println(sb);
	}
}

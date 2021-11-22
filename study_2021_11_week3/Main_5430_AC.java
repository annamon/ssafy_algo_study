package study_2021_11_week3;

import java.util.*;
import java.io.*;

/**
 * @author anna
 * @date 2021.11.21
 * @summary 
 * BOJ-gold5  256MB/1s (KB/ms)
 * R 뒤집기 : 배열에 있는 숫자의 순서 뒤집기
 * D 버리기 : 첫 번째 숫자 버리기
 * 배열이 비어있는데 D 사용한 경우 에러 error 출력
 * 최종 결과 구하기
 * 
 * T : 테스트케이스, 1~100
 * p : 수행할 함수. 1~100,000
 * n : 배열에 들어있는 수의 개수 0~100,000
 */
public class Main_5430_AC {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int t = 0; t < T; t++) {
			String order = br.readLine(); //명령
			char[] ord = order.toCharArray(); //명령배열
			int N = Integer.parseInt(br.readLine()); //배열 수
			Deque<String> dq = new LinkedList<>();
			String input = br.readLine();
			input = input.substring(1, input.length()-1); //수
			if(N!=0) {
				st = new StringTokenizer(input, ","); //수 뜯기
			}
			else { //수 없는 경우
				if(order.contains("D")) System.out.println("error");
				else System.out.println("[]");
				continue;
			}
			//수 넣기
			for (int i = 0; i < N; i++) {
				dq.add(st.nextToken());
			}
			boolean left = true; //방향
			boolean error = false; //에러유무
			for (int i = 0; i < ord.length; i++) {
				if(ord[i]=='R') left = !left; //방향바꾸기
				else {
					if(dq.isEmpty()) {
						error = true;
						break;
					}
				}
				if(left) dq.pollFirst(); //방향따라 꺼내기
				else dq.pollLast();
			}
			//다 했는데 에러 안 난 경우 = 출력
			if(!error) {
				System.out.print("[");
				if(left) {
					while(dq.size()>1) System.out.print(dq.pollFirst() + ",");
				}
				else {
					while(dq.size()>1) System.out.print(dq.pollLast() + ",");
				}
				if(dq.size()!=0) System.out.print(dq.getFirst());
				System.out.println("]");
			}
			else System.out.println("error");
		}
	}

}

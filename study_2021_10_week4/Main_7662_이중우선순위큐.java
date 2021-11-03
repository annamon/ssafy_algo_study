package study_2021_10_week4;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.11.01
 * @summary 
 * BOJ-gold5  256MB/6s (KB/ms)
 * T : 테스트 데이터 수
 * K : 연산 개수 ~1,000,000
 * D 1 : 최댓값 삭제
 * D -1 : 최솟값 삭제
 * I n : n 삽입
 * 큐 빈 경우 D 무시 가능
 * 
 * 연산 처리 후 남은 최대, 최소 값 출력. 빈 경우 EMPTY 출력
 */
public class Main_7662_이중우선순위큐 {

	static int T, K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minQue = new PriorityQueue<>();
			K = Integer.parseInt(br.readLine());
			for (int k = 0; k < K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				char C = st.nextToken().charAt(0);
				int N = Integer.parseInt(st.nextToken());
				if(C=='I') {
					maxQue.add(N);
					minQue.add(N);
				}
				else {
					if(maxQue.isEmpty()) continue;
					if(N==1) {
						int max = maxQue.poll();
						minQue.remove(max);
					}
					else {
						int min = minQue.poll();
						maxQue.remove(min);
					}
				}
			}
			if(maxQue.isEmpty()) System.out.println("EMPTY");
			else System.out.println(maxQue.poll() + " " + minQue.poll());
		}
		
	}

}

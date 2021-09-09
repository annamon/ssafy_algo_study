package study_2021_9_week2;

import java.util.*;

/**
 * @author anna
 * @date 2021.09.09
 * @summary 
 * BOJ-silver4  128MB/2s (44224KB/168ms)
 * N장의 카드, 순서 1~N, 1이 맨 위
 * 맨 위 카드 버리기, 맨 위 카드 -> 맨 밑으로 옮기기
 * 카드 한 장 남을 때까지 위 반복
 * 마지막으로 남는 카드 구하기
 * 
 * N : 1~500,000
 */
public class Main_2164_카드2 {

	static int N;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		//카드가 1장인 경우
		if(N==1) System.out.println(1);
		//카드가 2장 이상인 경우
		else {
			Queue<Integer> q = new LinkedList<>();
			//카드 준비
			for (int i = 1; i <= N; i++) q.add(i);
			//1장 남을 때 까지 반복
			while(q.size()!=1) {
				q.poll(); //맨 위 카드 버리기
				q.add(q.poll()); //맨 위 카드 맨 아래로
			}
			//마지막 한 장 남은 카드 출력
			System.out.println(q.poll());
		}		
		scann.close();
	}
}

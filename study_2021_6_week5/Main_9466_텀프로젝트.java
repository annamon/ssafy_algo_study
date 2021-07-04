package study_2021_6_week5;

import java.util.*;

/**
 * @author anna
 * @date 2021.07.03
 * @summary 
 * BOJ-gold4  256MB/3s (KB/ms)
 * 프로젝트 같이 하고 싶은 학생 1명 선택
 * 자기 자신 선택 가능
 * 팀 구성 : 사이클 이루는 경우에만 가능
 * 어느 팀에도 속하지 않는 학생 수 계산하기
 * 
 * T : 테스트케이스 수
 * N : 학생 수  (2≤n≤100,000)
 * 
 */
public class Main_9466_텀프로젝트 {

	static int T, N, answer;
	static int[] want;
	static boolean[] selected;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 0; t < T; t++) {
			N = scann.nextInt();
			want = new int[N+1];
			selected = new boolean[N+1];
			answer = 0;
			for (int i = 1; i <= N; i++) {
				want[i] = scann.nextInt();
			}
			for (int i = 1; i <= N; i++) {
				if(selected[i]) continue;
				else if(want[i]==i) {
					selected[i] = true;
					answer++;
				}
				else check(i);
			}
			System.out.println(N - answer);
		}
	}
	
	static List<Integer> member = new ArrayList<>();
	private static void check(int start) {
		member.clear();
		boolean can = false;
		int now = start;
		int next = 0;
		while(true) {
			next = want[now];
			if(next == start) {
				answer += member.size() + 1;
				break;
			}
			else if(member.contains(next)) {
				break;
			}
			else {
				member.add(next);
				now = next;
			}
		}
	}
	

}

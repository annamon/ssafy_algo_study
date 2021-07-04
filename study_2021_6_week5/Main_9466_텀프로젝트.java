package study_2021_6_week5;

import java.util.*;

/**
 * @author anna
 * @date 2021.07.04
 * @summary 
 * BOJ-gold4  256MB/3s (302876KB/3916ms)
 * 프로젝트 같이 하고 싶은 학생 1명 선택
 * 자기 자신 선택 가능
 * 팀 구성 : 사이클 이루는 경우에만 가능
 * 어느 팀에도 속하지 않는 학생 수 계산하기
 * 
 * T : 테스트케이스 수
 * N : 학생 수  (2≤n≤100,000)
 * answer : 팀 구성 완료된 친구 수
 * team_num : 현재 팀 찾기 번호
 * want[] : index=내번호, want[index]=원하는 친구 번호
 * selected[] : 팀 구성 현황
 * member_list : 현재 팀 후보
 */
public class Main_9466_텀프로젝트 {

	static int T, N, answer, team_num = 1;
	static int[] want;
	static int[] selected;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 0; t < T; t++) {
			N = scann.nextInt();
			want = new int[N+1];
			selected = new int[N+1];
			answer = 0;
			for (int i = 1; i <= N; i++) {
				want[i] = scann.nextInt();
			}
			for (int i = 1; i <= N; i++) {
				//체크 안 한 친구인 경우
				if(selected[i]==0) {
					selected[i] = team_num;
					if(want[i]==i) answer++; //혼자서 팀 하는 경우
					else check(i); //그 외 경우 팀원 찾기
					team_num++;
				}
			}
			System.out.println(N - answer);
		}
		scann.close();
	}
	
	static Stack<Integer> memberList = new Stack<>();
	private static void check(int start) {
		memberList.clear();
		memberList.add(start);
		int now = start;
		int next = 0;
		while(true) {
			next = want[now]; //다음 친구 지목
			//지목한 친구가 처음 시작한 친구인 경우
			if(next == start) {
				makeTeam(start);
				break;
			}
			//지목한 친구가 처음 시작은 아니지만 우리팀 후보에 있는 경우
			else if(selected[next]==team_num) {
				makeTeam(next);
				break;
			}
			//지목한 친구가 이미 다른 팀 후보에 있는 경우
			else if(selected[next]!=0) break;
			//그 외 경우 팀 후보에 친구 추가
			else {
				memberList.add(next);
				selected[next] = team_num;
				now = next;
			}
		}
	}
	
	//팀구성
	private static void makeTeam(int first) {
		int count = 0;
		//첫 번째 친구까지 모두 한 팀
		while(!memberList.isEmpty()) {
			int now = memberList.pop();
			count++;
			if(now == first) break;
		}
		answer += count;
	}
}

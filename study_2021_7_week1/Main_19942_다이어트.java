package study_2021_7_week1;

import java.util.*;

/**
 * @author anna
 * @date 2021.07.05
 * @summary 
 * BOJ-gold5  512MB/2s (15616KB/152ms)
 * 식재료 N개 중에 일부 고르기
 * 최소 비용으로 단,탄,지,비 일정 조건 만족시키는 조합?
 * 
 * N : 식재료 수 (3~15)
 * answer : 최소 비용
 * min : 최저 영양소 기준, 영양소 합>0
 * list[] : 식재료별 영양소 정보 배열
 * selected[] : 식재료 선택여부
 * answerList : 정답 식재료  
 * 부분집합으로 풀기.
 */
public class Main_19942_다이어트 {

	static class nutrient {
		int n1, n2, n3, n4, cost;
		public nutrient(int n1, int n2, int n3, int n4, int cost) {
			super();
			this.n1 = n1;
			this.n2 = n2;
			this.n3 = n3;
			this.n4 = n4;
			this.cost = cost;
		}
	}
	static int N, answer = Integer.MAX_VALUE;
	static nutrient min;
	static nutrient[] list;
	static boolean[] selected;
	static List<Integer> answerList = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		//최저 영양소 조건
		min = new nutrient(scann.nextInt(), scann.nextInt(),
				scann.nextInt(), scann.nextInt(), 0);
		list = new nutrient[N+1];
		selected = new boolean[N+1];
		//식재료 정보 배열
		for (int i = 1; i <= N; i++) {
			list[i] = new nutrient(scann.nextInt(), scann.nextInt(),
				scann.nextInt(), scann.nextInt(), scann.nextInt());
		}
		//부분집합 진행
		np(1);
		//조건 만족하는 답이 없는 경우
		if(answerList.isEmpty()) System.out.println(-1);
		//조건 만족하는 답이 있는 경우
		else {			
			System.out.println(answer);
			for(int i : answerList) {
				System.out.print(i+" ");
			}
		}
		scann.close();
	}
	
	//부분집합
	private static void np(int cnt) {
		if(cnt == N+1) {
			int n1 = 0, n2 = 0, n3 = 0, n4 = 0, cost = 0;
			for (int i = 1; i <= N; i++) {
				if(selected[i]) { //선택한 식재료
					//식재료 영양소가 모두 0이면 선택하지 않는다.
					if(list[i].n1 + list[i].n2 + list[i].n3 + list[i].n4 == 0) return;
					//그 외
					n1 += list[i].n1;
					n2 += list[i].n2;
					n3 += list[i].n3;
					n4 += list[i].n4;
					cost += list[i].cost;
				}
			}
			//최저 영양소 조건 만족하면서
			if(n1>=min.n1 && n2>=min.n2 && n3>=min.n3 && n4>=min.n4) {
				//비용이 낮은 경우 선택
				if(cost < answer) {
					answer = cost;
					answerList.clear();
					for (int i = 1; i <= N; i++) {
						if(selected[i]) answerList.add(i);
					}
				}
			}
			return;
		}
		//부분집합 선택
		selected[cnt] = true;
		np(cnt+1);
		selected[cnt] = false;
		np(cnt+1);
	}
	
	

}

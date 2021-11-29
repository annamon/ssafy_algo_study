package study_2021_11_week4;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.11.29
 * @summary 
 * BOJ-gold5  128MB/1s (11632KB/92ms)
 * 부전승을 여러번 만들더라도 랭킹 차이 비슷하게 만들기
 * 추첨된 순서대로 배치
 * 왼쪽에서 오른쪽 순서가 어긋나지 않도록 시합 정하기
 * 랭킹 차이의 총 합의 최소값 구하기
 * 같은 랭킹은 없다.
 * 
 * N : 선수 수 1~256
 */
public class Main_2262_토너먼트 {

	static int N, answer;
	static List<Integer> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int n = 0; n < N; n++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < N-1; i++) {
			//가장 랭킹 낮은 선수 찾기
			int max = 0;
			for (int k = 0; k < list.size(); k++) {
				if(list.get(k)>max) max = list.get(k);
			}
			int index = list.indexOf(max); //가장 낮은 랭킹 위치
			if(index == 0) { //맨 첫번째 선수가 랭킹이 가장 낮은 경우
				answer += list.get(index) - list.get(index+1); //첫번째와 두번째 선수
			}
			else if(index == list.size()-1) { //맨 마지막 선수가 랭킹이 가장 낮은 경우
				answer += list.get(index) - list.get(index-1); //맨 마지막, 그 직전 선수
			}
			else { //그외경우 좌우선수중 가장 차이 적은 것 먼저
				answer += Math.min(list.get(index)-list.get(index+1), 
						list.get(index)-list.get(index-1));
			}
			//선수 제외
			list.remove(list.get(index));
		}
		System.out.println(answer);
	}

}

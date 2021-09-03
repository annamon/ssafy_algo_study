package study_2021_9_week1;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.03
 * @summary 
 * BOJ-gold5  128MB/2s (11664KB/84ms)
 * 현재 0, 현재 책 위치도 0
 * 책 원래 위치 주어지고 모두 제자리에 두는 최소 걸음 수 구하기
 * 마지막 책 두고 0으로 돌아올 필요 없음
 * 한 번에 최대 M권 들기 가능
 * 책 위치 0 아니고, 절댓값 1~10,000
 * 
 * N : 책 개수, 1~10,000
 * M : 한 번에 들 수 있는 책 수, 1~10,000
 * answer : 정답
 * max : 가장 멀리 있는 책까지의 걸음 수
 * negative, positive : 책 위치 음수, 양수 리스트
 */
public class Main_1461_도서관 {
	
	static int N, M, answer, max;
	static List<Integer> negative, positive;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		negative = new ArrayList<>();
		positive = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		//책 위치 음수, 양수 별로 나누어 저장하기
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num>0) positive.add(num);
			else negative.add(num);
		}
		//음수 경우 오름차순, 양수는 내림차순 정렬
		Collections.sort(negative);
		Collections.sort(positive, Collections.reverseOrder());
		//걸음 수 체크
		check(negative);
		check(positive);
		//총 걸음 수에서 가장 먼 책까지의 걸음 수 빼기
		System.out.println(answer - max);
	}
	
	//걸음 수 체크
	private static void check(List<Integer> books) {
		int index = 0; //현재 책 index
		int step = 0;  //한 번 이동시 최대 걸음수
		int bookNum = 0; //들고 갈 책의 수
		int sum = 0;     //걸음수 합
		while(true) {
			//마지막 이동인 경우
			if(index == books.size()) {
				sum += step * 2; //왕복 걸음수
				answer += sum; //정답에 걸음수 합 더하기
				break;
			}	
			//책 최대로 든 경우 걸음수 계산 후 초기화
			if(bookNum == M) {
				sum += step * 2;
				bookNum = 0;
				step = 0;
			}
			//책 아직 최대로 들지 않은 경우
			else {
				//책을 처음 든 경우 = 가장 먼 위치의 책을 걸음수로 지정
				if(bookNum==0) {
					step = Math.abs(books.get(index));
					//가진 책 중 가장 먼 위치인지 확인
					max = Math.max(max, Math.abs(books.get(index)));
				}
				//책 index, 들고 있는 책 개수 증가
				index++;
				bookNum++;
			}
		}
	}

}

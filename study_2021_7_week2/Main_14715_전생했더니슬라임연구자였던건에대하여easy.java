package study_2021_7_week2;

import java.util.*;

/**
 * @author anna
 * @date 2021.07.18
 * @summary 
 * BOJ-silver1  512MB/0.5s (12868KB/116ms)
 * 슬라임 에너지 : 2이상 자연수
 * K에너지 슬라임 = A에너지 슬라임 x B에너지 슬라임 (A,B 2이상)
 * 슬라임 분할시 흠집 하나씩 생김
 * 흠집 T개 슬라임 분해 -> 흠집 T+1 슬라임 2마리
 * ex) 흠집1, 에너지24 -> 흠집2,에너지4 & 흠집2,에너지6
 * 슬라임 끝까지 분해했을 때 가장 많이 생긴 흠집의 개수 최소값 출력
 * K : 첫 에너지 (2 ≤K≤1,000,000) 
 * start : 시작 수
 * num : 나눌 수
 * until : 종료조건
 * count : 소인수분해 결과 약수 수
 */
public class Main_14715_전생했더니슬라임연구자였던건에대하여easy {
	
	static int K, start, num, until, count;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		K = scann.nextInt();
		start = K; //시작수 10
		num = 2; //나눌수
		until = start/2; //종료조건 5
		while(true) {
			//가능한 약수 다 체크해본 경우(약수 쌍의 절반 확인한 경우)
			if(num>until) {
				count++; //소인수 개수 증가
				break;
			}
			//약수인 경우
			if(start%num==0) {
				start /= num; //나누기
				until = start/2;
				num = 2; //나눌 수 초기화
				count++;
			}
			//약수가 아닌 경우
			else {
				num++; //수 증가
			}
		}
		//레벨 = log2(리프)
		System.out.println((int)Math.ceil(Math.log10(count)/Math.log10(2)));
		scann.close();
	}

}

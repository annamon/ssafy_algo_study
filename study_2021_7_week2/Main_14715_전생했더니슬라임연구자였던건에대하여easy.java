package study_2021_7_week2;

import java.util.*;

/**
 * @author anna
 * @date 2021.07.18
 * @summary 
 * BOJ-silver1  512MB/0.5s (KB/ms)
 * 슬라임 에너지 : 2이상 자연수
 * K에너지 슬라임 = A에너지 슬라임 x B에너지 슬라임 (A,B 2이상)
 * 슬라임 분할시 흠집 하나씩 생김
 * 흠집 T개 슬라임 분해 -> 흠집 T+1 슬라임 2마리
 * ex) 흠집1, 에너지24 -> 흠집2,에너지4 & 흠집2,에너지6
 * 슬라임 끝까지 분해했을 때 가장 많이 생긴 흠집의 개수 최소값 출력
 * K : 첫 에너지 (2 ≤K≤1,000,000) 
 */
public class Main_14715_전생했더니슬라임연구자였던건에대하여easy {
	
	static int K, start, num, until, count;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		K = scann.nextInt();
		start = K;
		num = 2;
		until = start/2;
		while(true) {
			if(num>until) {
				count++;
				break;
			}
			if(K%num==0) {
				start /= num;
				until = start/2;
				num = 2;
				count++;
			}
			else {
				num++;
			}
		}
		if(start == K) System.out.println(0);
		else if(count%2==1) System.out.println(count/2 +1);
		else System.out.println(count/2);
		scann.close();
	}

}

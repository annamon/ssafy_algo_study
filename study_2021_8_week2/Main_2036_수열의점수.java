package study_2021_8_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author anna
 * @date 2021.08.11
 * @summary 
 * BOJ-silver1  128MB/2s (31196KB/868ms)
 * n개 정수로 이루어진 수열
 * 정수 제거 or 두 정수 제거
 * 한 정수 제거시 그 정수가 점수가 됨
 * 두 정수 제거시 두 정수의 곱이 점수가 됨
 * 점수 총 합 최대 구하기
 * 
 * N : 정수 개수, 1~100,000 / 각 정수값 1,000,000이하
 * plus : 양수인 정수 리스트
 * minus : 음수인 정수 리스트
 */
public class Main_2036_수열의점수 {
	
	static int N;
	static long answer;
	static List<Integer> plus, minus;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		plus = new ArrayList<>();
		minus = new ArrayList<>();
		int zero = 0;
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) zero++;
			else if(n==1) answer++; //1인 경우 곱하지 말고 그냥 더하기
			else if(n>1) plus.add(n);
			else minus.add(n);
		}
		//양수, 내림차순
		plus.sort(Comparator.reverseOrder());
		while(!plus.isEmpty()) {
			if(plus.size()>1) {
				long n = (long)plus.get(0) * (long)plus.get(1);
				answer += n;
				plus.remove(0);
				plus.remove(0);
			}else {
				answer += plus.get(0);
				plus.remove(0);
			}
		}
		//음수, 오름차순
		minus.sort(Comparator.naturalOrder());
		while(!minus.isEmpty()) {
			if(minus.size()>1) {
				long n = (long)minus.get(0) * (long)minus.get(1);
				answer += n;
				minus.remove(0);
				minus.remove(0);
			}else {
				//0이 없는 경우에는 그대로 더하기
				if(zero==0) answer += minus.get(0);
				//0이 있는 경우에는 소멸시키기
				minus.remove(0);
			}
		}
		System.out.println(answer);
	}

}

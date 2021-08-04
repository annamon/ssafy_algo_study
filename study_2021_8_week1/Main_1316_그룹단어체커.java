package study_2021_8_week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author anna
 * @date 2021.08.05
 * @summary 
 * BOJ-silver5  128MB/2s (11560KB/80ms)
 * 그룹 단어 : 각 문자가 연속해서 나타나는 경우의 단어
 * abc, aabb는 그룹 단어임
 * abca는 그룹 단어가 아님
 * N개의 단어 중 그룹 단어 개수 출력
 * 
 * N : 1~99
 * answer : 정답
 * alpha[] : 알파벳별 사용 여부 체크 배열
 */
public class Main_1316_그룹단어체커 {

	static int N, answer;
	static int[] alpha;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = N;
		for (int i = 0; i < N; i++) {
			alpha = new int[26];
			String s = br.readLine();
			//맨 첫 문자 체크
			int before = s.charAt(0) -97;
			alpha[before]++;
			//이후 문자 체크
			for (int j = 1; j < s.length(); j++) {
				int now = s.charAt(j) - 97;
				//이전에 쓴 적 있는 문자인 경우
				if(alpha[now]!=0) {
					//바로 직전 문자가 아니면 종료 = 연속이 아니다.
					if(now!=before) {
						answer--;
						break;
					}
				}
				//쓴 적 없는 문자인 경우 체크
				alpha[now]++;
				before = now;
			}
		}
		System.out.println(answer);
	}

}

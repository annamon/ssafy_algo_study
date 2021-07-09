package study_2021_7_week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author anna
 * @date 2021.07.09
 * @summary 
 * BOJ-gold5  256MB/1s (17864KB/2296ms)
 * R행 C개의 열
 * 열 위에서 아래로 읽어서 하나의 문자열 만들 수 있음
 * 맨 위 행 지워도 만든 문자열 중복되지 않는다면 맨 위 행 지우고 count+1
 * 같은 문자열 발견시 반복 멈추고 count 개수 출력 후 종료
 * 
 * R, C :  (2≤ R,C ≤1000)
 * words[] : 문자열 보관 배열
 */
public class Main_2866_문자열잘라내기 {

	static int R, C, answer = 1000;
	static String[] words;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		words = new String[R];
		for (int i = 0; i < R; i++) {
			words[i] = br.readLine();
		}
		//맨 마지막 문자열 비교
		for (int i = 0; i < C-1; i++) {
			//문자가 같으면 check 시작
			char now = words[R-1].charAt(i);
			for (int j = i+1; j < C; j++) {
				if(now == words[R-1].charAt(j)) {
					check(i, j);
				}
			}
		}
		if(answer==1000) System.out.println(R-1); //같은 문자가 하나도 없는 경우
		else System.out.println(answer);
	}
	private static void check(int w1, int w2) {
		int index = R-1; //맨끝 문자열부터 시작
		int count = 0;
		while(index>0) {
			//한 줄씩 올라가며 비교. 같으면 계속 올라가기
			if(words[index].charAt(w1) == words[index].charAt(w2)) {
				index--;
				count++;
			}
			//다른 문자 나오면 종료
			else break;
		}
		//전체 행 개수 - 맨 첫 번째 행 - 같은 라인 수
		answer = Math.min(answer, R - 1 - count);
	}
}

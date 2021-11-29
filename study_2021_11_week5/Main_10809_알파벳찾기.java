package study_2021_11_week5;

import java.util.*;

/**
 * @author anna
 * @date 2021.11.30
 * @summary 
 * BOJ-bronze2  256MB/1s (12800KB/104ms)
 * 각 알파벳에 대해 처음 등장 위치 출력
 * 없는 경우 -1 출력
 * 
 * S : 단어, 길이 100 이하
 */
public class Main_10809_알파벳찾기 {

	static String S;
	static int[] alpha = new int[26];
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		S = scann.next();
		Arrays.fill(alpha, -1);
		for (int i = 0; i < S.length(); i++) {
			int n = S.charAt(i) - 97;
			if(alpha[n]==-1) alpha[n] = i;
		}
		for (int i = 0; i < 26; i++) {
			System.out.print(alpha[i] + " ");
		}
		scann.close();
	}

}

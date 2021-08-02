package study_2021_7_week4;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.08.1
 * @summary 
 * BOJ-gold5  512MB/2s (20616KB/312ms)
 * 회문 : 앞으로 읽으나 뒤로 읽으나 같은 문자
 * 문자열 길이 1~50
 * 회문이 아닌 가장 긴 부분문자열 길이 출력,
 * 없으면 -1 출력 
 * 
 * left : 왼쪽 index
 * right : 오른쪽 index
 * same : 같은지 여부
 */
public class Main_15927_회문은회문아니야 {

	static String s;
	static int left, right;
	static boolean same = true;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		s = scann.next();
		left = 0;
		right = s.length()-1;
		//시작과 끝이 다른 경우
		if(s.charAt(left)!=s.charAt(right)) System.out.println(s.length());
		else {
			//모든 글자가 같은 경우
			for (int i = 0; i < s.length()-1; i++) {
				if(s.charAt(i)!=s.charAt(i+1)) {
					same = false;
					break;
				}
			}
			if(same) System.out.println(-1);
			//그 외 경우
			else {
				//대칭 체크
				same = true;
				while(true) {
					left++;
					right--;
					if(left+1>=right) break;
					if(s.charAt(left)!=s.charAt(right)) {
						same = false;
						break;
					}
				}
				//대칭인 경우
				if(same) System.out.println(s.length()-1);
				//대칭이 아닌 경우
				else System.out.println(s.length());
			}
		}
		scann.close();
	}

}

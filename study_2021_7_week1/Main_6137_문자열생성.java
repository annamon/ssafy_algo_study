package study_2021_7_week1;

import java.util.Scanner;

/**
 * @author anna
 * @date 2021.07.06
 * @summary 
 * BOJ-gold4  128MB/1s (19048KB/200ms)
 * N개 문자로 이루어진 문자열 S
 * 각 문자들로 새로운 문자열 T 만들기
 * 1. S 가장 앞 문자 하나를 T 마지막에 추가
 * 2. S 가장 뒤 문자 하나를 T 마지막에 추가
 * T중 사전순으로 가장 빠른 문자열 출력
 * 80글자마다 새줄 문자 출력
 * 
 * N : 문자 개수 (N<=2000)
 * start : 시작점, 현재 문자 index (앞쪽)
 * end : 끝점, 현재 문자 index (뒤쪽)
 * alpha[] : 문자 배열, 아스키코드 int (A:65)
 */
public class Main_6137_문자열생성 {

	static int N, start, end;
	static int[] alpha;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = Integer.parseInt(scann.nextLine());
		alpha = new int[N+1];
		start = 1;
		end = N;
		for (int i = 1; i <= N; i++) {
			String s = scann.nextLine();
			alpha[i] = s.charAt(0);
		}
		for (int i = 1; i <= N; i++) {
			int startP = start; //시작점에서 시작
			int endP = end;  //끝점에서 시작
			//두 포인터가 만나기 전까지 시작점과 끝점 사이 한 칸씩 줄여가며 알파벳 순서 비교
			while(startP+1<endP) {
				//같은 알파벳인 경우 계속 진행
				if(alpha[startP] == alpha[endP]) {
					startP++;
					endP--;
				}
				//다은 알파벳인 경우 종료
				else break;
			}
			//끝쪽에 알파벳이 더 큰 경우 앞쪽 알파벳 사용
			if(alpha[startP] > alpha[endP]) useEnd(end);
			//그 외 경우 뒤쪽 알파벳 사용
			else useStart(start);
			if(i%80==0) System.out.println();
		}
		scann.close();
	}
	
	private static void useStart(int i) {
		System.out.print((char)alpha[i]);
		start++;
	}
	private static void useEnd(int i) {
		System.out.print((char)alpha[i]);
		end--;
	}
}

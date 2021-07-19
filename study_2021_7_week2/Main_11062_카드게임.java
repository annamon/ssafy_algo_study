package study_2021_7_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author anna
 * @date 2021.07.18
 * @summary 
 * BOJ-gold3  256MB/1s (KB/ms)
 * 자기 턴에 맨 왼쪽 혹은 맨 오른쪽 카드 가져가기 가능
 * 점수 = 가져간 카드에 적힌 수의 합
 * 근우부터 시작, 근우의 점수 구하기
 * 
 * N : 카드 개수 1≤N≤1,000
 * 왜 스택오버플로우 ㅡㅡ
 */
public class Main_11062_카드게임 {
	static int T, N, woo;
	static int[] card;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			card = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				card[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println(game(0, N-1, true));
		}
	}
	
	private static int game(int left, int right, boolean turn) {
		//카드 두 장 남은 경우
		if(left+1==right) {
			if(turn) return Math.max(card[left], card[right]); //건우차례
			else return Math.min(card[left], card[right]);	//명우차례	
		}
		//건우차례
		if(turn) {
			return Math.max((game(left+1, right, !turn) + card[left]), (game(left, right-1, !turn) + card[right]));	
		}
		//명우차례
		else {
			return Math.min(game(left+1, right, !turn), game(left, right-1, !turn));
		}
	}

}

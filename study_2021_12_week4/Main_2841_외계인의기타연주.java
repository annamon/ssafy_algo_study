package study_2021_12_week4;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.1.1
 * @summary 
 * BOJ-silver1  256MB/1s
 * 기타 1~6번줄, 각 줄은 P개의 프렛, 프렛 번호 1~P
 * 프렛 여러개 누르면 가장 높은 프렛 ㄱㄱ
 * 손가락 가장 적게 움직이는 회수 구하기
 * 
 * N : 음의 수 ~500,000
 * P : 프렛 수 2~300,000
 * 
 */
public class Main_2841_외계인의기타연주 {

	static int N, P, answer;
	static Stack<Integer>[] guitar;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		guitar = new Stack[N+1];
		for (int i = 0; i <= N; i++) {
			guitar[i] = new Stack<>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int line = Integer.parseInt(st.nextToken());
			int fret = Integer.parseInt(st.nextToken());
			//아무 프렛도 안 누른 경우
			if(guitar[line].isEmpty()) {
				guitar[line].push(fret); //누르기
				answer++; //손이동+1
				continue;
			}
			//더 큰 프렛 누른 경우 = 이미 누른 것들 손 떼기
			while(guitar[line].peek()>fret) {
				guitar[line].pop();
				answer++;
				if(guitar[line].isEmpty()) break;
			}
			//같은 프렛 누른 경우
			if(!guitar[line].isEmpty() && guitar[line].peek()==fret) continue;
			guitar[line].push(fret);
			answer++;
		}
		System.out.println(answer);
	}

}

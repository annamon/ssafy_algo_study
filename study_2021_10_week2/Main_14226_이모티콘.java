package study_2021_10_week2;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.10.18
 * @summary 
 * BOJ-gold5  512MB/2s (KB/ms)
 * 1. 화면의 임티 모두 복사해 클립보드에 저장
 * 2. 클립 보드에 있는 모든 임티 화면에 붙여넣기
 * 3. 화면에 있는 임티 중 하나 삭제
 * 모든 연산은 1초 걸림
 * 임티 복사하면 이전 클립보드 내용은 덮어쓰기 됨
 * 화면에 붙여넣기 하면 클립보드에 있는 이모티콘 개수 추가됨
 * 
 * S : 만들 이모티콘 개수
 */
public class Main_14226_이모티콘 {

	public static class Emoji {
		int clip;
		int view;
		int time;
		public Emoji(int clip, int view, int time) {
			super();
			this.clip = clip;
			this.view = view;
			this.time = time;
		}
	}
	static int S;
	static boolean[] made = new boolean[1002];
	static Queue<Emoji> em = new LinkedList<>();
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		S = scann.nextInt();
		em.add(new Emoji(0,1,0));
		while(!em.isEmpty()) {
			Emoji now = em.poll();
			if(now.view == S) {
				System.out.println(now.time);
				break;
			}
			//1.화면에 있는 이모티콘 모두 복사해서 클립보드에 저장
			em.add(new Emoji(now.view, now.view, now.time+1));
			//2.클립보드에 있는 이모티콘 화면에 붙여넣기
			if(now.clip+now.view<=S+1) {
				if(now.clip!=0 && !made[now.clip+now.view]) {
					em.add(new Emoji(now.clip, now.clip+now.view, now.time+1));
					made[now.clip+now.view] = true;
				}				
			}
			//3.화면에 있는 이모티콘 중 하나 삭제
			if(now.view!=0 && !made[now.view-1]) {
				em.add(new Emoji(now.clip, now.view-1, now.time+1));
				made[now.view-1] = true;
			}
			
		}
	}

}

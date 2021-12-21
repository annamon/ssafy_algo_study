package study_2021_12_week1;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.12.12
 * @summary 
 * BOJ-gold4  128MB/1s (KB/ms)
 * 일직선 상에 위치한 M개의 사대에서만 사격 가능
 * 총 사정거리 L
 * 사대x와 동물a,b간의 거리 = |x-a|+b
 *  잡을 수 있는 동물 수 출력
 *  
 *  M : 사대 수, 1~100,000
 *  N : 동물 수, 1~100,000
 *  L : 사정거리 1~1,000,000,000
 */
public class Main_8983_사냥꾼 {

	static class Animal {
		int r, c;
		public Animal(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int M, N, L, max, answer;
	static int[] gun;
	static Animal[] animals;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		gun = new int[M];
		animals = new Animal[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			gun[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(gun);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			animals[i] = new Animal(x,y);
		}
		shoot();
		System.out.println(answer);
	}
	
	private static void shoot() {
		for (int i = 0; i < N; i++) {
			int start = 0;
			int end = M-1;
			while(start <= end) {
				int mid = (start+end)/2;
				//동물-총 거리
				int d = Math.abs(gun[mid]-animals[i].r) + animals[i].c;
				if(L<d && animals[i].r < gun[mid]) end = mid-1; //사정거리 오른쪽 넘어감
				if(L<d && animals[i].r >= gun[mid]) start = mid+1; //사정거리 왼쪽 넘어감
				if(L>=d) { //사정거리 내
					answer++;
					break;
				}
			}
		}
	}

}

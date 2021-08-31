package study_2021_9_week1;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.08.31
 * @summary 
 * BOJ-silver5  256MB/1s (57236KB/940ms)
 * 2차원 평면 위에 점 N개
 * x좌표 -> y좌표 순으로 오름차순 정렬
 * 좌표 : -100,000~100,000
 * 위치 같은 점은 없다.
 * 
 * N : 1~100,000개
 * list[] : 좌표 배열
 */
public class Main_11650_좌표정렬하기 {

	public static class Point implements Comparable<Point>{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Point o) {
			//x, y순으로 오름차순 정렬
			int diff = this.x - o.x;
			return diff == 0 ? this.y - o.y : diff;
		}
	}
	
	static int N;
	static Point[] list;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		list = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(list);
		for (int i = 0; i < N; i++) {
			bw.write(list[i].x + " " + list[i].y);
			bw.newLine();
		}
		bw.flush();
	}
}

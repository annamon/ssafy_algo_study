package study_2021_11_week5;

import java.util.*;
import java.io.*;

/**
 * @author anna
 * @date 2021.12.05
 * @summary 
 * BOJ-gold4  128MB/2s (23192KB/304ms)
 * 어떤 경로를 오가야 하는가
 * 한 집하장에서 다른 집하장으로 최단 경로로 화물 이동하기 위해
 * 먼저 거쳐야 하는 집하장 찾기
 * 경로표 구하기
 * 소요시간 1,000 이하
 * 
 * N : 집하장 개수, ~200
 * M : 경로 개수, ~10,000
 */
public class Main_1719_택배 {

	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] matrix = new int[N+1][N+1];
		int[][] way = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(matrix[i], 99999);
			matrix[i][i] = 0;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			matrix[a][b] = c;
			matrix[b][a] = c;
			way[a][b] = a;
			way[b][a] = b;
		}
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(matrix[i][j] > matrix[i][k] + matrix[k][j]) {
						matrix[i][j] = matrix[i][k] + matrix[k][j];
						way[i][j] = way[k][j];
					}
				}
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i==j) bw.append("- ");
				else bw.append(way[j][i] + " ");
			}
			bw.newLine();
		}
		bw.flush();
	}

}

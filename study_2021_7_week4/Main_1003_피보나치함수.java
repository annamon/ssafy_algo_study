package study_2021_7_week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author anna
 * @date 2021.07.30
 * @summary 
 * BOJ-silver3  128MB/0.25s (11612KB/76ms)
 * 피보나치 함수 
 */
public class Main_1003_피보나치함수 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int[][] fibo;
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			fibo = new int[N+1][2];
			if(N>=0) {
				fibo[0][0] = 1;
				fibo[0][1] = 0;
			}
			if(N>=1) {
				fibo[1][0] = 0;
				fibo[1][1] = 1;				
			}
			if(N>=2) {
				for (int n = 2; n <= N; n++) {
					fibo[n][0] = fibo[n-1][0] + fibo[n-2][0];
					fibo[n][1] = fibo[n-1][1] + fibo[n-2][1];
				}
			}
			bw.write(fibo[N][0] + " " + fibo[N][1]);
			bw.newLine();
		}
		bw.flush();
	}

}

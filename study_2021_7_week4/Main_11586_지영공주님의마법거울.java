package study_2021_7_week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author anna
 * @date 2021.07.31
 * @summary 
 * BOJ-bronze1  256MB/2s (11688KB/84ms)
 * 1이면 그대로, 2면 좌우반전, 3이면 상하반전 출력하기
 */
public class Main_11586_지영공주님의마법거울 {

	static int N, K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		String[] mirror = new String[N];
		for (int n = 0; n < N; n++) {
			mirror[n] = br.readLine();
		}
		K = Integer.parseInt(br.readLine());
		if(K==1) {
			for (String s : mirror) {
				bw.write(s);
				bw.newLine();
			}
		}
		else if(K==2) {
			for (int i = 0; i < N; i++) {
				for (int j = N-1; j >= 0; j--) {
					bw.write(mirror[i].charAt(j));
				}
				bw.newLine();
			}
		}
		else {
			for (int i = N-1; i >= 0; i--) {
				bw.write(mirror[i]);
				bw.newLine();
			}
		}
		bw.flush();
	}

}

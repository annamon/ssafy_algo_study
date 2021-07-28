package study_2021_7_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author anna
 * @date 2021.07.28
 * @summary 
 * BOJ-bronze1  128MB/2s (11616KB/92ms)
 * X 누울 수 없는 자리, . 누울 수 있는 자리
 * 연속 두 칸 이상이면 누울 수 있다
 * 
 * N : 방 크기, 1~100
 * map[][] : 방
 */
public class Main_1652_누울자리를찾아라 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N+1][N+1];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
			map[i][N]=map[N][i]='X';
		}
		if(N==1) System.out.print(0+" "+0);
		else {			
			int r=0;
			int c=0;
			for (int i = 0; i < N; i++) {
				for (int j = 2; j < N+1; j++) {
					r+= (map[i][j]=='X' && map[i][j-1]=='.' && map[i][j-2]=='.') ? 1:0;
					c+= (map[j][i]=='X' && map[j-1][i]=='.' && map[j-2][i]=='.') ? 1:0;
				}
			}
			System.out.print(r+" "+c);
		}
	}
}

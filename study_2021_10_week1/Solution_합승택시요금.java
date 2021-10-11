package study_2021_10_week1;

public class Solution_합승택시요금 {
	public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] cost = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j) continue;
                cost[i][j] = 9999999;
            }
        }
        //지점간 요금 저장
        for(int i=0; i<fares.length; i++){
            cost[fares[i][0]][fares[i][1]] = fares[i][2];
            cost[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        //플로이드와샬
        for(int k=1; k<=n; k++){ //거쳐가는 점
            for(int i=1; i<=n; i++){ //출발
                for(int j=1; j<=n; j++){ //도착
                    //i~j 다이렉트와 i~k~j 거쳐가는 것 중 최소값 저장
                    cost[i][j] = Math.min(cost[i][j], cost[i][k]+cost[k][j]);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            //i=s인 경우 합승X
            answer = Math.min(answer, cost[s][i]+cost[i][a]+cost[i][b]);
        }
        return answer;
    }
}

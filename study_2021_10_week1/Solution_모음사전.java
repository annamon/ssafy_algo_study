package study_2021_10_week1;

public class Solution_모음사전 {

	static int answer;
    static String s;
    static boolean stop;
    public int solution(String word) {
        s = word;
        check("");
        return answer;
    }
    //몇 번째인지 확인하기
    public void check(String word){
        //찾는 문자인 경우 끝
        if(word.equals(s)){
            stop = true;
            return;
        }
        //5글자까지만 체크
        if(word.length()==5) return;
        //못 찾은 경우 AEIOU 순서대로 붙이기
        if(!stop){
            answer++;
            check(word+"A");
        }
        if(!stop){
            answer++;
            check(word+"E");
        }
        if(!stop){
            answer++;
            check(word+"I");
        }
        if(!stop){
            answer++;
            check(word+"O");
        }
        if(!stop){
            answer++;
            check(word+"U");
        }
        
    }

}

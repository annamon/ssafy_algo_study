package study_2021_9_week3;

import java.io.*;
import java.util.*;

/**
 * @author anna
 * @date 2021.09.14
 * @summary 
 * BOJ-silver1  128MB/1s (11616KB/88ms)
 * 이진트리 입력받기
 * 전위, 중위, 후위 순회한 결과 출력
 * A : 루트 노드
 * 전위 : 루트 - 왼쪽자식 - 오른쪽자식
 * 중위 : 왼쪽자식 - 루트 - 오른쪽자식
 * 후위 : 왼쪽자식 - 오른쪽자식 - 루트
 * 
 * N : 노드 개수, 1~26
 * node[] : 노드 정보
 */
public class Main_1991_트리순회 {

	static class Node {
		char left;
		char right;
		public Node(char left, char right) {
			super();
			this.left = left;
			this.right = right;
		}
	}
	static int N;
	static Node[] node;
	static StringTokenizer st;
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		node = new Node[N];
		//각 노드별 자식 정보 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = st.nextToken().charAt(0) - 'A';
			node[n] = new Node(st.nextToken().charAt(0), st.nextToken().charAt(0));
		}
		//전위 순회
		preorder(0);
		bw.newLine();
		//중위 순회
		inorder(0);
		bw.newLine();
		//후위 순회
		postorder(0);
		bw.flush();
	}
	
	//전위순회 : 루트 - 왼쪽자식 - 오른쪽자식
	private static void preorder(int index) throws Exception {
		bw.append((char)(index+'A'));
		if(node[index].left != '.') preorder(node[index].left - 'A');
		if(node[index].right != '.') preorder(node[index].right - 'A');
	}
	
	//중위순회 : 왼쪽자식 - 루트 - 오른쪽자식
	private static void inorder(int index) throws Exception {
		if(node[index].left != '.') inorder(node[index].left - 'A');
		bw.append((char)(index+'A'));
		if(node[index].right != '.') inorder(node[index].right - 'A');
	}
	
	//후위순회 : 왼쪽자식 - 오른쪽자식 - 루트
	private static void postorder(int index) throws Exception {
		if(node[index].left != '.') postorder(node[index].left - 'A');
		if(node[index].right != '.') postorder(node[index].right - 'A');
		bw.append((char)(index+'A'));
	}

}

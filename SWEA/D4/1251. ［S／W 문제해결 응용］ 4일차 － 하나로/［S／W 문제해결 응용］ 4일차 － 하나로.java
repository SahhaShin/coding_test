import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class Solution {
    // 크루스칼 알고리즘
    // Union-Find 알고리즘
 
    static node[] nodes;// 정점들의 환경 부담 세율 실수가 작은 순으로 간선을 저장하는 배열
    static int[] p; // 각 정점들의 부모를 저장
    static int[][] xy;// 각 정점들의 xy값을 받는다.
    static double E;// 환경 부담 세율
    static int N;// 섬의 갯수
 
    static class node {
        int startNode;
        int endNode;
        double fee;
 
        node(int startNode, int endNode, double fee) {
            this.startNode = startNode;
            this.endNode = endNode;
            this.fee = fee;
        }
 
    }
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());// test case
 
        for (int T = 1; T < t + 1; T++) {
            N = Integer.parseInt(br.readLine());// 섬의 갯수
 
            // x,y 두번 받아야 한다.
            int[][] xy = new int[N][2]; // 0 :x -> 1:y
 
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    xy[j][i] = Integer.parseInt(st.nextToken());
                }
            }
 
            E = Double.parseDouble(br.readLine());// 환경 부담 세율
 
            // 입력 받기 끝
 
            // 구현
 
            // step1. 먼저 자기 자신을 부모로 갖는다.
            p = new int[N];
            makeNode();
 
            // step2. 모든 섬의 간선을 생성한다.
            // 환경 부담금이 적은 순으로 order 배열에 저장한다.
            nodes = new node[N * (N - 1) / 2];
            int orderIdx = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    // 거리 -> 환경 부담금 계산하기
                    double distance = Math.pow(Math.abs(xy[i][0] - xy[j][0]), 2)
                            + Math.pow(Math.abs(xy[i][1] - xy[j][1]), 2);
                    double newFee = E * Math.pow(Math.sqrt(distance), 2);
 
                    node newNode = new node(i, j, newFee);
 
                    // 새로운 노드 배열에 저장
                    nodes[orderIdx++] = newNode;
                }
            }
 
            // step3. 환경부담금 순으로 정렬시킨다.
            Arrays.sort(nodes, new Comparator<node>() {
 
                @Override
                public int compare(node o1, node o2) {
                    return o1.fee >= o2.fee ? 1 : -1;
                }
 
            });
 
            // step4. N-1개의 간선을 채택해라
            // 두 노드의 부모가 같으면 간선을 잇는 순간 순환구조가 되므로 안됨
            // N*(N-1)/2는 간선의 수
            int pick = 0;
            double fee = 0;
            for (int i = 0; i < N * (N - 1) / 2; i++) {
                int node1 = nodes[i].startNode;
                int node2 = nodes[i].endNode;
 
                if (findSet(node1) != findSet(node2)) {
                    union(node1, node2);
                    pick++;
                    fee += nodes[i].fee;
                }
 
                if (pick == N - 1)
                    break;
            }
 
            StringBuilder result = new StringBuilder();
            long gaza=Math.round(fee);
            result.append("#").append(T).append(" ").append(gaza);
            System.out.println(result);
 
        } // test case end
 
    }
 
    /**
     * 초기 셋팅 : 자신의 노드를 부모로 셋팅한다.
     */
    static public void makeNode() {
        for (int i = 0; i < N; i++) {
            p[i] = i;
        }
    }
 
    /**
     * 내 부모를 찾아줘
     */
    static public int findSet(int num) {
        if (p[num] == num)
            return num;
        return p[num] = findSet(p[num]);
    }
 
    /**
     * 이 간선을 채택하고 연결해주겠어 -> 부모를 바꿔주겠어
     */
    static public void union(int a, int b) {
        p[findSet(b)] = findSet(a);
    }
 
}
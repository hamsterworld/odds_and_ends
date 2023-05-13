package fwefw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 줄세우기 {

    private static List<Integer>[] list;
    private static boolean[] visited;
    private static int[] in_degree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        visited = new boolean[N+1];
        in_degree = new int[N+1];

        for(int i = 1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
            in_degree[B] +=1;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i<=N; i++){
            if(in_degree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int poll = queue.poll();
            for (int k : list[poll]) {
                if(in_degree[k] != 0){
                    in_degree[k] -= 1;
                }
                if(in_degree[k] == 0){
                    queue.add(k);
                    System.out.print(k+" ");
                }
            }
        }

    }
}

package fwefw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 리프노드의개수구하기 {

    private static boolean[] visited;
    private static List<Integer>[] list;
    private static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        list = new List[N];
        visited = new boolean[N];
        for(int i =0;i<N; i++){
            list[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());

        List<Integer> arrayList = new ArrayList<>();

        for (int i=0;i<N;i++){
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int i2 = Integer.parseInt(st.nextToken());
        int i3 = 0;
        for(int i =0; i<N; i++){
            int i1 = arrayList.get(i);
            if(i1 == -1){
                i3 = i;
                continue;
            }
            if(i1 == i2 || i ==i2){
                continue;
            }
            list[i1].add(i);
        }

        visited[i2] = true;
        answer = 0;

        if(!visited[i3]){
            dfs(i3);
        }

        System.out.println(answer);
    }

    private static void dfs(int i) {
        visited[i] = true;
        if(list[i].size() == 0){
            answer++;
            return;
        }
        for (int k : list[i]) {
            if(!visited[k]){
                visited[k] = true;
                dfs(k);
            }
        }

    }
}

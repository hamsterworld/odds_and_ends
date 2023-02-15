package fwefw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가기 {

    private static int[] list;
    private static int[] city;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        list = new int[N+1];

        for(int i = 1; i<=N; i++){
            list[i] = i;
        }

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N; j++){
                int i1 = Integer.parseInt(st.nextToken());
                if(i1 == 1){
                    union(i,j);
                }
            }
        }

        city = new int[M+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=M; i++){
            int i1 = Integer.parseInt(st.nextToken());
            city[i] = i1;
        }
        boolean flag = true;

        int k = 1;
        while(!(k == M)){
            if(!isUnion(city[k],city[k+1])){
                flag = false;
                break;
            };
            k++;
        }

        if(flag){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    private static int find(int index){
        if(list[index] == index){
            return index;
        }
        return list[index] = find(list[index]);
    }

    private static void union(int a,int b){
        int x = find(a);
        int y = find(b);
        if(x == y){
            return;
        }
        list[y] = x;
    }

    private static boolean isUnion(int x, int y){
        int x1 = find(x);
        int y1 = find(y);
        return x1 == y1;
    }


}

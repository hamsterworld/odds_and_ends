package fwefw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 거짓말쟁이가되기싫어 {

    private static int[] knowPeople;
    private static int[] firstPeople;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        knowPeople = new int[N+1];
        for (int i = 1; i<=N; i++){
            knowPeople[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        firstPeople = new int[L];

        for (int i =0; i<L; i++){
            int k = Integer.parseInt(st.nextToken());
            firstPeople[i] = k;
        }

        for(int i = 0; i<L-1; i++){
            union(firstPeople[i],firstPeople[i+1]);
        }

        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            for (int j = 1; j<=T; j++){
                int i1 = Integer.parseInt(st.nextToken());
                if(isUnion(firstPeople[0],i1)){

                }
            }
        }


    }


    private static boolean isUnion(int x,int y){
        int a = find(x);
        int b = find(y);
        if( a == b ){
            return true;
        }
        return false;
    }

    private static int find(int x){
        if(x == knowPeople[x]){
            return x;
        }
        return knowPeople[x] = find(knowPeople[x]);
    }

    private static void union(int x,int y){
        int a = find(x);
        int b = find(y);
        if( a == b){
            return;
        }
        knowPeople[a] = b;
    }
}

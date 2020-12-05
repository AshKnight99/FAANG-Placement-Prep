/*
Spoj question

AGGRCOW - Aggressive cows
#binary-search
Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).

His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
Input
t – the number of test cases, then t test cases follows.
* Line 1: Two space-separated integers: N and C
* Lines 2..N+1: Line i+1 contains an integer stall location, xi
Output
For each test case output one integer: the largest minimum distance.
Example
Input:

1
5 3
1
2
8
4
9
Output:

3
Output details:

FJ can put his 3 cows in the stalls at positions 1, 4 and 8,
resulting in a minimum distance of 3

*/
import java.io.*;
import java.util.*;

class AGGRCOW {

    public static void main(String args[])throws IOException{
     
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
     int T = Integer.parseInt(br.readLine());
     
     while(T-- != 0){
     
     String inp[] = br.readLine().split(" ");
     
     int N = Integer.parseInt(inp[0]);
     int C = Integer.parseInt(inp[1]);
     
     int arr[] = new int[N];
     for(int i = 0; i < N; i++){
     arr[i] = Integer.parseInt(br.readLine());
     
     }
     Arrays.sort(arr);
     
     int low = 0,high = arr[N - 1], mid , max = -1;
     
     while(low < high){
     
     mid = (low + high) / 2;
     
     if(isPossible(arr, mid, C)){
     if(max < mid){
     max = mid;
     }
     low = mid+1;
     }else{
     high = mid;
     }
     
     }
     
     System.out.println(max);
     
     }
     
    }
    
    public static boolean isPossible(int arr[],int d,int cows){
     int pre = arr[0], c = 1;
     for(int i = 1;i < arr.length; i++){
     if(arr[i] - pre >= d){
     pre = arr[i];
     c ++;
     if(c == cows){
     return true;
     }
     }
     }
     return false;     
    }    
}
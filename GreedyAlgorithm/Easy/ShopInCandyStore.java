import java.util.*;

import javax.sound.sampled.SourceDataLine;

public class ShopInCandyStore {
  public static void main(String[] args) {
    int N = 4;
    int K = 2;
    int candies[] = {3,2,1,4};

    Arrays.sort(candies);
    int max=0;int min=0;
    //for getting candies in min amount
    int i=0;int j=N-1;
    while(i<=j){
      min+=candies[i];
      i++;
      j-=K;
    }
    //for getting candies in max amount
    i=0;j=N-1;
    while(i<=j){
      max+=candies[j];
      i+=K;
      j--;
    }
    ArrayList<Integer>ans=new ArrayList<>();
    ans.add(min);
    ans.add(max);
    System.out.println("Minimum Cost is :"+min);
    System.out.println("Maximum cost is :"+max);
  }
}
//time complexity:O(nlogn)
//space complexity:O(1)

//dry run 
//after sorting array is 1234
//for min : min=1 i++ and j-=K so i=1 j=1
//          min=1+2=3 and as i=2 j=-1 so out of loop with min=3

//for max: max=4 i=2 j=2
//        max=4+3=7 and out of loop
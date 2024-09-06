import java.util.*;
public class MinimumCoins{
  public static void main(String[] args) {
    int V=49;
    ArrayList<Integer>ans=new ArrayList<>();
    int coins[]={1,2,5,10,20,50,100,500,1000};
    int n=coins.length;
    for(int i=n-1;i>=0;i--){
      while(V>=coins[i]){
        V-=coins[i];
        ans.add(coins[i]);
      }
    }
    System.out.println("min no of coins is "+ ans.size());
    System.out.print("coins are :");
    for(int i=0;i<ans.size();i++){
      System.out.print(" "+ans.get(i));
    }
  }
}
//will iterate coins array until we get V>=coins[i]
//V is not >=1000 500 100 50 skip
//V>20 so ans = 20  ans V=49-20=29
//29>20 so ans= 20 20 V=9
//9>5 so ans=20 20 5 V=4
//4>2 so ans =20 20 5 2 V=2
//2>=2 so ans=20 20 5 2 2
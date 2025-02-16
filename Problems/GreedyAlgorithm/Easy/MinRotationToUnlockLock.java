import java.util.*;
public class MinRotationToUnlockLock {
  public static void main(String[] args) {
    long R = 2345, D = 5432;
    
    int ans=0;
    long first,second;
    while(R>0 && D>0){
      first=R%10;
      second=D%10;
      R/=10;
      D/=10;
      ans+=Math.min(Math.abs(first-second),(10-Math.abs(first-second)));
    }
    System.out.println("minimum rotations is :"+ ans);
  }
}
//tc-O(logR) or O(logD)
//sc-O(1)

//first=5 second=2 R=234 D=543 ans=min(3,7)=3
//first=4 second=3 R=23 D=54 ans=3+min(1,9)=3+1=4
//first=3 second=4 R=2 D=5 ans=3+min(1,9)=4+1=5
//first=2 second=5 R=0 D=0 ans=5+min(3,7)=8
//ans=8

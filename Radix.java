import java.util.*;
public class Radix{
  public static int nth(int n, int col){
    return (int)(((n*1.0)/(Math.pow(10.0, col)))%10);
  }

  public static int length(int n){
    String ans = Integer.toString(n);
    return ans.length();
  }

  public static void merge(MyLinkedList original, MyLinkedList[] buckets){
    for(int i=0;i<buckets.length;i++){
      original.extend(buckets[i]);
    }
  }
  
}

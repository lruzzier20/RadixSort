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

  public static void radixSortSimple(SortableLinkedList data){
    int largest=1;
    SortableLinkedList dumpster = new SortableLinkedList();
    SortableLinkedList master = data;
    SortableLinkedList[] bucket = new SortableLinkedList[10];
    for(int m=0;m<bucket.length;m++){
      bucket[m]= new SortableLinkedList();
    }

    for(int q=0;q<master.size();q++){
      if(length(master.get(q))>largest){largest=length(master.get(q));}
    }

    for(int i=0;i<largest;i++){
      for(int l=0;l<master.size();l++){
        bucket[nth(master.get(l), i)].add(master.get(l));
      }
        dumpster.extend(master);
      for(int f=0;f<bucket.length;f++){
        System.out.println("bucket " + f + " is:" + bucket[f].toString());
        }
      for(int j=0;j<bucket.length;j++){
        master.extend(bucket[j]);
      }
      System.out.println(master);
      System.out.println(largest+"");
      System.out.println();
    }
  }

}

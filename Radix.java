import java.util.*;
public class Radix{
  public static int nth(int n, int col){
    return (int)(((n*1.0)/(Math.pow(10.0, col)))%10);
  }

  public static int length(int n){
    String ans = Integer.toString(n);
    if(n<0){return ans.length()-1;}
    return ans.length();
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets){
    for(int i=0;i<buckets.length;i++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    int largest=1;
    int temp=0;
    boolean done=true;
    SortableLinkedList master = data;
    SortableLinkedList[] bucket = new SortableLinkedList[10];
    for(int m=0;m<bucket.length;m++){
      bucket[m]= new SortableLinkedList();
    }

    for(int i=0;i<largest;i++){
      while(master.size()>0){
        temp=master.remove(0);
        if(length(temp)>largest&&done){largest=length(temp);}
        bucket[nth(temp, i)].add(temp);
      }

      merge(master, bucket);
    }
    data=master;
  }

  public static void radixSort(SortableLinkedList data){
    int largest=1;
    int temp=0;
    boolean done=true;
    SortableLinkedList master = data;
    SortableLinkedList[] bucket = new SortableLinkedList[19];
    for(int m=0;m<bucket.length;m++){
      bucket[m]= new SortableLinkedList();
    }

    for(int i=0;i<largest;i++){
      while(master.size()>0){
        temp=master.remove(0);
        if(length(temp)>largest&&done){largest=length(temp);}
        if(temp<0){bucket[nth(temp, i)+9].add(temp);}else{
        bucket[nth(temp, i)+9].add(temp);}
      }
      done=false;
      merge(master, bucket);
    }
    data=master;
  }
}

import java.util.*;

public class TopologicalSort{
  int n;
  int mat[][];
  boolean visit[];
  boolean visit3[];
  int countEdge[];
  boolean visit2[];
  TopologicalSort(int n){
     this.n=n;
     mat=new int[n][n];
     visit=new boolean[n];
     visit3=new boolean[n];
     visit2=new boolean[n];
     countEdge=new int[n];
  }
  void add(int i,int j){
     mat[i][j]=1;
  }

  boolean isEdge(int i,int j){
    if(mat[i][j]==1) return true;
    return false;
  }
  void display(){
    for(int i=0;i<n;i++){
      System.out.print(i+" --> ");
      for(int j=0;j<n;j++){
        if(mat[i][j]==1){
            System.out.print(j+" ");
        }
      }
      System.out.println();
    }
  }

  void displayMat(){
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
            System.out.print(mat[i][j]+" ");
      }
      System.out.println();
    }
  }

  void topo_dfs(int source, boolean visit[]){
      System.out.print(source+" ");
      visit[source]=true;
      for(int i=0;i<n;i++){
        if(mat[source][i]==1 && !visit[i]){
          topo_dfs(i,visit);
        }
      }
  }

  void topo_bfs(int source){
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    visit3[source]=true;
    while(!queue.isEmpty()){
      int cur=queue.poll();
      System.out.print(cur+" ");
      for(int i=0;i<n;i++){
        if(mat[cur][i]==1 && !visit3[i]){
          queue.add(i);
          visit3[i]=true;
        }
      }
    }
  }

  int[] incomingEdge(){
    int countEdge[] = new int[n];
    for(int i=0;i<n;i++){
      int count=0;
      for(int j=0;j<n;j++){
        if(mat[i][j]==1){
          countEdge[j]++; 
        }
      }
    }
    return countEdge;
  }


  void tpSort(){
    Queue<Integer> qu = new LinkedList<>();
    int arr1[]=incomingEdge();
    int c=0;
    for(int i=0;i<n;i++){
      if(arr1[i]==0){
        qu.add(i);
      }
    }
    while(!qu.isEmpty()){
      int cur=qu.poll();
      System.out.print(cur+" ");
      c++;
      for(int i=0;i<n;i++){
        if(mat[cur][i]==1){
          arr1[i]--;
          if(arr1[i]==0){
            qu.add(i);
          }
        }
      }
    }
      System.out.println();

    if (c != n) {
        System.out.println("Topological sort is not possible: cycle detected.");
    } else {
        System.out.println("Topological sort completed.");
    }
  }
  public static void main(String... kalai){
    TopologicalSort t = new TopologicalSort(6);
    t.add(0,2);
    t.add(3,2);
    t.add(3,1);
    t.add(4,0);
    t.add(0,5);
    t.add(5,3);
    t.add(2,1);
    System.out.println("Matrix values : ");
    t.displayMat();
    System.out.println("Display the Vertexs : ");
    t.display();
    System.out.println("Check the edge : ");
    System.out.println(t.isEdge(2,1));
    System.out.print("DFS is topo : ");
    t.topo_dfs(2,t.visit);
    System.out.println();
    System.out.print("BFS is topo : ");
    t.topo_bfs(2);
    System.out.println();
    t.incomingEdge();
    int arr[] = t.incomingEdge();
    System.out.print("Count the all Edges : ");
    for(int i=0;i<t.n;i++){
      System.out.print(arr[i]+" ");
    }
    System.out.println();
    t.tpSort();
  }
}

package dropbox;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Folder{
    
    int id;
    List<Integer> cows;
    boolean isShared;
    List<Integer> children;
    
    Folder(int id, boolean isShared, List<Integer> cows){
        this.id=id;
        this.isShared=isShared;
        this.cows=cows;
        this.children=new ArrayList<>();
    }
    
    public String toString(){
        return "[id="+id+", cows="+cows+" , isShared="+isShared+" , children="+children+"]";
    }
    
}
public class FoldersAndCows {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int Q=in.nextInt();
        int m=Integer.parseInt(in.next()); //Shared
        int n= Integer.parseInt(in.next());
        
        //Parent and Child
        
        Set<Integer> parent= new HashSet<Integer>();
        Map<Integer,Folder> folderMap= new HashMap<>();
        HashSet<Integer> totalCowList= new HashSet<Integer>();
        

        while(m>0){
            
            int id=Integer.parseInt(in.next());
            int cowLength=Integer.parseInt(in.next());
            List<Integer> cows= new ArrayList<Integer>();
            
            while(cowLength>0){
                
                cows.add(Integer.parseInt(in.next()));
                cowLength--;
            }
            
            Folder folder= new Folder(id,true,cows);
            
            parent.add(id);
            folderMap.put(id,folder);
            totalCowList.addAll(cows);
            
            m--;
        }
        
         while(n>0){
            
            int id=Integer.parseInt(in.next());
            int cowLength=Integer.parseInt(in.next());
            List<Integer> cows= new ArrayList<Integer>();
            
            while(cowLength>0){
                
                cows.add(Integer.parseInt(in.next()));
                cowLength--;
            }
            
            Folder folder= new Folder(id,false,cows);
            
            parent.add(id);
            folderMap.put(id,folder);
            totalCowList.addAll(cows);
            
            n--;
        }
        
        
        int G= Integer.parseInt(in.next());
        
        while(G>0){
            int p=in.nextInt();
            int c=in.nextInt();
            
            Folder parentFolder= folderMap.get(p);
            parentFolder.children.add(c);
            
            parent.remove(c);
            
            G--;
        }
        
       /* System.out.println(folderMap);
        System.out.println(parent);
        System.out.println(totalCowList);
        */
        
        Iterator<Integer> it= parent.iterator();
        int parentId=-1;
        HashSet<Integer> resultCows=(HashSet)totalCowList.clone();
        
        while(it.hasNext()){
            parentId=it.next();
            Folder root= folderMap.get(parentId);
            findMembersWithAccessToAllLeafNodes(root,resultCows,folderMap);
        }
        
       // System.out.println(parentId);
        
      /*  System.out.println("------");
        System.out.println(totalCowList);
        System.out.println(resultCows);
        
        System.out.println(totalCowList);
        */
        totalCowList.removeAll(resultCows);
        List<Integer> sortedUncool= new ArrayList<>(totalCowList);
        Collections.sort(sortedUncool);
        
        if(!sortedUncool.isEmpty())
        for(Integer a:sortedUncool)
            System.out.print(a+" ");
        
  
    }
    
    
    private static void findMembersWithAccessToAllLeafNodes(Folder root, Set<Integer> 

resultCows,Map<Integer,Folder> folderMap){
        
        if(root.children.isEmpty()){
            resultCows.retainAll(root.cows);
            return;
        }
        
        if(resultCows.isEmpty()){
            return;
        }
        
        for(Integer child: root.children){
            Folder childFolder= folderMap.get(child);
            
            if(childFolder.isShared){
                childFolder.cows.addAll(root.cows);
            }
            
            findMembersWithAccessToAllLeafNodes(childFolder,resultCows,folderMap);
        }
        
    }
    
    
}
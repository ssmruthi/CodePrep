package others;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class File{
  String name;
  
  File(String name){
	  this.name=name;
	  
  }
}

class Folder{
  List<Folder> subfolder;
  List<File> files;
  String name;
  
  Folder(String name){
	  this.name=name;
  }
  
  @Override
  public String toString(){
	  
	  StringBuilder str= new StringBuilder();
	


	 for(Folder fol: this.subfolder){
		 str.append(fol.name).append(",");
		 
	 }
	 
	 for(File file:files)
		 str.append(file.name).append(":");
	 
	 return str.toString();
  }
}

public class RenameFolder{

  public void rename(Folder dir){
    if(dir==null)
      return ;
      
	dir.name=dir.name.toUpperCase();

    if((dir.subfolder==null || dir.subfolder.isEmpty() ) &&(dir.files==null || dir.files.isEmpty())){
      return;
    }

    for(File file:dir.files){
      file.name=file.name.toUpperCase();
    }

    for(Folder folder:dir.subfolder){
      rename(folder);
    }

  
  }
  
  
  public static void main(String[] args){
	 
	  Folder f1= new Folder("f1");
	  Folder f2= new Folder("f2");
	  Folder f3= new Folder("f3");
	  
	  File file1= new File("file1");
	  File file2= new File("file2");
	  File file3= new File("file3");
	  
	  List<File> filelist1 = new ArrayList<File>();
	  List<Folder> folderlist1 = new ArrayList<Folder>();
	  
	  filelist1.add(file1);
	  filelist1.add(file2);
	  folderlist1.add(f2);
	  
	  f1.files=filelist1;
	  f1.subfolder=folderlist1;
	  
	  
	  List<File> filelist2 = new ArrayList<File>();
	  List<Folder> folderlist2 = new ArrayList<Folder>();
	  
	  filelist2.add(file3);
	  folderlist2.add(f3);
	  
	  f2.files=filelist2;
	  f2.subfolder=folderlist2;
	  
	  
	  
	  
	  new RenameFolder().rename(f1);
	  
	  LinkedList<Folder> toPrint = new LinkedList<Folder>();
	  
	  toPrint.add(f1);
	  
	  while(!toPrint.isEmpty()){
		  Folder fol=toPrint.poll();
		  
			  
			  System.out.print(fol.name+"-");
			  
			  if(fol.files!=null)
				  for(File file:fol.files){
					  System.out.print(file.name+",");
				  }
			  System.out.println();
			  
			  if(fol.subfolder!=null)

			  for(Folder f:fol.subfolder){
				  toPrint.addFirst(f);
			  }
			  
		 
		  
		 
	  }
	  
	  
  }

}
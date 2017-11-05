package Amazon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Movie{
	int id;
	int rating;
	List<Movie> similarMovies=new ArrayList<>();
	
	Movie(int id, int rating){
		this.id=id;
		this.rating=rating;
	}
}
public class MovieSimilarity {

	private static List<Integer> findSimilar(Movie m, int k){
		
		PriorityQueue<Movie> top= new PriorityQueue<>(new Comparator<Movie>() {
			
			public int compare(Movie m1,Movie m2){
				return m1.rating-m2.rating;
			}
					
		});
		
		findSimilarDFS(m,k,top);

		List<Integer> result= new ArrayList<Integer>();

		while(!top.isEmpty()){
			result.add(top.poll().id);
		}
		
		return result;
		
	}
	
	private static void findSimilarDFS(Movie m, int k,PriorityQueue<Movie> top){
		
		if(m==null)
			return;
		
		for(Movie x: m.similarMovies){
			findSimilarDFS(x,k,top);
			
			top.offer(x);			
			if(top.size()>k)
				top.poll();
		}
		
	}
	
	private static List<Integer> findSimilarBFS(Movie m, int k){
		
	
		List<Integer> result= new ArrayList<Integer>();
		
		Queue<Movie> queue= new LinkedList<>();
		List<Movie> visited= new ArrayList<>();
		PriorityQueue<Movie> top= new PriorityQueue<>(new Comparator<Movie>() {
		
			public int compare(Movie m1,Movie m2){
				return m1.rating-m2.rating;
			}
					
		});
		
		queue.offer(m);
		
		while(!queue.isEmpty()){
			Movie x=queue.poll();
			
			for(Movie child: x.similarMovies){
				
				if(!visited.contains(child)){
					visited.add(child);
					top.offer(child);
					queue.offer(child);
					
				}
				
				if(top.size()>k)
					top.poll();
				
			}
		}
		
		
		while(!top.isEmpty()){
			result.add(top.poll().id);
		}
		
		return result;
		
	}
	
	
	
	public static void main(String[] args) {
		
		Movie m0= new Movie(0,4);
		Movie m1= new Movie(1,2);
		Movie m2= new Movie(2,3);
		Movie m3= new Movie(3,5);
		Movie m4= new Movie(4,6);

		/*
		 * m0-m1
		 * m0-m2
		 * m1-m3
		 * m2-m4
		 * 
		 * 
		 */
		List<Movie> similar= new ArrayList<>();
		
		similar.add(m1);
		similar.add(m2);
		m0.similarMovies=similar;
		
		similar= new ArrayList<>();
		similar.add(m3);
		m1.similarMovies=similar;

		similar= new ArrayList<>();
		similar.add(m4);
		m2.similarMovies=similar;
		
		System.out.println(findSimilar(m0,3));
	}

}

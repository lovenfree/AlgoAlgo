package me.jeiyai;

import java.util.Scanner;

public class Main{
    
    public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		double max=0.0;
		
		try{
			int cnt = sc.nextInt();
			double data[] = new double[cnt];
			int i=0;
			while(i<cnt) {
				data[i++] = sc.nextInt();	
			}
			
			for (i=0;i<cnt;i++) {
				if(max < data[i])
					max = data[i];
			}
		
			double totalScore =0.0;
			
			for (i=0; i<cnt;i++) {
				double newScore= 0.0;
				newScore  = data[i]/max * 100.0;
				totalScore+= newScore;
			}
			
			double avg = totalScore/cnt;
			
			System.out.println(avg);
		      	
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    

    }
}

import java.util.Scanner;
import java.util.Stack;


public class Laveshtein {
	  

	public static void main(String[]args)
	{
		Scanner scan = new Scanner(System.in);
		Stack stacked=new Stack<String>();
	    Laveshtein d = new Laveshtein(); 
	  
	  
		System.out.println("Please enter two strings and I would tell you their edit distance");

		String first1 = scan.next();
		String second1 = scan.next();
		int p = first1.length()+1;
		int q= second1.length()+1;
		int difference;
		
		
		int[][] array = new int[p][q];
		char[][]array1 = new char[p][q];
		

		d.edit(first1, second1, array, array1);
		for(int k =0;k<p;k++)
		{
			for(int l=0;l<q;l++)
			{
				System.out.print(array1[k][l]);
			}
			System.out.print("\n");
		}
		
		
		System.out.println("The edit distance is " +array[p-1][q-1]);
		
		System.out.println("The edit operations are ");
		
		
		int i = p-1 ;
  	    int j=q-1;
  	   
  	
  	 
  	  while(i>0&&j>0)
  	  {
 
  			if(array1[i][j]=='I')
			    {
                    
					String var;
			        var=first1.substring(i-1).replaceFirst(Character.toString(first1.charAt(i-1)), Character.toString(first1.charAt(i-1)).concat(Character.toString(second1.charAt(j-1))));
			        first1=first1.substring(0,i-1).concat(var);
			        stacked.push(first1);
			         j=j-1;
			    }
			    else if(array1[i][j]=='D')
			    {
			    	
			    	String var;
			    	var=first1.substring(i-1).replaceFirst(Character.toString(first1.charAt(i-1)), " ");
			    	 first1=first1.substring(0,i-1).concat(var);
			       stacked.push(first1);
			   
			    	i=i-1;
			    }
			    	
			    else if(array1[i][j]=='S')
			    {
			  
			    	String var;
			    	var=first1.substring(i-1).replaceFirst(Character.toString(first1.charAt(i-1)),Character.toString(second1.charAt(j-1)));
			        first1=first1.substring(0,i-1).concat(var);
			        stacked.push(first1);
			     
			    	i=i-1;
			    	j=j-1;
			    } 
  		  
  	     
       }
       
  	    
		while(!stacked.isEmpty())
		{
		
			System.out.println(stacked.pop());
		}
	}
	
	public void edit(String first, String second, int[][]arr,char[][]arr1)
	{
		int cost;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{ 
				arr1[0][0]='N';
				if(i==0)
				{
					arr[i][j]= Math.max(i, j);
					arr1[i][j]='I';
				}
				else if(j==0)
				{
					arr[i][j]= Math.max(i, j);
					arr1[i][j]='D';
				}
				else
				{
					if(first.charAt(i-1)==second.charAt(j-1))
					{
						arr[i][j]=arr[i - 1][j - 1] ;
					     arr1[i][j]='N';
						
					}
					else{
						
					
					if ((arr[i - 1][j] + 1) < (arr[i][j - 1] + 1) && (arr[i - 1][j] + 1 )< (arr[i - 1][j - 1] + 1))
					{
						arr[i][j] =arr[i - 1][j] + 1;
						
							arr1[i][j]='D';
					}
					else if ((arr[i][j - 1] + 1) < (arr[i - 1][j] + 1) && (arr[i][j - 1] + 1) < (arr[i - 1][j - 1] + 1))
					{
							arr[i][j] =(arr[i][j - 1] + 1);
							
									arr1[i][j]='I';
					}
					else
					{
						arr[i][j] =arr[i - 1][j - 1] + 1;
							arr1[i][j]='S';
					}
					}
				}
				
			}
		}
		}
}
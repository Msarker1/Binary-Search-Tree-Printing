import java.io.BufferedReader;
import java.io.FileReader;


public class Project2 {
	public static void main(String [] args){

	BinaryTree T;
	FileReader thefile;				
	BufferedReader infile;
	String oneLine;
		try{		
			thefile = new FileReader("input.txt");	
			infile = new BufferedReader(thefile);
			int count = 0;
			while((oneLine=infile.readLine())!=null){
				count++;
				if(count%2 == 0)
					continue;
				System.out.println(oneLine);
				String Numbers[] = oneLine.split(" ");
				T = new BinaryTree();
				for(int i=0;i<Numbers.length;i++)
					T = T.append(T, Integer.parseInt(Numbers[i]));
				int col=100;
				int row=10;
				char [][] c = new char[row][col];
				
				T.plotTree(c,T,' ',0,48,12,false);
				T.printTree(c, row, col);
				
				System.out.println(" ");
			}
		
		}
		catch(Exception e){System.out.println(e);
		}
	}
}



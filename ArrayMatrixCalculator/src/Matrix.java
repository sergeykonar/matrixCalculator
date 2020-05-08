
public class Matrix{

	private int a[][];

	private String str1[][];
	
	public Matrix(int m, int n)
	{
		a = new int[m][n];
	}
	public int getHeight()
	{
		return a.length;
	}
	
	public int getWidth()
	{
		return a[0].length;
	}
	
	public void setValue(int i, int j, int value)
	{
		a[i][j] = value;
		
	}
	
	public void loadStr(String[][] str)
	{
		for(int i = 0; i<a.length; i++)
		{
			
			for(int j = 0; j<a[0].length; j++)
			{
				//System.out.print(strTwo[i][j] + " ");     // Outputs the array as a String
				a[i][j] = Integer.parseInt(str[i][j]);

				
			}
			System.out.println("\n");

		}
	}
	
	public String addNum(int num)
	{
		String result = "";
		for(int i = 0; i<a.length; i++)
		{
			for(int j=0; j<a[0].length; j++)
			{
				a[i][j] += num;
				result += a[i][j] + "\t";
			}
			result += "\n";
		}
		return result;
	}
	
	public String mulNum(int num)
	{
		String result = "";
		for(int i = 0; i<a.length; i++)
		{
			for(int j=0; j<a[0].length; j++)
			{
				a[i][j] *= num;
				result += a[i][j] + "\t";
			}
			result += "\n";
		}
		return result;
	}
	
	public String addArray(Matrix arr)
	{
		String result = "";
		for(int i = 0; i<a.length; i++)
		{
			for(int j=0; j<a[0].length; j++)
			{
				a[i][j] += arr.getValue(i, j);
				result += a[i][j] + "\t";
			}
			result += "\n";
		}
		return result;
	}
	
	public String mulArray(Matrix arr1, Matrix arr2)
	{
		String result = "";
		for(int i = 0; i < arr1.getHeight(); i++) {         // rows from m1
            for(int j = 0; j < arr2.getWidth(); j++) {     // columns from m2
                for(int k = 0; k < arr2.getWidth(); k++) { // columns from m1
                	a[i][j] += arr1.getValue(i, k) * arr2.getValue(k, j);
                	
                }
                result += "\n";
            }
		}
		return result;
	}
	
	public int getValue(int i, int j)
	{
		int value = a[i][j];
		return value;
	}
	
	
	
	public  String toString()
	{
		String result = "" ;
		for (int i = 0; i < a.length; i++) 
		{
			for (int j = 0; j < a[0].length; j++) 
			{
				result += a[i][j] + "\t";
			}
			result += "\n";
		}
		return result;
	}
}

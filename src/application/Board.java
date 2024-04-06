package application;

public class Board {

	public RectangleTec arrRectangle[];
	
	
	public Board()
	{
		arrRectangle = new RectangleTec[9];
	}
	
	
	public int getWidth()
	{
		return arrRectangle.length;
	}
	
	
	public boolean isFull(int index) 
	{
		return arrRectangle[index].xo != '\0';
	}
	
	public void setValue(int index, char value)
	{
		arrRectangle[index].xo = value;
	}
	
	public boolean anySpace()
	{
		for(int i = 0 ; i < 9 ; i++)
		{
			if(arrRectangle[i].xo == '\0')
			{
				return true;
			}
		}
		
		return false;
	}
	
	
	
}

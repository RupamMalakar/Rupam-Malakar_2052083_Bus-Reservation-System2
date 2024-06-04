package mybus;


class Chandrama
{
	int a;
	double b;
	
	Chandrama(int a,double b)
	{
		this.a=a;
		this.b=b;
	}
	
	Chandrama(double b,int a)
	{
		this.a=a;
		this.b=b;
	}
	
	void show()
	{
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
	
}

public class testingg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chandrama ob=new Chandrama(2,3.6);
		Chandrama ob2=new Chandrama(2.4,3);
		
		ob.show();
		ob2.show();
	}

}

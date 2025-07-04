package final_keyword;

public class FinalVaribles {
	
	//The blank final field x may not have been initialized
	//	final int x;
	//final int a;
	final int x=100;
	
	//declare a static blank final variable
   final static int y;
   
   final static int z=10;
   
   //instance method
   void change() {
	   // final variable can't change or reassign
	//   x=30;
	  // z=40;
   }

@Override
public String toString() {
	return "FinalVaribles [x=" + x + ",y="+y+"]";
}
   static {
	   y=20;
	 //  z=20; once initialized can't change
   }
}

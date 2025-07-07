package com.tnsif.abstraction;

public class Square extends Shape {
float side ;

public Square() {
	
	side=2.4f;
}

public Square(float side) {
	
	this.side = side;
	
}

@Override
public void calarea() {
	this.area=side*side;
	
	
}


}

package fun.kolowert.learning.common;

public abstract class Fo implements F {
	
	static final int BEST_NUMBER = 1024;
	
	public int getMaskProduct() {
		return BEST_NUMBER;
	}
	
	public abstract void setMaskProduct(int input);
}

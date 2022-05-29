package fun.kolowert.learning.common;

import java.util.Arrays;

public class Foo extends Fo implements Intrfc {

	private final int id;
	private final String name;
	private final int[] mask;

	private int maskSum;
	private int maskProduct;
	private boolean isSumCounted = false;
	private boolean isProductCounted = false;

	public Foo(int id, String name, int[] mask) {
		super();
		this.id = id;
		this.name = name;
		this.mask = mask;
	}
	
	@Override
	public int getMaskSum() {
		if (!isSumCounted) {
			int sum = 0;
			for (int n : mask) {
				sum += n;
			}
			maskSum = sum;
			isSumCounted = true;
		}
		return maskSum;
	}

	@Override
	public int getMaskProduct() {
		if (!isProductCounted) {
			int prod = 1;
			for (int n : mask) {
				prod *= n;
			}
			maskProduct = prod;
			isProductCounted = true;
		}
		return maskProduct;
	}

	@Override
	public void setMaskProduct(int input) {
		maskProduct = input;
	}
	
	@Override
	public double getPi() {
		return PI;
	}
	
	@Override
	public String toString() {
		return "Foo [id=" + id + ", name=" + name + ", mask=" + Arrays.toString(mask) + ", maskSum="
				+ (isSumCounted ? maskSum : "Not Counted") + ", maskProduct="
				+ (isProductCounted ? maskProduct : "Not Counted") + "]";
	}
	
}

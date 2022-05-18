package fun.kolowert.learning.rizne;

import java.util.Arrays;

public class Foo {

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

	public int getNaskSum() {
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
	public String toString() {
		return "Foo [id=" + id + ", name=" + name + ", mask=" + Arrays.toString(mask) + ", maskSum="
				+ (isSumCounted ? maskSum : "Not Counted") + ", maskProduct="
				+ (isProductCounted ? maskProduct : "Not Counted") + "]";
	}
}

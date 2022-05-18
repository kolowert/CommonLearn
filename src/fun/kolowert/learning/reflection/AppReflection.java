package fun.kolowert.learning.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class AppReflection {

	public static void main(String[] args) {

		Foo foo = new Foo(128, "Name for Foo", new int[] { 1, 4, 9, 2 });
		
		foo.getNaskSum();
		foo.getMaskProduct();
		
		System.out.println("foo: " + foo.toString());

		// prepare Class
		Class<? extends Foo> fooClass = foo.getClass();
		System.out.println(fooClass.getName() + " " + Arrays.toString(fooClass.getDeclaredMethods()));
		
		// prepare constructor
		Constructor<?>[] constructors = fooClass.getConstructors(); 
		for (Constructor<?> constructor : constructors) { 
		    Class<?>[] params = constructor.getParameterTypes(); 
		    for (Class<?> param : params) { 
		        System.out.println(param.getName()); 
		    } 
		}
		
		// field play
		Field[] declaredFields = fooClass.getDeclaredFields();
		System.out.println("field play~\n" + Arrays.toString(declaredFields));
		
	}

}

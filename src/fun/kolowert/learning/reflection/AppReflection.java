package fun.kolowert.learning.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

import fun.kolowert.learning.common.*;

public class AppReflection {

	public static void main(String[] args) {

		Foo foo = new Foo(128, "Name for Foo", new int[] { 1, 4, 9, 2 });
		
		foo.getMaskSum();
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
		System.out.println("field play | declared fields");
		for (Field field : declaredFields) {
			System.out.println("field: " + field);
		}
		
		// more class play
		System.out.println("\n~~~ more class play ~~~");
		Class<? extends F> cls = foo.getClass();
		Class<?> scls = cls.getSuperclass();
		System.out.println("Superclass: " + scls);
		Class<?>[] ifs = cls.getInterfaces();
		System.out.println("Foo interfaces: " + Arrays.toString(ifs));
		Class<?>[] ifss = scls.getInterfaces();
		System.out.println("Fo interfaces: " + Arrays.toString(ifss));
	}

}

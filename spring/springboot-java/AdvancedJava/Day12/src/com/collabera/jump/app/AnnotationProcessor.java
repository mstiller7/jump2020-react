package com.collabera.jump.app;

import java.lang.annotation.Annotation;

import com.collabera.jump.MyAnnotationWithMultiValue;
import com.collabera.jump.MyAnnotationWithSingleValue;

public class AnnotationProcessor {

	public static void main(String[] args) throws ClassNotFoundException {
//		TestAnnotation testAnnotation = new TestAnnotation();
//		
//		System.out.println(testAnnotation.getClass());
//		
//		System.out.println(testAnnotation.getClass().isAnnotation());

//		System.out.println(TestAnnotation.class.getPackageName());
//
//		// Class<Object> className = new Class();
//		System.out.println(TestAnnotation.class.getClassLoader().isRegisteredAsParallelCapable());
//
//		System.out.println(TestAnnotation.class.getDeclaredMethods());

		Class testAnnoationClass = TestAnnotation.class;

		Annotation[] myAnnotations = testAnnoationClass.getAnnotationsByType(MyAnnotationWithSingleValue.class);

		for (Annotation a : myAnnotations) {
			MyAnnotationWithSingleValue myAnnotation = (MyAnnotationWithSingleValue) a;

			System.out.println(myAnnotation.value());
		}

		Annotation[] myAnnotationWithMultiValue = testAnnoationClass
				.getAnnotationsByType(MyAnnotationWithMultiValue.class);

		for (Annotation a : myAnnotationWithMultiValue) {
			MyAnnotationWithMultiValue myAnnotation = (MyAnnotationWithMultiValue) a;

			System.out.println(myAnnotation.value());
			System.out.println(myAnnotation.path());
			System.out.println(myAnnotation.count());

		}

//		for (Method method : TestAnnotation.class.getDeclaredMethods()) {
//
//			int type = method.getModifiers();
//
//			switch (type) {
//			case Modifier.PRIVATE: {
//				System.out.println(method.getName() + " is Private method");
//
//			
//			}
//				break;
//			case Modifier.PUBLIC:
//				System.out.println(method.getName() + " is Public method");
//				break;
//			case Modifier.PROTECTED:
//				System.out.println(method.getName() + " is Protected method");
//				break;
//			default:
//				System.out.println(method.getName() +" :::::> "+ method.getModifiers());
//				break;
//			}

		// System.out.println(method.get);
//			Annotation[] annotations = method.getAnnotations();
//			System.out.println();
//
//			
//			
//			for (Annotation annotation : annotations) {
//				System.out.println(annotation.annotationType());
//			}
//		}
//
//		System.out.println(MyAnnotation.class.isAnnotation());

	}
}

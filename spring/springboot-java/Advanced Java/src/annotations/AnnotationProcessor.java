package annotations;

import java.lang.annotation.Annotation;

public class AnnotationProcessor {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Class<TestAnnotation> taClass = TestAnnotation.class;
		
		Annotation[] sv = taClass.getAnnotationsByType(SV.class);
		for (Annotation a : sv) {
			SV annote = (SV) a;
			System.out.println("SV in Main..." + annote.value());
		}
		
		Annotation[] mv = taClass.getAnnotationsByType(MV.class);
		for (Annotation a : mv) {
			MV annote = (MV) a;
			System.out.println("MV in Main..." + annote.value());
			System.out.println("MV in Main..." + annote.path());
			System.out.println("MV in Main..." + annote.count());
		}
	}
}
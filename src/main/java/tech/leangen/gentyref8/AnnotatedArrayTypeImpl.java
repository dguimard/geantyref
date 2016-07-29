package tech.leangen.gentyref8;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedArrayType;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.GenericArrayType;

/**
 * Created by bojan.tomic on 7/24/16.
 */
public class AnnotatedArrayTypeImpl extends AnnotatedTypeImpl implements AnnotatedArrayType {

	private AnnotatedType componentType;

	public AnnotatedArrayTypeImpl(GenericArrayType type, Annotation[] annotations, AnnotatedType componentType) {
		super(type, annotations);
		this.componentType = componentType;
	}

	public AnnotatedArrayTypeImpl(Class type, Class componentType) {
		super(type, type.getAnnotations());
		this.componentType = new AnnotatedTypeImpl(componentType, componentType.getAnnotations());
	}

	@Override
	public AnnotatedType getAnnotatedGenericComponentType() {
		return componentType;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof AnnotatedArrayTypeImpl
				&& super.equals(other)
				&& ((AnnotatedArrayTypeImpl) other).componentType.equals(this.componentType);
	}

	@Override
	public int hashCode() {
		return super.hashCode() + componentType.hashCode();
	}
}

/**
 * 
 */
package com.pd.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author psivadas
 * 
 * Annotation to verify the image type from the list of allowed image types
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) //can use in method only.
public @interface ImageType {

	String message() default "Not a valid image type!";

	String[] groups() default {"jpeg" , "png" , "gif"};

	//public boolean isValid() default false;

}

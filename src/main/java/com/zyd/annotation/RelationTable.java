
package com.zyd.annotation;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RelationTable
{
  String join() default "inner";
  
  String fkCol() default "";
  
  String col() default "";
}

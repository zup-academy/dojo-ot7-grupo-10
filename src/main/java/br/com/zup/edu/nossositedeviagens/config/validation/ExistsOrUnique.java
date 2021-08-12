package br.com.zup.edu.nossositedeviagens.config.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ExistsOrUniqueValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsOrUnique {

    String message() default "Objeto não existe";

    String field();
    Class<?> entity();
    boolean unique() default false;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

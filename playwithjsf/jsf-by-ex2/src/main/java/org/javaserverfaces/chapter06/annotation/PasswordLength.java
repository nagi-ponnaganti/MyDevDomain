
package org.javaserverfaces.chapter06.annotation;

/**
 * Custom validation annotation for validating passwords to ensure that they 
 * meet the criteria.
 * @author juneau
 */
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import org.javaserverfaces.chapter06.validator.CheckPasswordValidator;

@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CheckPasswordValidator.class)
@Documented
public @interface PasswordLength {

    String message() default "{org.javaserverfaces.constraints.password}";
    /**
     * @return password length
     */
    int passwordLength();

}

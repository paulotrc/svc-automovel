package br.paulotrc.svcautomovel.entites.validators;

import br.paulotrc.svcautomovel.entites.validators.TipoAutomovelPatternValidator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = TipoAutomovelPatternValidator.class)
public @interface TipoAutomovelValidator {
    String regexp();
    String message() default "Precisa ser uma das seguintes opções: \"{regexp}\"";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

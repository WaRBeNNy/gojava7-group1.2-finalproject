package annotations;

/**
 * Created by Magomed on 07.07.2017.
 * NEEDS TEST!!!!!!!
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@code JsonIgnore} annotation indicates
 * that field should be ignored for serialization.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface JsonIgnore {
}

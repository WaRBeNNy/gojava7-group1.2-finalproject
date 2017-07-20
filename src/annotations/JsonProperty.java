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
 * {@code JsonProperty} annotation indicates that
 * field should be serialized and provides means to change
 * field name for serialization.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface JsonProperty {

    /**
     * Special value that indicates that handlers should use the
     * default attribute (derived from filed attribute) for property.
     */
    String DEFAULT_NAME = "";

    /**
     * Defines attribute of the logical property, i.e. JSON object field
     * attribute to use for the property. If value is empty String, will try
     * to use attribute of the field that is annotated.
     */
    String name() default DEFAULT_NAME;
}

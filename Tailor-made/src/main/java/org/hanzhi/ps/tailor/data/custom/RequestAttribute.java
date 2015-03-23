package org.hanzhi.ps.tailor.data.custom;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestAttribute {
	String value();
}
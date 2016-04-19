package com.br.uepb.validator.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.NotReadablePropertyException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

public class CustomConstraintSpringValidatorAdapter extends LocalValidatorFactoryBean {

	@Override
	protected void processConstraintViolations(Set<ConstraintViolation<Object>> violations, Errors errors) {
		for (ConstraintViolation<Object> violation : violations) {
			String field = violation.getPropertyPath().toString();
			FieldError fieldError = errors.getFieldError(field);
			if (fieldError == null || !fieldError.isBindingFailure()) {
				try {
					String errorCode = violation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName();
					Object[] errorArgs = getArgumentsForConstraint(errors.getObjectName(), field, violation.getConstraintDescriptor());
					if (errors instanceof BindingResult) {
						// can do custom FieldError registration with invalid value from ConstraintViolation,
						// as necessary for Hibernate Validator compatibility (non-indexed set path in field)
						BindingResult bindingResult = (BindingResult) errors;
						String[] errorCodes = bindingResult.resolveMessageCodes(errorCode, field);
						String nestedField = bindingResult.getNestedPath() + field;
						ObjectError error;
						if ("".equals(nestedField)) {
							error = new ObjectError(
									errors.getObjectName(), errorCodes, errorArgs, violation.getMessage());
						}
						else {
							Object invalidValue = violation.getInvalidValue();
							if (!"".equals(field) && invalidValue == violation.getLeafBean()) {
								// bean constraint with property path: retrieve the actual property value
								invalidValue = bindingResult.getRawFieldValue(field);
							}
							if(violation.getMessage() != null && violation.getMessage().startsWith("{") && violation.getMessage().endsWith("}")){
								String keyMessage = violation.getMessage();
								keyMessage = keyMessage.replace("{", "");
								keyMessage = keyMessage.replace("}", "");
								List<String> temp = new ArrayList<String>(Arrays.asList(errorCodes));
								temp.add(keyMessage);
								errorCodes = temp.toArray(new String[temp.size()]);
								error = new FieldError(
										errors.getObjectName(), nestedField, invalidValue, false,
										errorCodes, errorArgs, violation.getMessage());
							} else {
								error = new FieldError(
										errors.getObjectName(), nestedField, invalidValue, false,
										errorCodes, errorArgs, violation.getMessage());								
							}
						}
						bindingResult.addError(error);
					}
					else {
						// got no BindingResult - can only do standard rejectValue call
						// with automatic extraction of the current field value
						if(violation.getMessage() != null && violation.getMessage().startsWith("{") && violation.getMessage().endsWith("}")){
							String keyMessage = violation.getMessage();
							keyMessage = keyMessage.replace("{", "");
							keyMessage = keyMessage.replace("}", "");
							errors.rejectValue(field, keyMessage);
						} else {
							errors.rejectValue(field, errorCode, errorArgs, violation.getMessage());							
						}
					}
				}
				catch (NotReadablePropertyException ex) {
					throw new IllegalStateException("JSR-303 validated property '" + field +
							"' does not have a corresponding accessor for Spring data binding - " +
							"check your DataBinder's configuration (bean property versus direct field access)", ex);
				}
			}
		}
	}
}

package FileValidator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.br.uepb.model.File;


public class FileValidator implements Validator {
	public boolean supports(Class<?> paramClass) {
		return File.class.equals(paramClass);
	}

	public void validate(Object obj, Errors errors) {
		File file = (File) obj;
		  if (file.getFile().getSize() == 0) {
		   errors.rejectValue("file", "Please select a file!");
		  }
	}
}
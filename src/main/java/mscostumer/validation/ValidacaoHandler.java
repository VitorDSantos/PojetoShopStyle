package mscostumer.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidacaoHandler {

	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code =  HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ValidacaoFormDto> handle(MethodArgumentNotValidException exception) {
		List<ValidacaoFormDto> validacaoFormDto = new ArrayList<>();
		List<FieldError> errosCampos = exception.getBindingResult().getFieldErrors();
		
		errosCampos.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ValidacaoFormDto erro = new ValidacaoFormDto(e.getField(), mensagem);
			validacaoFormDto.add(erro);
		});
		
		return validacaoFormDto; 
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ValidacaoSqlDto handle(DataIntegrityViolationException exception){
		return new ValidacaoSqlDto(exception.getMostSpecificCause().getLocalizedMessage()); 
	}
}

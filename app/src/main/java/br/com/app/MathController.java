package br.com.app;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.exceptions.UnsupportedMathOperationException;
import br.com.app.helpers.NumericHelper;


@RestController
public class MathController {
	

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable(value= "numberOne") String numberOne,
			@PathVariable(value= "numberTwo") String numberTwo) throws Exception {
		if(!NumericHelper.isNumeric(numberOne) || !NumericHelper.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Parametros nao sao numeros");
		}
		return NumericHelper.convertToDouble(numberOne) + NumericHelper.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable(value= "numberOne") String numberOne,
			@PathVariable(value= "numberTwo") String numberTwo) throws Exception {
		if(!NumericHelper.isNumeric(numberOne) || !NumericHelper.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Parametros nao sao numeros");
		}
		return NumericHelper.convertToDouble(numberOne) - NumericHelper.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(@PathVariable(value= "numberOne") String numberOne,
			@PathVariable(value= "numberTwo") String numberTwo) throws Exception {
		if(!NumericHelper.isNumeric(numberOne) || !NumericHelper.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Parametros nao sao numeros");
		}
		
		if( NumericHelper.convertToDouble(numberTwo) == 0) {
			throw new UnsupportedMathOperationException("Não é possivel dividir por 0");
		}
		return NumericHelper.convertToDouble(numberOne) / NumericHelper.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/square-root/{numberOne}", method=RequestMethod.GET)
	public Double squareRoot(@PathVariable(value= "numberOne") String numberOne) throws Exception {
		if(!NumericHelper.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Parametros nao sao numeros");
		}
		
		return Math.sqrt(NumericHelper.convertToDouble(numberOne));
	}
	
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(@PathVariable(value= "numberOne") String numberOne,
			@PathVariable(value= "numberTwo") String numberTwo) throws Exception {
		if(!NumericHelper.isNumeric(numberOne) || !NumericHelper.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Parametros nao sao numeros");
		}
		return (NumericHelper.convertToDouble(numberOne)  + NumericHelper.convertToDouble(numberTwo)) / 2;
	}
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication(@PathVariable(value= "numberOne") String numberOne,
			@PathVariable(value= "numberTwo") String numberTwo) throws Exception {
		if(!NumericHelper.isNumeric(numberOne) || !NumericHelper.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Parametros nao sao numeros");
		}
		return NumericHelper.convertToDouble(numberOne) * NumericHelper.convertToDouble(numberTwo);
	}

}

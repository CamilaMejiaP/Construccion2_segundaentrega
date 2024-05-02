package tdea.construccion2.app.validators;

import org.springframework.stereotype.Component;

@Component
public abstract class InputsValidator {
    public void stringValidator(String string, String element) throws Exception {
        if (string == null || string.equals("")) {
            throw new Exception(element + " no es un valor valido");
        }
    }

    public int integerValidator(int number, String element) throws Exception {
        try {
            return Integer.parseInt(String.valueOf(number));
        } catch (Exception e) {
            throw new Exception(element + " no es un numero valido");
        }
    }
    
    public long longValidator(long number, String element) throws Exception {
        try {
        	 return Long.parseLong(String.valueOf(number));
        } catch (Exception e) {
            throw new Exception(element + " no es un numero valido");
        }
    }
    
    public double doubleValidator(double number, String element) throws Exception {
        try {
            return Double.parseDouble(String.valueOf(number));
        } catch (Exception e) {
            throw new Exception(element + " no es un numero valido");
        }
    }
}

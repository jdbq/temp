package gasoline.store.utility;

class InvalidCreditCardNumberException extends Exception {
	InvalidCreditCardNumberException(String mes){
		super(mes);
	}
}

public class ValidateCreditCardNumber {
	public static void validateNumber(String num) throws InvalidCreditCardNumberException{
		LuhnChecker lc = new LuhnChecker();
		if(lc.check(num) == false){
			throw new InvalidCreditCardNumberException("You're credit card number is not valid!");
		}else{
			System.out.println("hello");
		}
		
	}
}

import javax.xml.validation.Validator;

public class Main {
    public static void main(String[] args) {
        boolean result = ValidatorService.validate("DeadShoot19", "Nice_5219", "Nice_5219");
        if (result) {
            System.out.println("Логин и пароль конкретные");
        }
    }
}

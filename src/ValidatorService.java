public class ValidatorService {
    private static final String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789";

    private ValidatorService() {
    }

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            check(login, password, confirmPassword);
            return true;
        } catch (WrongPasswordException | WrongLoginException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    private static void check(String login, String password,
                              String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login == null || login.length() > 20) {
            throw new WrongLoginException("Длина логина должна быть меньше 20!");
        }
        if (password == null || password.length() >= 20) {
            throw new WrongPasswordException("Длина паспорта должна быть меньше или равна 20!");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать!");
        }
        checkWrong(password, false);
        checkWrong(login, true);
    }

    private static void checkWrong(String string, boolean login)
            throws WrongLoginException, WrongPasswordException {
        for (int i = 0; i < string.length(); i++) {
            if (!allowedCharacters.contains(String.valueOf(string.charAt(i)))) {
                if (login) {
                    throw new WrongLoginException("Символ " + string.charAt(i) + "недоступный");
                } else {
                    throw new WrongPasswordException("Символ " + string.charAt(i) + "недоступный");
                }
            }
        }
    }
}

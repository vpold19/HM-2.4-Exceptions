public class ValidatorService {

    private ValidatorService(){
    }

    public static boolean validate( String login, String password, String confirmPassword) {
try {

   check(login,password,confirmPassword );
   return true;
} catch (WrongPasswordException | WrongLoginException e) {
    System.out.println(e.getMessage());
    return false;
}

    }

    private static void check(String login, String password,
                              String confirmPassword) throws WrongLoginException, WrongPasswordException{

    }
}

package mypractice.com.practice;

public class Check {

    public static Boolean validateEmail(String email) {
        Boolean isValidated = Boolean.FALSE;
        if(!isValidated) {
            if (email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
                isValidated = Boolean.TRUE;
            }
        }
        return isValidated;
    }

        public static void main(String[] args) {
                String mail = "a.mcclelland@hatzelandbuehler.com";

               Boolean checking = validateEmail(mail);
               System.out.println(checking);
        }

}

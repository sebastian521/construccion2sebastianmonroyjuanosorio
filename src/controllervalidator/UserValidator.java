package controllervalidator;


public class UserValidator extends CommonsValidator {
    public void validUsarName(String UserName) throws Exception{
        super.isValidString("El Nombre Del Usuario", UserName);
    }
    public void validRole(String Role) throws Exception{
        super.isValidString("El Rol Del Usuario", Role);
    }
    public void validPassword(String password) throws Exception{
        super.isValidString("la contraseña", password);
    }
}

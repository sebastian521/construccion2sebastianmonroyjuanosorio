package Controller;

import java.sql.Date;
import controllervalidator.PersonValidator;
import controllervalidator.UserValidator;
import dto.PersonDto;
import dto.UserDto;


public class GuestController implements ControllerInterface {
    private PersonValidator personavalidator;
    private UserValidator UserValidator;
    private static final String MENU = "Ingrese la opcion la accion que desea hacer \n 1.. \n 2. para cerrar sesion";
    
    
    
    
    @Override
    public void session() throws Exception {
		boolean session = true;
		while (session) {
			session = GuestSession();
		}

	}
    private boolean GuestSession() {
		try {
			System.out.println(MENU);
			String option = Utils.getReader().nextLine();
			return menu(option);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	}
    private boolean menu(String option) throws Exception {
		switch (option) {
		case "1": {
			;
			return true;
		}
		case "2": {
			System.out.println("se ha cerrado sesion");
			return false;
		}
		default: {
			System.out.println("opcion invalida");
			return true;
		}
		}

	}

    public GuestController() {
        this.personavalidator = new PersonValidator();
        this.UserValidator = new UserValidator();
    }
    
    


    
}

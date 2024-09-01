package Controller;


import java.util.HashMap;
import java.util.Map;
import controllervalidator.UserValidator;
import dto.UserDto;
import Service.Service;
import ServiceInterface.LoginService;

public class LoginController implements ControllerInterface{
    private UserValidator userValidator;
	private LoginService service;
	private static final String MENU= "ingrese la opcion que desea: \n 1. para iniciar sesion. \n 2. para detener la ejecucion.";
	private Map<String,ControllerInterface> roles;
	public LoginController() {
		this.userValidator= new UserValidator();
                this.service = new Service() {
                    @Override
                    public void Login(UserDto userDto) throws Exception {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public void Logout() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public void CreatePartner(UserDto userDto) throws Exception {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }
                };
                ControllerInterface AdminController= new AdminController();
                ControllerInterface GuestController = new GuestController();
		ControllerInterface PartnerController = (ControllerInterface) new PartnerController();
                this.roles= new HashMap<String,ControllerInterface>();
		roles.put("admin", AdminController);
		roles.put("Partner",PartnerController );
		roles.put("Guest",GuestController);
                
	}
    @Override
	public void session() throws Exception {
		boolean session = true;
		while (session) {
			session = menu();
		}		
	}
	
	private boolean menu() {
		try {
			System.out.println(MENU);
			String option = Utils.getReader().nextLine();
			return options(option);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	}
	private boolean options(String option) throws Exception {
		switch (option) {
		case "1": {
			this.login();
			return true;
		}
		case "2": {
			System.out.println("se detiene el programa");;
			return false;
		}
		default: {
			System.out.println("ingrese una opcion valida");
			return true;
		}
		}
	}
	
	private void login()throws Exception {
		System.out.println("ingrese el usuario");
		String userName= Utils.getReader().nextLine();
		userValidator.validUsarName(userName);
		System.out.println("ingrese la contraseña");
		String password= Utils.getReader().nextLine();
		userValidator.validPassword(password);
		UserDto userDto = new UserDto();
		userDto.setPassword(password);
		userDto.setUserName(userName);
		this.service.Login(userDto);
		if(roles.get(userDto.getRole())==null) {
			throw new Exception ("Rol invalido");
		}
		roles.get(userDto.getRole()).session();
		
	}
	
	

    
}

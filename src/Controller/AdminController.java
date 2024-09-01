
package Controller;
import controllervalidator.PersonValidator;
import controllervalidator.UserValidator;
import dto.PersonDto;
import dto.UserDto;
import dto.PartnerDto;
import Service.Service;
import ServiceInterface.AdminService;


public class AdminController  implements ControllerInterface{
    private PersonValidator personaValidator;
    private UserValidator userValidator;
    private AdminService service;
    private static final String MENU = "ingrese la opcion /n 1. Crear socio /2. Para crear invitado /3. para cerrar sesion /n";
    
  
    public AdminController (){
        this.personaValidator = new PersonValidator();
        this.userValidator = new UserValidator();
        this.service = new  service();
        
    }
    @Override
    public void session() throws Exception{
        boolean session = true;
        while (session){
            session = menu();
        }
    }
    private boolean menu(){
        try{
            System.out.println("Bienvenido " + Service.user.getUserName());
            System.out.println(MENU);
            String option = Utils.getReader().nextLine();
            return options(option);
            
        }catch (Exception e){
            System.out.println(e.getMessage());
            return true;
        }
    }
    private boolean options (String option) throws Exception{
        switch (option){
            case "1" -> {
                this.createPartner();
                return true;
            }
            case "2" -> {
                this.createGuest();
                return true;
            }
            case "3" -> {
                System.out.println("se ha cerrado sesion");
                return false;
            }
            default -> {
                System.out.println("ingrese una opcion que sea valida");
            }
            
                
            }
        return false;
        
        
    }
    
        
    
   private void createPartner() throws Exception {
        System.out.println("ingrese el nombre del socio");
        String name = Utils.getReader().nextLine();
        personaValidator.ValidName(name);
        System.out.println("ingrese el documento del socio");
        long cedula = personaValidator.ValidCedula(Utils.getReader().nextLine());
        System.out.println("Ingrese el nombre usuario del socio");
        String userName = Utils.getReader().nextLine();
        userValidator.validUsarName(userName);
        System.out.println("ingrese la contraseña del socio");
        String password = Utils.getReader().nextLine();
        
        PersonDto personDto = new PersonDto();
        personDto.setName(name);
        personDto.setDocument(cedula);
        personDto.setCellPhoneNumber(cedula);
        UserDto userDto = new UserDto();
        userDto.setPersonId(personDto);
        userDto.setUserName(userName);
        userDto.setPassword(password);
        userDto.setRole("partner");
        
        this.service.CreatePartner(userDto);
        System.out.println("se ha creado el usuario exitosamente");
        
        
    
    }
    private void createGuest() throws Exception{

    }

    private static class service implements AdminService {

        public service() {
        }

        @Override
        public void CreatePartner(UserDto userDto) throws Exception {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

}

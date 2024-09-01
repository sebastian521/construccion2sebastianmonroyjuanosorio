package Service;

import java.sql.SQLException;
import app.dao.PersonDaoImplementation;
import app.dao.UserDaoImplementation;
import app.dao.PartnerDaoImplementation;
import dto.PartnerDto;
import dao.Interfaces.UserDao;
import dao.Interfaces.GuestDao;
import dao.Interfaces.PartnerDao;
import dao.Interfaces.PersonDao;
import dao.Interfaces.InvoiceDao;
import dao.Interfaces.InvoiceDetailDao;
import dto.GuestDto;
import dto.PersonDto;
import dto.UserDto;
import dto.PartnerDto;
import ServiceInterface.AdminService;
import ServiceInterface.LoginService;
import ServiceInterface.PartnerService;
import java.sql.Timestamp;

public abstract class Service implements LoginService, AdminService, PartnerService {

    private UserDao userDao;
    private GuestDao guestdao;
    private PartnerDao partnerdao;
    private PersonDao persondao;
    private InvoiceDao invoicedao;
    private InvoiceDetailDao invoicedetaildao;

    public static UserDto user;

    public Service() {
        this.userDao = (UserDao) new UserDaoImplementation();
        this.persondao = (PersonDao) new PersonDaoImplementation();
        this.partnerdao= (PartnerDao) new PartnerDaoImplementation();

    }

    public void login(UserDto userDto) throws Exception {
        UserDto validateDto = userDao.findByUserName(userDto);
        if (validateDto == null) {
            throw new Exception("no existe usuario registrado");
        }
        if (!userDto.getPassword().equals(validateDto.getPassword())) {
            System.out.println(validateDto.getPassword());
            System.out.println(userDto.getPassword());
            throw new Exception("usuario o contraseña incorrecto");
        }
        userDto.setRole(validateDto.getRole());
        user = validateDto;
    }

    public void logout() {
        user = null;
        System.out.println("se ha cerrado sesion");
    }

    private void createPerson(PersonDto personDto) throws Exception {
        if (this.persondao.existsByDocument(personDto)) {
            throw new Exception("ya existe una persona con ese documento");
        }
        this.persondao.createPerson(personDto);
    }

    private void createUser(UserDto userDto) throws Exception {
        this.createPerson(userDto.getPersonId());
        PersonDto personDto = persondao.findByDocument(userDto.getPersonId());
        userDto.setPersonId(personDto);
        if (this.userDao.existsByUserName(userDto)) {
            this.persondao.deletePerson(userDto.getPersonId());
            throw new Exception("ya existe un usuario con ese user name");
        }
        try {
            this.userDao.createUser(userDto);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.persondao.deletePerson(userDto.getPersonId());
        }
    }

    
    public void createPartner(UserDto userDto) throws Exception {
        this.createUser(userDto);
        userDto = userDao.findByUserName(userDto);
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setDatecreated(new Timestamp(System.currentTimeMillis()));
        partnerDto.setMoney(50000);
        partnerDto.setType("regular");
        partnerDto.setUserId(userDto);
        GuestDto PartnerDto;
        partnerdao.createPartner(partnerDto);
        
        
        
        
        
        
    }

    @Override
    public void createGuest(GuestDto GuestDto) throws Exception {
        //agregar logica
    }

    
}

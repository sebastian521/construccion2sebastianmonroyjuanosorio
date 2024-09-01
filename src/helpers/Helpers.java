
package helpers;

import dto.PersonDto;
import dto.UserDto;
import model.Person;
import model.User;

public abstract class Helpers {
    public static PersonDto parse(Person Person){
        PersonDto personDto = new PersonDto();
	personDto.setiD(Person.getiD());
	personDto.setDocument(Person.getDocument());
	personDto.setName(Person.getName());
	personDto.setCellPhoneNumber(Person.getCellPhone());
	return personDto;     
        
    }
}

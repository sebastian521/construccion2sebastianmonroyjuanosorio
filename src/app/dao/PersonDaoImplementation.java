package app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Config.MYSQLConnection;
import dao.Interfaces.PersonDao;
import dto.PersonDto;
import helpers.Helpers;
import model.Person;

public  class PersonDaoImplementation implements PersonDao{
    public boolean existsByDocument(PersonDto personDto) throws Exception {
		String query = "SELECT 1 FROM PERSON WHERE DOCUMENT = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, personDto.getDocument());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean exists = resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return exists;
	}
    public void createPerson(PersonDto personDto) throws Exception {
		Person person = Helpers.parse(personDto);
		String query = "INSERT INTO PERSON(DOCUMENT,NAME,CELLPHONE) VALUES (?,?,?) ";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, person.getDocument());
		preparedStatement.setString(2,person.getName());
		preparedStatement.setLong(3, person.getCellPhone());
		preparedStatement.execute();
		preparedStatement.close();
	}
    public void deletePerson(PersonDto personDto) throws Exception {
		Person person = Helpers.parse(personDto);
		String query = "DELETE FROM PERSON WHERE DOCUMENT = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1,person.getDocument());
		preparedStatement.execute();
		preparedStatement.close();
    }
    public PersonDto findByDocument(PersonDto personDto) throws Exception {
		String query = "SELECT ID,DOCUMENT,NAME,CELLPHONE FROM PERSON WHERE DOCUMENT = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, personDto.getDocument());
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			Person person = new Person();
			person.setiD(resulSet.getLong("ID"));
			person.setDocument(resulSet.getLong("DOCUMENT"));
			person.setName(resulSet.getString("NAME"));
			person.setCellPhone(resulSet.getLong("CELLPHONE"));
			resulSet.close();
			preparedStatement.close();
			return Helpers.parse(person);
		}
		resulSet.close();
		preparedStatement.close();
		return null;
	
    
}
    
        
    }

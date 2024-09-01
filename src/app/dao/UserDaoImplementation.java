package app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Config.MYSQLConnection;
import dao.Interfaces.UserDao;
import dto.UserDto;
import helpers.Helpers;
import model.Person;
import model.User;


public  class UserDaoImplementation implements UserDao {
        
         public UserDto findByUserName(UserDto userDto) throws Exception {
		String query = "SELECT ID,PERSONNID,USERNAME,PASSWORD,ROLE FROM USER WHERE USERNAME = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setString(1, userDto.getUserName());
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			User user = new User();
                        Person Person = new Person();
			user.setID(resulSet.getLong("ID"));
                        user.setUserName(resulSet.getString("USERNAME"));
			Person.setDocument(resulSet.getLong("PERSONNID"));
			user.setPassword(resulSet.getString("PASSWORD"));
			user.setRole(resulSet.getString("ROLE"));
			user.setPersonID(Person);
			resulSet.close();
			preparedStatement.close();
			return Helpers.parse(user);
		}
		resulSet.close();
		preparedStatement.close();
		return null;

	}
    public boolean existsByUserName(UserDto userDto) throws Exception {
		String query = "SELECT 1 FROM USER WHERE USERNAME = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setString(1, userDto.getUserName());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean exists = resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return exists;
		}
    public void createUser(UserDto userDto) throws Exception {
		User user = Helpers.parse(userDto);
		String query = "INSERT INTO USER(PERSONNID,USERNAME,PASSWORD,ROLE) VALUES (?,?,?,?) ";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, user.getPersonID().getiD());
		preparedStatement.setString(2, user.getUserName());
		preparedStatement.setString(3,user.getPassword());
		preparedStatement.setString(4, user.getRole());
		preparedStatement.execute();
		preparedStatement.close();
		}
}


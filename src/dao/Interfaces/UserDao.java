package dao.Interfaces;

import dto.UserDto;
public interface UserDao {

public UserDto findByUserName(UserDto userDto) throws Exception;

	public boolean existsByUserName(UserDto userDto) throws Exception;
	
	public void createUser(UserDto userDto) throws Exception;
    
}

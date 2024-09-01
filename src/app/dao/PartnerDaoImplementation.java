
package app.dao;

import dao.Interfaces.PartnerDao;
import dto.PartnerDto;
import java.sql.PreparedStatement;
import Config.MYSQLConnection;
import helpers.Helpers;
import model.Partner;
import java.sql.ResultSet;

public class PartnerDaoImplementation {
    


    
    public boolean existsByDocument(PartnerDto partnerDto) throws Exception {
        String query = "SELECT 1 FROM PERSON WHERE DOCUMENT = ?";
        PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setLong(1, partnerDto.getID());
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean exists = resultSet.next();
        resultSet.close();
        preparedStatement.close();
        return exists;
    }

    public void createPartner(PartnerDto partnerDto) throws Exception {    
        Partner partner = Helpers.parse(partnerDto);
        String query = "INSERT INTO PARTNER(USERID, AMOUNT, TYPE, CREATIONDATE) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
        preparedStatement.setLong(1, partner.getUserID().getID());
        preparedStatement.setDouble(2, partner.getMoney());
        preparedStatement.setString(3, partner.getType());
        preparedStatement.setTimestamp(4, partner.getDateCreated());

        preparedStatement.execute();
        preparedStatement.close();
    }
}


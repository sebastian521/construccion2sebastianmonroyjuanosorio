package dao.Interfaces;

import dto.UserDto;
import java.sql.Date;
import java.util.List;
import dto.PartnerDto;

public interface PartnerDao {
    void createPartner(PartnerDto partnerDto) throws Exception;
}

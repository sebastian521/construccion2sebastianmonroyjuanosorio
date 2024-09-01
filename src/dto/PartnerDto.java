package dto;

import java.util.Date;

public class PartnerDto extends PersonDto {
    private long RegistrationId; 
    private double AvailableFunds;
    private String SuscriptionType;
    private Date AffiliationDate;

    public PartnerDto() {
    }
    
    public long getRegistrationId() {
        return RegistrationId;
    }

    public void setRegistrationId(long RegistrationId) {
        this.RegistrationId = RegistrationId;
    }

    public double getAvailableFunds() {
        return AvailableFunds;
    }

    public void setAvailableFunds(double AvailableFunds) {
        this.AvailableFunds = AvailableFunds;
    }

    public String getSuscriptionType() {
        return SuscriptionType;
    }

    public void setSuscriptionType(String SuscriptionType) {
        this.SuscriptionType = SuscriptionType;
    }

    public Date getAffiliationDate() {
        return AffiliationDate;
    }

    public void setAffiliationDate(Date AffiliationDate) {
        this.AffiliationDate = AffiliationDate;
    }

   
    
}

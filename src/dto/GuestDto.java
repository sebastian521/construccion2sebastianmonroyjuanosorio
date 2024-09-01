
package dto;


public class GuestDto {
    private int registrationId;
    private long PartnerId;
    private boolean InvitationStatus;

    public GuestDto(int registrationId, long PartnerId, boolean InvitationStatus) {
        this.registrationId = registrationId;
        this.PartnerId = PartnerId;
        this.InvitationStatus = InvitationStatus;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public long getPartnerId() {
        return PartnerId;
    }

    public void setPartnerId(long PartnerId) {
        this.PartnerId = PartnerId;
    }

    public boolean isInvitationStatus() {
        return InvitationStatus;
    }

    public void setInvitationStatus(boolean InvitationStatus) {
        this.InvitationStatus = InvitationStatus;
    }
    
    
}

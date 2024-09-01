package model;

 

public class Guest { 
    private int registrationId;
    private long Id;
    private boolean InvitationStatus;
    private Person person;

    public Guest(){
        
    }
    
    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public boolean isInvitationStatus() {
        return InvitationStatus;
    }

    public void setInvitationStatus(boolean InvitationStatus) {
        this.InvitationStatus = InvitationStatus;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    

    
    
      
    }

  
    



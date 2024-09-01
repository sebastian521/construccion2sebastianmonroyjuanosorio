package model;

 

public class Guest { 
    private User user;
    private long ID;
    private String Status;
    private Partner partner;

    public Guest(){
        
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return ID;
    }

    public void setId(long Id) {
        this.ID = Id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }
    
    

    

    
    
      
    }

  
    



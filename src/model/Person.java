package model;


public class Person {
    private long iD;
    private long Document;
    private String name;
    private long CellPhone;

    public Person(){
        
    }
        
    public long getiD() {
        return iD;
    }

    public void setiD(long iD) {
        this.iD = iD;
    }

    public long getDocument() {
        return Document;
    }

    public void setDocument(long Document) {
        this.Document = Document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCellPhone() {
        return CellPhone;
    }

    public void setCellPhone(long CellPhone) {
        this.CellPhone = CellPhone;
    }
  
    
}

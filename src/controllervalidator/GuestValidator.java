package controllervalidator;


public class GuestValidator extends CommonsValidator{
    
    public GuestValidator(){
        super();
    }
    public boolean validStatus(String status) throws Exception{
        return super.isValueBoolean("El Estado De La Factura", status);
    }
}

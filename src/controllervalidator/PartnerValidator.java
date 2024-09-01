package controllervalidator;


public class PartnerValidator extends CommonsValidator{
    public PartnerValidator(){
        super();
    }
    public double validMoney(String money) throws Exception{
        return super.isValidDouble("La Cantidad De La Factura", money);
        }
    
    public void validType(String type) throws Exception{
        super.isValidString("El Tipo De Suscripción", type);
    }
}

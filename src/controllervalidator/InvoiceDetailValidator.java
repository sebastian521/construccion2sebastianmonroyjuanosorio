package controllervalidator;


public class InvoiceDetailValidator extends CommonsValidator {
    public InvoiceDetailValidator(){
        super();
    }
    public int validItem(String item) throws Exception{
        return super.isValidInteger("el Item ",item);
    }
    public void validDescription(String description) throws Exception{
        super.isValidString("Descripción De La Factura", description);
    }
    public double validAmount(String amount) throws Exception{
        return super.isValidDouble("Cantidad De La Factura", amount);
    }
}



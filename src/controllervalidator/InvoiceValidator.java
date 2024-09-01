package controllervalidator;


    public class InvoiceValidator extends CommonsValidator {
        public InvoiceValidator(){
            super();
    }

    public double validAmount(String amount) throws Exception{
        return super.isValidDouble("Cantidad De La Factura", amount);
    }    
    public boolean validArticle(String status) throws Exception{
        return super.isValueBoolean("Estado De La factura ", status);
    }
}

package controllervalidator;


public class PersonValidator extends CommonsValidator{
    public PersonValidator(){
        super();
    }
    public void ValidName(String name) throws Exception{
        super.isValidString("nombre de la persona", name);
    }
    public long ValidCedula(String Document) throws Exception{
        return super.isValidLong("Documento de la persona",Document);
    }
    public int ValidNumber(String Cellphone) throws Exception{
        return super.isValidInteger("El numero de celular de la persona es",Cellphone);
    }
}

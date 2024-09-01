
package model;

public class InvoiceDetail {
    private long Id;
    private int Item;
    private double amount;
    private Invoice Invoice;
    private String Description;

    public InvoiceDetail(){
        
    }
    
    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public int getItem() {
        return Item;
    }

    public void setItem(int Item) {
        this.Item = Item;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Invoice getInvoice() {
        return Invoice;
    }

    public void setInvoice(Invoice Invoice) {
        this.Invoice = Invoice;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
}

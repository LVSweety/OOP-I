package model.customer;

import model.parcel.Address;

public class CustomerAsCompany extends AbstractCustomer{
    private String title;
    private String companyRegNo;

    public CustomerAsCompany() throws Exception {
        super();
        setCompanyRegNo("87654321");
        setTitle("Generic food company");  
        setCustomerCode();
    }

    public CustomerAsCompany(Address address, String phone, String title, String companyRegNo) throws Exception {
        super(address, phone);
        setCompanyRegNo(companyRegNo);
        setTitle(title);        
        setCustomerCode();
    }

    @Override
    public void setCustomerCode() {
        super.customerCode = super.getcID() + "_company_" + this.companyRegNo;
    }

    public void setTitle(String title) throws Exception {
        if (title != null && title.length() < 200){
            this.title = title;
            return;
        }
        throw new IllegalArgumentException("[ERROR]: invalid arguments"); 
    }
    public void setCompanyRegNo(String companyRegNo)  throws Exception  {
        if (companyRegNo != null && companyRegNo.matches("[0-9]{8}")) {
            this.companyRegNo = companyRegNo;
            return;
        }
        throw new IllegalArgumentException("[ERROR]: invalid arguments");  
    }

    public String getTitle() {
        return title;
    }
    public String getCompanyRegNo() {
        return companyRegNo;
    }
    public String toString() {
        return "[ " + super.getcID() + " , " + super.getAddress() + " , " + super.getCustomerCode() + " , " + super.getPhoneNo() + " ]:[ " + this.title + " , " + this.companyRegNo + " ]";
    }
}

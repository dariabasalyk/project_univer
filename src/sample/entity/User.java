package sample.entity;


public class User {
    private String fname;
    private String lname;
    private String email;
    private String phonenumber;

    public User(String fname, String lname, String email, String phonenumber) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "Пользователь{" + "\r\n" +
                "Имя='" + fname + "\r\n" +
                ", Фамилия='" + lname + "\r\n" +
                ", email='" + email + "\r\n" +
                ",Номер телефона='" + phonenumber + "\r\n" +
                '}' + "\n\n\n\n\n";
    }
}

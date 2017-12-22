package kata6.model;

public class Mail {
    private String mail;
    private int id;
    

    public Mail(Integer id, String mail) {
        this.mail = mail;
        this.id = id;
    }

    public String getMail() {
        return mail;
    }
    
    public int getId(){
        return id;
    }
    
            
}

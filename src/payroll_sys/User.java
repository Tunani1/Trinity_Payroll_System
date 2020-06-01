
package payroll_sys;

public class User {
    private byte[] picture;
    
    public User(byte[]image){
        
        this.picture = image;
    
    }
    
    public byte[] getImage(){
        return picture;
    
    }
}

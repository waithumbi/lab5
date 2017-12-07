
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NjeriAbby
 */

public class CrudOperations {
    private int id_number;
    private String F_name;
    private String L_name;
    private String gender;
    private String programme;
    private String passwd;
    //setters
    public void setStudent_no(int id_number) {
        this.id_number = id_number;
    }

    public void setFirst_name(String first_name) {
        this.F_name = F_name;
    }

    public void setLast_name(String last_name) {
        this.L_name = L_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setProgramme(String program) {
        this.programme = programme;
        
    }
    public void setPasswd(String passwd) {
    this.passwd = passwd;
    }
    //getters
    public int getid_number() {
        return id_number;
    }

    public String getF_name() {
        return F_name;
    }

    public String getL_name() {
        return L_name;
    }

    public String getgender() {
        return gender;
    }

    public String getProgramme() {
        return programme;
    }
    public String getPasswd() {
        return passwd;
    }
           // Methods used to process gender from string to 
            // integer and vice versa
    
        public int processGender(String g){
               if (g.equalsIgnoreCase("M")){
                        return 1;
                }return 0;
        }


        public String processGender(int g){
               if (g == 1 ){
                        return "Male";
                }return "Female";
        }
    
        //method to verify users on login
    public boolean checkRecord(int reg_number) {
        ResultSet rs = null; 
        java.sql.PreparedStatement pst = null;
        java.sql.Connection con = new DBConnector().connector();
    // Check that the record exists
        try{
        
        pst = con.prepareStatement("SELECT * FROM student_details WHERE student_id = ?");
        pst.setInt(1,getid_number());
        rs = pst.executeQuery();
        if (rs.next())
        {        
            return true;
        }
        else
            {
                return false;
            }
        }catch(SQLException sqle)
            {
                return false;
            }
        }
        
      
    //methods
    public boolean save(){
       PreparedStatement pst = null;
       Connection con = (Connection) new DBConnector().connector();
            try{
            pst = (PreparedStatement) con.prepareStatement("INSERT INTO student_details (id_number, F_name, L_Name, gender, programme) VALUES(?,?,?,?,?)");
            pst.setInt(1,getid_number());
            pst.setString(2,getF_name());
            pst.setString(3,getL_name());
            pst.setInt(4,processGender(getgender()));
            pst.setString(5,getProgramme());
            pst.executeUpdate();
            return true;
            }catch( SQLException ex){
                System.out.println("error" +ex.getMessage());
                return false;
                
            }
/**
     * this method saves student number and name into the database
     * @param name this is the student name
     * @param id_number this is the student number
     * @return true if saved successfully, false otherwise. 
     * @deprecated 
     */
    
       
    }

    public boolean removeRecord(){
    return true;
    }
    public boolean updateRecord(){
    return true;
    }


    boolean register() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        }

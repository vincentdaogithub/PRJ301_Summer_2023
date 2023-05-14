package obj;

import java.io.Serializable;


public class Student implements Serializable {
    private int id;
    private String name;
    private String password;

    public Student() {
        id = 0;
        name = "";
        password = "";
    }

    public Student(int id, String username, String password) {
        this.id = id;
        this.name = username;
        this.password = password;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}

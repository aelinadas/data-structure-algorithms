/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework4;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author aelinadas
 */
public class User implements Comparable<User>{
    private String name;
    private int id;
    private Date birth;
    public User (String name, int id, Date birth){
        this.name = name; this.id = id; this.birth = birth; 
    }
    @Override
    public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null || (this.getClass() != other.getClass()))
    { return false; }
    User guest = (User) other;
    return (this.id == guest.id)
            && (this.name == null && name.equals(guest.name)) 
            && (this.birth != null && birth.equals(guest.birth));
    }
    @Override public int hashCode() {
    int result = 0;
    result = 31*result + id;
    result = 31*result + (name !=null ? name.hashCode() : 0);
    result = 31*result + (birth !=null ? birth.hashCode() : 0);
    return result;
    }
    @Override
    public int compareTo(User o) {
    return this.id - o.id; }
    
    public static void main(String[] args){
        User u1 = new User("Hello", 1, new Date());
        User u2 = new User("I", 2, new Date());
        User u3 = new User("am", 3, new Date());
        User u4 = new User("in", 4, new Date());
        User u5 = new User("Java", 5, new Date());
        User u6 = new User(".", 6, new Date());
        
        System.out.println(u1.equals(u1));
        System.out.println(u1.equals(u2));
        ArrayList<User> list = new ArrayList<User>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        list.add(u5);
        list.add(u6);
        System.out.println(u1.compareTo(u5));
    }
}

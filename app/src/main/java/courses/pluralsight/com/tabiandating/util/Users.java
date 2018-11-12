package courses.pluralsight.com.tabiandating.util;

import java.util.ArrayList;
import java.util.List;

import courses.pluralsight.com.tabiandating.model.User;

public class Users {
    public static List<User> userList;

    static{
        userList = new ArrayList<>();

        addUser(new User("zoey.jpg","Zoey","Female"
                ,"Male","Looking"));
        addUser(new User("ann.jpg","Ann","Female"
                ,"Female","Not Looking"));
        addUser(new User("line.jpg","Line","Female"
                ,"Male","Looking"));
        addUser(new User("rosilla.jpg","Rosilla","Female"
                ,"Male","Looking"));
        addUser(new User("jenel.jpg","Jenel","Female"
                ,"Female","Not Looking"));
        addUser(new User("lynn.jpg","Lynn","Female"
                ,"Female","Not Looking"));

        addUser(new User("john.jpg","John","Male"
                ,"Female","Looking"));
        addUser(new User("christopher.jpg","Christopher","Male"
                ,"Female","Looking"));
        addUser(new User("mark.jpg","Mark","Male"
                ,"Female","Looking"));
        addUser(new User("gab.jpg","Gab","Male"
                ,"Female","Looking"));
        addUser(new User("james.jpg","James","Male"
                ,"Female","Not Looking"));
        addUser(new User("mc.jpg","Mc","Male"
                ,"Female","Not Looking"));


    }

    private static void addUser(User user){
        userList.add(user);
    }
}

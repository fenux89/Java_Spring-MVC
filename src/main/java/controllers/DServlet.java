package controllers;

import entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DServlet {

    List<User> userList = new ArrayList<>();
    File f = new File("C:\\Users\\fenux\\IdeaProjects\\Java_Spring MVC\\src\\main\\resources\\User.txt");


    @GetMapping(value = "/user")
    public String getForm() {
        return "user.jsp";
    }

    @PostMapping(value = "/user")
    public ModelAndView passDataFromUser(@ModelAttribute("user") User user, ModelAndView modelAndView) {


        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(f, false)))

        {
            userList.add(user);
            objectOutputStream.writeObject(userList);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(user);
        modelAndView.setViewName("result.jsp");
        modelAndView.addObject("koll", userList.size());

        modelAndView.addObject("user", user);
        return modelAndView;

    }

    @GetMapping(value = "/all")
    public ModelAndView listAll(ModelAndView modelAndView) {

       User  us;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(f))) {

            userList = (List<User>) objectInputStream.readObject();
            System.out.println(userList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        modelAndView.addObject("userList", userList);
        modelAndView.addObject("all", "all");
        System.out.println(userList);
        modelAndView.setViewName("result.jsp");
        return modelAndView;
    }


}

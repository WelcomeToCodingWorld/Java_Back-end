/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author zz
 */
@Controller
public class UserController {
    @Autowired
    private UserDao userDao;
 
    @RequestMapping(value="/user")
    public ModelAndView userbook(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        if (name != null){
            userDao.persist(new User(name));
        }
        // Prepare the result view (user.jsp):
        return new ModelAndView("user.jsp", "userDao", userDao);
    }
}

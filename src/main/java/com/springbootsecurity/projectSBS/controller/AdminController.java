package com.springbootsecurity.projectSBS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.springbootsecurity.projectSBS.model.Role;
import com.springbootsecurity.projectSBS.model.User;
import com.springbootsecurity.projectSBS.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AdminController {

    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/allUsers")
    public String users(Model model, Authentication authentication) {
        List<User> users = userService.findAll();
        User userCurrent = (User) authentication.getPrincipal();
        model.addAttribute("users", users);
        model.addAttribute("userCurrent", userCurrent);
        return "allUsers";
    }

    @PostMapping("/admin/delete")
    public String deleteUser(@ModelAttribute("user") User user) {
        userService.deleteUserById(user.getId());
        return "redirect:/admin/allUsers";
    }

    @PostMapping("/admin/update")
    public String updateUserPost(@ModelAttribute("user") User user, HttpServletRequest req) {
        Set<Role> roles = new HashSet<>();
        try {
            if (req.getParameter("role").equals("admin")) {
                roles.add(userService.getRoleByRole("ROLE_ADMIN"));
            } else if (req.getParameter("role").equals("user")) {
                roles.add(userService.getRoleByRole("ROLE_USER"));
            } else if (req.getParameter("role").equals("admin") && req.getParameter("role").equals("user")) {
                roles.add(userService.getRoleByRole("ROLE_ADMIN"));
                roles.add(userService.getRoleByRole("ROLE_USER"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setRoles(roles);
        userService.updateUser(user);
        return "redirect:/admin/allUsers";
    }

    @PostMapping("/admin/add")
    public String addUserPost(@ModelAttribute("user") User user) {
//        Set<Role> roles2 = user.getRoles();
//        Set<Role> roles = new HashSet<>();
//
//        try {
//            for (Role role : roles2) {
//                if (role.getName().equals("admin")) {
//                    roles.add(userService.getRoleByRole("ROLE_ADMIN"));
//                } else if (role.getName().equals("user")) {
//                    roles.add(userService.getRoleByRole("ROLE_USER"));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        user.setRoles(roles);
        userService.save(user);
        return "redirect:/admin/allUsers";
    }
}








//
//
//
//
//package com.springbootsecurity.projectSBS.controller;
//
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.security.core.Authentication;
//        import org.springframework.stereotype.Controller;
//        import org.springframework.ui.Model;
//        import org.springframework.web.bind.annotation.*;
//        import com.springbootsecurity.projectSBS.model.Role;
//        import com.springbootsecurity.projectSBS.model.User;
//        import com.springbootsecurity.projectSBS.service.UserService;
//
//        import javax.servlet.http.HttpServletRequest;
//        import java.util.HashSet;
//        import java.util.List;
//        import java.util.Set;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminController {
//
//    private UserService userService;
//
//    @Autowired
//    public AdminController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/allUsers")
//    public String users(Model model, Authentication authentication) {
//        List<User> users = userService.findAll();
//        User userCurrent = (User) authentication.getPrincipal();
//        model.addAttribute("users", users);
//        model.addAttribute("userCurrent", userCurrent);
//        return "allUsers";
//    }
//
//    @PostMapping("/delete")
//    public String deleteUser(@ModelAttribute("user") User user) {
//        userService.deleteUserById(user.getId());
//        return "redirect:/admin/allUsers";
//    }
//
//    @PostMapping("/update")
//    public String updateUserPost(@ModelAttribute("user") User user, HttpServletRequest req) {
//        Set<Role> roles = new HashSet<>();
//        try {
//            if (req.getParameter("role").equals("admin")) {
//                roles.add(userService.getRoleByRole("ROLE_ADMIN"));
//            } else if (req.getParameter("role").equals("user")) {
//                roles.add(userService.getRoleByRole("ROLE_USER"));
//            } else if (req.getParameter("role").equals("admin") && req.getParameter("role").equals("user")) {
//                roles.add(userService.getRoleByRole("ROLE_ADMIN"));
//                roles.add(userService.getRoleByRole("ROLE_USER"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        user.setRoles(roles);
//        userService.updateUser(user);
//        return "redirect:/admin/allUsers";
//    }
//
//    @PostMapping("/add")
//    public String addUserPost(@ModelAttribute("user") User user, HttpServletRequest req) {
//        Set<Role> roles2 = user.getRoles();
//        Set<Role> roles = new HashSet<>();
//
//        try {
//            for (Role role : roles2) {
//                if (role.getName().equals("admin")) {
//                    roles.add(userService.getRoleByRole("ROLE_ADMIN"));
//                } else if (role.getName().equals("user")) {
//                    roles.add(userService.getRoleByRole("ROLE_USER"));
//                }
////                else if (req.getParameter("role").equals("admin") && req.getParameter("role").equals("user")) {
////                    roles.add(userService.getRoleByRole("ROLE_ADMIN"));
////                    roles.add(userService.getRoleByRole("ROLE_USER"));
////                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        user.setRoles(roles);
//        userService.save(user);
//        return "redirect:/admin/allUsers";
//    }
//}

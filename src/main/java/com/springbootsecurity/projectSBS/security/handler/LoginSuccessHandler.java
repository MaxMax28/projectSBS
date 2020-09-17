package com.springbootsecurity.projectSBS.security.handler;

import com.springbootsecurity.projectSBS.model.Role;
import com.springbootsecurity.projectSBS.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException {
        User user = (User) authentication.getPrincipal();
        Set<Role> userRolesList = user.getRoles();

        if (userRolesList.contains(new Role("ROLE_ADMIN"))) {
            httpServletResponse.sendRedirect("/admin/allUsers");
        } else {
                httpServletResponse.sendRedirect("/user" + "?name=" + user.getName());
        }


//        for (Role role : userRolesList) {
//            if (role.getName().equals("ROLE_ADMIN")) {
//                httpServletResponse.sendRedirect("/admin/allUsers");
//            } else {
//                httpServletResponse.sendRedirect("/user" + "?name=" + user.getName());
//            }
//            //userRolesList.add(role.getName());
//        }
////        if (userRolesList.contains("ROLE_USER") && !userRolesList.contains("ROLE_ADMIN")) {
//            httpServletResponse.sendRedirect("/user" + "?name=" + user.getName());
//        } else if (userRolesList.contains("ROLE_ADMIN")) {
//            httpServletResponse.sendRedirect("/admin/allUsers");
//        } else {
//            httpServletResponse.sendRedirect("/");
//        }
    }
}
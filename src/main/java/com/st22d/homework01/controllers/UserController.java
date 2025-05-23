package com.st22d.homework01.controllers;

import com.st22d.homework01.domain.Company;
import com.st22d.homework01.domain.Role;
import com.st22d.homework01.domain.UserDemo;
import com.st22d.homework01.services.CompanyService;
import com.st22d.homework01.services.RoleService;
import com.st22d.homework01.services.UserService;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserService userService;
    private final RoleService roleService;
    private final CompanyService companyService;

    public UserController(UserService userService, RoleService roleService, CompanyService companyService) {
        this.userService = userService;
        this.roleService = roleService;
        this.companyService = companyService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<UserDemo> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/table-user";
    }

    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        UserDemo user = this.userService.getUserById(id);
        Set<Role> userRoles = user.getRoles();
        Company userCompany = user.getCompany();
        model.addAttribute("user", user);
        model.addAttribute("userRoles", userRoles);
        model.addAttribute("userCompany", userCompany);
        model.addAttribute("id", id);
        return "admin/user/user-detail";
    }

    @RequestMapping("/admin/user/create")
    public String getUserCreatePage(Model model) {
        model.addAttribute("newUser", new UserDemo());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") UserDemo user) {
        System.out.println("Run here: " + user);
        if (user == null || user.getEmail() == null || user.getEmail().isEmpty() ||
                user.getPassword() == null || user.getPassword().isEmpty()) {
            var errorMessage = "User information is not null.";
            model.addAttribute("errorMessage", errorMessage);
            return "/admin/user/create";
        }

        this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUserUpdatePage(Model model, @PathVariable long id) {
        UserDemo user = this.userService.getUserById(id);
        model.addAttribute("newUser", user);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String postUserUpdate(Model model, @ModelAttribute("newUser") UserDemo user) {
        UserDemo userFind = this.userService.getUserById(user.getId());
        if (userFind != null) {
            userFind.setAddress(user.getAddress());
            userFind.setFullName(user.getFullName());
            userFind.setPhone(user.getPhone());
            this.userService.handleSaveUser(userFind);
        }
        model.addAttribute("newUser", userFind);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getUserDeletePage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("newUser", new UserDemo());

        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
    public String postUserDelete(Model model, @ModelAttribute("newUser") UserDemo user) {
        this.userService.handleDeleteUser(user.getId());
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/assignrole/{userId}")
    public String getAssignRolePage(@PathVariable long userId, Model model) {
        UserDemo user = userService.getUserById(userId);
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "admin/user/assignrole";
    }

    @PostMapping("/admin/user/assignrole")
    public String assignUserRole(@RequestParam long userId, @RequestParam long roleId, Model model) {
        userService.assignRole(userId, roleId);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/assigncompany/{userId}")
    public String getAssignCompanyPage(@PathVariable long userId, Model model) {
        UserDemo user = userService.getUserById(userId);
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("user", user);
        model.addAttribute("companies", companies);
        return "admin/user/assigncompany";
    }

    @PostMapping("/admin/user/assigncompany")
    public String assignUserToCompany(@RequestParam long userId, @RequestParam long companyId) {
        userService.assignUserToCompany(userId, companyId);
        return "redirect:/admin/user";
    }
}

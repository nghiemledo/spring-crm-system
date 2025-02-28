package com.st22d.homework01.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.st22d.homework01.domain.Company;
import com.st22d.homework01.domain.Role;
import com.st22d.homework01.domain.UserDemo;
import com.st22d.homework01.repositories.CompanyRepository;
import com.st22d.homework01.repositories.RoleRepository;
import com.st22d.homework01.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CompanyRepository companyRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository,
            CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.companyRepository = companyRepository;
    }

    public String handleHello() {
        return "Hello from UserService";
    }

    public List<UserDemo> getAllUsers() {
        return this.userRepository.findAll();
    }

    public UserDemo getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public List<UserDemo> getAllUsersByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public UserDemo handleSaveUser(UserDemo user) {
        UserDemo newUser = this.userRepository.save(user);
        return newUser;
    }

    public void handleDeleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    public void assignRole(long userId, long roleId) {
        UserDemo user = userRepository.findById(userId);
        Role role = roleRepository.findById(roleId);
        user.getRoles().add(role);
        userRepository.save(user);
    }

    public void assignUserToCompany(long userId, long companyId) {
        UserDemo user = userRepository.findById(userId);
        Company company = companyRepository.findById(companyId);

        if (user != null && company != null) {
            user.setCompany(company);
            userRepository.save(user);
        }
    }
}

package com.example.diskontcard.controller;

import com.example.diskontcard.entity.Users;
import com.example.diskontcard.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/card")
public class UsersController {

    // http://localhost:8080/card/add?discountNumber=12321&validity=12.12.2022&discountPercentage=30&owner=Denis&dateBirthday=02.08.2003&number=063192414&overdue=no

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser (
            @RequestParam Integer discountNumber,
            @RequestParam String validity,
            @RequestParam Integer discountPercentage,
            @RequestParam String owner,
            @RequestParam String dateBirthday,
            @RequestParam Integer number,
            @RequestParam String overdue){

        Users users = new Users();
        users.setDiscountNumber(discountNumber);
        users.setValidity(validity);
        users.setDiscountPercentage(discountPercentage);
        users.setOwner(owner);
        users.setDateBirthday(dateBirthday);
        users.setNumber(number);
        users.setOverdue(overdue);

        usersRepository.save(users);

        return "Данні збережені!";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @GetMapping(path = "/owner")
    public @ResponseBody Iterable<Users> getInfoFindByOwner(@RequestParam String owner){
        return usersRepository.findByOwner(owner);
    }


}
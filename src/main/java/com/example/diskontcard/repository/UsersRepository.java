package com.example.diskontcard.repository;

import com.example.diskontcard.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface UsersRepository extends CrudRepository<Users, BigInteger> {

    List<Users> findByOwner(String owner);

}
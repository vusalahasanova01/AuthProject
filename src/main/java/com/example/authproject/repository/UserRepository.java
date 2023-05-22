package com.example.authproject.repository;

import com.example.demo._2a.tables.records.UsersRecord;


public interface UserRepository {

    UsersRecord findByEmail(String email);

}

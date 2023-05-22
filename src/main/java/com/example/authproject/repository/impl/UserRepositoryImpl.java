package com.example.authproject.repository.impl;

import com.example.authproject.repository.UserRepository;
import com.example.demo._2a.tables.records.UsersRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.InsertResultStep;
import org.springframework.stereotype.Repository;

import static com.example.demo._2a.tables.Users.USERS;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final DSLContext dslContext;
    @Override
    public UsersRecord findByEmail(String email) {
        return dslContext.selectFrom(USERS)
                .where(USERS.EMAIL.eq(email))
                .fetchInto(UsersRecord.class)
                .stream().findFirst().orElseThrow();
    }
}

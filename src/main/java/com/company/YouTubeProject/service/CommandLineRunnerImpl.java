package com.company.YouTubeProject.service;

import com.company.YouTubeProject.entity.ProfileEntity;
import com.company.YouTubeProject.enums.GeneralStatus;
import com.company.YouTubeProject.enums.ProfileRole;
import com.company.YouTubeProject.repository.ProfileRepository;


import com.company.YouTubeProject.util.MD5Util;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Optional;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    // Bu databaseda ADMINni yaratadi paroli :1 pochtasi :admin@gmail.com
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private DataSource dataSource;
    @Override
    public void run(String... args) throws Exception {
        Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
        String email = "admin@gmail.com";
        Optional<ProfileEntity> profileEntity = profileRepository.findByEmail(email);
        if (profileEntity.isEmpty()) {
            ProfileEntity entity = new ProfileEntity();
            entity.setName("Admin");
            entity.setSurname("Adminov");
            entity.setEmail(email);
            entity.setRole(ProfileRole.ROLE_ADMIN);
            entity.setPassword(MD5Util.getMd5Hash("1"));
            entity.setStatus(GeneralStatus.ACTIVE);
            profileRepository.save(entity);
            System.out.println("Admin created");
        }
    }
}

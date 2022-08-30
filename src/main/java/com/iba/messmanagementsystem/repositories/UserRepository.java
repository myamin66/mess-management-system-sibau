package com.iba.messmanagementsystem.repositories;

import com.iba.messmanagementsystem.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    public UserModel findUserByUsername(String username);

    @Transactional
    @Modifying
    @Query("UPDATE UserModel user set user.visible=false where user.id=?1")
    public void deleteByVisible(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE UserModel user set user.visible=true where user.id=?1")
    public void recoverByVisible(Integer id);
}

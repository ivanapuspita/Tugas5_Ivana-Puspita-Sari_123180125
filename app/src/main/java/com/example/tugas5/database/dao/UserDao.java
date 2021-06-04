package com.example.tugas5.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tugas5.database.entitas.User;

import java.util.List;


@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("INSERT INTO user (name, `No Handphone`) VALUES(:name, :noHp)")
    void insertAll(String name, String noHp);

    @Query("UPDATE user SET name=:name, `No Handphone`=:noHp WHERE userId=:uid")
    void update(int uid, String name, String noHp);

    @Query("SELECT * FROM user WHERE userId=:uid")
    User get(int uid);

    @Delete
    void delete(User user);
}

package com.example.tugas5.database.entitas;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    public int userId;

    @ColumnInfo(name = "Name")
    public String fullName;

    @ColumnInfo(name = "No Handphone")
    public String noHp;

}

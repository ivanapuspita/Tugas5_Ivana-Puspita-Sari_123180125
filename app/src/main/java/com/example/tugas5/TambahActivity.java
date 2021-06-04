package com.example.tugas5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tugas5.database.AppDatabase;
import com.example.tugas5.database.entitas.User;

public class TambahActivity extends AppCompatActivity {
    private EditText editName, editHp;
    private Button btnSave;
    private AppDatabase database;
    private int uid = 0;
    private boolean isEdit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        editName =findViewById(R.id.full_name);
        editHp = findViewById(R.id.no_hp);
        btnSave = findViewById(R.id.btn_save);

        database = AppDatabase.getInstance(getApplicationContext());

        Intent intent = getIntent();
        uid = intent.getIntExtra("uid", 0);
        if (uid > 0) {
            isEdit = true;
            User user = database.UserDao().get(uid);
            editName.setText(user.fullName);
            editHp.setText(user.noHp);
        } else {
            isEdit = false;
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                User user = new User();
//                user.fullName =editName.getText().toString();
//                user.noHp = editHp.getText().toString();
                if (isEdit) {
                    //edit
                    database.UserDao().update(uid, editName.getText().toString(), editHp.getText().toString());
                } else {
                    //tambah
                    database.UserDao().insertAll(editName.getText().toString(), editHp.getText().toString());
                }
                finish();
            }
        });

    }
}
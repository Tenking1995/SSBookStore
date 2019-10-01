package com.example.ssbookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateBook extends AppCompatActivity{

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_book);

        final Button btnEdit = (Button) findViewById(R.id.btnEdit);
        Button btnBack = (Button) findViewById(R.id.btnBack);

        Intent intent = getIntent();
        final Intent intent2 = new Intent(UpdateBook.this, MainActivity.class);
        String oldname = intent.getStringExtra("name");
        String oldauthor = intent.getStringExtra("author");
        String olddescription = intent.getStringExtra("description");
        String olddate = intent.getStringExtra("date");
        final int position = intent.getIntExtra("position", -1);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etAuthor = (EditText) findViewById(R.id.etAuthor);
        final EditText etDecription = (EditText) findViewById(R.id.etDescription);

        etName.setText(oldname);
        etAuthor.setText(oldauthor);
        etDecription.setText(olddescription);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnEdit.getText().equals("Edit")) {
                    etName.setFocusableInTouchMode(true);
                    etAuthor.setFocusableInTouchMode(true);
                    etDecription.setFocusableInTouchMode(true);
                    btnEdit.setText("Done");
                }else{
                    String name = etName.getText().toString();
                    String author = etAuthor.getText().toString();
                    String description = etDecription.getText().toString();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd MM yy");
                    final String date = sdf.format(new Date());


                    intent2.putExtra("name", name);
                    intent2.putExtra("author", author);
                    intent2.putExtra("date", date);
                    intent2.putExtra("description", description);
                    intent2.putExtra("position", position);

                    etName.setFocusable(false);
                    etAuthor.setFocusable(false);
                    etDecription.setFocusable(false);
                    btnEdit.setText("Edit");
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });
    }
}

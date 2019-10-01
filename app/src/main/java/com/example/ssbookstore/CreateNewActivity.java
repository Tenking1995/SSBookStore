package com.example.ssbookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CreateNewActivity extends AppCompatActivity {

    private ArrayList<Book> bookArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_create_new);


        ImageView imgView = (ImageView) findViewById(R.id.imageView);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog btms = new BottomSheetDialog();
                btms.show(getSupportFragmentManager(), "bottomSheetAction");
            }
        });
        bookArrayList = new ArrayList<Book>();
        final TextView editName = (TextView) findViewById(R.id.etName);
        Button btnDone = (Button) findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editName.getText().toString().equals("")){
                    Toast.makeText(CreateNewActivity.this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
                }else {

                    String name = ((EditText) findViewById(R.id.etName)).getText().toString();
                    String author = ((EditText) findViewById(R.id.etAuthor)).getText().toString();
                    String description = ((EditText) findViewById(R.id.etDescription)).getText().toString();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd MM yy");
                    final String date = sdf.format(new Date());

                    Intent intent = new Intent(CreateNewActivity.this, MainActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("author", author);
                    intent.putExtra("date", date);
                    intent.putExtra("description", description);
                    startActivity(intent);

                }
            }
        });
    }


}

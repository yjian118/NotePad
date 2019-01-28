package com.example.notepad;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.Manifest;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class NoteViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_view);
        ExampleDBHelper mydb;

        TextView titleview=(TextView)findViewById(R.id.title_view);
        TextView textview=(TextView)findViewById(R.id.text_view);
        ImageView iv2=(ImageView)findViewById(R.id.iv2);


        String sub_id=getIntent().getStringExtra("id");
        String title=getIntent().getStringExtra("title");
        String text=getIntent().getStringExtra("text");
        String imagePath=getIntent().getStringExtra("image");
        titleview.setText(title);
        textview.setText(text);

        /*mydb = new ExampleDBHelper(getApplicationContext());
        Cursor cursor = mydb.getPerson(sub_id);
        String imagePath = cursor.getString(cursor.getColumnIndex("image"));*/


        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        iv2.setImageBitmap(bitmap);
    }
}
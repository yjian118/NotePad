package com.example.notepad;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


public class NoteViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_view);

        TextView titleview=(TextView)findViewById(R.id.title_view);
        TextView textview=(TextView)findViewById(R.id.text_view);
        ImageView iv2=(ImageView)findViewById(R.id.iv2);


        String sub_id=getIntent().getStringExtra("id");
        String title=getIntent().getStringExtra("title");
        String text=getIntent().getStringExtra("text");
        String imagePath=getIntent().getStringExtra("image");
        titleview.setText(title);
        textview.setText(text);

        // this function only works for image saved in db as bitmap
        /*mydb = new ExampleDBHelper(getApplicationContext());
        Cursor cursor = mydb.getPerson(sub_id);
        String imagePath = cursor.getString(cursor.getColumnIndex("image"));*/

        // show image from the its path
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        iv2.setImageBitmap(bitmap);
    }
}
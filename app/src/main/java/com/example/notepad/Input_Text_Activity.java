package com.example.notepad;

import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Input_Text_Activity extends AppCompatActivity {
    ExampleDBHelper db;
    EditText n_title;
    EditText n_text;
    String title,text;
    public static SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_text);
        db=new ExampleDBHelper(getApplicationContext());
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);


        n_title=(EditText) findViewById(R.id.title);
        n_text=(EditText) findViewById(R.id.text);



        Button clickButton = (Button) findViewById(R.id.clickButton);
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                title = n_title.getText().toString();
                text = n_text.getText().toString();

                if(title.length() == 0){
                    SharedPreferences.Editor editor = pref.edit();

                    int idName = pref.getInt("name", 0);
                    idName++;
                    title="new document "+idName ;
                    editor.putInt("name",idName);
                    editor.commit();

                };

                if( text.length() == 0){
                    Toast.makeText(getApplicationContext(), "title or text box is empty !!!",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    db.insertPerson(title,text);
                    Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
                    finish();}
            }
        });
    }

}
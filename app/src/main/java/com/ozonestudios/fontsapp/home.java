package com.ozonestudios.fontsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class home extends AppCompatActivity {
    private mydatabase dbs = new mydatabase(this);
    private EditText id_EditText,Name, Age;
    private ListView lists;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        id_EditText=findViewById(R.id.id_EditeText);
        Name = findViewById(R.id.name);
        Age = findViewById(R.id.age);
        lists = findViewById(R.id.fontslist);
showdata();

    }

    public void addtodb(View view) {
        String name = Name.getText().toString();
        String age = Age.getText().toString();
        dbs.insertData(name, age);
        Name.setText("");
        Age.setText("");
        showdata();
        //your method here
    }

    public void updatedb(View view) {
        String name = Name.getText().toString();
        String age = Age.getText().toString();
        String id =id_EditText.getText().toString();

        dbs.updateData(id,name,age);
        showdata();
        id_EditText.setText("");
        Name.setText("");
        Age.setText("");
        //update method
    }

    public void deleteFromDb(View view) {
        String id =id_EditText.getText().toString();
dbs.Delete(id);
id_EditText.setText("");
showdata();
 //update method
    }

    /**
     * public void setfont(View view) {
     * String s=text1.getText().toString();
     * textView.setText(s);
     * textView.setShadowLayer(8,3,3,Color.BLACK);
     * textView.setTextSize(24);
     * <p>
     * textView.setTextColor(Color.rgb(0,240,150));
     * tryfont.setShadowLayer(8,5,5,R.color.colorPrimaryDark);
     * if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
     * tryfont.setElevation(5);
     * }
     * <p>
     * <p>
     * }
     **/

    public void showdata() {

        ArrayList lista = dbs.getAllrecords();
        myAdapter adapter = new myAdapter(this,lista);
        lists.setAdapter(adapter);
    }
}

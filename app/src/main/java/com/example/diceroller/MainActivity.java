package com.example.diceroller;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.diceroller.R.*;
import static com.example.diceroller.R.id.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        Toolbar toolbar = findViewById(id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("SetTextI18n")
    public void on_button_click(View view){
        //basic dice functionality
        TextView tv = this.findViewById(numberTextView);

        Random r = new Random();
        int number = r.nextInt(7);

        tv.setText(Integer.toString(number));

        String inputNum = ((EditText)findViewById(inputText)).getText().toString();
        //User input, comparison, and output
        int inNumber = 0;
        //int score = 0;

        TextView scoreOut = this.findViewById(scoreBox);

        if (inputNum.matches(""))
        {
            Toast.makeText(this, "Enter a number.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            inNumber = Integer.parseInt(inputNum);
        }

        int score = 0;
        if (inNumber == number)
        {


                Toast.makeText(this, "Congratulations, the numbers are equal.", Toast.LENGTH_SHORT).show();
                scoreOut.setText(Integer.toString(score));
                score = score + 1;

        }
    }
}

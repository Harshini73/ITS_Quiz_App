package com.example.klsriharshini.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by K L SRIHARSHINI on 29-03-2017.
 */
public class Options_menu extends Activity {

    Button button1, button2, button3;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.optionsmenu);


        // the textview in which the question will be displayed

        // the three buttons,

        // the idea is to set the text of three buttons with the options from question bank

        button1 = (Button) findViewById(R.id.btnmath);

        button2 = (Button) findViewById(R.id.btneng);

        button3 = (Button) findViewById(R.id.btnapt);


        button1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(Options_menu.this,

                        QuestionActivity.class);
                startActivity(intent);


            }

        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(Options_menu.this,

                        QuestionActivity1.class);
                startActivity(intent);


            }

        });

        button3.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(Options_menu.this,

                        QuestionActivity2.class);
                startActivity(intent);


            }

        });

    }
}

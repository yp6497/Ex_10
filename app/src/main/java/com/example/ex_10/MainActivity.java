package com.example.ex_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Yulia Piavka <yp6497@bs.amalnet.k12.il>
 * @version 1.1
 * @since 21/12/2020
 * short description- 3 buttons, one editText for an input and one textView to show the input. always adds new text(never deleting him).
 */
public class MainActivity extends AppCompatActivity {

        EditText ed;
        TextView t;
        /**
         * Holds the input from the edit text.
         */
        String st,
        /**
         * Holds the info from the file.
         */
        s;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ed = findViewById(R.id.ed);
            t = findViewById(R.id.t);

            /**
             * reads the information in the file and shows it in the text view.
             */
            try {
                FileInputStream fis = openFileInput("test.txt");
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                StringBuffer sb = new StringBuffer();
                st = br.readLine();
                while (st != null) {
                    sb.append(st + '\n');
                    st = br.readLine();
                }
                s = sb.toString(); //
                isr.close();
                t.setText(s);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * short description- saves the text and add it to the text who was entered before.
         * @param view the view
         */
        public void saveB(View view) {

            try {
                FileOutputStream fos = openFileOutput("test.txt", MODE_PRIVATE);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);
                st = s + ed.getText().toString();
                s = st;
                bw.write(st);
                bw.close();
                t.setText(st);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * short description- reset the history of the text view and the edit text.
         * @param view the view
         */
        public void resetB(View view) {

            ed.setText("");
            t.setText("");
        }

        /**
         * short description- saves the text and adds it to the text entered before and exits the app.
         * @param view the view
         */
        public void exitB(View view) {

            try {
                FileOutputStream fos = openFileOutput("test.txt", MODE_PRIVATE);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);
                st = st + ed.getText().toString();
                bw.write(st);
                bw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            finish();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        /**
         * description- if "Credits" selected: goes to the credits screen.
         */
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            String st = item.getTitle().toString();
            if (st.endsWith("Credits")) {
                Intent si = new Intent(this, creditsActivity.class);
                startActivity(si);
            }
            return true;
        }
    }

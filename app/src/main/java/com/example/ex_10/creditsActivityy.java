package com.example.ex_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class creditsActivityy extends AppCompatActivity {

    /**
     * @author Yulia Piavka <yp6497@bs.amalnet.k12.il>
     * @version 1.1
     * @since 21/12/2020
     * short description- the credits.
     */
    public class creditsActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_credits);
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        /**
         * description- if "Main screen" selected: return back to the Main activity.
         */
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            String st = item.getTitle().toString();
            if (st.endsWith("Main screen")) {
                Intent si = new Intent(this, creditsActivity.class);
                startActivity(si);
            }
            return true;
        }
    }
}
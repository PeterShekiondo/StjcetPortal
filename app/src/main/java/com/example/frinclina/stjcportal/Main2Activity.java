package com.example.frinclina.stjcportal;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import de.hdodenhof.circleimageview.CircleImageView;


public class Main2Activity extends AppCompatActivity {

    private LinearLayout ac1,ac2,ac3,ac4,ac5,ac6,ac7,ac8;

    private Toolbar accounttoolbar;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        accounttoolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(accounttoolbar);
        getSupportActionBar().setTitle("Student Account");


    }

    public void Results (View v){
        ac1= findViewById(R.id.results);
        ac1.animate().rotation(ac1.getRotation()-360).start();

        Intent intent1= new Intent(Main2Activity.this,Resultss.class);
        startActivity(intent1);
    }

    public void Admission (View v){
        ac2= findViewById(R.id.admission);
        ac2.animate().rotation(ac2.getRotation()-360).start();

        Intent intent2= new Intent(Main2Activity.this, Admission.class);
        startActivity(intent2);
    }

    public void Clearance(View v){
        ac3= findViewById(R.id.clearance);
        ac3.animate().rotation(ac3.getRotation()-360).start();
    }

    public void Library(View v){
        ac4= findViewById(R.id.library);
        ac4.animate().rotation(ac4.getRotation()-360).start();
    }

    public void Project(View v){
        ac5= findViewById(R.id.projects);
        ac5.animate().rotation(ac5.getRotation()-360).start();

        Intent intent5= new Intent(Main2Activity.this, Projectss.class);
        startActivity(intent5);

    }

    public void Iptr (View v){
        ac6= (LinearLayout)findViewById(R.id.iptr);
        ac6.animate().rotation(ac6.getRotation()-360).start();

        Intent intent6= new Intent(Main2Activity.this, Iptr.class);
        startActivity(intent6);
    }

    public void Nhif(View v){
        ac7= findViewById(R.id.nhif);
        ac7.animate().rotation(ac7.getRotation()-360).start();
    }

    public void Announcements(View v){
        ac8= findViewById(R.id.announcements);
        ac8.animate().rotation(ac8.getRotation()-360).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.account_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_Logout:
                logout();
                return true;

            case R.id.action_myaccount:
                accountsetting();
                return true;

                default:
                    return false;
        }

    }

    private void accountsetting() {

        Intent accountintent= new Intent(Main2Activity.this, Accountsettings.class);
        startActivity(accountintent);

    }

    private void logout() {

      //  mAuth.signOut();
        sendout();

    }

    private void sendout() {

        Intent loginintent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(loginintent);
        //finish();
    }
}

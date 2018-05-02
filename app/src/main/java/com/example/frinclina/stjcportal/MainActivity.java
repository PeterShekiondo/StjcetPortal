package com.example.frinclina.stjcportal;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


private ImageButton imageb2,imageb3,imageb4,imageb5,imageb6,imageb7,imageb8,imageb9;
 LinearLayout home1, home2, home3, home4, home5, home6, home7, home8, home9; // container for image buttons in  home page

    private EditText lname;
    private EditText lpassword;
    private EditText uname;
    private EditText ename;
    private EditText epassword;
    private EditText epassword2;
    private FirebaseAuth mAuth;
    private ProgressBar logprogress;
    private ProgressBar regprogress;
    private DatabaseReference mDatabase;

    private Dialog myDialog,myDialog2;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDialog = new Dialog(this);
        myDialog2 = new Dialog(this);

    home1= (LinearLayout)findViewById(R.id.Account);
    home1.animate().rotation(home1.getRotation()+360).start();
    home2= (LinearLayout)findViewById(R.id.Coursess);
    home2.animate().rotation(home2.getRotation()-360).start();
    home3= (LinearLayout)findViewById(R.id.Calendarss);
    home3.animate().rotation(home3.getRotation()+360).start();
    home4= (LinearLayout)findViewById(R.id.Newss);
    home4.animate().rotation(home4.getRotation()-360).start();
    home5=(LinearLayout)findViewById(R.id.Mediass);
    home5.animate().rotation(home5.getRotation()+360).start();
    home6=(LinearLayout)findViewById(R.id.Eventss);
    home6.animate().rotation(home6.getRotation()-360).start();
    home7=(LinearLayout)findViewById(R.id.Stjoseph);
    home7.animate().rotation(home7.getRotation()+360).start();
    home8=(LinearLayout)findViewById(R.id.Mapss);
    home8.animate().rotation(home8.getRotation()-360).start();
    home9=(LinearLayout)findViewById(R.id.Sportss);
    home9.animate().rotation(home9.getRotation()+360).start();


    }



    @Override
    protected void onStart() {
        super.onStart();

        home1= (LinearLayout)findViewById(R.id.Account);
        home1.animate().rotation(home1.getRotation()+360).start();
        home2= (LinearLayout)findViewById(R.id.Coursess);
        home2.animate().rotation(home2.getRotation()-360).start();
        home3= (LinearLayout)findViewById(R.id.Calendarss);
        home3.animate().rotation(home3.getRotation()+360).start();
        home4= (LinearLayout)findViewById(R.id.Newss);
        home4.animate().rotation(home4.getRotation()-360).start();
        home5=(LinearLayout)findViewById(R.id.Mediass);
        home5.animate().rotation(home5.getRotation()+360).start();
        home6=(LinearLayout)findViewById(R.id.Eventss);
        home6.animate().rotation(home6.getRotation()-360).start();
        home7=(LinearLayout)findViewById(R.id.Stjoseph);
        home7.animate().rotation(home7.getRotation()+360).start();
        home8=(LinearLayout)findViewById(R.id.Mapss);
        home8.animate().rotation(home8.getRotation()-360).start();
        home9=(LinearLayout)findViewById(R.id.Sportss);
        home9.animate().rotation(home9.getRotation()+360).start();
    }
    @Override
    protected void onResume() {
        super.onResume();
        home1= (LinearLayout)findViewById(R.id.Account);
        home1.animate().rotation(home1.getRotation()+360).start();
        home2= (LinearLayout)findViewById(R.id.Coursess);
        home2.animate().rotation(home2.getRotation()-360).start();
        home3= (LinearLayout)findViewById(R.id.Calendarss);
        home3.animate().rotation(home3.getRotation()+360).start();
        home4= (LinearLayout)findViewById(R.id.Newss);
        home4.animate().rotation(home4.getRotation()-360).start();
        home5=(LinearLayout)findViewById(R.id.Mediass);
        home5.animate().rotation(home5.getRotation()+360).start();
        home6=(LinearLayout)findViewById(R.id.Eventss);
        home6.animate().rotation(home6.getRotation()-360).start();
        home7=(LinearLayout)findViewById(R.id.Stjoseph);
        home7.animate().rotation(home7.getRotation()+360).start();
        home8=(LinearLayout)findViewById(R.id.Mapss);
        home8.animate().rotation(home8.getRotation()-360).start();
        home9=(LinearLayout)findViewById(R.id.Sportss);
        home9.animate().rotation(home9.getRotation()+360).start();

    }

    public void coursess(View v){
    home2= (LinearLayout)findViewById(R.id.Coursess);
    home2.animate().rotation(home2.getRotation()-360).start();

   // Intent intent= new Intent(MainActivity.this, Courses.class);
    //startActivity(intent);
}

public void calendarss(View v){
    home3= (LinearLayout)findViewById(R.id.Calendarss);
    home3.animate().rotation(home3.getRotation()-360).start();
}

public void newss(View v){
    home4= (LinearLayout)findViewById(R.id.Newss);
    home4.animate().rotation(home4.getRotation()-360).start();
}

public void mediass(View v){
    home5=(LinearLayout)findViewById(R.id.Mediass);
    home5.animate().rotation(home5.getRotation()-360).start();
}

public void eventss(View v){
    home6=(LinearLayout)findViewById(R.id.Eventss);
    home6.animate().rotation(home6.getRotation()-360).start();
}

public void stjoseph(View v){
    home7=(LinearLayout)findViewById(R.id.Stjoseph);
    home7.animate().rotation(home7.getRotation()-360).start();
}

public void mapss(View v){
    home8=(LinearLayout)findViewById(R.id.Mapss);
    home8.animate().rotation(home8.getRotation()-360).start();
}

public void sportss(View v){
    home9=(LinearLayout)findViewById(R.id.Sportss);
    home9.animate().rotation(home9.getRotation()-360).start();
}

    public void showPopup(View v){

    home1= (LinearLayout)findViewById(R.id.Account);
    home1.animate().rotation(home1.getRotation()-360).start();
//    imageb1= (ImageButton)findViewById(R.id.imageButton1);             Image button ratation animation ( imageb1 not declare)
//    imageb1.animate().rotation(imageb1.getRotation()-360).start();

        myDialog.setContentView(R.layout.login);

        mAuth=FirebaseAuth.getInstance();

         lname = (EditText) myDialog.findViewById(R.id.editText118);
        lpassword = (EditText) myDialog.findViewById(R.id.editText117);
        logprogress = (ProgressBar) myDialog.findViewById(R.id.progressBar1);

//        AuthListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                if (firebaseAuth.getCurrentUser() != null){
//                    startActivity(new Intent(MainActivity.this, Main2Activity.class));
//                }
//
//            }
//        };


//firebase Get instance

        final Button btnLog;
        btnLog =(Button) myDialog.findViewById(R.id.button117);
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logprogress.setVisibility(View.VISIBLE);
                startLogin();
                logprogress.setVisibility(View.INVISIBLE);
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
  }



    public void showPopup2(View v){

        myDialog2.setContentView(R.layout.register);

//// object creation and define events
        uname = (EditText) myDialog2.findViewById(R.id.editText);
        ename = (EditText) myDialog2.findViewById(R.id.editText2);
        epassword = (EditText) myDialog2.findViewById(R.id.editText3);
        epassword2 = (EditText) myDialog2.findViewById(R.id.editText4);
        regprogress = (ProgressBar) myDialog2.findViewById(R.id.progressBar2);

        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference().child("users");

        final Button btnReg;
        TextView login;
        login =(TextView) myDialog2.findViewById(R.id.textView11);
        btnReg =(Button) myDialog2.findViewById(R.id.button);

        // Log in text view
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog2.dismiss();
            }
        });

        // Register button
       btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
 //              btnReg.animate().rotation(btnReg.getRotation()-360).start();
                regprogress.setVisibility(View.VISIBLE);
                startregister();
                regprogress.setVisibility(View.INVISIBLE);
            }
        });

        myDialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog2.show();

    }


    private  void startregister(){
        String Username=  uname.getText().toString().trim();
        String Email = ename.getText().toString().trim();
        String Password = epassword.getText().toString().trim();
        String Password2 = epassword2.getText().toString().trim();
        regprogress = (ProgressBar) myDialog2.findViewById(R.id.progressBar2);

        if ( TextUtils.isEmpty(Username) ||
                TextUtils.isEmpty(Email) ||
                TextUtils.isEmpty(Password) ||
                TextUtils.isEmpty(Password2)) {
            Toast.makeText(MainActivity.this, "Username, Email or Password field cannot be empty", Toast.LENGTH_LONG)
                    .show();

        } else if (TextUtils.isDigitsOnly(Email)) {
            Toast.makeText(MainActivity.this, "Wrong email", Toast.LENGTH_LONG)
                    .show();

        }
       else if ( Password.equals(Password2)){
 //           regprogress.setVisibility(View.VISIBLE);
            mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "failed to  register, please check your credentilas or internet and try again",
                                Toast.LENGTH_SHORT)
                                .show();
                    }else {

                        //String user_id= mAuth.getCurrentUser().getUid();

                        Intent intent= new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);

                    }
                }
            });
  //          regprogress.setVisibility(View.INVISIBLE);

        }
        else {
            Toast.makeText(MainActivity.this, "Password did not match", Toast.LENGTH_LONG)
                    .show();
        }
    }

    private void startLogin() {
        String Email = lname.getText().toString();
        String Password = lpassword.getText().toString();
        logprogress = (ProgressBar) myDialog.findViewById(R.id.progressBar1);

        if (TextUtils.isEmpty(Email) || TextUtils.isEmpty(Password)) {
            Toast.makeText(MainActivity.this, "Email or Password field cannot be empty", Toast.LENGTH_LONG)
                    .show();

        } else if (TextUtils.isDigitsOnly(Email)) {
            Toast.makeText(MainActivity.this, "Wrong email", Toast.LENGTH_LONG)
                    .show();

        } else {
 //           logprogress.setVisibility(View.VISIBLE);
            mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){

                                Toast.makeText(MainActivity.this,"Sign incomplete please chek your credentials or internet and try again", Toast.LENGTH_LONG).show();
                            }else {
                                Toast.makeText(MainActivity.this,"Sign in complited Successfully", Toast.LENGTH_LONG).show();
                                Intent intent= new Intent(MainActivity.this, Main2Activity.class);
                                startActivity(intent);
finish();
                            }
                        }
                    });
 //           logprogress.setVisibility(View.INVISIBLE);
        }


    }
}


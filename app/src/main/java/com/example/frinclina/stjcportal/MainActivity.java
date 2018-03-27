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


ImageButton imageb1,imageb2,imageb3,imageb4,imageb5,imageb6,imageb7,imageb8,imageb9;

     private EditText lname;
     private EditText lpassword;
     private EditText uname;
    private EditText ename;
    private EditText epassword;
    private EditText epassword2;
    private  FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private Dialog myDialog,myDialog2;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDialog = new Dialog(this);
        myDialog2 = new Dialog(this);
    }



    public void showPopup(View v){

    imageb1= (ImageButton)findViewById(R.id.imageButton1);
    imageb1.animate().rotation(imageb1.getRotation()-360).start();

        myDialog.setContentView(R.layout.login);

        mAuth=FirebaseAuth.getInstance();

         lname = (EditText) myDialog.findViewById(R.id.editText118);
        lpassword = (EditText) myDialog.findViewById(R.id.editText117);

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
        btnLog.animate().rotation(btnLog.getRotation()-360).start();
                startLogin();

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
               btnReg.animate().rotation(btnReg.getRotation()-360).start();
                startregister();
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
//        else if ( Password != Password2){
//            Toast.makeText(MainActivity.this, "Password did not match", Toast.LENGTH_LONG)
//                    .show();
//
//        }
        else {
            mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Failed to sign in please check your internet and try agin",
                                Toast.LENGTH_SHORT)
                                .show();
                    }else {
                         String user_id= mAuth.getCurrentUser().getUid();

                        DatabaseReference cureent_user_db= mDatabase.child(user_id);
                        cureent_user_db.child("name").setValue(uname);
                        cureent_user_db.child("image").setValue("default");

                        Intent intent= new Intent(MainActivity.this, Main2Activity.class);
//                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);

                    }
                }
            });

        }
    }

    private void startLogin() {
        String Email = lname.getText().toString();
        String Password = lpassword.getText().toString();

        if (TextUtils.isEmpty(Email) || TextUtils.isEmpty(Password)) {
            Toast.makeText(MainActivity.this, "Email or Password field cannot be empty", Toast.LENGTH_LONG)
                    .show();

        } else if (TextUtils.isDigitsOnly(Email)) {
            Toast.makeText(MainActivity.this, "Wrong email", Toast.LENGTH_LONG)
                    .show();

        } else {
            mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"Sign incomplete please chek your internet and try again", Toast.LENGTH_LONG).show();
                            }else {
                                Toast.makeText(MainActivity.this,"Sign in complited Successfully", Toast.LENGTH_LONG).show();
                                Intent intent= new Intent(MainActivity.this, Main2Activity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);

                            }
                        }
                    });
        }


    }
}


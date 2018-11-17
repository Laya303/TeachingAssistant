package devaguptam.sreelaya.g.teachingassistant;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    private ProgressDialog progressDialog;
    private TextView goto_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        editTextEmail = (EditText) findViewById(R.id.ed1);
        editTextPassword = (EditText) findViewById(R.id.ed2);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        goto_signup=findViewById(R.id.goto_signup);

        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        buttonLogin.setOnClickListener(this);
    }

    private void loginUser(){

        String email = editTextEmail.getText().toString().trim();
        final String password  = editTextPassword.getText().toString().trim();

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password", Toast.LENGTH_LONG).show();
            return;
        }



        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.

                        if (!task.isSuccessful()) {
                            // there was an error

                                Toast.makeText(Login.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(Login.this, "Successfully logged in", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    @Override
    public void onClick(View view) {
        //calling register method on click
        loginUser();
    }

    public void gotoSignup(View view)
    {
        Intent i= new Intent(Login.this,SignUp.class);
        startActivity(i);

    }
}

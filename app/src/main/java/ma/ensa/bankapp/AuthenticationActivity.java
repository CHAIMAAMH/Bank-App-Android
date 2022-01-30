package ma.ensa.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AuthenticationActivity extends AppCompatActivity {

    EditText login;
    EditText pass;
    SharedPreferences sharedPreferences;
    Button btnLogin;
    CheckBox showPassword;


    public static final String Username = "USERNAME";
    public static final String Password = "PASSWORD";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);
        login = findViewById(R.id.username);
        pass = findViewById(R.id.password);

        sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);

        if(sharedPreferences.contains(Username)){
            Intent intent = new Intent(getApplicationContext(),TransactionActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnLogin = findViewById(R.id.login);
        showPassword = findViewById(R.id.showPassword);
        // 1. Check si l'utilisateur a deja sauvegarde qqchose dans le sharedPref
        // 2. Si oui ==> StartActivity vers ecran de la liste
        // 3. Sinon on reste sur lecran authentification
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sauvegarder login et mdp dans shared Pref
                String username = login.getText().toString();
                String password = pass.getText().toString();
                if (username.equals("chaimae") && password.equals("1234")) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(Username, username);
                    editor.putString(Password, password);
                    editor.apply();
                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), TransactionActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Invalid User Details", Toast.LENGTH_SHORT).show();
                    login.setText("");
                    login.requestFocus();
                    pass.setText("");
                }
            }
        });

        showPassword.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(!isChecked){
                pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            else{
                pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        });
    }
}
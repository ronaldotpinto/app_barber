package br.com.app_barber;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etSenha;
    private Button btnEntrar, btnCadastro;

    private FirebaseAuth autenticacao;
    private FirebaseAuth.AuthStateListener authStateListener;
    String emailCompar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        autenticacao = FirebaseAuth.getInstance();


        authStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if ( user != null ){
                    Intent intent = new Intent( LoginActivity.this,
                            ListaActivity.class);
                    startActivity( intent );
                }

            }

        };

        etEmail = (EditText) findViewById(R.id.etLogin);
        etSenha = (EditText) findViewById(R.id.etSenha);

        btnCadastro = (Button) findViewById(R.id.btnCadastro);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        LoginActivity.this, CadastroActivity.class);
                startActivity( intent );
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrar();
            }
        });
    }

    private void entrar(){
        String email = etEmail.getText().toString();
        String senha = etSenha.getText().toString();
        emailCompar = new String(etEmail.getText().toString());
        if( !email.isEmpty() ){
            autenticacao.signInWithEmailAndPassword(email,senha)
                    .addOnCompleteListener(this,
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if( !task.isSuccessful()){
                                        Toast.makeText(LoginActivity.this,
                                                "Erro ao efetuar o login",
                                                Toast.LENGTH_LONG).show();
                                    }
                                    else
                                    {
                                        if(emailCompar.equals("admin@teste.com"))
                                        {
                                            EntrarMenuAdmin();
                                        }
                                        else
                                        {
                                            EntrarCalendarioActivity();
                                        }

                                        Toast.makeText(LoginActivity.this,
                                                "Login efetuado",
                                                Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
        }
    }

    private void EntrarCalendarioActivity(){
        Intent intentCalendario = new Intent(
                LoginActivity.this, CalendarioActivity.class);
        startActivity(intentCalendario);
    }
  
    private void EntrarMenuAdmin(){
        Intent intentMenuAdmin = new Intent(
                LoginActivity.this, MenuAdminActivity.class);
        startActivity(intentMenuAdmin);
    }
}









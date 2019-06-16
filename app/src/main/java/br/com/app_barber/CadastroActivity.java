package br.com.app_barber;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroActivity extends AppCompatActivity {

    private EditText etCadastroNome, etCadastroEmail, etCadastroSenha;
    private Button btnCadastrar;

    private FirebaseAuth auth;


    private FirebaseDatabase database;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        etCadastroNome = (EditText) findViewById(R.id.etCadastroNome);
        etCadastroEmail = (EditText) findViewById(R.id.etCadastroEmail);
        etCadastroSenha = (EditText) findViewById(R.id.etCadastroSenha);
        btnCadastrar = (Button) findViewById(R.id.btnCadastro);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });

    }

    private void cadastrar(){
        final String nome = etCadastroNome.getText().toString();
        final String email = etCadastroEmail.getText().toString();
        String senha = etCadastroSenha.getText().toString();

        if( !nome.isEmpty() && !email.isEmpty() && !senha.isEmpty()){

            auth = FirebaseAuth.getInstance();
            auth.createUserWithEmailAndPassword(email, senha).
                    addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if( task.isSuccessful() ) {
                                String idUsuario = auth.getCurrentUser().getUid();
                                database = FirebaseDatabase.getInstance();
                                reference = database.getReference("usuarios").child(idUsuario);
                                reference.child("nome").setValue(nome);
                                reference.child("email").setValue(email);
                                finish();
                                Toast.makeText(CadastroActivity.this,
                                        "Usuário criado",
                                        Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(CadastroActivity.this,
                                        "Erro ao criar o usuário",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }


    }

}















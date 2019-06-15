package br.com.app_barber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroServico extends AppCompatActivity {

    private EditText etServico, etValor;
    private Button btnSalvar;

    private FirebaseDatabase database;
    private DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_servico);

        etServico = (EditText) findViewById(R.id.etServico);
        etValor = (EditText) findViewById(R.id.etValor);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }

    private void salvar(){
        Servico servico = new Servico();
        servico.setServico(etServico.getText().toString());
        servico.setValor( etValor.getText().toString());

        database = FirebaseDatabase.getInstance();
        reference = database.getReference();

        reference.child("servicos").push().setValue( servico );




        this.finish();
    }
}

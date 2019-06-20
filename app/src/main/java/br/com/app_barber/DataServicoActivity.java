package br.com.app_barber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataServicoActivity extends AppCompatActivity {

    private EditText etServico, etHorario;
    private TextView tvDataServico;
    private Button btnSalvarDataServico;

    private FirebaseDatabase database;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_servico);

        etServico = (EditText) findViewById(R.id.etServico);
        tvDataServico = (TextView) findViewById(R.id.tvDataServico);
        etHorario = (EditText) findViewById(R.id.etHorario);

        btnSalvarDataServico = (Button)findViewById(R.id.btnSalvarDataServico);

        btnSalvarDataServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarDataServico();
            }
        });

    }

    private void salvarDataServico(){
        DataServico dataservico = new DataServico();
        dataservico.setServico(etServico.getText().toString());
        dataservico.setData( tvDataServico.getText().toString());
        dataservico.setHorario( etHorario.getText().toString());

        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        reference.child("DataServico").push().setValue( dataservico );

        Toast.makeText(DataServicoActivity.this,
                "Serviço agendado!",
                Toast.LENGTH_LONG).show();
        this.finish();
    }

}


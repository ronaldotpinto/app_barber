package br.com.app_barber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataServicoActivity extends AppCompatActivity {

    private EditText etNome, etServico, etHorario;
    private TextView tvDataServico;
    private Button btnSalvarDataServico;

    private FirebaseDatabase database;
    private DatabaseReference reference;

    long dataservico;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_servico);


        etNome = (EditText)  findViewById(R.id.etNome);
        etServico = (EditText) findViewById(R.id.etServico);
        tvDataServico = (TextView) findViewById(R.id.tvDataServico);
        etHorario = (EditText) findViewById(R.id.etHorario);

        //dataservico = getIntent().getExtras().getLong("datahoraselecao");

        data = getIntent().getExtras().getString("datahoraselecao");

        /*Date date = new Date(dataservico);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dateselecao = sdf.format(date.getTime());
        */

        tvDataServico.setText(data);

        btnSalvarDataServico = (Button)findViewById(R.id.btnSalvarDataServico);

        btnSalvarDataServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarDataServico();
            }
        });

    }

    private void salvarDataServico(){
        String sData = new String(data);
        DataServico dataservico = new DataServico();
        dataservico.setNome(etNome.getText().toString());
        dataservico.setServico(etServico.getText().toString());
        dataservico.setData( sData);
        dataservico.setHorario( etHorario.getText().toString());


        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        reference.child("DataServico").push().setValue(dataservico);

        Toast.makeText(DataServicoActivity.this,
                "Serviço agendado!",
                Toast.LENGTH_LONG).show();
        this.finish();
    }

}


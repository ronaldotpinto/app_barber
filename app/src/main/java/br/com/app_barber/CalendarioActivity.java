package br.com.app_barber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CalendarioActivity extends AppCompatActivity {

    private Button btnSalvarData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        btnSalvarData = (Button) findViewById(R.id.btnSalvarData);

        btnSalvarData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SalvarDataServico();
            }
        });
    }

    private void SalvarDataServico(){
        Intent intentCadastroServico = new Intent(
                CalendarioActivity.this, DataServicoActivity.class);
        startActivity(intentCadastroServico);

    }
}

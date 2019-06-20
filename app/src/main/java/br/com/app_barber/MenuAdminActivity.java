package br.com.app_barber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuAdminActivity extends AppCompatActivity {

    private Button btnCadastroServico, btnListaServicos, btnCadastroUsuario,btnCalendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);

        btnCadastroServico = (Button) findViewById(R.id.btnCadastroServico);
        btnListaServicos = (Button) findViewById(R.id.btnListaServicos);
        btnCadastroUsuario = (Button) findViewById(R.id.btnCadastroUsuario);
        btnCalendario = (Button) findViewById(R.id.btnCalendario);

        btnCadastroServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MenuAdminActivity.this, CadastroServico.class);
                startActivity( intent );
            }
        });

        btnListaServicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MenuAdminActivity.this, ListaActivity.class);
                startActivity( intent );
            }
        });

        btnCadastroUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MenuAdminActivity.this, CadastroActivity.class);
                startActivity( intent );
            }
        });

        btnCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MenuAdminActivity.this, CalendarioActivity.class);
                startActivity( intent );
            }
        });

    }
}

package br.com.infnet.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.infnet.agenda.R;
import br.com.infnet.agenda.ui.model.Contato;

@SuppressWarnings("ALL")
public class DetailsContactActivity extends AppCompatActivity {

    private static final String DETALHES_CONTATO = "Detalhes contato";

    private TextView fieldName;
    private TextView fieldTelefone;
    private TextView fieldEmail;
    private TextView fieldCidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_contact);
        setTitle(DETALHES_CONTATO);

        fieldName = findViewById(R.id.textContactNome);
        fieldTelefone = findViewById(R.id.textContactTelefone);
        fieldEmail = findViewById(R.id.textContactEmail);
        fieldCidade = findViewById(R.id.textContactCidade);

        initFields();


    }

    private void initFields() {
        Intent data = getIntent();
        Contato contact = (Contato) data.getSerializableExtra("contact");


        fieldName.setText(contact.getNome());
        fieldTelefone.setText(contact.getTelefone());
        fieldEmail.setText(contact.getEmail());
        fieldCidade.setText(contact.getCidade());

    }




}

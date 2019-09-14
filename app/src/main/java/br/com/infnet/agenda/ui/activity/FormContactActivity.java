package br.com.infnet.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.infnet.agenda.R;
import br.com.infnet.agenda.dao.ContactsDAO;
import br.com.infnet.agenda.ui.model.Contato;

public class FormContactActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_contact);

        final ContactsDAO contactsDao = new ContactsDAO();

        final EditText campoNome = findViewById(R.id.editText_name);
        final EditText campoTelefone = findViewById(R.id.editText_telefone);
        final EditText campoEmail = findViewById(R.id.editText_email);
        final EditText campoCidade = findViewById(R.id.editText_cidade);

        Button btnSalvar = findViewById(R.id.button_save);
        Button btnLimpar = findViewById(R.id.button_clear);
        Button btnViewContacts = findViewById(R.id.button_ViewContacts);


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvaContato(campoNome.getText().toString(),
                        campoTelefone.getText().toString(),
                        campoEmail.getText().toString(),
                        campoCidade.getText().toString(),
                        contactsDao);
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                campoNome.getText().clear();
                campoTelefone.getText().clear();
                campoEmail.getText().clear();
                campoCidade.getText().clear();
            }
        });


        btnViewContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(FormContactActivity.this, ListContactsActivity.class);
                startActivity(nextActivity);
            }
        });

    }

    private void salvaContato(String nome, String telefone, String email, String cidade, ContactsDAO contactsDao) {

        if (!nome.isEmpty() && !telefone.isEmpty() && !email.isEmpty() && !cidade.isEmpty()) {
            Contato contato = new Contato(nome, telefone, email, cidade);
            contactsDao.salva(contato, getApplicationContext());

            startActivity(new Intent(FormContactActivity.this, ListContactsActivity.class));
            finish();
        } else {
            Toast.makeText(this, "Todos os campos devem ser preenchidos", Toast.LENGTH_LONG).show();
        }
    }


}

package br.com.infnet.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.com.infnet.agenda.R;
import br.com.infnet.agenda.dao.ContactsDAO;
import br.com.infnet.agenda.ui.adapter.ListContactsAdapter;
import br.com.infnet.agenda.ui.model.Contato;

public class ListContactsActivity extends AppCompatActivity {

    private static final String TITLE = "Agenda de contatos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contacts);
        setTitle(TITLE);
        configuraLista();
    }

    private void configuraLista() {
        final FloatingActionButton botaoAdicionaContato = findViewById(R.id.actionButton_addContact);
        botaoAdicionaContato.setOnClickListener(startAddActivity());
    }

    private View.OnClickListener startAddActivity() {
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentFormContactActivity = new Intent(ListContactsActivity.this, FormContactActivity.class);
                startActivity(intentFormContactActivity);
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView listaContatos = findViewById(R.id.list_contacts_listView);
        final List<Contato> contatos = loadDataContatcs();

        if (contatos.isEmpty())
            Toast.makeText(getApplicationContext(), "Sem contatos cadastrados!", Toast.LENGTH_LONG).show();

        listaContatos.setAdapter(new ListContactsAdapter(contatos, this));
        onClickItemList(listaContatos, contatos);

    }

    private void onClickItemList(ListView listaContatos, final List<Contato> contatos) {
        listaContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentDetailsContactActivity = new Intent(ListContactsActivity.this, DetailsContactActivity.class);
                intentDetailsContactActivity.putExtra("contact", contatos.get(position));
                startActivity(intentDetailsContactActivity);
            }
        });
    }

    private List<Contato> loadDataContatcs() {
        return new ContactsDAO().listarContatos(getApplicationContext());
    }




}

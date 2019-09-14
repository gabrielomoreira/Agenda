package br.com.infnet.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.infnet.agenda.R;
import br.com.infnet.agenda.ui.model.Contato;

public class ListContactsAdapter extends BaseAdapter {

    private final List<Contato> contacts;
    private final Context context;

    public ListContactsAdapter(List<Contato> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }


    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int pos) {
        return contacts.get(pos);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent) {

        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);

        Contato contato = contacts.get(pos);

        TextView contatoView = viewCriada.findViewById(R.id.contact);
        contatoView.setText(contato.getNome());

        return viewCriada;
    }

}

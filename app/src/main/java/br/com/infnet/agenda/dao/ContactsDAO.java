package br.com.infnet.agenda.dao;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.infnet.agenda.ui.model.Contato;

public class ContactsDAO {

    private final String FILE_NAME = "contacts9.json";

    public List<Contato> listarContatos(Context context) {

        if (!context.getFileStreamPath(FILE_NAME).exists()){
            return new ArrayList<>();
        }

        try (FileInputStream fis = context.openFileInput(FILE_NAME)) {

            final BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            Type listType = new TypeToken<ArrayList<Contato>>() {}.getType();
            ArrayList<Contato> contatos = new Gson().fromJson(reader, listType);

            return contatos == null ? new ArrayList<Contato>() : contatos;

        } catch (Exception e) {
            Log.d("ContactsDAO", "Erro ao tentar recuprar os arquivos", e);
            Toast.makeText(context, "Erro ao tentar buscar os Contatos!", Toast.LENGTH_SHORT).show();
            return new ArrayList<>();
        }
    }

    public void salva(Contato contato, Context context) {

        try (FileOutputStream fos = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE)) {
            List<Contato> listaContatos = listarContatos(context);
            listaContatos.add(contato);

            fos.write(new Gson().toJson(listaContatos).getBytes());
            fos.flush();

        } catch (Exception e) {
            Log.d("ContactsDAO", "Erro ao tentar incluir um contato", e);
            Toast.makeText(context, "Erro ao tentar incluir um contato!", Toast.LENGTH_SHORT).show();
        }

    }


}

package com.example.appadaptters;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TelaPrincipal extends AppCompatActivity {

    EditText txtNome;
    EditText txtSobrenome;
    EditText txtEmail;
    EditText txtTelefone;
    List<HashMap <String, String>> lista = new ArrayList<>();
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
    }

    public void add(View v){
        txtNome = findViewById(R.id.txtNome);
        String nome = txtNome.getText().toString();
        txtSobrenome = findViewById(R.id.txtSobrenome);
        String sobrenome = txtSobrenome.getText().toString();
        txtEmail = findViewById(R.id.txtEmail);
        String email = txtEmail.getText().toString();
        txtTelefone = findViewById(R.id.txtTelefone);
        String telefone = txtTelefone.getText().toString();

        HashMap<String,String> map = new HashMap<>();
        map.put("nome",nome);
        map.put("sobrenome",sobrenome);
        map.put("email",email);
        map.put("telefone",telefone);

        lista.add(map);

        String[] from = {"nome","sobrenome","email","telefone"};
        int[] to = {R.id.nome,R.id.sobrenome,R.id.email,R.id.telefone};

        SimpleAdapter s = new SimpleAdapter(this,lista,R.layout.item,from,to);

        listView = findViewById(R.id.listView);

        listView.setAdapter(s);

        Toast.makeText(getApplicationContext(),"Incluido com sucesso!", Toast.LENGTH_SHORT).show();

    }
}

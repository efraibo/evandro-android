package sourceinformation.com.br.widgets_app;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import sourceinformation.com.br.widgets_app.model.Pessoa;

public class CallActivity extends AppCompatActivity {

    private List<Pessoa> Pessoas;
    private int _posicao;

    /**
     * Called when the activity is first created.
     */

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        final ListView listaPessoas = findViewById(R.id.listPessoas);
        Pessoa pessoa = new Pessoa();

        Pessoas = pessoa.getPessoa();

        // adapter que sera o source para a listview
        ArrayAdapter<Pessoa> adapter = new ArrayAdapter<Pessoa>(this, android.R.layout.simple_list_item_1, Pessoas);

        //seta o adapter para o listview
        listaPessoas.setAdapter(adapter);

        //evento para o click
        listaPessoas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int posicao, long id) {

                _posicao = posicao;
                // TODO Auto-generated method stub
                //registra o menu após o click
                registerForContextMenu(listaPessoas);
                return false;

            }

        });

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        super.onCreateContextMenu(menu, v, menuInfo);

        //cria o menu para fazer a ligação
        menu.add(0, 0, 0, "Ligar");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        // TODO Auto-generated method stub
        if (item.getItemId() == 0) {
            try {
                //Tipos de chamadas

                //ACTION_DIAL

                //ACTION_CALL
                Intent chamada = new Intent(Intent.ACTION_DIAL);
                //pega a posição da pessoa

                chamada.setData(Uri.parse("tel:" + Pessoas.get(_posicao)));

                startActivity(chamada);

            } catch (ActivityNotFoundException act) {
                Log.e("Exemplo de chamada", "falha", act);
            }
        }

        return super.onContextItemSelected(item);
    }

}

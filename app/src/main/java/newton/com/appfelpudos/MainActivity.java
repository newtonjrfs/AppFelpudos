package newton.com.appfelpudos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] listaNomes = {"Felpuro","Fofura","Lesmo","Bugado","Uruca","Racing","iOS"};

    int[] listaIcones = {R.drawable.carrinho,R.drawable.carrinho,R.drawable.carrinho,
            R.drawable.carrinho,R.drawable.carrinho,R.drawable.carrinho,R.drawable.carrinho};

    String[] listaDescricoes = {"Felpuro","Fofura","Lesmo","Bugado","Uruca","Racing","iOS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Trecho de codigo quando usa padrao do android
        ArrayAdapter<String> meuAdaptador = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,listaNomes);

        ListView minhaLista = findViewById(R.id.lista);
        minhaLista.setAdapter(meuAdaptador);

        minhaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, ""+listaNomes[position], Toast.LENGTH_SHORT).show();

            }
        });*/


        //Trecho de codigo quando uso meu proprio list

        ListView minhaLista = findViewById(R.id.lista);
        MeuAdaptador meuAdaptador = new MeuAdaptador(getApplicationContext(),R.layout.layout_lista);
        int i =0;
        for (String nome:listaNomes){
            DadosPersonagem dadosPersonagem;
            dadosPersonagem = new DadosPersonagem(listaIcones[i],nome,listaDescricoes[i]);
            meuAdaptador.add(dadosPersonagem);
            i++;
        }
        minhaLista.setAdapter(meuAdaptador);

    }
}

class viewPersonagem{
    ImageView icone;
    TextView titulo;
    TextView descricao;
}

class DadosPersonagem{
    int icone;
    String titulo;
    String descricao;

    public DadosPersonagem(int icone, String titulo, String descricao) {
        this.icone = icone;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public int getIcone() {
        return icone;
    }

    public void setIcone(int icone) {
        this.icone = icone;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

class MeuAdaptador extends ArrayAdapter{

    public MeuAdaptador(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View minhaView;
        minhaView = convertView;
        viewPersonagem viewPersonagem;

        if (convertView == null){

            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            minhaView = inflater.inflate(R.layout.layout_lista,parent,false);

            viewPersonagem = new viewPersonagem();
            viewPersonagem.icone = minhaView.findViewById(R.id.meuIcone);
            viewPersonagem.titulo = minhaView.findViewById(R.id.meuTitulo);
            viewPersonagem.descricao = minhaView.findViewById(R.id.meuDescricao);

            minhaView.setTag(viewPersonagem);

        }else{
            viewPersonagem = (viewPersonagem) minhaView.getTag();
        }

        DadosPersonagem dadosPersonagem;
        dadosPersonagem = (DadosPersonagem) this.getItem(position);

        viewPersonagem.icone.setImageResource(dadosPersonagem.getIcone());
        viewPersonagem.titulo.setText(dadosPersonagem.getTitulo());
        viewPersonagem.descricao.setText(dadosPersonagem.getDescricao());

        return minhaView;
    }
}
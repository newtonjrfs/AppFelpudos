package newton.com.appfelpudos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] listaNomes = {"Felpuro","Fofura","Lesmo","Bugado","Uruca","Racing","iOS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> meuAdaptador = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,listaNomes);

        ListView minhaLista = findViewById(R.id.lista);

        minhaLista.setAdapter(meuAdaptador);

    }
}

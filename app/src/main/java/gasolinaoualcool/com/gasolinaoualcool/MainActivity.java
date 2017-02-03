package gasolinaoualcool.com.gasolinaoualcool;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;
    private TextInputLayout textInputPrecoAlcool;
    private TextInputLayout textInputPrecoGasolina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //localizar componentes na tela

        textInputPrecoAlcool = (TextInputLayout) findViewById(R.id.textInputPrecoAlcool);
        textInputPrecoGasolina = (TextInputLayout) findViewById(R.id.textInputPrecoGasolina);
        precoAlcool = (EditText) findViewById(R.id.precoAlcoolId);
        precoGasolina = (EditText) findViewById(R.id.precoGasolinaId);
        botaoVerificar = (Button) findViewById(R.id.botaoVerificarId);
        textoResultado = (TextView) findViewById(R.id.textoresultadoId);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( testeEditText(Arrays.asList( textInputPrecoAlcool , textInputPrecoGasolina )) )
                    return;

                //recupera valores digitados

                String textoPrecoAlcool = precoAlcool.getText().toString();
                String textoPrecoGasolina = precoGasolina.getText().toString();

                //converter valores strings para numeros
                Double valorAlcool = Double.parseDouble( textoPrecoAlcool );
                Double valorGasolina = Double.parseDouble( textoPrecoGasolina );

                //alcool / gasolina
                double resultado = valorAlcool / valorGasolina;

                if( resultado >= 0.7){

                    //Gasolina

                    textoResultado.setText("É melhor usar Gasolina.");

                }else{

                    //Alcool

                    textoResultado.setText("É melhor usar Álcool.");

                }

            }
        });



    }

    private Boolean testeEditText (List<TextInputLayout> List){

        boolean teste = false;

        for (TextInputLayout edt : List) {

            if (edt.getEditText().getText().toString().isEmpty()) {
                //edt.setError("Preencha os campos!");
                teste = true;

            }else if( edt.getError()!= null ){
                edt.setError(null);
            }

        }

        return teste;

    }


}

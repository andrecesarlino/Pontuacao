package edu.unidavi.pontuacao;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.RadioGroup;
        import android.widget.TextView;
        import android.widget.Toast;
        import android.widget.ToggleButton;

        import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    public static TextInputEditText TimeUm;
    public static TextInputEditText TimeDois;
    public static TextInputEditText Comeca;
    public static TextInputEditText Termina;

    public Button Cadastrar;

    public RadioGroup GrupoRadio;
    public String idSelecionado;


    //add jogador
    public Button TerceiroJogador;
    public TextView NomeTerceiro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TimeUm = findViewById(R.id.JogadorUm);
        TimeDois = findViewById(R.id.TimeDois);
        Termina = findViewById(R.id.Termina);
        Cadastrar = findViewById(R.id.Cadastrar);


        //radio
        GrupoRadio = (RadioGroup) findViewById(R.id.GrupoRadio);

        //jogador novo
        TerceiroJogador = findViewById(R.id.TerceiroJogador);
        NomeTerceiro = findViewById(R.id.NomeTerceiro);

        TerceiroJogador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NomeTerceiro.setVisibility(View.VISIBLE);

            }
        });



        Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it;

                int id = GrupoRadio.getCheckedRadioButtonId();

                switch (id) {
                    case R.id.TrucoJogo:
                        it = new Intent(MainActivity.this, Truco.class);
                        startActivity(it);
                        break;
                    case R.id.CanastraJogo:
                        it = new Intent(MainActivity.this, Canastra.class);
                        startActivity(it);
                        break;
                    default:
                        // Your code
                        break;
                }

            }
        });

    }





}

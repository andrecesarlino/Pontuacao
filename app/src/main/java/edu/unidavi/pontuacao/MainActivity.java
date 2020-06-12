package edu.unidavi.pontuacao;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.RadioGroup;

        import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    public static TextInputEditText TimeUm;
    public static TextInputEditText TimeDois;
    public static TextInputEditText Comeca;
    public static TextInputEditText Termina;
    public RadioGroup Jogo;

    public Button Cadastrar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TimeUm = findViewById(R.id.JogadorUm);
        TimeDois = findViewById(R.id.TimeDois);
        Comeca = findViewById(R.id.Comeca);
        Termina = findViewById(R.id.Termina);
        Jogo = findViewById(R.id.GrupoRadio);
        Cadastrar = findViewById(R.id.Cadastrar);



        Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent it = new Intent(MainActivity.this, Truco.class);
               startActivity(it);



            }
        });

    }





}

package edu.unidavi.pontuacao;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class Truco extends AppCompatActivity {

    Dialog testeDialogo;

    private String JogadorUmPontuacao;
    private TextView JogadorUm;

    private String JogadorDoisPontuacao;
    private TextView JogadorDois;

    private String PtsUm;
    private TextView PontuacaoJogadorUm;

    private String PtsDois;
    private TextView PontuacaoJogadorDois;

   private Button SomaUm;
    private Button SomaTres;
    private Button SomaSeis;
    private Button SomaNove;
    private Button SomaDoze;
    private Button MarcoUm;
    private Button MarcoDois;

    public int count = 0;
    public String vencedor;

    Editable TimeUmAndroid = MainActivity.TimeUm.getText();
    final Editable TimeDoisAndroid = MainActivity.TimeDois.getText();
    final Editable ComecaAndroid = MainActivity.Comeca.getText();
    final Editable TerminaAndroid = MainActivity.Termina.getText();


    //Icones

    private TextView ResetarIcone;


    //popup
    private TextView TimeVencedor;
    private TextView TimeA;
    private TextView TimeB;
    private TextView ResultadoA;
    private TextView ResultadoB;
    private Button Reset;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truco);

        testeDialogo = new Dialog(this);


        JogadorUm = findViewById(R.id.JogadorUm);
        JogadorUmPontuacao = TimeUmAndroid.toString();
        JogadorUm.setText(JogadorUmPontuacao);

        JogadorDois = findViewById(R.id.JogadorDois);
        JogadorDoisPontuacao = TimeDoisAndroid.toString();
        JogadorDois.setText(JogadorDoisPontuacao);


        PontuacaoJogadorUm = findViewById(R.id.PontuacaoJogadorUm);
        PtsUm = ComecaAndroid.toString();
        PontuacaoJogadorUm.setText(PtsUm);


        PontuacaoJogadorDois = findViewById(R.id.PontuacaoJogadorDois);
        PtsDois = ComecaAndroid.toString();
        PontuacaoJogadorDois.setText(PtsDois);


        SomaUm = findViewById(R.id.SomaUm);
        SomaTres = findViewById(R.id.SomaTres);
        SomaSeis = findViewById(R.id.SomaSeis);
        SomaNove = findViewById(R.id.SomaNove);
        SomaDoze = findViewById(R.id.SomaDoze);

        MarcoUm = findViewById(R.id.MarcoUm);
        MarcoDois = findViewById(R.id.MarcoDois);

        MarcoUm.setText(JogadorUmPontuacao);
        MarcoDois.setText(JogadorDoisPontuacao);

        ResetarIcone = findViewById(R.id.ResetarIcone);




        MarcoUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //torna visivel
                Visivel();

                ResetarIcone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PtsUm = "0";
                        PtsDois = "0";
                        PontuacaoJogadorUm.setText("0");
                        PontuacaoJogadorDois.setText("0");
                        count = 0;
                    }
                });


                SomaUm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //CONCATENA
                        //PtsUm = PtsUm + 1;
                        //PontuacaoJogadorUm.setText(PtsUm);

                        int numero = Integer.parseInt(PtsUm);
                        numero = numero + 1;
                        PtsUm = String.valueOf(numero);
                        PontuacaoJogadorUm.setText(PtsUm);

                        //torna invisivel
                        Invisivel();
                        count = count + 1;
                       // Log.d("tag ", "count "+ count);
                        vencedor = JogadorUmPontuacao;
                        Vitoria(vencedor);

                    }
                });

                SomaTres.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.parseInt(PtsUm);
                        numero = numero + 3;
                        PtsUm = String.valueOf(numero);
                        PontuacaoJogadorUm.setText(PtsUm);

                        Invisivel();
                        count = count + 3;

                        vencedor = JogadorUmPontuacao;
                        Vitoria(vencedor);

                    }
                });

                SomaSeis.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.parseInt(PtsUm);
                        numero = numero + 6;
                        PtsUm = String.valueOf(numero);
                        PontuacaoJogadorUm.setText(PtsUm);

                        Invisivel();
                        count = count + 6;

                        vencedor = JogadorUmPontuacao;
                        Vitoria(vencedor);

                    }
                });

                SomaNove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.parseInt(PtsUm);
                        numero = numero + 9;
                        PtsUm = String.valueOf(numero);
                        PontuacaoJogadorUm.setText(PtsUm);

                        Invisivel();

                        count = count + 9;

                        vencedor = JogadorUmPontuacao;
                        Vitoria(vencedor);

                    }
                });

                SomaDoze.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.parseInt(PtsUm);
                        numero = numero + 12;
                        PtsUm = String.valueOf(numero);
                        PontuacaoJogadorUm.setText(PtsUm);

                        Invisivel();

                        count = count + 12;

                        vencedor = JogadorUmPontuacao;
                        Vitoria(vencedor);

                    }

                });



            }
        });

        MarcoDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //torna visivel
                Visivel();

                SomaUm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.parseInt(PtsDois);
                        numero = numero + 1;
                        PtsDois = String.valueOf(numero);
                        PontuacaoJogadorDois.setText(PtsDois);

                        //torna invisivel
                        Invisivel();

                        count = count + 1;

                        vencedor = JogadorDoisPontuacao;
                        Vitoria(vencedor);


                    }
                });


                SomaTres.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.parseInt(PtsDois);
                        numero = numero + 3;
                        PtsDois = String.valueOf(numero);
                        PontuacaoJogadorDois.setText(PtsDois);

                        Invisivel();

                        count = count + 3;

                        vencedor = JogadorDoisPontuacao;
                        Vitoria(vencedor);

                    }
                });

                SomaSeis.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.parseInt(PtsDois);
                        numero = numero + 6;
                        PtsDois = String.valueOf(numero);
                        PontuacaoJogadorDois.setText(PtsDois);

                        Invisivel();

                        count = count + 6;

                        vencedor = JogadorDoisPontuacao;
                        Vitoria(vencedor);

                    }
                });

                SomaNove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.parseInt(PtsDois);
                        numero = numero + 9;
                        PtsDois = String.valueOf(numero);
                        PontuacaoJogadorDois.setText(PtsDois);

                        Invisivel();

                        count = count + 9;

                        vencedor = JogadorDoisPontuacao;
                        Vitoria(vencedor);

                    }
                });

                SomaDoze.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.parseInt(PtsDois);
                        numero = numero + 12;
                        PtsDois = String.valueOf(numero);
                        PontuacaoJogadorDois.setText(PtsDois);

                        Invisivel();

                        count = count + 12;

                        vencedor = JogadorDoisPontuacao;
                        Vitoria(vencedor);

                    }
                });

            }
        });
    }

    public void Invisivel() {
        SomaUm.setVisibility(View.INVISIBLE);
        SomaTres.setVisibility(View.INVISIBLE);
        SomaSeis.setVisibility(View.INVISIBLE);
        SomaNove.setVisibility(View.INVISIBLE);
        SomaDoze.setVisibility(View.INVISIBLE);
    }

    public void Visivel() {
        SomaUm.setVisibility(View.VISIBLE);
        SomaTres.setVisibility(View.VISIBLE);
        SomaSeis.setVisibility(View.VISIBLE);
        SomaNove.setVisibility(View.VISIBLE);
        SomaDoze.setVisibility(View.VISIBLE);
    }

    public void verPub() {
        testeDialogo.setContentView(R.layout.activity_vitoria);
        TimeVencedor = testeDialogo.findViewById(R.id.TimeVencedor);
        TimeVencedor.setText(vencedor);

        TimeA = testeDialogo.findViewById(R.id.TimeA);
        TimeA.setText(JogadorUmPontuacao);

        TimeB = testeDialogo.findViewById(R.id.TimeB);
        TimeB.setText(JogadorDoisPontuacao);

        ResultadoA = testeDialogo.findViewById(R.id.ResultadoA);
        ResultadoA.setText(PtsUm);

        ResultadoB = testeDialogo.findViewById(R.id.ResultadoB);
        ResultadoB.setText(PtsDois);

        Reset = testeDialogo.findViewById(R.id.Reset);

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PtsUm = "0";
                PtsDois = "0";
                PontuacaoJogadorUm.setText("0");
                PontuacaoJogadorDois.setText("0");
                count = 0;
                testeDialogo.dismiss();
            }
        });


        testeDialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        testeDialogo.show();
    }

    public String Vitoria(String vencedor) {
        String ganhador = "";
        if(Integer.parseInt(PtsUm) >= 12 || Integer.parseInt(PtsDois) >= 12) {
            verPub();
            ganhador = vencedor;
        }
        return ganhador;
    }
}



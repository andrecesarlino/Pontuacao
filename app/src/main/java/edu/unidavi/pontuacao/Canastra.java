package edu.unidavi.pontuacao;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Canastra extends AppCompatActivity {

    Dialog testeDialogo;

    private String JogadorUmPontuacao;
    private TextView JogadorUm;

    private String JogadorDoisPontuacao;
    private TextView JogadorDois;

    private String PtsUm;
    private TextView PontuacaoJogadorUm;

    private String PtsDois;
    private TextView PontuacaoJogadorDois;

    private Button SomaDez;
    private Button SomaCinquenta;
    private Button SomaCem;
    private Button SomaQuinhentos;
    private Button SomaMil;
    private Button MarcoUm;
    private Button MarcoDois;

    public int count = 0;
    public String vencedor;

    Editable TimeUmAndroid = MainActivity.TimeUm.getText();
    final Editable TimeDoisAndroid = MainActivity.TimeDois.getText();
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


    // Editar
    private TextView InputTimeAEditar;
    private TextView InputTimeBEditar;
    private TextView TimeAEditar;
    private TextView TimeBEditar;
    private Button Editar;
    Dialog TelaEditar;
    private TextView EditarTruco;

    //home
    private TextView Home;

    //terminar

    int TerminaNumero = Integer.parseInt(String.valueOf(TerminaAndroid));


    // Pontuar
    public Button Pontuar;
    public TextView InputPontuacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canastra);

        //Pontuar
        Pontuar = findViewById(R.id.Pontuar);
        InputPontuacao = findViewById(R.id.InputPontuacao);

        testeDialogo = new Dialog(this);

        TelaEditar = new Dialog(this);


        JogadorUm = findViewById(R.id.JogadorUm);
        JogadorUmPontuacao = TimeUmAndroid.toString();
        JogadorUm.setText(JogadorUmPontuacao);

        JogadorDois = findViewById(R.id.JogadorDois);
        JogadorDoisPontuacao = TimeDoisAndroid.toString();
        JogadorDois.setText(JogadorDoisPontuacao);


        PontuacaoJogadorUm = findViewById(R.id.PontuacaoJogadorUm);
        PtsUm = "0";
        PontuacaoJogadorUm.setText(PtsUm);


        PontuacaoJogadorDois = findViewById(R.id.PontuacaoJogadorDois);
        PtsDois = "0";
        PontuacaoJogadorDois.setText(PtsDois);


        SomaDez = findViewById(R.id.SomaDez);
        SomaCinquenta = findViewById(R.id.SomaCinquenta);
        SomaCem = findViewById(R.id.SomaCem);
        SomaQuinhentos = findViewById(R.id.SomaQuinhentos);
        SomaMil = findViewById(R.id.SomaMil);

        MarcoUm = findViewById(R.id.MarcoUm);
        MarcoDois = findViewById(R.id.MarcoDois);

        MarcoUm.setText(JogadorUmPontuacao);
        MarcoDois.setText(JogadorDoisPontuacao);

        //button editar

        ResetarIcone = findViewById(R.id.ResetarIcone);


        //button editar
        EditarTruco = findViewById(R.id.EditarTruco);





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



        Home = findViewById(R.id.Home);

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Canastra.this, MainActivity.class);
                startActivity(it);
            }
        });




        EditarTruco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditarPlacar();
            }
        });

        PontuacaoJogadorUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditarPlacar();
            }
        });
        PontuacaoJogadorDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditarPlacar();
            }
        });

        MarcoUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //torna visivel
                Visivel();

                InputPontuacao.setText("0");


                SomaDez.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.valueOf(String.valueOf(InputPontuacao.getText()));
                        numero = numero + 10;
                        InputPontuacao.setText(String.valueOf(numero));


                    }
                });

                SomaCinquenta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.valueOf(String.valueOf(InputPontuacao.getText()));
                        numero = numero + 50;
                        InputPontuacao.setText(String.valueOf(numero));
                    }
                });

                SomaCem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.valueOf(String.valueOf(InputPontuacao.getText()));
                        numero = numero + 100;
                        InputPontuacao.setText(String.valueOf(numero));

                    }
                });

                SomaQuinhentos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.valueOf(String.valueOf(InputPontuacao.getText()));
                        numero = numero + 500;
                        InputPontuacao.setText(String.valueOf(numero));

                    }
                });

                SomaMil.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.valueOf(String.valueOf(InputPontuacao.getText()));
                        numero = numero + 1000;
                        InputPontuacao.setText(String.valueOf(numero));

                    }

                });

                Pontuar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int Soma = Integer.parseInt(String.valueOf(InputPontuacao.getText()));

                        PtsUm = String.valueOf(Integer.valueOf(PtsUm) + Soma);

                        PontuacaoJogadorUm.setText(PtsUm);

                        int conteudo = Integer.parseInt(String.valueOf(PtsUm));
                        count = count + conteudo;


                        Invisivel();
                        vencedor = JogadorUmPontuacao;
                        Vitoria(vencedor);

                        InputPontuacao.setText("");


                    }
                });

            }
        });

        MarcoDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //torna visivel
                Visivel();

                InputPontuacao.setText("0");

                SomaDez.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.valueOf(String.valueOf(InputPontuacao.getText()));
                        numero = numero + 10;
                        InputPontuacao.setText(String.valueOf(numero));


                    }
                });


                SomaCinquenta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.valueOf(String.valueOf(InputPontuacao.getText()));
                        numero = numero + 50;
                        InputPontuacao.setText(String.valueOf(numero));

                    }
                });

                SomaCem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.valueOf(String.valueOf(InputPontuacao.getText()));
                        numero = numero + 100;
                        InputPontuacao.setText(String.valueOf(numero));

                    }
                });

                SomaQuinhentos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.valueOf(String.valueOf(InputPontuacao.getText()));
                        numero = numero + 500;
                        InputPontuacao.setText(String.valueOf(numero));

                    }
                });

                SomaMil.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int numero = Integer.valueOf(String.valueOf(InputPontuacao.getText()));
                        numero = numero + 1000;
                        InputPontuacao.setText(String.valueOf(numero));
                    }
                });

                Pontuar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int Soma = Integer.parseInt(String.valueOf(InputPontuacao.getText()));

                        PtsDois = String.valueOf(Integer.valueOf(PtsDois) + Soma);

                        PontuacaoJogadorDois.setText(PtsDois);

                        int conteudo = Integer.parseInt(String.valueOf(PtsDois));
                        count = count + conteudo;


                        Invisivel();
                        vencedor = JogadorDoisPontuacao;
                        Vitoria(vencedor);

                        InputPontuacao.setText("");


                    }
                });

            }
        });
    }

    public void Invisivel() {
        SomaDez.setVisibility(View.INVISIBLE);
        SomaCinquenta.setVisibility(View.INVISIBLE);
        SomaCem.setVisibility(View.INVISIBLE);
        SomaQuinhentos.setVisibility(View.INVISIBLE);
        SomaMil.setVisibility(View.INVISIBLE);
        Pontuar.setVisibility(View.INVISIBLE);
        InputPontuacao.setVisibility(View.INVISIBLE);
    }

    public void Visivel() {
        SomaDez.setVisibility(View.VISIBLE);
        SomaCinquenta.setVisibility(View.VISIBLE);
        SomaCem.setVisibility(View.VISIBLE);
        SomaQuinhentos.setVisibility(View.VISIBLE);
        SomaMil.setVisibility(View.VISIBLE);
        Pontuar.setVisibility(View.VISIBLE);
        InputPontuacao.setVisibility(View.VISIBLE);
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
        if(Integer.parseInt(PtsUm) >= TerminaNumero || Integer.parseInt(PtsDois) >= TerminaNumero) {
            verPub();
            ganhador = vencedor;
        }
        return ganhador;
    }

    public void EditarPlacar() {

        TelaEditar.setContentView(R.layout.activity_editar);

        InputTimeAEditar = TelaEditar.findViewById(R.id.InputTimeAEditar);
        InputTimeBEditar = TelaEditar.findViewById(R.id.InputTimeBEditar);

        TimeAEditar = TelaEditar.findViewById(R.id.TimeAEditar);
        TimeBEditar = TelaEditar.findViewById(R.id.TimeBEditar);

        TimeAEditar.setText(JogadorUmPontuacao);
        TimeBEditar.setText(JogadorDoisPontuacao);


        InputTimeAEditar.setText(PtsUm);
        InputTimeBEditar.setText(PtsDois);

        Editar = TelaEditar.findViewById(R.id.Editar);

        Editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String PtsConverterUm = String.valueOf(InputTimeAEditar.getText());
                String PtsConverterDois = String.valueOf(InputTimeBEditar.getText());


                PtsUm = PtsConverterUm;
                PtsDois = PtsConverterDois;

                PontuacaoJogadorUm.setText(PtsConverterUm);
                PontuacaoJogadorDois.setText(PtsConverterDois);
                //converter para integer para
                int timeACompare = Integer.parseInt(String.valueOf(InputTimeAEditar.getText()));
                int timeBCompare = Integer.parseInt(String.valueOf(InputTimeBEditar.getText()));

                if(timeACompare > timeBCompare) {
                    count = timeACompare;
                    vencedor = JogadorUmPontuacao;
                    Vitoria(vencedor);
                } else if(timeBCompare > timeACompare) {
                    count = timeBCompare;
                    vencedor = JogadorDoisPontuacao;
                    Vitoria(vencedor);
                } else if(timeACompare == timeBCompare) {
                    count = timeACompare;
                }

                TelaEditar.dismiss();
            }
        });



        TelaEditar.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TelaEditar.show();

    }
    }

package com.example.viniciusnunes.memequiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    TextView pergunta;
    RadioButton rbResposta1, rbResposta2, rbResposta3, rbResposta4;
    ImageView imgPergunta;
    RadioGroup rgRespostas;
    int respostaCerta;
    int pontos;
    List<Questao> questoes = new ArrayList<Questao>(){
        {
            add(new Questao(R.drawable.questao1, "Considerando o pseudocódigo", R.id.rbResposta3, "A) Lê um número negativo e mostra na tela o seu fatorial.", "B) Lê o fatorial e mostra o número na tela.", "C) Lê um número não negativo e mostra na tela o seu fatorial.", "D) Nenhuma das opções acima."));
            add(new Questao(R.drawable.questao2,"Analise os trechos de código acima, escritos em uma linguagem de programação hipotética, fazendo uso dos comandos “while-do” (enquanto-faça) e “do-while” (faça-enquanto) e supondo que a, b e c foram declaradas anteriormente." + "\n \nQuais são os valores de a, b e c, após o término de cada trecho, se as variáveis a, b e c foram inicializadas com 3, 0 e 3, respectivamente, antes de cada trecho?", R.id.rbResposta1, "A) 3, 0 e 3   e   2, 1 e 4.", "B) 2, 1 e 1   e   2, 1 e 2.", "C) 1, 2 e 3   e   3, 2 e 3.", "D) 2, 1 e 3   e   1, 2 e 3."));
            add(new Questao(R.drawable.questao3,"Considere o seguinte algoritmo, onde n é um inteiro positivo lido do teclado:", R.id.rbResposta4, "A) Constante;", "B) Logarítmica em n;", "C) Linear em n;", "D) Quadrática em n;"));
            add(new Questao(R.drawable.questao4, "Sendo a e b variáveis inteiras em um programa, a expressão lógica", R.id.rbResposta3, "A) (a <= b);", "B) (a >= b);", "C) (a < b);", "D) (a > b);"));
            add(new Questao(R.drawable.questao5, "Considere o código acima:", R.id.rbResposta2, "A) Em um laço de repetição, o controle do número de vezes que o laço será repetido ocorre por meio de variáveis", "B) Em um laço de repetição, o controle do número de vezes que o laço será repetido ocorre por meio de operadores lógicos.", "C) Opção A e B.", "D) Nenhuma das alternativas."));
            add(new Questao(R.drawable.logo, "Mamãe, no céu tem pão?", R.id.rbResposta3, "E sobreviveu", "E viveu", "E morreu", "E faleceu"));
            add(new Questao(R.drawable.logo, "Hoje eu vim falar de um assunto polêmico..", R.id.rbResposta4, "Nádegas", "Olhos", "Mãos", "Mamilos"));
            add(new Questao(R.drawable.logo, "Complete a frase segundo Gilderlan. E depois.. tem:", R.id.rbResposta1, "Xenhenhenhenhem", "Nheco Nheco", "Nananananana", "Um furdunço"));
            add(new Questao(R.drawable.logo, "Qual é o nome artístico dessa maravilhosa criatura?", R.id.rbResposta2, "Lohane Vêkanandre Gisele Gavião da Portela de bala Halls", "Lohane Vêkanandre Sthephany Smith Bueno de HA HA HA de Raio Laser bala de Icekiss", "Lohane Vêkanandre Bueno de HA HA HA de Raio Laser de bala Mentos", "Lohane Vêkanandre Sthephany Smith Brasil de Paitê"));
            add(new Questao(R.drawable.logo, "Qual o refrão da música que essa missionária estava cantando?", R.id.rbResposta3, "Sem Jesus não viverão!", "Jesus é bom o tempo todo", "O sangue de Jesus tem poder!", "O sangue de Jesus é maravilhosooooo!"));


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        imgPergunta = (ImageView)findViewById(R.id.imgPergunta);
        pergunta = (TextView)findViewById(R.id.pergunta);
        rgRespostas = (RadioGroup)findViewById(R.id.rgRespostas);
        rbResposta1 = (RadioButton)findViewById(R.id.rbResposta1);
        rbResposta2 = (RadioButton)findViewById(R.id.rbResposta2);
        rbResposta3 = (RadioButton)findViewById(R.id.rbResposta3);
        rbResposta4 = (RadioButton)findViewById(R.id.rbResposta4);
        carregarQuestao();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        carregarQuestao();
    }

    public void btnResponderOnClick(View v){
        RadioButton rb = (RadioButton)findViewById(rgRespostas.getCheckedRadioButtonId());
        Intent intent = new Intent(this, RespostaActivity.class);
        if(rgRespostas.getCheckedRadioButtonId() == respostaCerta) {
            intent.putExtra("acertou", true);
            pontos++;
        }
        else intent.putExtra("acertou", false);
        intent.putExtra("pontos", pontos);
        startActivity(intent);

        rgRespostas.clearCheck();
        rbResposta1.setChecked(true);
    }

    private void carregarQuestao(){

        // embaralhar(questoes);

        if(questoes.size() > 0) {
            Questao q = questoes.remove(0);
            pergunta.setText(q.getPergunta());
            imgPergunta.setImageResource(q.getImgPergunta());
            List<String> resposta = q.getRespostas();
            rbResposta1.setText(resposta.get(0));
            rbResposta2.setText(resposta.get(1));
            rbResposta3.setText(resposta.get(2));
            rbResposta4.setText(resposta.get(3));
            respostaCerta = q.getRespostaCerta();
            rgRespostas.setSelected(false);
        }
        else{ //acabaram as questões
            Intent intent = new Intent(this, RespostaActivity.class);
            intent.putExtra("pontos", pontos);
            startActivity(intent);
            finish();
        }
    }

    public void embaralhar(List<Questao> questoes){
        Collections.shuffle(questoes);
    }
}

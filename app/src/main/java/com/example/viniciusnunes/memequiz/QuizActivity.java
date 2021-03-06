package com.example.viniciusnunes.memequiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
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
    int count = 0;
    int respostaCerta;
    int pontos;
    List<Questao> questoes = new ArrayList<Questao>(){
        {
            add(new Questao(R.drawable.questao1, "Considerando o pseudocódigo", R.id.rbResposta3, "A) Lê um número negativo e mostra na tela o seu fatorial.", "B) Lê o fatorial e mostra o número na tela.", "C) Lê um número não negativo e mostra na tela o seu fatorial.", "D) Nenhuma das opções acima."));
            add(new Questao(R.drawable.questao2,"Analise os trechos de código acima, escritos em uma linguagem de programação hipotética, fazendo uso dos comandos “while-do” (enquanto-faça) e “do-while” (faça-enquanto) e supondo que a, b e c foram declaradas anteriormente. \n \nQuais são os valores de a, b e c, após o término de cada trecho, se as variáveis a, b e c foram inicializadas com 3, 0 e 3, respectivamente, antes de cada trecho?", R.id.rbResposta1, "A) 3, 0 e 3   e   2, 1 e 4.", "B) 2, 1 e 1   e   2, 1 e 2.", "C) 1, 2 e 3   e   3, 2 e 3.", "D) 2, 1 e 3   e   1, 2 e 3."));
            add(new Questao(R.drawable.questao3,"Considere o seguinte algoritmo, onde n é um inteiro positivo lido do teclado \n \nSupondo que as variáveis i e j não sofram alterações no bloco de comandos B, o número total de vezes que B é executado é uma função:", R.id.rbResposta4, "A) Constante;", "B) Logarítmica em n;", "C) Linear em n;", "D) Quadrática em n;"));
            add(new Questao(R.drawable.questao4, "Sendo a e b variáveis inteiras em um programa, a expressão lógica é equivalente a:", R.id.rbResposta3, "A) (a <= b);", "B) (a >= b);", "C) (a < b);", "D) (a > b);"));
            add(new Questao(R.drawable.questao5, "Considere o código acima:", R.id.rbResposta2, "A) Em um laço de repetição, o controle do número de vezes que o laço será repetido ocorre por meio de variáveis", "B) Em um laço de repetição, o controle do número de vezes que o laço será repetido ocorre por meio de operadores lógicos.", "C) Opção A e B.", "D) Nenhuma das alternativas."));
            add(new Questao(R.drawable.questao6, "Qual a definição de bubble sort está correta?", R.id.rbResposta3, "A) O princípio do Bubblesort é a troca de vetores entre posições separadas, fazendo com que os valores mais altos ( ou mais baixos ) \"borbulhem\" para o final do arranjo (daí o nome Bubblesort).", "B) São bolhas de sabão sortudas.", "C) O princípio do Bubblesort é a troca de valores entre posições consecutivas, fazendo com que os valores mais altos ( ou mais baixos ) \"borbulhem\" para o final do arranjo (daí o nome Bubblesort).", "D) Nenhuma das alternativas"));
            add(new Questao(R.drawable.questao7, "Qual o valor de 'a' na seguinte expressão:", R.id.rbResposta3, "A) true;", "B) false;", "C) 20.", "D) 10."));
            add(new Questao(R.drawable.questao8, "Qual o nome dado a estrutura utilizada para gravar as características de uma classe?", R.id.rbResposta4, "A) Método.", "B) Caracter.", "C) Query.", "D) Atributo."));
            add(new Questao(R.drawable.questao9, "Qual o tipo de retorno do método acima?", R.id.rbResposta1, "A) Vazio.", "B) String.", "C) Estático.", "D) Público."));
            add(new Questao(R.drawable.questao10, "O que está sendo impresso?", R.id.rbResposta1, "A) [1,11,21,31,41,51,61,71,81,91,101,111,121,131,141,151,161,171,181,191];", "B) [1,11,21,31,41,51,61,71,81,91,101,111,112,131,141,151,161,171,181,191];", "C) [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20];", "D) Nenhuma das anteriores."));
            add(new Questao(R.drawable.questao11,"O que é 'Pseudocódigo'?", R.id.rbResposta1, "A) Um bagulho muito louco", "Uma forma genérica de escrever um algoritmo, utilizando uma linguagem simples (nativa a quem o escreve, de forma a ser entendida por qualquer pessoa) sem necessidade de conhecer a sintaxe de uma linguagem de programação específica;", "Uma linguagem de programação Orientada a Objetos;", "Uma linguagem de programação não Orientada a Objetos;" ));
            add(new Questao(R.drawable.questao12, "Onde as variáveis ficam armazenadas?", R.id.rbResposta1, "A) Na memória RAM;", "B) No Disco Local C;", "C) Na memória do programador;", "D) No banco de dados;" ));
            add(new Questao(R.drawable.questao13, "O que são estruturas de repetição ?", R.id.rbResposta4, "A) É a estrutura em algoritmos que soma todas as variáveis.", "B) É a estrutura em algoritmos usada para definir um fatorial.", "C) É uma estrutura em algoritmos que utilizam variáveis booleanas.", "D) É a estrutura em algoritmos que permite executar mais de uma vez um conjunto de comandos."));
            add(new Questao(R.drawable.questao14, "Informe qual o resultado da expressão aritmética  será exibido no algoritmo a seguir:", R.id.rbResposta2, "A) 14.2", "B) 17.2", "C) 27.8", "D) 102"));
            add(new Questao(R.drawable.questao15, "Informe qual o resultado da expressão aritmética  será exibido no algoritmo a seguir:", R.id.rbResposta3, "A) Entrará nos 2", "B) Entrará no SE", "C) Entrará no SENÃO", "D) Não entrará em nenhum"));
            add(new Questao(R.drawable.questao16, "Diga o resultado final das duas questões utilizando os seguintes operadores de sentença:", R.id.rbResposta3, "A) Falso e verdadeiro", "B) Falso e falso", "C) Verdadeiro e falso", "D) Verdadeiro e verdadeiro"));
            add(new Questao(R.drawable.questao17, "Observe a seguinte expressão e responda qual será o resultado final:", R.id.rbResposta3, "A) Falso", "B) 5", "C) Verdadeiro", "D) Nenhuma das anteriores"));
            add(new Questao(R.drawable.questao18, "Seguindo a ordem, diga o significados dos seguintes operadores lógicos:", R.id.rbResposta4, "A) Maior, menor, menor ou igual, maior ou igual, igual, diferente", "B) Menor, maior, menor ou igual, maior ou igual, igual, diferente", "C) Menor, maior, maior ou igual, menor ou igual, igual, diferente", "D) Maior, menor, maior ou igual, menor ou igual, igual, diferente"));
            add(new Questao(R.drawable.questao19, "Qual das seguintes variáveis só aceita números inteiros?", R.id.rbResposta3, "A) Single", "B) Double", "C) Integer", "D) String"));
            add(new Questao(R.drawable.questao20, "Qual a definição está correta?", R.id.rbResposta1, "A) É um conjunto de variáveis do mesmo tipo acessíveis com um único nome.", "B) É um conjunto de variáveis de tipos diferentes acessíveis com boolean.", "C) É uma variável contendo uma função.", "D) Nenhuma das anteriores"));

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        imgPergunta = (ImageView)findViewById(R.id.imgPergunta);
        pergunta    = (TextView)findViewById(R.id.pergunta);
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

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    public void btnResponderOnClick(View v){
        if ( rgRespostas.getCheckedRadioButtonId() != -1 ) {
            RadioButton rb = (RadioButton) findViewById(rgRespostas.getCheckedRadioButtonId());
            Intent intent = new Intent(this, RespostaActivity.class);
            if (rgRespostas.getCheckedRadioButtonId() == respostaCerta) {
                intent.putExtra("acertou", true);
                pontos++;
            } else intent.putExtra("acertou", false);
            intent.putExtra("pontos", pontos);
            startActivity(intent);

            rgRespostas.clearCheck();
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(QuizActivity.this).create();
            alertDialog.setTitle("Atenção");
            alertDialog.setMessage("Você deve marcar pelo menos uma opção");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }

    private void carregarQuestao(){
        embaralhar(questoes);

        if(questoes.size() > 0 && this.count < 10) {
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
            this.count++;
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

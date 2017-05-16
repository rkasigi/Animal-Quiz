package iak.rkasigi.net.quizbinatang;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ListIterator;

public class QuizActivity extends AppCompatActivity {

    private ListIterator<AnimalQuizModel> animalQuizRepositoryList;
    private AnimalQuizModel animalQuizModel;

    private MediaPlayer mPlayer;
    private ImageView imageViewAnimal;
    private TextView textViewTitleAnimalId;
    private RadioButton radioButton01;
    private RadioButton radioButton02;
    private RadioButton radioButton03;
    private RadioButton radioButton04;
    private Button buttonNext;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        this.setFinishOnTouchOutside(false);

        imageViewAnimal = (ImageView) findViewById(R.id.quzImageViewAnimal);
        textViewTitleAnimalId = (TextView) findViewById(R.id.quzTitle);
        buttonNext = (Button) findViewById(R.id.quzButtonNext);
        radioButton01 = (RadioButton) findViewById(R.id.quzRadio01);
        radioButton02 = (RadioButton) findViewById(R.id.quzRadio02);
        radioButton03 = (RadioButton) findViewById(R.id.quzRadio03);
        radioButton04 = (RadioButton) findViewById(R.id.quzRadio04);

        buttonNext.setOnClickListener(onButtonNextClicked);

        initialData();
    }

    private void initialData() {
        animalQuizRepositoryList = AnimalQuizRepository.getInstance().getAnimalQuizModelList().listIterator();
        score = 0;

        if(animalQuizRepositoryList.hasNext()) {
            buttonNext.setText("Selanjutnya");
            showAnimalDetail(animalQuizRepositoryList.next());

        } else {
            buttonNext.setText("Kembali");
        }

    }

    private void showAnimalDetail(AnimalQuizModel quiz) {
        radioButton01.setChecked(false);
        radioButton02.setChecked(false);
        radioButton03.setChecked(false);
        radioButton04.setChecked(false);

        animalQuizModel = quiz;
        imageViewAnimal.setImageResource(quiz.getAnimalModel().getImage());
        textViewTitleAnimalId.setText(quiz.getAnimalModel().getNameID());
        radioButton01.setText(quiz.getChoicesAnswer().get(0));
        radioButton02.setText(quiz.getChoicesAnswer().get(1));
        radioButton03.setText(quiz.getChoicesAnswer().get(2));
        radioButton04.setText(quiz.getChoicesAnswer().get(3));

        mPlayer = MediaPlayer.create(this, quiz.getAnimalModel().getVoice());
        mPlayer.start();

    }

    private void nextQuestion() {
        if(animalQuizRepositoryList.hasNext()) {
            showAnimalDetail(animalQuizRepositoryList.next());
        } else {

            new AlertDialog.Builder(this)
                    .setTitle("Selamat")
                    .setMessage(String.format("Quiz telah selesai.\nkamu berhasil menjawab %s dari %s pertanyaan  ", score, AnimalQuizRepository.getInstance().getAnimalQuizModelList().size()))
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();

                        }
                    })
                    .setCancelable(false)
                    .show();



        }

    }


    private View.OnClickListener onButtonNextClicked = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            int theAnswer = 0;

            if(radioButton01.isChecked())       theAnswer = 1;
            else if(radioButton02.isChecked())  theAnswer = 2;
            else if(radioButton03.isChecked())  theAnswer = 3;
            else if(radioButton04.isChecked())  theAnswer = 4;

            if(theAnswer > 0) {

                if(animalQuizModel.getAnswer() == theAnswer) {
                    score += 1;
                    Toast.makeText(v.getContext(), "Selamat Jawaban kamu benar", Toast.LENGTH_SHORT).show();
                    nextQuestion();
                } else {
                    String correntAnswer = animalQuizModel.getAnswerString();

                    new AlertDialog.Builder(v.getContext())
                            .setTitle("Jawaban")
                            .setMessage(String.format("Maaf, jawaban kamu salah.\nJawaban yang benar adalah %s", correntAnswer))
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    nextQuestion();

                                }
                            })
                            .setCancelable(false)
                            .show();

                }





            } else {

                Toast.makeText(v.getContext(), "Kamu harus menjawab pertanyaannya, untuk bisa melanjutkan", Toast.LENGTH_LONG).show();

            }







        }
    };
}

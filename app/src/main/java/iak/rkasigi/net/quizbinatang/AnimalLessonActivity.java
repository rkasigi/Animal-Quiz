package iak.rkasigi.net.quizbinatang;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ListIterator;

public class AnimalLessonActivity extends AppCompatActivity {

    ListIterator<AnimalModel> animalList;
    private MediaPlayer mPlayer;
    private ImageView imageViewAnimal;
    private TextView textViewTitleAnimalId;
    private TextView textViewTitleAnimalEn;
    private Button buttonNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_lesson);


        imageViewAnimal = (ImageView) findViewById(R.id.lsnImageViewAnimal);
        textViewTitleAnimalId = (TextView) findViewById(R.id.lsnTitle);
        textViewTitleAnimalEn = (TextView) findViewById(R.id.lsnTitlen);
        Button buttonHearVoice = (Button) findViewById(R.id.lsnButtonHearVoice);
        buttonNext = (Button) findViewById(R.id.lsnButtonNext);

        buttonHearVoice.setOnClickListener(onButtonHearVoiceClicked);
        buttonNext.setOnClickListener(onButtonNextClicked);

        initialData();

    }

    private void initialData() {
        animalList = AnimalRepository.getInstance().getAnimalList().listIterator();
        if(animalList.hasNext()) {
            buttonNext.setText("Selanjutnya");
            showAnimalDetail(animalList.next());

        } else {
            buttonNext.setText("Kembali");
        }

    }

    private void showAnimalDetail(AnimalModel animal) {

        imageViewAnimal.setImageResource(animal.getImage());
        textViewTitleAnimalId.setText(animal.getNameID());
        textViewTitleAnimalEn.setText(animal.getNameEN());
        mPlayer = MediaPlayer.create(this, animal.getVoice());
        mPlayer.start();

    }

    private View.OnClickListener onButtonHearVoiceClicked = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            mPlayer.stop();
            try {
                mPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mPlayer.start();
        }
    };

    private View.OnClickListener onButtonNextClicked = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            if(animalList.hasNext()) {
                showAnimalDetail(animalList.next());
            } else {

                if(buttonNext.getText() != "Kembali") {
                    buttonNext.setText("Kembali");
                    Toast.makeText(v.getContext(), "Pelajaran telah selesai, mari kembali", Toast.LENGTH_LONG).show();
                } else {
                    finish();
                }

            }

        }
    };

}

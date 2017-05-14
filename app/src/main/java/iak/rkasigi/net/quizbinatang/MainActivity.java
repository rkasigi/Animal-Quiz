package iak.rkasigi.net.quizbinatang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String loginName = getIntent().getStringExtra("loginName");
        ((TextView)findViewById(R.id.textViewDisplayName)).setText("Selamat datang " + loginName);

        TextView buttonShowBelajarBinatang = (TextView) findViewById(R.id.buttonShowBelajarBinatang);
        TextView buttonQuizBinatang = (TextView) findViewById(R.id.buttonShowQuizBinatang);


        buttonShowBelajarBinatang.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AnimalLessonActivity.class);
                startActivity(intent);
            }
        });

        buttonQuizBinatang.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), QuizActivity.class);
                startActivity(intent);
            }
        });
    }
}

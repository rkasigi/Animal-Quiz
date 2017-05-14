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

        final Intent intent = new Intent(this, AnimalLessonActivity.class);
        TextView buttonShowBelajarBinatang = (TextView) findViewById(R.id.buttonShowBelajarBinatang);


        buttonShowBelajarBinatang.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}

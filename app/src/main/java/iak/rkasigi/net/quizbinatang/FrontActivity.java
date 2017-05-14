package iak.rkasigi.net.quizbinatang;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FrontActivity extends AppCompatActivity {

    private EditText textName;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        Button buttonMasuk = (Button) findViewById(R.id.buttonEnter);
        textName = (EditText) findViewById(R.id.editTextName);
        intent = new Intent(this, MainActivity.class);

        textName.requestFocus();
        buttonMasuk.setOnClickListener(onButttonMasukClick);
    }

    private View.OnClickListener onButttonMasukClick = new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            String name = textName.getText().toString();

            if(name.isEmpty()) {
                new AlertDialog.Builder(v.getContext())
                        .setTitle("Informasi")
                        .setMessage("Kolom nama tidak boleh kosong!")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(R.string.ok, null)
                        .show();
            } else {
                intent.putExtra("loginName", name);
                startActivity(intent);
                finish();

            }

        }
    };
}

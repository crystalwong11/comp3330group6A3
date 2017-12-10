package group6.group6a3demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDB;
    Button btnStg;
    Button btnNotf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDB = findViewById(R.id.database);
        btnStg = findViewById(R.id.storage);
        btnNotf = findViewById(R.id.notifications);

        btnDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent();
                //startActivity(intent);
            }
        });

        btnStg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CloudStorage.class);
                startActivity(intent);
            }
        });

        btnNotf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent();
                //startActivity(intent);
            }
        });
    }
}

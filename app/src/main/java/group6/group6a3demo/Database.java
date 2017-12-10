package group6.group6a3demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;



public class Database  extends AppCompatActivity {

    TextView viewEventNameI;
    TextView viewDateI;
    TextView viewTimeI;
    TextView viewLocationI;
    TextView viewContactNameI;
    TextView viewContactPhoneI;
    TextView viewDescriptionI;

    Button button1;
    Button button2;
    Button button3;
    Button button4;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    Query query;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        viewEventNameI = (TextView) findViewById(R.id.viewEventNameI);
        viewDateI = (TextView) findViewById(R.id.viewDateI);
        viewTimeI = (TextView) findViewById(R.id.viewTimeI);
        viewLocationI = (TextView) findViewById(R.id.viewLocationI);
        viewContactNameI = (TextView) findViewById(R.id.viewContactNameI);
        viewContactPhoneI = (TextView) findViewById(R.id.viewContactPhoneI);
        viewDescriptionI = (TextView) findViewById(R.id.viewDescriptionI);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runQuery("001");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runQuery("005");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runQuery("003");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runQuery("004");
            }
        });

    }

    private void runQuery(String key) {
        query = database.getReference().child("events").child(key);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("event_name").getValue().toString();
                String date = dataSnapshot.child("eventDate").getValue().toString();
                String time = dataSnapshot.child("eventTime").getValue().toString();
                String location = dataSnapshot.child("location").getValue().toString();
                String contactName = dataSnapshot.child("contactName").getValue().toString();
                String contactPhone = dataSnapshot.child("contactPhone").getValue().toString();
                String description = dataSnapshot.child("description").getValue().toString();

                viewEventNameI.setText("Event Name: "+ name);
                viewDateI.setText("Date: " + date);
                viewTimeI.setText("Time:" + time);
                viewLocationI.setText("Loaction: " + location);
                viewContactNameI.setText("Contact Person: " + contactName);
                viewContactPhoneI.setText("Phone: " + contactPhone);
                viewDescriptionI.setText("Description: " + description);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

    }

}

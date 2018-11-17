package devaguptam.sreelaya.g.teachingassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;




public class Intermediate extends AppCompatActivity {



    CardView clause,phrase,tenses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate);

        clause= findViewById(R.id.clause);
        phrase=findViewById(R.id.phrase);
        tenses=findViewById(R.id.tense);

        clause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clause.getContext().startActivity(new Intent(clause.getContext(),Clause.class));
            }
        });

        phrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clause.getContext().startActivity(new Intent(clause.getContext(),Phrase.class));
            }
        });

        tenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tenses.getContext().startActivity(new Intent(tenses.getContext(),Tenses.class));
            }
        });


    }
}

package devaguptam.sreelaya.g.teachingassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Basics extends AppCompatActivity {

    CardView article, senten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basics);

        article= findViewById(R.id.articles);
        senten=findViewById(R.id.sentences);

        article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                article.getContext().startActivity(new Intent(article.getContext(),Articles.class));
            }
        });

        senten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senten.getContext().startActivity(new Intent(senten.getContext(),Sentences.class));
            }
        });
    }
}

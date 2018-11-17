
package devaguptam.sreelaya.g.teachingassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;


public class Levels extends AppCompatActivity {

    CardView basic,novice,inter,adv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        basic= findViewById(R.id.basic);
        novice= findViewById(R.id.novice);
        inter= findViewById(R.id.inter);
        adv= findViewById(R.id.adv);

        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basic.getContext().startActivity(new Intent(basic.getContext(),Basics.class));
            }
        });

        novice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novice.getContext().startActivity(new Intent(novice.getContext(),Novices.class));
            }
        });

        inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inter.getContext().startActivity(new Intent(inter.getContext(),Intermediate.class));
            }
        });

        adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adv.getContext().startActivity(new Intent(adv.getContext(),Advanced.class));
            }
        });


    }
}

package devaguptam.sreelaya.g.teachingassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Advanced extends AppCompatActivity {

    CardView aapv,dais,idioms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);

        aapv=findViewById(R.id.aapv);
        dais=findViewById(R.id.dais);
        idioms=findViewById(R.id.idioms);


        aapv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aapv.getContext().startActivity(new Intent(aapv.getContext(),Aapv.class));
            }
        });

        dais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dais.getContext().startActivity(new Intent(dais.getContext(),Dais.class));
            }
        });

        idioms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idioms.getContext().startActivity(new Intent(idioms.getContext(),Idioms.class));
            }
        });



    }
}

package devaguptam.sreelaya.g.teachingassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Novices extends AppCompatActivity {

    CardView pos,cnp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novices);

        pos=findViewById(R.id.pos);
        cnp=findViewById(R.id.cnp);

        pos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos.getContext().startActivity(new Intent(pos.getContext(),Pos.class));
            }
        });

        cnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cnp.getContext().startActivity(new Intent(cnp.getContext(),Cnp.class));
            }
        });


    }
}

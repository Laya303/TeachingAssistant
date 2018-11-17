package devaguptam.sreelaya.g.teachingassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Main extends AppCompatActivity {
CardView eng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        eng=findViewById(R.id.card_view1);
        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eng.getContext().startActivity(new Intent(eng.getContext(),Levels.class));
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.go_profile)
        {
            Intent i=new Intent(this,Login.class);
            startActivity(i);
        }
        return true;
    }


}

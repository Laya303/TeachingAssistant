package devaguptam.sreelaya.g.teachingassistant;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    ImageView sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sp= findViewById(R.id.sp);

        Animation rotate = AnimationUtils.loadAnimation(Splash.this, R.anim.rotate_picture);
        sp.startAnimation(rotate);

        new Handler().postDelayed(new Runnable() {




            @Override
            public void run() {

                Intent i = new Intent(Splash.this, Main.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}

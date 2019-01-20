package e.nirvik.floatingbutton;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity{
    FloatingActionButton fab_plus,fab_call,fab_message,fab_email;
    Animation FabOpen,FabClose,FabRClockwise,FabRanti;
    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab_plus = (FloatingActionButton) findViewById(R.id.fab_plus);
        fab_call = (FloatingActionButton) findViewById(R.id.fab_call);
        fab_message = (FloatingActionButton) findViewById(R.id.fab_message);
        fab_email = (FloatingActionButton) findViewById(R.id.fab_email);
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_opn);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        FabRClockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clkwse);
        FabRanti = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlkwse);

        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (isOpen) {
                fab_call.startAnimation(FabClose);
                fab_message.startAnimation(FabClose);
                fab_email.startAnimation(FabClose);
                fab_plus.startAnimation(FabRanti);
                fab_message.setClickable(false);
                fab_call.setClickable(false);
                fab_email.setClickable(false);
                isOpen = false;
            } else {
                fab_call.startAnimation(FabOpen);
                fab_message.startAnimation(FabOpen);
                fab_email.startAnimation(FabOpen);
                fab_plus.startAnimation(FabRClockwise);
                fab_call.setClickable(true);
                fab_message.setClickable(true);
                fab_email.setClickable(true);
                isOpen = true;
            }
        }
    });
    }
}
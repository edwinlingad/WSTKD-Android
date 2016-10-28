package com.ascensive_software.wstkd;

import android.graphics.Typeface;
import android.icu.text.DisplayContext;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.ascensive_software.wstkd.core.IdeaManager;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabGenerateIdea;
    private TextView tvIdea;

    private IdeaManager ideaManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WSTKDApplication app = (WSTKDApplication)getApplicationContext();
        ideaManager = app.getIdeaManager();

        fabGenerateIdea = (FloatingActionButton) findViewById(R.id.generate_idea);
        fabGenerateIdea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idea = ideaManager.GetNextIdea();
                tvIdea.setText(idea);
                tvIdea.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in));
            }
        });
        fabGenerateIdea.setRippleColor(0);

        tvIdea = (TextView)findViewById(R.id.tv_idea);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/PermanentMarker.ttf");
        tvIdea.setTypeface(typeface);
    }
}

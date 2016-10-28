package com.ascensive_software.wstkd;

import android.graphics.Typeface;
import android.icu.text.DisplayContext;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabGenerateIdea;
    private TextView tvIdea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabGenerateIdea = (FloatingActionButton) findViewById(R.id.generate_idea);
        fabGenerateIdea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvIdea.setText("Hello");
            }
        });

        tvIdea = (TextView)findViewById(R.id.tv_idea);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/PermanentMarker.ttf");
        tvIdea.setTypeface(typeface);
    }
}

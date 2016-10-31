package com.ascensive_software.wstkd;

import android.graphics.Typeface;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ascensive_software.wstkd.core.CategoryEnum;
import com.ascensive_software.wstkd.core.IdeaManager;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

//    private FloatingActionButton fabGenerateIdea;
    private TextView tvIdea;
    private ImageButton btnCategory;

    private IdeaManager ideaManager;
    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // IdeaManager
        ideaManager = getApp().getIdeaManager();

        // Bottom sheet
        RelativeLayout bottomSheetLayout = (RelativeLayout)findViewById(R.id.category_bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout);

//        // FAB
//        fabGenerateIdea = (FloatingActionButton) findViewById(R.id.generate_idea);
//        fabGenerateIdea.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String idea = ideaManager.getNextIdea();
//                tvIdea.setText(idea);
//                tvIdea.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in));
//
//            }
//        });
//        fabGenerateIdea.setRippleColor(0);

        // background image
        ImageView backgroundImage = (ImageView)findViewById(R.id.background_image);
        backgroundImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idea = ideaManager.getNextIdea();
                tvIdea.setText(idea);
                tvIdea.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in));
            }
        });

        // Text View
        tvIdea = (TextView)findViewById(R.id.tv_idea);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/PermanentMarker.ttf");
        tvIdea.setTypeface(typeface);

        // category Button
        btnCategory = (ImageButton) findViewById(R.id.category_button);
        btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        // Bottom Sheet
        initBottomSheet();

        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

    }

    private void initBottomSheet() {
        final HashMap<Integer, CategoryEnum> map = getApp().getIdToCategoryMap();
        final HashMap<Integer, Integer> idToIconMap = getApp().getIdToIconMap();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ideaManager.setCategory(map.get(view.getId()));
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                btnCategory.setImageResource(idToIconMap.get(view.getId()));
                btnCategory.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in));
            }
        };

        int[] catIds = getApp().getCatIds();

        for (int i=0; i< catIds.length; i++) {
            LinearLayout linearLayout = (LinearLayout)findViewById(catIds[i]);
            linearLayout.setOnClickListener(listener);
        }
    }

    private WSTKDApplication app_;
    private WSTKDApplication getApp() {
        if(app_ == null)
            app_ = (WSTKDApplication)getApplicationContext();

        return app_;
    }

}

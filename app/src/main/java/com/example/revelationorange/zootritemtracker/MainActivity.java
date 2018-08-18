package com.example.revelationorange.zootritemtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private IconStateManager iconManager;
    private SharedPreferences sp;
    private ArrayList<ImageButton> allButtons = new ArrayList<>();
    private final float MARKED_ALPHA = 1, UNMARKED_ALPHA = (float) 0.4;
    private static final String SHARED_PREFS = "shared_preferences";

    private static int idStart = 100;
    private static int idCounter = idStart;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        /*
        dunno if I'm supposed to credit where I got the icons from, but:
        icon credit goes to testrunner's OoT map tracker
        just grabbed the icon files from that
        they're good icons
        also the FRST and stuff, those images I just screenshotted from emotracker
        from Hamsda's package "OoT Randomizer - Map and Item Tracker"
        */

        iconManager = new IconStateManager(sp);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        final int iconWidth = 160;
        final int iconHeight = 160;
        int maxIcons = screenWidth/ iconWidth;
        int remainingPadding = screenWidth - maxIcons* iconWidth;
        int actualPad = (remainingPadding/maxIcons);
        actualPad *= 0.75;

        ConstraintLayout trackerPanel = findViewById(R.id.trackerLayout);
        findViewById(R.id.mainLayout).setBackgroundColor(Color.parseColor("#646464"));
//        trackerPanel.setBackground(getResources().getDrawable(R.mipmap.ic_launcher));
        ConstraintSet cset = new ConstraintSet();
        ImageButton prevButton = null;
        int newRowCounter = 1;
        for (int i = 0; i < iconManager.getNIcons(); i++) {
            ImageButton b = makeImgButton(this);
            int state = iconManager.getState(i);
            b.setBackgroundResource(iconManager.getBackground(i));
            if (state > 0) { b.setAlpha(MARKED_ALPHA); }
            else { b.setAlpha(UNMARKED_ALPHA); }
            b.setMinimumHeight(iconHeight);
            b.setMinimumWidth(iconWidth);
            b.setOnClickListener(cycleIcons(b, i));
            b.setOnLongClickListener(resetIcon(b, i));

            trackerPanel.addView(b);
            cset.clone(trackerPanel);
            if (prevButton == null) {
                ImageButton rb = findViewById(R.id.resetButton);
                cset.connect(b.getId(), ConstraintSet.TOP, rb.getId(), ConstraintSet.BOTTOM, 16*3);
                cset.connect(b.getId(), ConstraintSet.LEFT, trackerPanel.getId(), ConstraintSet.LEFT, actualPad);
            }
            else {
                if (newRowCounter < maxIcons) {
                    cset.connect(b.getId(), ConstraintSet.TOP, prevButton.getId(), ConstraintSet.TOP);
                    cset.connect(b.getId(), ConstraintSet.LEFT, prevButton.getId(), ConstraintSet.RIGHT, actualPad);
                    newRowCounter++;
                }
                else {
                    cset.connect(b.getId(), ConstraintSet.TOP, prevButton.getId(), ConstraintSet.BOTTOM);
                    cset.connect(b.getId(), ConstraintSet.LEFT, trackerPanel.getId(), ConstraintSet.LEFT, actualPad);
                    newRowCounter = 1;
                }
            }
            cset.applyTo(trackerPanel);

            if (iconManager.getNIcons()-i < 10) {
                ImageButton bOver = makeImgButton(this);
                bOver.setMinimumWidth(iconWidth);
                int bheight = 20;
                bOver.setMinimumHeight(bheight);
                bOver.setMaxHeight(bheight);
                bOver.setOnClickListener(cycleIcons(b, i));
                bOver.setOnLongClickListener(resetIcon(b, i));
                switch (iconManager.getNIcons()-i) {
                    case 9:
                        bOver.setBackgroundResource(R.drawable.frst);
                        break;
                    case 8:
                        bOver.setBackgroundResource(R.drawable.fire);
                        break;
                    case 7:
                        bOver.setBackgroundResource(R.drawable.watr);
                        break;
                    case 6:
                        bOver.setBackgroundResource(R.drawable.sprt);
                        break;
                    case 5:
                        bOver.setBackgroundResource(R.drawable.shdw);
                        break;
                    case 4:
                        bOver.setBackgroundResource(R.drawable.free);
                        break;
                    case 3:
                        bOver.setBackgroundResource(R.drawable.deku);
                        break;
                    case 2:
                        bOver.setBackgroundResource(R.drawable.dcvn);
                        break;
                    case 1:
                        bOver.setBackgroundResource(R.drawable.jabu);
                        break;
                }
                trackerPanel.addView(bOver);
                cset.clone(trackerPanel);
                cset.connect(bOver.getId(), ConstraintSet.BOTTOM, b.getId(), ConstraintSet.BOTTOM);
                cset.connect(bOver.getId(), ConstraintSet.LEFT, b.getId(), ConstraintSet.LEFT);
                cset.applyTo(trackerPanel);
            }

            allButtons.add(b);
            prevButton = b;
        }
        ImageButton ib = allButtons.get(allButtons.size()-1);
        ib.setForegroundGravity(Gravity.BOTTOM);
    }

    public void reset(View v) {
        for (int i = 0; i < allButtons.size(); i++) {
            ImageButton b = allButtons.get(i);
            b.setAlpha(UNMARKED_ALPHA);
            iconManager.resetState(i);
            b.setBackgroundResource(iconManager.getBackground(i));
            sp.edit().putInt(Integer.toString(i), 0).apply();
        }
    }

    View.OnClickListener cycleIcons(final ImageButton b, final int index) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newState = iconManager.advState(index);
                b.setBackgroundResource(iconManager.getBackground(index));
                b.setAlpha(newState == 0 ? UNMARKED_ALPHA : MARKED_ALPHA);
                sp.edit().putInt(Integer.toString(index), iconManager.getState(index)).apply();
            }
        };
    }

    View.OnLongClickListener resetIcon(final ImageButton b, final int index) {
        return new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                b.setBackgroundResource(iconManager.resetState(index));
                b.setAlpha(UNMARKED_ALPHA);
                sp.edit().putInt(Integer.toString(index), 0).apply();
                return true;
            }
        };
    }

    private static int getNextID() { return idCounter++; }
//    private static int getCurID() { return idCounter; }

    private static ImageButton makeImgButton(Context c) {
        ImageButton retButton = new ImageButton(c);
        retButton.setId(getNextID());
        return retButton;
    }
}

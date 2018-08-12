package com.example.revelationorange.zootritemtracker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout trackerPanel;
    private ArrayList<Integer> iconIds = new ArrayList<>();
    private final int iconWidth = 160, iconHeight = 160;
    private final float MARKED_ALPHA = 1, UNMARKED_ALPHA = (float) 0.45;

    private static int idStart = 100;
    private static int idCounter = idStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iconIds.add(R.drawable.deku_stick);
        iconIds.add(R.drawable.deku_nut);
        iconIds.add(R.drawable.bomb);
        iconIds.add(R.drawable.bow);
        iconIds.add(R.drawable.fire_arrow);
        iconIds.add(R.drawable.ice_arrow);
        iconIds.add(R.drawable.light_arrow);
        iconIds.add(R.drawable.dins_fire);
        iconIds.add(R.drawable.farores_wind);
        iconIds.add(R.drawable.nayrus_love);
        iconIds.add(R.drawable.kokiri_sword);
        iconIds.add(R.drawable.master_sword);
        iconIds.add(R.drawable.biggorons_sword);
        iconIds.add(R.drawable.slingshot);
        iconIds.add(R.drawable.fairy_ocarina);
        iconIds.add(R.drawable.bombchu);
        iconIds.add(R.drawable.hookshot);
        iconIds.add(R.drawable.deku_shield);
        iconIds.add(R.drawable.hylian_shield);
        iconIds.add(R.drawable.mirror_shield);
        iconIds.add(R.drawable.boomerang);
        iconIds.add(R.drawable.lens);
        iconIds.add(R.drawable.magic_beans);
        iconIds.add(R.drawable.hammer);
        iconIds.add(R.drawable.goron_bracelet);
        iconIds.add(R.drawable.goron_tunic);
        iconIds.add(R.drawable.zora_tunic);
        iconIds.add(R.drawable.empty_bottle);
        iconIds.add(R.drawable.rutos_letter);
        iconIds.add(R.drawable.silver_scale);
        iconIds.add(R.drawable.iron_boots);
        iconIds.add(R.drawable.hover_boots);
        iconIds.add(R.drawable.gray_note);
        iconIds.add(R.drawable.gray_note);
        iconIds.add(R.drawable.gray_note);
        iconIds.add(R.drawable.gray_note);
        iconIds.add(R.drawable.gray_note);
        iconIds.add(R.drawable.gray_note);
        iconIds.add(R.drawable.adults_wallet);
        iconIds.add(R.drawable.magic);
        iconIds.add(R.drawable.gold_skulltula);
        iconIds.add(R.drawable.minuet_of_forest);
        iconIds.add(R.drawable.bolero_of_fire);
        iconIds.add(R.drawable.serenade_of_water);
        iconIds.add(R.drawable.requiem_of_spirit);
        iconIds.add(R.drawable.nocturne_of_shadow);
        iconIds.add(R.drawable.prelude_of_light);
        iconIds.add(R.drawable.stone_of_agony);
        iconIds.add(R.drawable.forest_medallion);
        iconIds.add(R.drawable.fire_medallion);
        iconIds.add(R.drawable.water_medallion);
        iconIds.add(R.drawable.spirit_medallion);
        iconIds.add(R.drawable.shadow_medallion);
        iconIds.add(R.drawable.light_medallion);
        iconIds.add(R.drawable.kokiri_emerald);
        iconIds.add(R.drawable.gorons_ruby);
        iconIds.add(R.drawable.zoras_sapphire);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        int maxIcons = screenWidth/iconWidth;
        int remainingPadding = screenWidth - maxIcons*iconWidth;
        int actualPad = (remainingPadding/maxIcons);
        actualPad *= 0.75;
        System.out.println("padding:");
        System.out.println(actualPad);

        trackerPanel = findViewById(R.id.trackerLayout);
        trackerPanel.setBackgroundColor(Color.parseColor("#646464"));
//        trackerPanel.setBackground(getResources().getDrawable(R.mipmap.ic_launcher));
        ConstraintSet cset = new ConstraintSet();
        ImageButton prevButton = null;
        int newRowCounter = 1;
        for (int i = 0; i < iconIds.size(); i++) {
            ImageButton b = makeImgButton(this);
            b.setBackgroundResource(iconIds.get(i));
            b.setMinimumHeight(160);
            b.setMinimumWidth(160);
            b.setAlpha(UNMARKED_ALPHA);
            b.setOnClickListener(swapAlpha(b));

            trackerPanel.addView(b);
            cset.clone(trackerPanel);
            if (prevButton == null) {
                cset.connect(b.getId(), ConstraintSet.TOP, trackerPanel.getId(), ConstraintSet.TOP);
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
            prevButton = b;
        }
    }

    View.OnClickListener swapAlpha(final ImageButton b) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getAlpha() == MARKED_ALPHA) { v.setAlpha(UNMARKED_ALPHA); }
                else { v.setAlpha(MARKED_ALPHA); }
            }
        };
    }

    static int getNextID() { return idCounter++; }
    static int getCurID() { return idCounter; }

    static Button makebutton(Context c) {
        Button retButton = new Button(c);
        retButton.setId(getNextID());
        return retButton;
    }

    static ImageButton makeImgButton(Context c) {
        ImageButton retButton = new ImageButton(c);
        retButton.setId(getNextID());
        return retButton;
    }

    static FloatingActionButton makefabutton(Context c) {
        FloatingActionButton retButton = new FloatingActionButton(c);
        retButton.setId(getNextID());
        return retButton;
    }
}

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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout trackerPanel;
    private ArrayList<Integer[]> iconIds = new ArrayList<>();
    private JSONObject iconDict = new JSONObject();
    private final int iconWidth = 160, iconHeight = 160;
    private final float MARKED_ALPHA = 1, UNMARKED_ALPHA = (float) 0.45;

    private static int idStart = 100;
    private static int idCounter = idStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iconIds.add(new Integer[]{R.drawable.deku_stick});
        iconIds.add(new Integer[]{R.drawable.deku_nut});
        iconIds.add(new Integer[]{R.drawable.bomb});
        iconIds.add(new Integer[]{R.drawable.bow});
        iconIds.add(new Integer[]{R.drawable.fire_arrow});
        iconIds.add(new Integer[]{R.drawable.ice_arrow});
        iconIds.add(new Integer[]{R.drawable.light_arrow});
        iconIds.add(new Integer[]{R.drawable.dins_fire});
        iconIds.add(new Integer[]{R.drawable.farores_wind});
        iconIds.add(new Integer[]{R.drawable.nayrus_love});
        iconIds.add(new Integer[]{R.drawable.kokiri_sword});
        iconIds.add(new Integer[]{R.drawable.master_sword});
        iconIds.add(new Integer[]{R.drawable.biggorons_sword});
        iconIds.add(new Integer[]{R.drawable.slingshot});
        iconIds.add(new Integer[]{R.drawable.fairy_ocarina, R.drawable.ocarina_of_time});
        iconIds.add(new Integer[]{R.drawable.bombchu});
        iconIds.add(new Integer[]{R.drawable.hookshot, R.drawable.longshot});
        iconIds.add(new Integer[]{R.drawable.deku_shield});
        iconIds.add(new Integer[]{R.drawable.hylian_shield});
        iconIds.add(new Integer[]{R.drawable.mirror_shield});
        iconIds.add(new Integer[]{R.drawable.boomerang});
        iconIds.add(new Integer[]{R.drawable.lens});
        iconIds.add(new Integer[]{R.drawable.magic_beans});
        iconIds.add(new Integer[]{R.drawable.hammer});
        iconIds.add(new Integer[]{R.drawable.goron_bracelet, R.drawable.silver_gauntlets, R.drawable.golden_gauntlets});
        iconIds.add(new Integer[]{R.drawable.goron_tunic});
        iconIds.add(new Integer[]{R.drawable.zora_tunic});
        iconIds.add(new Integer[]{R.drawable.empty_bottle});
        iconIds.add(new Integer[]{R.drawable.empty_bottle});
        iconIds.add(new Integer[]{R.drawable.empty_bottle});
        iconIds.add(new Integer[]{R.drawable.empty_bottle});
        iconIds.add(new Integer[]{R.drawable.rutos_letter});
        iconIds.add(new Integer[]{R.drawable.silver_scale, R.drawable.gold_scale});
        iconIds.add(new Integer[]{R.drawable.iron_boots});
        iconIds.add(new Integer[]{R.drawable.hover_boots});
        iconIds.add(new Integer[]{R.drawable.gray_note});
        iconIds.add(new Integer[]{R.drawable.gray_note});
        iconIds.add(new Integer[]{R.drawable.gray_note});
        iconIds.add(new Integer[]{R.drawable.gray_note});
        iconIds.add(new Integer[]{R.drawable.gray_note});
        iconIds.add(new Integer[]{R.drawable.gray_note});
        iconIds.add(new Integer[]{R.drawable.adults_wallet, R.drawable.giants_wallet});
        iconIds.add(new Integer[]{R.drawable.magic, R.drawable.more_magic});
        iconIds.add(new Integer[]{R.drawable.gold_skulltula});
        iconIds.add(new Integer[]{R.drawable.minuet_of_forest});
        iconIds.add(new Integer[]{R.drawable.bolero_of_fire});
        iconIds.add(new Integer[]{R.drawable.serenade_of_water});
        iconIds.add(new Integer[]{R.drawable.requiem_of_spirit});
        iconIds.add(new Integer[]{R.drawable.nocturne_of_shadow});
        iconIds.add(new Integer[]{R.drawable.prelude_of_light});
        iconIds.add(new Integer[]{R.drawable.stone_of_agony});
        iconIds.add(new Integer[]{R.drawable.forest_medallion});
        iconIds.add(new Integer[]{R.drawable.fire_medallion});
        iconIds.add(new Integer[]{R.drawable.water_medallion});
        iconIds.add(new Integer[]{R.drawable.spirit_medallion});
        iconIds.add(new Integer[]{R.drawable.shadow_medallion});
        iconIds.add(new Integer[]{R.drawable.light_medallion});
        iconIds.add(new Integer[]{R.drawable.kokiri_emerald});
        iconIds.add(new Integer[]{R.drawable.gorons_ruby});
        iconIds.add(new Integer[]{R.drawable.zoras_sapphire});

        for (int i = 0; i < iconIds.size(); i++) {
            JSONObject iconInfo = new JSONObject();
            try {
//                iconInfo.put("iconList", Arrays.asList(iconIds.get(i)));
                iconInfo.put("maxState", iconIds.get(i).length-1);
                iconInfo.put("state", -1);
                iconDict.put(Integer.toString(i), iconInfo);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

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
            b.setBackgroundResource(iconIds.get(i)[0]);
            b.setMinimumHeight(160);
            b.setMinimumWidth(160);
            b.setAlpha(UNMARKED_ALPHA);
            b.setOnClickListener(swapAlpha(b, i));

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

    View.OnClickListener swapAlpha(final ImageButton b, final int index) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (iconDict.getJSONObject(Integer.toString(index)).getInt("state") == -1) {
                        iconDict.getJSONObject(Integer.toString(index)).put("state", 0);
                        b.setAlpha(MARKED_ALPHA);
                    }
                    else if (iconDict.getJSONObject(Integer.toString(index)).getInt("state") ==
                            iconDict.getJSONObject(Integer.toString(index)).getInt("maxState")) {
                        iconDict.getJSONObject(Integer.toString(index)).put("state", -1);
                        b.setBackgroundResource(iconIds.get(index)[0]);
                        b.setAlpha(UNMARKED_ALPHA);
                    }
                    else {
                        int st = iconDict.getJSONObject(Integer.toString(index)).getInt("state");
                        iconDict.getJSONObject(Integer.toString(index)).put("state", st+1);
                        b.setBackgroundResource(iconIds.get(index)[st+1]);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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

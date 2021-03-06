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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout trackerPanel;
    private SharedPreferences sp;
    private ArrayList<Integer[]> iconIds = new ArrayList<>();
    private ArrayList<ImageButton> allButtons = new ArrayList<>();
    private JSONObject iconDict = new JSONObject();
    private final int iconWidth = 160, iconHeight = 160;
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

        iconIds.add(new Integer[]{R.drawable.bow0, R.drawable.bow1, R.drawable.bow2, R.drawable.bow3});
        iconIds.add(new Integer[]{R.drawable.fire_arrow, R.drawable.fire_arrow});
        iconIds.add(new Integer[]{R.drawable.ice_arrow, R.drawable.ice_arrow});
        iconIds.add(new Integer[]{R.drawable.light_arrow, R.drawable.light_arrow});
        iconIds.add(new Integer[]{R.drawable.dins_fire, R.drawable.dins_fire});
        iconIds.add(new Integer[]{R.drawable.farores_wind, R.drawable.farores_wind});
        iconIds.add(new Integer[]{R.drawable.nayrus_love, R.drawable.nayrus_love});
        iconIds.add(new Integer[]{R.drawable.bomb0, R.drawable.bomb1, R.drawable.bomb2, R.drawable.bomb3});
        iconIds.add(new Integer[]{R.drawable.deku_stick0, R.drawable.deku_stick1, R.drawable.deku_stick2, R.drawable.deku_stick3});
        iconIds.add(new Integer[]{R.drawable.deku_nut0, R.drawable.deku_nut1, R.drawable.deku_nut2, R.drawable.deku_nut3});
        iconIds.add(new Integer[]{R.drawable.kokiri_sword, R.drawable.kokiri_sword});
        iconIds.add(new Integer[]{R.drawable.master_sword, R.drawable.master_sword});
        iconIds.add(new Integer[]{R.drawable.biggorons_sword, R.drawable.biggorons_sword});
        iconIds.add(new Integer[]{R.drawable.slingshot0, R.drawable.slingshot1, R.drawable.slingshot2, R.drawable.slingshot3});
        iconIds.add(new Integer[]{R.drawable.fairy_ocarina, R.drawable.fairy_ocarina, R.drawable.ocarina_of_time});
        iconIds.add(new Integer[]{R.drawable.bombchu, R.drawable.bombchu});
        iconIds.add(new Integer[]{R.drawable.hookshot, R.drawable.hookshot, R.drawable.longshot});
        iconIds.add(new Integer[]{R.drawable.deku_shield, R.drawable.deku_shield});
        iconIds.add(new Integer[]{R.drawable.hylian_shield, R.drawable.hylian_shield});
        iconIds.add(new Integer[]{R.drawable.mirror_shield, R.drawable.mirror_shield});
        iconIds.add(new Integer[]{R.drawable.boomerang, R.drawable.boomerang});
        iconIds.add(new Integer[]{R.drawable.lens, R.drawable.lens});
        iconIds.add(new Integer[]{R.drawable.magic_beans, R.drawable.magic_beans});
        iconIds.add(new Integer[]{R.drawable.hammer, R.drawable.hammer});
        iconIds.add(new Integer[]{R.drawable.strength0, R.drawable.strength1, R.drawable.strength2, R.drawable.strength3});
        iconIds.add(new Integer[]{R.drawable.goron_tunic, R.drawable.goron_tunic});
        iconIds.add(new Integer[]{R.drawable.zora_tunic, R.drawable.zora_tunic});
        iconIds.add(new Integer[]{R.drawable.bottle0, R.drawable.bottle1, R.drawable.bottle2, R.drawable.bottle3, R.drawable.bottle4});
        iconIds.add(new Integer[]{R.drawable.rutos_letter, R.drawable.rutos_letter});
        iconIds.add(new Integer[]{R.drawable.silver_scale, R.drawable.silver_scale, R.drawable.gold_scale}); // 30
        iconIds.add(new Integer[]{R.drawable.iron_boots, R.drawable.iron_boots});
        iconIds.add(new Integer[]{R.drawable.hover_boots, R.drawable.hover_boots});
        iconIds.add(new Integer[]{R.drawable.zeldas_lullaby, R.drawable.zeldas_lullaby});
        iconIds.add(new Integer[]{R.drawable.eponas_song, R.drawable.eponas_song});
        iconIds.add(new Integer[]{R.drawable.sarias_song, R.drawable.sarias_song});
        iconIds.add(new Integer[]{R.drawable.suns_song, R.drawable.suns_song});
        iconIds.add(new Integer[]{R.drawable.song_of_time, R.drawable.song_of_time});
        iconIds.add(new Integer[]{R.drawable.song_of_storms, R.drawable.song_of_storms});
        iconIds.add(new Integer[]{R.drawable.wallet0, R.drawable.wallet1, R.drawable.wallet2});
        iconIds.add(new Integer[]{R.drawable.magic, R.drawable.magic, R.drawable.more_magic});
        iconIds.add(new Integer[]{R.drawable.skulltula0, R.drawable.skulltula1, R.drawable.skulltula2, R.drawable.skulltula3, R.drawable.skulltula4, R.drawable.skulltula5});
        iconIds.add(new Integer[]{R.drawable.stone_of_agony, R.drawable.stone_of_agony});
        iconIds.add(new Integer[]{R.drawable.minuet_of_forest, R.drawable.minuet_of_forest});
        iconIds.add(new Integer[]{R.drawable.bolero_of_fire, R.drawable.bolero_of_fire});
        iconIds.add(new Integer[]{R.drawable.serenade_of_water, R.drawable.serenade_of_water}); // 45
        iconIds.add(new Integer[]{R.drawable.requiem_of_spirit, R.drawable.requiem_of_spirit});
        iconIds.add(new Integer[]{R.drawable.nocturne_of_shadow, R.drawable.nocturne_of_shadow});
        iconIds.add(new Integer[]{R.drawable.prelude_of_light, R.drawable.prelude_of_light});
        iconIds.add(new Integer[]{R.drawable.forest_medallion, R.drawable.forest_medallion});
        iconIds.add(new Integer[]{R.drawable.fire_medallion, R.drawable.fire_medallion});
        iconIds.add(new Integer[]{R.drawable.water_medallion, R.drawable.water_medallion});
        iconIds.add(new Integer[]{R.drawable.spirit_medallion, R.drawable.spirit_medallion});
        iconIds.add(new Integer[]{R.drawable.shadow_medallion, R.drawable.shadow_medallion});
        iconIds.add(new Integer[]{R.drawable.light_medallion, R.drawable.light_medallion});
        iconIds.add(new Integer[]{R.drawable.kokiri_emerald, R.drawable.kokiri_emerald});
        iconIds.add(new Integer[]{R.drawable.gorons_ruby, R.drawable.gorons_ruby});
        iconIds.add(new Integer[]{R.drawable.zoras_sapphire, R.drawable.zoras_sapphire}); // 57
        Integer[] medalTrackers = new Integer[]{R.drawable.qmark, R.drawable.kokiri_emerald, R.drawable.gorons_ruby,
                R.drawable.zoras_sapphire, R.drawable.forest_medallion, R.drawable.fire_medallion,
                R.drawable.water_medallion, R.drawable.spirit_medallion, R.drawable.shadow_medallion,
                R.drawable.light_medallion};
        iconIds.add(medalTrackers);
        iconIds.add(medalTrackers);
        iconIds.add(medalTrackers);
        iconIds.add(medalTrackers);
        iconIds.add(medalTrackers);
        iconIds.add(medalTrackers);
        iconIds.add(medalTrackers);
        iconIds.add(medalTrackers);
        iconIds.add(medalTrackers);

        for (int i = 0; i < iconIds.size(); i++) {
            JSONObject iconInfo = new JSONObject();
            try {
                iconInfo.put("maxState", iconIds.get(i).length - 1);
                iconInfo.put("state", sp.getInt(Integer.toString(i), 0));
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

        trackerPanel = findViewById(R.id.trackerLayout);
        findViewById(R.id.mainLayout).setBackgroundColor(Color.parseColor("#646464"));
//        trackerPanel.setBackground(getResources().getDrawable(R.mipmap.ic_launcher));
        ConstraintSet cset = new ConstraintSet();
        ImageButton prevButton = null;
        int newRowCounter = 1;
        for (int i = 0; i < iconIds.size(); i++) {
            ImageButton b = makeImgButton(this);
            try {
                int state = iconDict.getJSONObject(Integer.toString(i)).getInt("state");
                b.setBackgroundResource(iconIds.get(i)[state]);
                if (state > 0) { b.setAlpha(MARKED_ALPHA); }
                else { b.setAlpha(UNMARKED_ALPHA); }
            } catch (JSONException e) {
                e.printStackTrace();
            }
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

            if (iconIds.size()-i < 10) {
                ImageButton bOver = makeImgButton(this);
                bOver.setMinimumWidth(iconWidth);
                int bheight = 20;
                bOver.setMinimumHeight(bheight);
                bOver.setMaxHeight(bheight);
                bOver.setOnClickListener(cycleIcons(b, i));
                bOver.setOnLongClickListener(resetIcon(b, i));
                switch (iconIds.size()-i) {
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
            b.setBackgroundResource(iconIds.get(i)[0]);
            try {
                iconDict.getJSONObject(Integer.toString(i)).put("state", 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            sp.edit().putInt(Integer.toString(i), 0).apply();
        }
    }

    View.OnClickListener cycleIcons(final ImageButton b, final int index) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int state = iconDict.getJSONObject(Integer.toString(index)).getInt("state");
                    int maxState = iconDict.getJSONObject(Integer.toString(index)).getInt("maxState");
                    if (state == maxState) {
                        b.setAlpha(UNMARKED_ALPHA);
                        b.setBackgroundResource(iconIds.get(index)[0]);
                        iconDict.getJSONObject(Integer.toString(index)).put("state", 0);
                        sp.edit().putInt(Integer.toString(index), 0).apply();
                    }
                    else {
                        b.setAlpha(MARKED_ALPHA);
                        state++;
                        b.setBackgroundResource(iconIds.get(index)[state]);
                        iconDict.getJSONObject(Integer.toString(index)).put("state", state);
                        sp.edit().putInt(Integer.toString(index), state).apply();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    View.OnLongClickListener resetIcon(final ImageButton b, final int index) {
        return new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                try {
                    b.setAlpha(UNMARKED_ALPHA);
                    b.setBackgroundResource(iconIds.get(index)[0]);
                    iconDict.getJSONObject(Integer.toString(index)).put("state", 0);
                    sp.edit().putInt(Integer.toString(index), 0).apply();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return true;
            }
        };
    }

    private static int getNextID() { return idCounter++; }
    private static int getCurID() { return idCounter; }

    private static ImageButton makeImgButton(Context c) {
        ImageButton retButton = new ImageButton(c);
        retButton.setId(getNextID());
        return retButton;
    }
}

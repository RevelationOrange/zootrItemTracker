package com.example.revelationorange.zootritemtracker;

import android.content.SharedPreferences;


import java.util.ArrayList;

class IconStateManager {
    private ArrayList<Integer[]> iconBGs = new ArrayList<>();
    private ArrayList<Integer> iconStates = new ArrayList<>();

    IconStateManager(SharedPreferences sp) {
        this.iconBGs.add(new Integer[]{R.drawable.bow0, R.drawable.bow1, R.drawable.bow2, R.drawable.bow3});
        this.iconBGs.add(new Integer[]{R.drawable.fire_arrow, R.drawable.fire_arrow});
        this.iconBGs.add(new Integer[]{R.drawable.ice_arrow, R.drawable.ice_arrow});
        this.iconBGs.add(new Integer[]{R.drawable.light_arrow, R.drawable.light_arrow});
        this.iconBGs.add(new Integer[]{R.drawable.dins_fire, R.drawable.dins_fire});
        this.iconBGs.add(new Integer[]{R.drawable.farores_wind, R.drawable.farores_wind});
        this.iconBGs.add(new Integer[]{R.drawable.nayrus_love, R.drawable.nayrus_love});
        this.iconBGs.add(new Integer[]{R.drawable.bomb0, R.drawable.bomb1, R.drawable.bomb2, R.drawable.bomb3});
        this.iconBGs.add(new Integer[]{R.drawable.deku_stick0, R.drawable.deku_stick1, R.drawable.deku_stick2, R.drawable.deku_stick3});
        this.iconBGs.add(new Integer[]{R.drawable.deku_nut0, R.drawable.deku_nut1, R.drawable.deku_nut2, R.drawable.deku_nut3});
        this.iconBGs.add(new Integer[]{R.drawable.kokiri_sword, R.drawable.kokiri_sword});
        this.iconBGs.add(new Integer[]{R.drawable.master_sword, R.drawable.master_sword});
        this.iconBGs.add(new Integer[]{R.drawable.biggorons_sword, R.drawable.biggorons_sword});
        this.iconBGs.add(new Integer[]{R.drawable.slingshot0, R.drawable.slingshot1, R.drawable.slingshot2, R.drawable.slingshot3});
        this.iconBGs.add(new Integer[]{R.drawable.fairy_ocarina, R.drawable.fairy_ocarina, R.drawable.ocarina_of_time});
        this.iconBGs.add(new Integer[]{R.drawable.bombchu, R.drawable.bombchu});
        this.iconBGs.add(new Integer[]{R.drawable.hookshot, R.drawable.hookshot, R.drawable.longshot});
        this.iconBGs.add(new Integer[]{R.drawable.deku_shield, R.drawable.deku_shield});
        this.iconBGs.add(new Integer[]{R.drawable.hylian_shield, R.drawable.hylian_shield});
        this.iconBGs.add(new Integer[]{R.drawable.mirror_shield, R.drawable.mirror_shield});
        this.iconBGs.add(new Integer[]{R.drawable.boomerang, R.drawable.boomerang});
        this.iconBGs.add(new Integer[]{R.drawable.lens, R.drawable.lens});
        this.iconBGs.add(new Integer[]{R.drawable.magic_beans, R.drawable.magic_beans});
        this.iconBGs.add(new Integer[]{R.drawable.hammer, R.drawable.hammer});
        this.iconBGs.add(new Integer[]{R.drawable.strength0, R.drawable.strength1, R.drawable.strength2, R.drawable.strength3});
        this.iconBGs.add(new Integer[]{R.drawable.goron_tunic, R.drawable.goron_tunic});
        this.iconBGs.add(new Integer[]{R.drawable.zora_tunic, R.drawable.zora_tunic});
        this.iconBGs.add(new Integer[]{R.drawable.bottle0, R.drawable.bottle1, R.drawable.bottle2, R.drawable.bottle3, R.drawable.bottle4});
        this.iconBGs.add(new Integer[]{R.drawable.rutos_letter, R.drawable.rutos_letter});
        this.iconBGs.add(new Integer[]{R.drawable.silver_scale, R.drawable.silver_scale, R.drawable.gold_scale}); // 30
        this.iconBGs.add(new Integer[]{R.drawable.iron_boots, R.drawable.iron_boots});
        this.iconBGs.add(new Integer[]{R.drawable.hover_boots, R.drawable.hover_boots});
        this.iconBGs.add(new Integer[]{R.drawable.zeldas_lullaby, R.drawable.zeldas_lullaby});
        this.iconBGs.add(new Integer[]{R.drawable.eponas_song, R.drawable.eponas_song});
        this.iconBGs.add(new Integer[]{R.drawable.sarias_song, R.drawable.sarias_song});
        this.iconBGs.add(new Integer[]{R.drawable.suns_song, R.drawable.suns_song});
        this.iconBGs.add(new Integer[]{R.drawable.song_of_time, R.drawable.song_of_time});
        this.iconBGs.add(new Integer[]{R.drawable.song_of_storms, R.drawable.song_of_storms});
        this.iconBGs.add(new Integer[]{R.drawable.wallet0, R.drawable.wallet1, R.drawable.wallet2});
        this.iconBGs.add(new Integer[]{R.drawable.magic, R.drawable.magic, R.drawable.more_magic});
        this.iconBGs.add(new Integer[]{R.drawable.skulltula0, R.drawable.skulltula1, R.drawable.skulltula2, R.drawable.skulltula3, R.drawable.skulltula4, R.drawable.skulltula5});
        this.iconBGs.add(new Integer[]{R.drawable.stone_of_agony, R.drawable.stone_of_agony});
        this.iconBGs.add(new Integer[]{R.drawable.minuet_of_forest, R.drawable.minuet_of_forest});
        this.iconBGs.add(new Integer[]{R.drawable.bolero_of_fire, R.drawable.bolero_of_fire});
        this.iconBGs.add(new Integer[]{R.drawable.serenade_of_water, R.drawable.serenade_of_water}); // 45
        this.iconBGs.add(new Integer[]{R.drawable.requiem_of_spirit, R.drawable.requiem_of_spirit});
        this.iconBGs.add(new Integer[]{R.drawable.nocturne_of_shadow, R.drawable.nocturne_of_shadow});
        this.iconBGs.add(new Integer[]{R.drawable.prelude_of_light, R.drawable.prelude_of_light});
        this.iconBGs.add(new Integer[]{R.drawable.forest_medallion, R.drawable.forest_medallion});
        this.iconBGs.add(new Integer[]{R.drawable.fire_medallion, R.drawable.fire_medallion});
        this.iconBGs.add(new Integer[]{R.drawable.water_medallion, R.drawable.water_medallion});
        this.iconBGs.add(new Integer[]{R.drawable.spirit_medallion, R.drawable.spirit_medallion});
        this.iconBGs.add(new Integer[]{R.drawable.shadow_medallion, R.drawable.shadow_medallion});
        this.iconBGs.add(new Integer[]{R.drawable.light_medallion, R.drawable.light_medallion});
        this.iconBGs.add(new Integer[]{R.drawable.kokiri_emerald, R.drawable.kokiri_emerald});
        this.iconBGs.add(new Integer[]{R.drawable.gorons_ruby, R.drawable.gorons_ruby});
        this.iconBGs.add(new Integer[]{R.drawable.zoras_sapphire, R.drawable.zoras_sapphire}); // 57
        Integer[] medalTrackers = new Integer[]{R.drawable.qmark, R.drawable.kokiri_emerald, R.drawable.gorons_ruby,
                R.drawable.zoras_sapphire, R.drawable.forest_medallion, R.drawable.fire_medallion,
                R.drawable.water_medallion, R.drawable.spirit_medallion, R.drawable.shadow_medallion,
                R.drawable.light_medallion};
        this.iconBGs.add(medalTrackers);
        this.iconBGs.add(medalTrackers);
        this.iconBGs.add(medalTrackers);
        this.iconBGs.add(medalTrackers);
        this.iconBGs.add(medalTrackers);
        this.iconBGs.add(medalTrackers);
        this.iconBGs.add(medalTrackers);
        this.iconBGs.add(medalTrackers);
        this.iconBGs.add(medalTrackers);

        for (int i = 0; i < iconBGs.size(); i++) {
            iconStates.add(sp.getInt(Integer.toString(i), 0));
        }
    }

    public int getNIcons() { return this.iconBGs.size(); }

    public int getState(int index) { return this.iconStates.get(index); }

    public int getBackground(int index) { return this.iconBGs.get(index)[this.iconStates.get(index)]; }

    public int advState(int index) {
        int nextState = this.iconStates.get(index)+1;
        if (nextState == this.iconBGs.get(index).length) { nextState = 0; }
        this.iconStates.set(index, nextState);
        return nextState;
    }

    public int resetState(int index) {
        this.iconStates.set(index, 0);
        return this.iconBGs.get(index)[0];
    }
}

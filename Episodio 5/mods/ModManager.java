package me.danipro.tutorialclient.client.mods;

import java.util.ArrayList;

public class ModManager {

    private final ArrayList<Mod> mods = new ArrayList<>();

    public ModManager() {

    }

    public ArrayList<Mod> getMods() {
        return mods;
    }

    public Mod getModByName(String name) {
        return mods.stream().filter(mod -> mod.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public Mod getModByClass(Class<?> modClass) {
        return mods.stream().filter(mod -> mod.getClass().equals(modClass)).findFirst().orElse(null);
    }

    public ArrayList<Mod> getModByCategory(ModCategory c) {
        ArrayList<Mod> mods = new ArrayList<Mod>();
        for (Mod m : this.mods) {
            if (m.getCategory() == c) {
                mods.add(m);
            }
        }
        return mods;
    }
}

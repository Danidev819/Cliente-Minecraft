package me.danipro.tutorialclient.client.settings;

import me.danipro.tutorialclient.client.Client;
import me.danipro.tutorialclient.client.mods.Mod;

import java.util.*;

public class SettingsManager {

    private ArrayList<Setting> settings;

    public SettingsManager(){
        this.settings = new ArrayList<>();
    }

    public void addSetting(Setting in){
        this.settings.add(in);
    }

    public ArrayList<Setting> getSettingByMod(Mod mod){
        ArrayList<Setting> out = new ArrayList<>();
        for(Setting s : getSettings()){
            if(s.getParentMod().equals(mod)){
                out.add(s);
            }
        }
        Collections.sort(out);
        return out;
    }

    public Setting getSettingByNameForClickGUI(String name){
        for(Setting set : getSettings()){
            if(set.getName().equalsIgnoreCase(name)){
                return set;
            }
        }
        return null;
    }

    public Setting getSettingByName(Mod mod, String name){
        for(Setting set : getSettings()){
            if(set.getName().equalsIgnoreCase(name) && set.getParentMod() == mod){
                return set;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public Setting getSettingByClass(Class<?> modClass, String name){
        for(Setting set : getSettings()){
            if(set.getName().equalsIgnoreCase(name) && set.getParentMod().equals(Client.getInstance().modManager.getModByClass(modClass))){
                return set;
            }
        }
        return null;
    }

    public ArrayList<Setting> getSettings() {
        return settings;
    }

}

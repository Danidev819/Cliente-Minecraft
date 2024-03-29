package me.danipro.tutorialclient.client.mods;

import me.danipro.tutorialclient.client.Client;
import me.danipro.tutorialclient.client.settings.Setting;
import me.danipro.tutorialclient.client.utils.animation.Animation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

import java.util.ArrayList;

public class Mod {

    public Minecraft mc = Minecraft.getMinecraft();
    public FontRenderer fr = mc.fontRendererObj;

    private String name;

    private int x, y, width, height, draggingX, draggingY;

    private boolean toggled, dragging, hide;

    private ModCategory category;

    public Animation buttonAnimation = new Animation(62.0F);

    public Mod(String name, ModCategory category) {
        this.name = name;
        this.category = category;

        this.x = 100;
        this.y = 100;
        this.width = 100;
        this.height = 100;

        this.setup();
    }

    public void setup() {}

    public void onEnable() {
        Client.getInstance().eventManager.register(this);
    }

    public void onDisable() {
        Client.getInstance().eventManager.unregister(this);
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;

        if(toggled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void toggle() {
        toggled = !toggled;

        if(toggled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDraggingX() {
        return draggingX;
    }

    public void setDraggingX(int draggingX) {
        this.draggingX = draggingX;
    }

    public int getDraggingY() {
        return draggingY;
    }

    public void setDraggingY(int draggingY) {
        this.draggingY = draggingY;
    }

    public boolean isDragging() {
        return dragging;
    }

    public void setDragging(boolean dragging) {
        this.dragging = dragging;
    }

    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public ModCategory getCategory() {
        return category;
    }

    public void setCategory(ModCategory category) {
        this.category = category;
    }

    public boolean isToggled() {
        return toggled;
    }

    public Setting addBooleanSetting(String name, Mod mod, boolean toggle) {
        Setting setting;
        Client.getInstance().settingsManager.addSetting(setting = new Setting(name, mod, toggle));
        return setting;
    }

    public Setting addModeSetting(String name, Mod mod, String defaultMode, ArrayList<String> options) {
        Setting setting;
        Client.getInstance().settingsManager.addSetting(setting =new Setting(name, mod, defaultMode, options));
        return setting;
    }

    public Setting addSliderSetting(String name, Mod mod, double defaultValue, double minValue, double maxValue, boolean intValue) {
        Setting setting;
        Client.getInstance().settingsManager.addSetting(setting =new Setting(name, mod, defaultValue, minValue, maxValue, intValue));
        return setting;
    }

    public int getFontColor() {
        return -1;
    }

    public int getBackgroundColor() {
        return Integer.MIN_VALUE;
    }

}

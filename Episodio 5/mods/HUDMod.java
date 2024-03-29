package me.danipro.tutorialclient.client.mods;

import me.danipro.tutorialclient.client.Client;
import me.danipro.tutorialclient.client.settings.Setting;
import me.danipro.tutorialclient.client.utils.render.RenderUtils;

public class HUDMod extends Mod {

    public HUDMod(String name) {
        super(name, ModCategory.HUD);
    }

    public void setupHUD() {

        Setting background = this.addBooleanSetting("Background", this, true);
        Setting bracketsSettings = this.addBooleanSetting("Brackets", this, true);
        Setting font_shadow = this.addBooleanSetting("Font Shadow", this, true);

        font_shadow.setCategory("Render");
        background.setCategory("Render");
        bracketsSettings.setCategory("Render");

        Setting test = this.addSliderSetting("Test", this, 0, 0, 15, false);
        test.setCategory("Test");
    }

    public void onRender2D() {

        boolean background = Client.getInstance().settingsManager.getSettingByName(this, "Background").getValBoolean();
        boolean brackets = Client.getInstance().settingsManager.getSettingByName(this, "Brackets").getValBoolean();
        boolean fontShadow = Client.getInstance().settingsManager.getSettingByName(this, "Font Shadow").getValBoolean();

        String text = "";

        if(brackets) {
            text = "[" + this.getText() + "]";
        }else {
            text = this.getText();
        }

        if(background) {
            RenderUtils.drawRect(this.getX(), this.getY(), fr.getStringWidth(text) + 8, fr.FONT_HEIGHT + 8, this.getBackgroundColor());
        }

        fr.drawString(text, this.getX() + 4, this.getY() + 5, this.getFontColor(), fontShadow);

        this.setWidth(fr.getStringWidth(text) + 8);
        this.setHeight(fr.FONT_HEIGHT + 8);
    }

    public String getText() {
        return null;
    }
}

package me.danipro.tutorialclient.client.mods;

import me.danipro.tutorialclient.client.utils.animation.Animation;

public enum ModCategory {
    HUD("Hud"), PERFORMANCE("Rendimiento"), PLAYER("Jugador"), RENDER("Render"), OTHER("Otros");

    private final String name;
    Animation scrollAnimation = new Animation(0.0F);
    float scrollY = 0;

    ModCategory(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

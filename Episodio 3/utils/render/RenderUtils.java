package me.danipro.tutorialclient.client.utils.render;

/* Created by Danipro_2007 on 31/12/2022 inside the package - me.danipro.tutorialclient.client.utils */

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class RenderUtils {

    private static float zLevelFloat;
    private static Minecraft mc = Minecraft.getMinecraft();

    public static void drawScaledCustomSizeModalRect(double x, double y, float u, float v, int uWidth, int vHeight, double width, double height, float tileWidth, float tileHeight) {
        float f = 1.0F / tileWidth;
        float f1 = 1.0F / tileHeight;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos(x, (y + height), 0.0D).tex((u * f), ((v + (float)vHeight) * f1)).endVertex();
        worldrenderer.pos((x + width), (y + height), 0.0D).tex(((u + (float)uWidth) * f), ((v + (float)vHeight) * f1)).endVertex();
        worldrenderer.pos((x + width), y, 0.0D).tex(((u + (float)uWidth) * f), (v * f1)).endVertex();
        worldrenderer.pos(x, y, 0.0D).tex((u * f), (v * f1)).endVertex();
        tessellator.draw();
    }

}

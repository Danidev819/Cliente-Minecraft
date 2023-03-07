//Esto dentro del método addSingleplayerMultiplayerButtons
this.buttonList.add(new GuiButton(1, this.width / 2 - 100, p_73969_1_ + (int)(p_73969_2_ * 0.8), I18n.format("menu.singleplayer")));
this.buttonList.add(new GuiButton(2, this.width / 2 - 100, p_73969_1_ + p_73969_2_ * 2, I18n.format("menu.multiplayer")));

//Esto en el método drawScreen en la misma posción y orden que se muestra en el video
Gui.drawScaledCustomSizeModalRect(0, 0, 0.0f, 0.0f, scaledRes.getScaledWidth(), scaledRes.getScaledHeight(), scaledRes.getScaledWidth(), scaledRes.getScaledHeight(), scaledRes.getScaledWidth(), scaledRes.getScaledHeight());


this.fontRendererObj.drawString("TutorialClient", (int)(((0.5 * scaledRes.getScaledWidth())/scaleFactor) - tcStringWidth/2), (int)((0.2 * scaledRes.getScaledHeight())/scaleFactor), -1);
    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/SkinManager;<init>(Lnet/minecraft/client/renderer/texture/TextureManager;Ljava/io/File;Lcom/mojang/authlib/minecraft/MinecraftSessionService;)V"))
    public void progress1(CallbackInfo ci) {
        GuiSplashScreen.setProgress(1);
    }

    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/chunk/storage/AnvilSaveConverter;<init>(Ljava/io/File;)V"))
    public void progress2(CallbackInfo ci) {
        GuiSplashScreen.setProgress(2);
    }

    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/audio/SoundHandler;<init>(Lnet/minecraft/client/resources/IResourceManager;Lnet/minecraft/client/settings/GameSettings;)V"))
    public void progress3(CallbackInfo ci) {
        GuiSplashScreen.setProgress(3);
    }

    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/audio/MusicTicker;<init>(Lnet/minecraft/client/Minecraft;)V"))
    public void progress4(CallbackInfo ci) {
        GuiSplashScreen.setProgress(4);
    }

    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/FontRenderer;<init>(Lnet/minecraft/client/settings/GameSettings;Lnet/minecraft/util/ResourceLocation;Lnet/minecraft/client/renderer/texture/TextureManager;Z)V"))
    public void progress5(CallbackInfo ci) {
        GuiSplashScreen.setProgress(5);
    }

    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/MouseHelper;<init>()V"))
    public void progress6(CallbackInfo ci) {
        GuiSplashScreen.setProgress(6);
    }

    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/texture/TextureMap;<init>(Ljava/lang/String;)V"))
    public void progress7(CallbackInfo ci) {
        GuiSplashScreen.setProgress(7);
    }

    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model/ModelManager;<init>(Lnet/minecraft/client/renderer/texture/TextureMap;)V"))
    public void progress8(CallbackInfo ci) {
        GuiSplashScreen.setProgress(8);
    }

    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/RenderItem;<init>(Lnet/minecraft/client/renderer/texture/TextureManager;Lnet/minecraft/client/resources/model/ModelManager;)V"))
    public void progress9(CallbackInfo ci) {
        GuiSplashScreen.setProgress(9);
    }

    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/RenderManager;<init>(Lnet/minecraft/client/renderer/texture/TextureManager;Lnet/minecraft/client/renderer/entity/RenderItem;)V"))
    public void progress10(CallbackInfo ci) {
        GuiSplashScreen.setProgress(10);
    }

    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/ItemRenderer;<init>(Lnet/minecraft/client/Minecraft;)V"))
    public void progress11(CallbackInfo ci) {
        GuiSplashScreen.setProgress(11);
    }

    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/EntityRenderer;<init>(Lnet/minecraft/client/Minecraft;Lnet/minecraft/client/resources/IResourceManager;)V"))
    public void progress12(CallbackInfo ci) {
        GuiSplashScreen.setProgress(12);
    }

    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/BlockRendererDispatcher;<init>(Lnet/minecraft/client/renderer/BlockModelShapes;Lnet/minecraft/client/settings/GameSettings;)V"))
    public void progress13(CallbackInfo ci) {
        GuiSplashScreen.setProgress(13);
    }

    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/RenderGlobal;<init>(Lnet/minecraft/client/Minecraft;)V"))
    public void progress14(CallbackInfo ci) {
        GuiSplashScreen.setProgress(14);
    }

    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/achievement/GuiAchievement;<init>(Lnet/minecraft/client/Minecraft;)V"))
    public void progress15(CallbackInfo ci) {
        GuiSplashScreen.setProgress(15);
    }

    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/particle/EffectRenderer;<init>(Lnet/minecraft/world/World;Lnet/minecraft/client/renderer/texture/TextureManager;)V"))
    public void progress16(CallbackInfo ci) {
        GuiSplashScreen.setProgress(16);
    }

    @Inject(method = "startGame", at = @At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;ingameGUI:Lnet/minecraft/client/gui/GuiIngame;", shift = At.Shift.AFTER))
    public void progress17(CallbackInfo ci) {
        GuiSplashScreen.setProgress(17);
    }

package net.mat0u5.teamhearts.mixin.client;

import dev.kikugie.fletching_table.annotation.MixinEnvironment;
import net.mat0u5.teamhearts.ClientUtils;
import net.mat0u5.teamhearts.IdentifierHelper;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
//? if forge && <= 1.16 {
/*import net.minecraft.util.Identifier;
*///?} else {
import net.minecraft.resources.Identifier;
//?}
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Locale;

//? if forge && <= 1.16 {
/*import com.mojang.blaze3d.matrix.MatrixStack;
*///?} else if < 1.16 {
//?} else if <= 1.19.4 {
/*import com.mojang.blaze3d.vertex.PoseStack;
*///?} else if <= 1.21.11 {
/*import net.minecraft.client.gui.GuiGraphics;
*///?} else {
import net.minecraft.client.gui.GuiGraphicsExtractor;
//?}

//? if > 1.16 <= 1.19.4
//import com.mojang.blaze3d.systems.RenderSystem;

//? if >= 1.21.2 && <= 1.21.5 {
/*import net.minecraft.client.renderer.RenderType;
import java.util.function.Function;
*///?}
//? if >= 1.21.6
import com.mojang.blaze3d.pipeline.RenderPipeline;

//? if forge && <= 1.16 {
/*import net.minecraftforge.client.gui.ForgeIngameGui;
@Mixin(value = ForgeIngameGui.class)
*///?} else if <= 26.1 {
/*import net.minecraft.client.gui.Gui;
@Mixin(value = Gui.class)
*///?} else {
import net.minecraft.client.gui.Hud;
@Mixin(value = Hud.class, priority = 1)
//?}
@MixinEnvironment(type = MixinEnvironment.Env.CLIENT)
public class GuiMixin {

    //? if forge && <= 1.15 {
    /*@Redirect(method = "renderHealth", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/client/gui/ForgeIngameGui;blit(IIIIII)V"))
    private void customHearts(ForgeIngameGui instance, int x, int y, int u, int v, int i, int j) {
    *///?} else if forge && <= 1.16 {
    /*@Redirect(method = "renderHealth", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/client/gui/ForgeIngameGui;blit(Lcom/mojang/blaze3d/matrix/MatrixStack;IIIIII)V"))
    private void customHearts(ForgeIngameGui instance, MatrixStack poseStack, int x, int y, int u, int v, int i, int j) {
    *///?} else if <= 1.15 {
    /*@Redirect(method = "renderPlayerHealth", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Gui;blit(IIIIII)V"))
    private void customHearts(Gui instance, int x, int y, int u, int v, int i, int j) {
    *///?} else if <= 1.16 {
    /*@Redirect(method = "renderPlayerHealth", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Gui;blit(Lcom/mojang/blaze3d/vertex/PoseStack;IIIIII)V"))
    private void customHearts(Gui instance, PoseStack poseStack, int x, int y, int u, int v, int i, int j) {
    *///?} else if <= 1.19.4 {
    /*@Inject(method = "renderHeart", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/Gui;blit(Lcom/mojang/blaze3d/vertex/PoseStack;IIIIII)V"), cancellable = true)
    private void customHearts(PoseStack poseStack, Gui.HeartType heartType, int i, int j, int k, boolean isBlinking, boolean isHalf, CallbackInfo ci) {
    *///?} else if <= 1.20 {
    /*@Inject(method = "renderHeart", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;blit(Lnet/minecraft/resources/Identifier;IIIIII)V"), cancellable = true)
    private void customHearts(GuiGraphics guiGraphics, Gui.HeartType heartType, int i, int j, int k, boolean isBlinking, boolean isHalf, CallbackInfo ci) {
    *///?} else if <= 1.21 {
    /*@Redirect(method = "renderHeart", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/Identifier;IIII)V"))
    private void customHearts(GuiGraphics instance, Identifier identifier, int x, int y, int u, int v) {
    *///?} else if <= 1.21.5 {
    /*@Redirect(method = "renderHeart", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Ljava/util/function/Function;Lnet/minecraft/resources/Identifier;IIII)V"))
    private void customHearts(GuiGraphics instance, Function<Identifier, RenderType> renderLayers, Identifier identifier, int x, int y, int u, int v) {
    *///?} else if <= 1.21.9 {
    /*@Redirect(method = "renderHeart", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lcom/mojang/blaze3d/pipeline/RenderPipeline;Lnet/minecraft/resources/Identifier;IIII)V"))
    private void customHearts(GuiGraphics instance, RenderPipeline renderPipeline, Identifier identifier, int x, int y, int u, int v) {
    *///?} else if <= 1.21.11 {
    /*@Redirect(method = "renderHeart", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lcom/mojang/blaze3d/pipeline/RenderPipeline;Lnet/minecraft/resources/Identifier;IIII)V"))
    private void customHearts(GuiGraphics instance, RenderPipeline renderPipeline, Identifier identifier, int x, int y, int u, int v) {
    *///?} else {
    @Redirect(method = "extractHeart", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;blitSprite(Lcom/mojang/blaze3d/pipeline/RenderPipeline;Lnet/minecraft/resources/Identifier;IIII)V"))
    private void customHearts(GuiGraphicsExtractor instance, RenderPipeline renderPipeline, Identifier identifier, int x, int y, int u, int v) {
    //?}

        //? if <= 1.16 {
        /*String texturePath = "hud/heart/";
        boolean isNormal = (u >= 52 && u <= 79) && (v == 0 || v == 45);
        if (isNormal) {
            boolean isHardcore = v == 45;
            boolean isHalf = u == 61 || u == 79;
            boolean isBlinking = u == 70 || u == 79;
            if (isHardcore) texturePath += "hardcore_";
            if (isHalf) texturePath += "half";
            else texturePath += "full";
            if (isBlinking) texturePath += "_blinking";
        }
        System.out.println("TEST_"+texturePath);
        *///?} else if <= 1.20 {
        /*String texturePath = "hud/heart/";
        boolean isHardcore = k > 0;
        if (isHardcore) texturePath += "hardcore_";
        if (isHalf) texturePath += "half";
        else texturePath += "full";
        if (isBlinking) texturePath += "_blinking";
        if (heartType != Gui.HeartType.NORMAL) {
            return;
        }
        *///?} else {
        String texturePath = identifier.getPath();
        //?}

        String playerTeamColor = ClientUtils.getPlayerTeamColor();
        String playerTeamName = ClientUtils.getPlayerTeamName();
        if (playerTeamColor == null || playerTeamName == null ||
                !ClientUtils.heartAllowedColors.contains(playerTeamColor.toLowerCase(Locale.ROOT)) ||
                !ClientUtils.heartAllowedHearts.contains(texturePath)) {
            //? if <= 1.15 {
            /*instance.blit(x, y, u, v, i, j);
            *///?} else if <= 1.16 {
            /*instance.blit(poseStack, x, y, u, v, i, j);
            *///?} else if <= 1.20 {
            //?} else if <= 1.21 {
            /*instance.blitSprite(identifier, x, y, u, v);
            *///?} else if <= 1.21.5 {
            /*instance.blitSprite(renderLayers, identifier, x, y, u, v);
            *///?} else {
            instance.blitSprite(renderPipeline, identifier, x, y, u, v);
            //?}
            return;
        }

        String color = playerTeamColor.toLowerCase(Locale.ROOT);

        String heartTypeStr = texturePath.replaceFirst("hud/heart/", "");
        //? if <= 1.20 {
        /*var customHeart = IdentifierHelper.mod("textures/gui/sprites/"+color+"_"+heartTypeStr+".png");
        *///?} else {
        var customHeart = IdentifierHelper.mod(color+"_"+heartTypeStr);
        //?}

        //? if forge && <= 1.15 {
        /*Minecraft.getInstance().getTextureManager().bindTexture(customHeart);
        ForgeIngameGui.blit(x, y, 0, 0, 9, 9, 9, 9);
        Minecraft.getInstance().getTextureManager().bindTexture(ForgeIngameGui.GUI_ICONS_LOCATION);
        *///?} else if forge && <= 1.16 {
        /*System.out.println("blit.");
        Minecraft.getInstance().getTextureManager().bind(customHeart);
        ForgeIngameGui.blit(poseStack, x, y, 0, 0, 9, 9, 9, 9);
        Minecraft.getInstance().getTextureManager().bind(ForgeIngameGui.GUI_ICONS_LOCATION);
        System.out.println("blit-after.");
        *///?} else if <= 1.15 {
        /*Minecraft.getInstance().getTextureManager().bind(customHeart);
        Gui.blit(x, y, 0, 0, 9, 9, 9, 9);
        Minecraft.getInstance().getTextureManager().bind(Gui.GUI_ICONS_LOCATION);
        *///?} else if <= 1.16 {
        /*Minecraft.getInstance().getTextureManager().bind(customHeart);
        Gui.blit(poseStack, x, y, 0, 0, 9, 9, 9, 9);
        Minecraft.getInstance().getTextureManager().bind(Gui.GUI_ICONS_LOCATION);
        *///?} else if <= 1.19.4 {
        /*RenderSystem.setShaderTexture(0, customHeart);
        Gui.blit(poseStack, i, j, 0, 0, 9, 9, 9, 9);
        RenderSystem.setShaderTexture(0, Gui.GUI_ICONS_LOCATION);
        ci.cancel();
        *///?} else if <= 1.20 {
        /*guiGraphics.blit(customHeart, i, j, 0, 0, 9, 9, 9, 9);
        ci.cancel();
        *///?} else if <= 1.21 {
        /*instance.blitSprite(customHeart, x, y, u, v);
        *///?} else if <= 1.21.5 {
        /*instance.blitSprite(renderLayers, customHeart, x, y, u, v);
        *///?} else {
        instance.blitSprite(renderPipeline, customHeart, x, y, u, v);
        //?}
    }
}

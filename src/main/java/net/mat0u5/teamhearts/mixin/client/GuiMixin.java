package net.mat0u5.teamhearts.mixin.client;

import net.mat0u5.teamhearts.ClientUtils;
import net.mat0u5.teamhearts.IdentifierHelper;
import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import net.minecraft.resources.Identifier;

import java.util.List;
import java.util.Locale;

//? if <= 1.21.11 {
/*import net.minecraft.client.gui.GuiGraphics;
*///?} else {
import net.minecraft.client.gui.GuiGraphicsExtractor;
//?}

//? if >= 1.21.2 && <= 1.21.5 {
/*import net.minecraft.client.renderer.RenderType;
import java.util.function.Function;
*///?}
//? if >= 1.21.6
import com.mojang.blaze3d.pipeline.RenderPipeline;

//? if <= 26.1 {
/*import net.minecraft.client.gui.Gui;
@Mixin(value = Gui.class)
*///?} else {
import net.minecraft.client.gui.Hud;
@Mixin(value = Hud.class, priority = 1)
//?}
public class GuiMixin {

    //? if <= 1.20 {
    /*@Redirect(method = "renderHeart", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;blit(Lnet/minecraft/resources/Identifier;IIIIII)V"))
    private void customHearts(GuiGraphics instance, Identifier identifier, int x, int y, int u, int v, int m, int n) {
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

        String texturePath = identifier.getPath();
        String playerTeamColor = ClientUtils.getPlayerTeamColor();
        String playerTeamName = ClientUtils.getPlayerTeamName();
        if (playerTeamColor == null || playerTeamName == null ||
                !ClientUtils.heartAllowedColors.contains(playerTeamColor.toLowerCase(Locale.ROOT)) ||
                !ClientUtils.heartAllowedHearts.contains(texturePath)) {
            //? if <= 1.21 {
            /*instance.blitSprite(identifier, x, y, u, v);
            *///?} else if <= 1.21.5 {
            /*instance.blitSprite(renderLayers, identifier, x, y, u, v);
            *///?} else {
            instance.blitSprite(renderPipeline, identifier, x, y, u, v);
            //?}
            return;
        }

        String color = playerTeamColor.toLowerCase(Locale.ROOT);

        String heartType = texturePath.replaceFirst("hud/heart/", "");

        var customHeart = IdentifierHelper.mod(color+"_"+heartType);
        //? if <= 1.21 {
        /*instance.blitSprite(customHeart, x, y, u, v);
        *///?} else if <= 1.21.5 {
        /*instance.blitSprite(renderLayers, customHeart, x, y, u, v);
        *///?} else {
        instance.blitSprite(renderPipeline, customHeart, x, y, u, v);
        //?}
    }
}

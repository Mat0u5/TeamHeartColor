package net.mat0u5.teamhearts.mixin.client.compat.appleskin;

import net.mat0u5.teamhearts.ClientUtils;
import net.mat0u5.teamhearts.IdentifierHelper;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import squeek.appleskin.helpers.TextureHelper;

import java.util.Locale;

@Pseudo
@Mixin(value = TextureHelper.class, priority = 1, remap = false)
public class TextureHelperMixin {
    @Inject(method = "getHeartTexture", at = @At("RETURN"), cancellable = true)
    private static void lifeSkins(boolean hardcore, TextureHelper.HeartType type, CallbackInfoReturnable<Identifier> cir) {
        var original = cir.getReturnValue();
        String texturePath = original.getPath();
        String playerTeamColor = ClientUtils.getPlayerTeamColor();
        String playerTeamName = ClientUtils.getPlayerTeamName();
        if (playerTeamColor == null || playerTeamName == null ||
                !ClientUtils.heartAllowedColors.contains(playerTeamColor.toLowerCase(Locale.ROOT)) ||
                !ClientUtils.heartAllowedHearts.contains(texturePath)) {
            return;
        }
        String color = playerTeamColor.toLowerCase(Locale.ROOT);
        String heartType = texturePath.replaceFirst("hud/heart/", "");
        var customHeart = IdentifierHelper.mod(color+"_"+heartType);
        cir.setReturnValue(customHeart);
    }
}
package net.mat0u5.teamhearts.mixin.client.compat.appleskin;

//? if <= 1.20 {
/*import dev.kikugie.fletching_table.annotation.MixinEnvironment;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import squeek.appleskin.api.event.HUDOverlayEvent;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import squeek.appleskin.client.HUDOverlayHandler;
@Pseudo
@Mixin(value = HUDOverlayHandler.class, priority = 1, remap = false)
@MixinEnvironment(type = MixinEnvironment.Env.CLIENT)
public class TextureHelperMixin {
	//? if > 1.15 {
	//? if forge && <= 1.16 {
	/^@Redirect(method = "onRender", at = @At(value = "INVOKE", target = "Lsqueek/appleskin/api/event/HUDOverlayEvent$HealthRestored;isCanceled()Z"), remap = false)
	private boolean cancelHealthPreview(HUDOverlayEvent.HealthRestored instance) {
		return true;
	}
	^///?} else if forge {
	/^@Redirect(method = "renderFoodOrHealthOverlay", at = @At(value = "INVOKE", target = "Lsqueek/appleskin/api/event/HUDOverlayEvent$HealthRestored;isCanceled()Z"), remap = false)
	private static boolean cancelHealthPreview(HUDOverlayEvent.HealthRestored instance) {
		return true;
	}
	^///?} else {
	@WrapOperation(method = "onRender", at = @At(value = "FIELD", target = "Lsqueek/appleskin/api/event/HUDOverlayEvent$HealthRestored;isCanceled:Z"))
	private boolean cancelHealthPreview(HUDOverlayEvent.HealthRestored instance, Operation<Boolean> original) {
		return true;
	}
	//?}
	//?}
}
*///?} else {
import net.mat0u5.teamhearts.ClientUtils;
import dev.kikugie.fletching_table.annotation.MixinEnvironment;
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
@MixinEnvironment(type = MixinEnvironment.Env.CLIENT)
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
//?}
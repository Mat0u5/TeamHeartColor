package net.mat0u5.teamhearts.mixin.client.plugin;

import net.mat0u5.teamhearts.Main;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class ClientMixinPlugin implements IMixinConfigPlugin {

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {

        if (mixinClassName.contains("compat.appleskin")) {
            //? if <= 1.15 {
            /*boolean ret = false;
            *///?} else {
            boolean ret = Main.platform().isModLoaded("appleskin");
            Main.LOGGER.info("[TeamHeartColor] Compat - Appleskin - " + ret);
            //?}
            return ret;
        }
        return true;
    }

    @Override public void onLoad(String mixinPackage) {}
    @Override public String getRefMapperConfig() { return null; }
    @Override public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}
    @Override public List<String> getMixins() { return null; }
    @Override public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
    @Override public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
}
package net.mat0u5.teamhearts;


import net.minecraft.client.Minecraft;
import net.minecraft.world.scores.Team;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ClientUtils {
    public static final List<String> heartAllowedColors = List.of(
            "aqua","black","blue","dark_aqua","dark_blue","dark_gray","dark_green",
            "dark_purple","dark_red","gold","gray","green","light_purple","white","yellow", "red"
    );
    public static final List<String> heartAllowedHearts = List.of(
            "hud/heart/full", "hud/heart/full_blinking", "hud/heart/half", "hud/heart/half_blinking",
            "hud/heart/hardcore_full", "hud/heart/hardcore_full_blinking", "hud/heart/hardcore_half", "hud/heart/hardcore_half_blinking"
    );

    @Nullable
    public static String getPlayerTeamColor() {
        Minecraft client = Minecraft.getInstance();
        if (client.player == null) return null;
        Team team = client.player.getTeam();
        if (team != null) return team.getColor().getName();
        return null;
    }
    @Nullable
    public static String getPlayerTeamName() {
        Minecraft client = Minecraft.getInstance();
        if (client.player == null) return null;
        Team team = client.player.getTeam();
        if (team != null) return team.getName();
        return null;
    }
}

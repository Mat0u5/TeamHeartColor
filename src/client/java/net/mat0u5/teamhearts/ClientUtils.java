package net.mat0u5.teamhearts;


import net.minecraft.client.Minecraft;
import net.minecraft.world.scores.Team;
import org.jetbrains.annotations.Nullable;

public class ClientUtils {

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

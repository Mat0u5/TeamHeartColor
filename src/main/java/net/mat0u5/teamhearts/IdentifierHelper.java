package net.mat0u5.teamhearts;

//? if <= 1.21.9 {
/*import net.minecraft.resources.ResourceLocation;
*///?} else {
import net.minecraft.resources.Identifier;
//?}

public class IdentifierHelper {
    //? if <= 1.21.9 {
    /*public static ResourceLocation of(String namespace, String path) {
        return ResourceLocation.fromNamespaceAndPath(namespace, path);
    }
    public static ResourceLocation mod(String path) {
        return ResourceLocation.fromNamespaceAndPath("teamhearts", path);
    }
    public static ResourceLocation vanilla(String path) {
        return ResourceLocation.withDefaultNamespace(path);
    }
    public static ResourceLocation parse(String string) {
        return ResourceLocation.parse(string);
    }
    *///?} else {
    public static Identifier of(String namespace, String path) {
        return Identifier.fromNamespaceAndPath(namespace, path);
    }
    public static Identifier mod(String path) {
        return Identifier.fromNamespaceAndPath("teamhearts", path);
    }
    public static Identifier vanilla(String path) {
        return Identifier.withDefaultNamespace(path);
    }
    public static Identifier parse(String string) {
        return Identifier.parse(string);
    }
    //?}
}

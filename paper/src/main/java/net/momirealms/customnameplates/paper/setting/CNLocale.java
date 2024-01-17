package net.momirealms.customnameplates.paper.setting;

import dev.dejvokep.boostedyaml.YamlDocument;
import dev.dejvokep.boostedyaml.dvs.versioning.BasicVersioning;
import dev.dejvokep.boostedyaml.settings.dumper.DumperSettings;
import dev.dejvokep.boostedyaml.settings.general.GeneralSettings;
import dev.dejvokep.boostedyaml.settings.loader.LoaderSettings;
import dev.dejvokep.boostedyaml.settings.updater.UpdaterSettings;
import net.momirealms.customnameplates.api.CustomNameplatesPlugin;
import net.momirealms.customnameplates.api.util.LogUtils;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class CNLocale {

    public static String MSG_RELOAD;
    public static String MSG_PREFIX;
    public static String MSG_PREVIEW_COOLDOWN;
    public static String MSG_PREVIEW_START;
    public static String generate;
    public static String noNameplate;
    public static String MSG_PACK_GENERATION;
    public static String MSG_EQUIP_NAMEPLATE;
    public static String MSG_UNEQUIP_NAMEPLATE;
    public static String MSG_FORCE_EQUIP_NAMEPLATE;
    public static String np_force_unEquip;
    public static String MSG_NAMEPLATE_NOT_EXISTS;
    public static String MSG_NAMEPLATE_NOT_AVAILABLE;
    public static String np_available;
    public static String np_haveNone;
    public static String bb_equip;
    public static String bb_unEquip;
    public static String bb_force_equip;
    public static String bb_force_unEquip;
    public static String bb_not_exist;
    public static String bb_notAvailable;
    public static String bb_available;
    public static String bb_haveNone;

    public static void load() {
        try {
            YamlDocument.create(
                    new File(CustomNameplatesPlugin.getInstance().getDataFolder(), "messages/" + CNConfig.language + ".yml"),
                    Objects.requireNonNull(CustomNameplatesPlugin.getInstance().getResource("messages/" + CNConfig.language + ".yml")),
                    GeneralSettings.DEFAULT,
                    LoaderSettings
                            .builder()
                            .setAutoUpdate(true)
                            .build(),
                    DumperSettings.DEFAULT,
                    UpdaterSettings
                            .builder()
                            .setVersioning(new BasicVersioning("config-version"))
                            .build()
            );
        } catch (IOException e) {
            LogUtils.warn(e.getMessage());
        }
        loadSettings(CustomNameplatesPlugin.get().getConfig("messages/" + CNConfig.language + ".yml"));
    }

    public static void loadSettings(YamlConfiguration config) {
        ConfigurationSection section = config.getConfigurationSection("messages");
        if (section != null) {
            MSG_RELOAD = section.getString("reload");
            MSG_PREFIX = section.getString("prefix");
            MSG_PREVIEW_COOLDOWN = config.getString("messages.cooldown");
            MSG_PREVIEW_START = config.getString("messages.preview");
            generate = config.getString("messages.generate");
            MSG_PACK_GENERATION = config.getString("messages.generate-done");
            noNameplate = config.getString("messages.no-nameplate");
            MSG_EQUIP_NAMEPLATE = config.getString("messages.equip-nameplates");
            MSG_UNEQUIP_NAMEPLATE = config.getString("messages.unequip-nameplates");
            MSG_FORCE_EQUIP_NAMEPLATE = config.getString("messages.force-equip-nameplates");
            np_force_unEquip = config.getString("messages.force-unequip-nameplates");
            MSG_NAMEPLATE_NOT_EXISTS = config.getString("messages.not-exist-nameplates");
            MSG_NAMEPLATE_NOT_AVAILABLE = config.getString("messages.not-available-nameplates");
            np_available = config.getString("messages.available-nameplates");
            np_haveNone = config.getString("messages.have-no-nameplates");
            bb_equip = config.getString("messages.equip-bubbles");
            bb_unEquip = config.getString("messages.unequip-bubbles");
            bb_force_equip = config.getString("messages.force-equip-bubbles");
            bb_force_unEquip = config.getString("messages.force-unequip-bubbles");
            bb_not_exist = config.getString("messages.not-exist-bubbles");
            bb_notAvailable = config.getString("messages.not-available-bubbles");
            bb_available = config.getString("messages.available-bubbles");
            bb_haveNone = config.getString("messages.have-no-bubbles");
        }

    }
}
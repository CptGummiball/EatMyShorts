package org.cptgummiball.eatmyShorts;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class Main extends JavaPlugin {

    private Map<String, CommandShortcut> shortcuts;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadShortcuts();
        getLogger().info("EatMyShorts has been enabled!");
    }

    private void loadShortcuts() {
        shortcuts = new HashMap<>();
        getConfig().getKeys(false).forEach(key -> {
            if (!key.equals("version")) {
                String execute = getConfig().getString(key + ".execute");
                String command = getConfig().getString(key + ".command");
                boolean useArgs = getConfig().getBoolean(key + ".useargs");

                CommandShortcut shortcut = new CommandShortcut(execute, command, useArgs);
                shortcuts.put(key.toLowerCase(), shortcut); // Store in lowercase for case insensitivity
            }
        });
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if the command label is one of our shortcuts (case insensitive)
        if (shortcuts.containsKey(label.toLowerCase())) {
            CommandShortcut shortcut = shortcuts.get(label.toLowerCase());
            if (shortcut.isUseArgs()) {
                executeCommand(shortcut.getExecute(), sender, shortcut.getCommand(), args);
            } else {
                executeCommand(shortcut.getExecute(), sender, shortcut.getCommand());
            }
            return true;
        }
        return false;
    }

    private void executeCommand(String execute, CommandSender sender, String command, String... args) {
        String fullCommand = command + (args.length > 0 ? " " + String.join(" ", args) : "");

        if (execute.equalsIgnoreCase("server")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), fullCommand);
        } else if (execute.equalsIgnoreCase("player")) {
            if (sender instanceof org.bukkit.entity.Player) {
                org.bukkit.entity.Player player = (org.bukkit.entity.Player) sender;
                if (player.hasPermission("eatmyshorts.use")) {
                    Bukkit.dispatchCommand(player, fullCommand);
                } else {
                    player.sendMessage("You do not have permission to execute this command!");
                }
            } else {
                sender.sendMessage("This command can only be executed by a player.");
            }
        }
    }
}

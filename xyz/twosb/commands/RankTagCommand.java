package xyz.twosb.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import xyz.twosb.RankTag;

public class RankTagCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if (arg0 instanceof Player) {
			if (arg0.isOp()) {
				for (Player p : Bukkit.getOnlinePlayers()) {
					RankTag.updateTag(p);
					arg0.sendMessage("Updated tag for " + p.getName());
				}
			}

		}
		return true;
	}

}

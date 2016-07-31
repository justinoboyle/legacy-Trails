package com.arrayprolc.trails.event.custom;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerCommandEvent extends Event implements Cancellable {

	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled = false;
	private boolean allowedInConsole = false;
	private boolean done = false;
	private CommandSender sender;
	private Command command;
	private String commandLabel;
	private String[] args;

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	public CommandSender getSender(){
		return sender;
	}

	public Command getCommand(){
		return command;
	}

	public String[] getArgs(){
		return args;
	}

	public String getCommandLabel(){
		return commandLabel;
	}

	public void setDone(){
		done = true;
	}

	public boolean getDone(){
		return done;
	}

	public boolean isAllowedInConsole(){
		return allowedInConsole;
	}

	public boolean setAllowedInConsole(boolean b){
		allowedInConsole = b;
		return allowedInConsole;
	}

	@Override
	public void setCancelled(boolean arg0) {
		cancelled = arg0;
	}

	public PlayerCommandEvent(CommandSender sender, Command command, String commandLabel, String[] args){
		this.sender = sender; this.command = command; this.commandLabel = commandLabel; this.args = args;
	}

	/*    */   public HandlerList getHandlers()
	/*    */   {
		/* 89 */     return handlers;
	/*    */   }
	/*    */   
	/*    */   public static HandlerList getHandlerList() {
		/* 93 */     return handlers;
	/*    */   }

}

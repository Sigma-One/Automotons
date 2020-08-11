package net.automotons.items;

import net.automotons.blocks.AutomotonBlockEntity;
import net.minecraft.item.Item;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class ModuleItem extends Item implements Module{
	
	private Predicate<AutomotonBlockEntity> execution;
	
	public ModuleItem(Settings settings, Predicate<AutomotonBlockEntity> execution){
		super(settings);
		this.execution = execution;
	}
	
	public static ModuleItem fromConsumer(Settings settings, Consumer<AutomotonBlockEntity> execution){
		return new ModuleItem(settings, entity -> {
			execution.accept(entity);
			return true;
		});
	}
	
	public boolean execute(AutomotonBlockEntity block){
		return execution.test(block);
	}
}
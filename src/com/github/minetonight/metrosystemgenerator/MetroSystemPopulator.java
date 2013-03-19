package com.github.minetonight.metrosystemgenerator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class MetroSystemPopulator extends BlockPopulator {

	@Override
	public void populate(World world, Random random, Chunk chunk) {
		int cx = chunk.getX();
		int cz = chunk.getZ();
		
		if (cz == 0) {
			if (cx > -2 && cx < 2) {
				for (int x = 0; x < 16; x++) {
					for (int z = 5; z < 13; z++) {
						//create ceiling
						chunk.getBlock(x, 40, z).setType(Material.STONE);
						
						if (z == 5 || z == 12) {
							for (int y = 39; y > 34; y--) {
								//create walls
								chunk.getBlock(x, y, z).setType(Material.STONE);
							}//for y
						} else {
							//create tunnel
							for (int y = 19; y > 14; y--) {
								chunk.getBlock(x, y, z).setType(Material.AIR);
							}//for y
						}
					}//for z
				}//for x
			}
		}
	}//eof populate

}

package com.github.minetonight.metrosystemgenerator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

import com.github.minetonight.metrosystemgenerator.sections.TunnelSections;

public class MetroSystemPopulator extends BlockPopulator {

	@Override
	public void populate(World world, Random random, Chunk chunk) {
		int cx = chunk.getX();
		int cz = chunk.getZ();
		
		if (cx == 0) {
			if (cz > -4 && cz < 3) {
				System.out.println("Adding tunnel at cz="+cz+"/cx="+cx);
				//  y,z,x
				int[][][] tunnel = getTunnel(cx, cz);
				
				for (int x = 0; x < 16; x++) {
					for (int z = 0; z < 16; z++) {
						for (int y = 0; y < tunnel.length; y++) {
							int blockValue = tunnel[y][z][x];
								
							if (blockValue >= 0) {
								if (blockValue > 1000) {
									int metadata = blockValue % 1000;
									int blockId = (blockValue - metadata) / 1000;
									
									chunk.getBlock(x, y+51, z).setTypeIdAndData(blockId, (byte) metadata, true);
								} else {
									chunk.getBlock(x, y+51, z).setTypeId(blockValue);
								}
							}
						}//for y
					}//for z
				}//for x
			}
		}
	}//eof populate

	private int[][][] getTunnel(int chunkX, int chunkZ) {
		
		if (chunkZ == 2) {
			return TunnelSections.getNWTunnel();
		}
		
		return TunnelSections.getNSTunnel();
	}

}

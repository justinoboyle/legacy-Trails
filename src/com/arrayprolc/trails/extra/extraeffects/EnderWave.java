package com.arrayprolc.trails.extra.extraeffects;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

import com.arrayprolc.trails.effects.EffectManager;
import com.arrayprolc.trails.extra.ExtraManager;
import com.arrayprolc.trails.particles18.ParticleLib18;
import com.arrayprolc.trails.update.UpdateType;
import com.arrayprolc.trails.update.event.UpdateEvent;
import com.arrayprolc.trails.util.MathUtils;
import com.arrayprolc.trails.util.UtilVector;

public class EnderWave
implements Listener
{
	private int particles = 100;
	private int particlesPerIteration = 11;
	private float size = 1.0F;
	private float xFactor = 1.2F;
	private float yFactor = 0.6F;
	private float zFactor = 1.2F;
	private float yOffset = 0.6F;
	private double xRotation;
	private double yRotation;
	private double zRotation = 0.0D;
	private int step;

	@EventHandler
	public void LocationUpdater(UpdateEvent event)
	{
		if (event.getType() == UpdateType.TICK)
		{
			for (Player p : EffectManager.effect3.keySet())
			{
				if (EffectManager.getEffect(p) == EffectManager.EffectType.EnderWave)
				{
					if (p.isValid())
					{
						if (ExtraManager.isMoving(p))
						{
							Location location = p.getLocation();

							Vector vector = new Vector();

							for (int i = 0; i < this.particlesPerIteration; i++) {
								this.step += 1;

								float t = 3.141593F / this.particles * this.step;
								float r = MathUtils.sin(t * 6.283186F / this.particles) * this.size;
								float s = r * 3.141593F * t;

								vector.setX(this.xFactor * r * MathUtils.cos(s));
								vector.setZ(this.zFactor * r * MathUtils.sin(s));
								vector.setY(this.yFactor * MathUtils.cos(t) + this.yOffset);

								UtilVector.rotateVector(vector, this.xRotation, this.yRotation, this.zRotation);
								ParticleLib18 water = new ParticleLib18(ParticleLib18.ParticleType.SPELL_WITCH, 0.0D, 1, 0.0D);
								water.sendToLocation(location.add(vector));
								location.subtract(vector);
							}

						}
						else if (!p.isInsideVehicle()) {
							ParticleLib18 water = new ParticleLib18(ParticleLib18.ParticleType.SPELL_WITCH, 0.1000000014901161D, 4, 0.300000011920929D);
							water.sendToLocation(p.getLocation().add(0.0D, 1.0D, 0.0D));
						}
					}
				}
			}
		}
	}
}
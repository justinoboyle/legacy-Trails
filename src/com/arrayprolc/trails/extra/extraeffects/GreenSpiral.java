package com.arrayprolc.trails.extra.extraeffects;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.arrayprolc.trails.effects.EffectManager;
import com.arrayprolc.trails.extra.ExtraManager;
import com.arrayprolc.trails.particles18.ParticleLib18;
import com.arrayprolc.trails.update.UpdateType;
import com.arrayprolc.trails.update.event.UpdateEvent;

public class GreenSpiral
  implements Listener
{
  private double i = 0.0D;
  private double newY;

  @EventHandler
  public void LocationUpdater(UpdateEvent event)
  {
    if (event.getType() == UpdateType.TICK)
    {
      for (Player p : EffectManager.effect3.keySet())
      {
        if (EffectManager.getEffect(p) == EffectManager.EffectType.GreenSpiral)
        {
          if (p.isValid())
          {
            if (ExtraManager.isMoving(p)) {
              double slice = 0.1570796326794897D;
              double slice2 = 0.06283185307179587D;
              double x = 1.0D;
              double radius = 1.0D;
              Location ploca = p.getLocation();
              double angle = slice * this.i;
              double angle2 = slice2 * this.i;
              this.newY = (ploca.getY() + 1.0D + radius * Math.cos(angle2));
              double newX = ploca.getX() + radius * Math.cos(angle);
              double newZ = ploca.getZ() + radius * Math.sin(angle);
              Location l = new Location(p.getWorld(), newX, this.newY, newZ);

   		   	  ParticleLib18 happy = new ParticleLib18(ParticleLib18.ParticleType.VILLAGER_HAPPY, 0.0D, 1, 0.0D);
   		   	  happy.sendToLocation(l);
              this.i += 1.0D / x;
            }
            else if (!p.isInsideVehicle()) {
   		   	  ParticleLib18 happy = new ParticleLib18(ParticleLib18.ParticleType.VILLAGER_HAPPY, 0.1000000014901161D, 4, 0.300000011920929D);
   		   	  happy.sendToLocation(p.getLocation().add(0.0D, 1.0D, 0.0D));
            }

          }

          this.i += 1.0D;
        }
      }
    }
  }
}
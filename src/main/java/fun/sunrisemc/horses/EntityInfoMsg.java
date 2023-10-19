package fun.sunrisemc.horses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.ChestedHorse;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Llama;
import org.bukkit.entity.Player;
import org.bukkit.entity.Tameable;
import org.bukkit.potion.PotionEffect;

import net.md_5.bungee.api.ChatColor;

public class EntityInfoMsg extends PlayerMsg {
    ArrayList<String> attributes = new ArrayList<>();

    public EntityInfoMsg(Player player, Entity entity, String title) {
        super(player);
        EntityAttributes attributes = new EntityAttributes();
        h1(title);
        name(entity);
        age(entity);
        fire(entity);
        attributes.a(entity);

        if (!(entity instanceof LivingEntity)) return;
        LivingEntity livingEntity = (LivingEntity) entity;
        speed(livingEntity);
        air(livingEntity);
        arrows(livingEntity);
        effects(livingEntity);
        leash(livingEntity);
        attributes.a(livingEntity);

        if (entity instanceof Tameable) {
            Tameable tameable = (Tameable) entity;
            owner(tameable);

            if (tameable instanceof AbstractHorse) {
                AbstractHorse abstractHorse = (AbstractHorse) tameable;
                jump(abstractHorse);

                if (abstractHorse instanceof Horse) {
                    Horse horse = (Horse) abstractHorse;
                    color(horse);
                    style(horse);
                }

                if (abstractHorse instanceof ChestedHorse) {
                    ChestedHorse chestedHorse = (ChestedHorse) abstractHorse;
                    attributes.a(chestedHorse);

                    if (chestedHorse instanceof Llama) {
                        Llama llama = (Llama) chestedHorse;
                        color(llama);
                    }
                }
            }
        }
        attributes(attributes);
    }

    private void name(Entity entity) {
        field("Name", entity.getCustomName());
    }

    private void age(Entity entity) {
        field("Age", Utl.ticksToTime(entity.getTicksLived()));
    }

    private void fire(Entity entity) {
        int ticks = entity.getFireTicks();
        if (ticks > 0) field("Flaming", Utl.ticksToTime(ticks));
    }

    private void speed(LivingEntity livingEntity) {
        AttributeInstance attr = livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
        if (attr != null) field("Speed", attr.getValue());
    }

    private void air(LivingEntity livingEntity) {
        int air = livingEntity.getRemainingAir();
        int maxAir = livingEntity.getMaximumAir();
        if (air != maxAir) ratiof("Air", air, maxAir);
    }

    private void arrows(LivingEntity livingEntity) {
        int arrows = livingEntity.getArrowsInBody();
        if (arrows > 0) field("Arrows In Body", arrows);
    }

    private void effects(LivingEntity livingEntity) {
        Collection<PotionEffect> effects = livingEntity.getActivePotionEffects();
        if (effects.isEmpty()) return;
        ul("Effects");
        Iterator<PotionEffect> effectsIter = effects.iterator();
        while (effectsIter.hasNext()) {
            PotionEffect effect = effectsIter.next();
            String name = effect.getType().getName();
            int amplifier = effect.getAmplifier(); 
            if (amplifier > 0) name += " " + amplifier;
            lf(Utl.titleCase(name), Utl.ticksToTime(effect.getDuration()));
        }
    }

    private void leash(LivingEntity livingEntity) {
        if (!livingEntity.isLeashed()) return;
        Entity leashHolder = livingEntity.getLeashHolder();
        field("Leash Holder", Utl.id(leashHolder));
    }

    private void owner(Tameable tameable) {
        if (!tameable.isTamed()) return;
        AnimalTamer owner = tameable.getOwner();
        field("Owner", owner.getName());
    }

    private void jump(AbstractHorse abstractHorse) {
        field("Jump Strength", abstractHorse.getJumpStrength());
    }

    private void color(Horse horse) {
        field("Color", Utl.titleCase(horse.getColor().name()));
    }

    private void style(Horse horse) {
        field("Style", Utl.titleCase(horse.getStyle().name()));
    }

    private void color(Llama llama) {
        field("Color", Utl.titleCase(llama.getColor().name()));
    }

    private void attributes(EntityAttributes attributes) {
        if (attributes.isEmpty()) return;
        Iterator<String> iter = attributes.iterator();
        String list = iter.next();
        while (iter.hasNext()) {
            list += ChatColor.WHITE + ", " + iter.next();
        }
        field("Attributes", list);
    }
}

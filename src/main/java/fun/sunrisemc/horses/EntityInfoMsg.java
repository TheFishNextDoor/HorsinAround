package fun.sunrisemc.horses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Breedable;
import org.bukkit.entity.Camel;
import org.bukkit.entity.Cat;
import org.bukkit.entity.ChestedHorse;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Llama;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sittable;
import org.bukkit.entity.Steerable;
import org.bukkit.entity.Strider;
import org.bukkit.entity.Tameable;
import org.bukkit.entity.Vehicle;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.minecart.ExplosiveMinecart;
import org.bukkit.entity.minecart.HopperMinecart;
import org.bukkit.entity.minecart.PoweredMinecart;
import org.bukkit.potion.PotionEffect;

import net.md_5.bungee.api.ChatColor;

public class EntityInfoMsg extends PlayerMsg {
    ArrayList<String> attributes = new ArrayList<>();

    public EntityInfoMsg(Player player, Entity entity, String title) {
        super(player);
        EntityAttributes attributes = new EntityAttributes();
        h1(Utl.titleCase(entity.getType().name()) + " Info");
        name(entity);
        age(entity);
        fire(entity);
        attributes.a(entity);

        if (entity instanceof Sittable) {
            Sittable sittable = (Sittable) entity;
            attributes.a(sittable);
        }

        if (entity instanceof Vehicle) {
            Vehicle vehicle = (Vehicle) entity;
            speed(vehicle);

            if (vehicle instanceof Boat) {
                Boat boat = (Boat) vehicle;
                type(boat);
                status(boat);
            }

            if (vehicle instanceof Minecart) {
                Minecart minecart = (Minecart) vehicle;
                maxSpeed(minecart);
                displayBlock(minecart);
                damage(minecart);

                if (minecart instanceof ExplosiveMinecart) {
                    ExplosiveMinecart explosiveMinecart = (ExplosiveMinecart) minecart;
                    fuseTicks(explosiveMinecart);
                    attributes.a(explosiveMinecart);
                }

                if (minecart instanceof HopperMinecart) {
                    HopperMinecart hopperMinecart = (HopperMinecart) minecart;
                    attributes.a(hopperMinecart);
                }

                if (minecart instanceof PoweredMinecart) {
                    PoweredMinecart poweredMinecart = (PoweredMinecart) minecart;
                    fuel(poweredMinecart);
                }
            }
        }

        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            movementSpeed(livingEntity);
            air(livingEntity);
            arrows(livingEntity);
            effects(livingEntity);
            leash(livingEntity);
            attributes.a(livingEntity);

            if (livingEntity instanceof Mob) {
                Mob mob = (Mob) livingEntity;
                attributes.a(mob);

                if (livingEntity instanceof Ageable) {
                    Ageable ageable = (Ageable) livingEntity;
                    attributes.a(ageable);

                    if (ageable instanceof Breedable) {
                        Breedable breedable = (Breedable) ageable;
                        attributes.a(breedable);

                        if (breedable instanceof Animals) {
                            Animals animal = (Animals) breedable;
                            love(animal);

                            if (animal instanceof Tameable) {
                                Tameable tameable = (Tameable) animal;
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

                                    if (abstractHorse instanceof Camel) {
                                        Camel camel = (Camel) abstractHorse;
                                        attributes.a(camel);
                                    }
                                }

                                if (tameable instanceof Wolf) {
                                    Wolf wolf = (Wolf) tameable;
                                    collar(wolf);
                                    attributes.a(wolf);
                                }

                                if (tameable instanceof Cat) {
                                    Cat cat = (Cat) tameable;
                                    type(cat);
                                    collar(cat);
                                }

                                if (tameable instanceof Parrot) {
                                    Parrot parrot = (Parrot) tameable;
                                    variant(parrot);
                                    attributes.a(parrot);
                                }

                            }

                            if (animal instanceof Steerable) {
                                Steerable steerable = (Steerable) animal;
                                steer(steerable);
                                boost(steerable);

                                if (steerable instanceof Strider) {
                                    Strider strider = (Strider) steerable;
                                    attributes.a(strider);
                                }
                            }
                        }
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
        int ticks = entity.getTicksLived();
        if (ticks > 0) field("Age", Utl.toTime(ticks));
    }

    private void fire(Entity entity) {
        int ticks = entity.getFireTicks();
        if (ticks > 0) field("Flaming", Utl.toTime(ticks));
    }

    private void speed(Vehicle vehicle) {
        field("Current Speed", Utl.toSpeed(vehicle.getVelocity()));
    }

    private void type(Boat boat) {
        field("Type", Utl.titleCase(boat.getBoatType().name()));
    }

    private void status(Boat boat) {
        field("Status", Utl.titleCase(boat.getStatus().name()));
    }

    private void maxSpeed(Minecart minecart) {
        field("Max Speed", minecart.getMaxSpeed());
    }

    private void displayBlock(Minecart minecart) {
        BlockData display = minecart.getDisplayBlockData();
        if (display == null) return;
        Material material = display.getMaterial();
        if (material.isAir()) return;
        field("Block", Utl.titleCase(material.name()));

    }

    private void damage(Minecart minecart) {
        double damage = minecart.getDamage();
        if (damage > 0.0) field("Damage", damage);
    }

    private void fuseTicks(ExplosiveMinecart explosiveMinecart) {
        int ticks = explosiveMinecart.getFuseTicks();
        if (ticks > 0) field("Fuse", Utl.toTime(ticks));
    }

    private void fuel(PoweredMinecart poweredMinecart) {
        int ticks = poweredMinecart.getFuel();
        if (ticks > 0) field("Fuel", Utl.toTime(ticks));
    }

    private void movementSpeed(LivingEntity livingEntity) {
        AttributeInstance attr = livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
        if (attr != null) field("Movement Speed", attr.getValue());
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
            lf(Utl.titleCase(name), Utl.toTime(effect.getDuration()));
        }
    }

    private void leash(LivingEntity livingEntity) {
        if (!livingEntity.isLeashed()) return;
        Entity leashHolder = livingEntity.getLeashHolder();
        field("Leash Holder", Utl.id(leashHolder));
    }

    private void love(Animals animal) {
        int love = animal.getLoveModeTicks();
        if (love > 0) field("Love Mode", Utl.toTime(love));
    }

    private void owner(Tameable tameable) {
        if (!tameable.isTamed()) return;
        AnimalTamer owner = tameable.getOwner();
        if (owner != null) field("Owner", owner.getName());
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

    private void collar(Wolf wolf) {
        field("Collar", Utl.titleCase(wolf.getCollarColor().name()));
    }

    private void type(Cat cat) {
        field("Type", Utl.titleCase(cat.getCatType().name()));
    }

    private void collar(Cat cat) {
        field("Collar", Utl.titleCase(cat.getCollarColor().name()));
    }

    private void variant(Parrot parrot) {
        field("Variant", Utl.titleCase(parrot.getVariant().name()));
    }

    private void steer(Steerable steerable) {
        field("Steer Item", Utl.titleCase(steerable.getSteerMaterial().name()));
    }

    private void boost(Steerable steerable) {
        int boost = steerable.getCurrentBoostTicks();
        if (boost > 0) field("Boost", Utl.toTime(boost));
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

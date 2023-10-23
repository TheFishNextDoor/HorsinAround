package fun.sunrisemc.horses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.bukkit.Art;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Rotation;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.AbstractHorse;
import org.bukkit.entity.AbstractSkeleton;
import org.bukkit.entity.AbstractVillager;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.Allay;
import org.bukkit.entity.Ambient;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Axolotl;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Bee;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Boss;
import org.bukkit.entity.Breedable;
import org.bukkit.entity.Camel;
import org.bukkit.entity.Cat;
import org.bukkit.entity.ChestedHorse;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Flying;
import org.bukkit.entity.Fox;
import org.bukkit.entity.Frog;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.GlowSquid;
import org.bukkit.entity.Golem;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.Hanging;
import org.bukkit.entity.Hoglin;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Husk;
import org.bukkit.entity.Illager;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Llama;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Monster;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Panda;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.Phantom;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.PiglinAbstract;
import org.bukkit.entity.Player;
import org.bukkit.entity.PufferFish;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Raider;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Shulker;
import org.bukkit.entity.Sittable;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Sniffer;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.Spellcaster;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Steerable;
import org.bukkit.entity.Strider;
import org.bukkit.entity.Tameable;
import org.bukkit.entity.TropicalFish;
import org.bukkit.entity.Turtle;
import org.bukkit.entity.Vehicle;
import org.bukkit.entity.Vex;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Vindicator;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.entity.Warden;
import org.bukkit.entity.WaterMob;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.entity.Horse.Style;
import org.bukkit.entity.Spellcaster.Spell;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.entity.Warden.AngerLevel;
import org.bukkit.entity.minecart.ExplosiveMinecart;
import org.bukkit.entity.minecart.HopperMinecart;
import org.bukkit.entity.minecart.PoweredMinecart;
import org.bukkit.material.Colorable;
import org.bukkit.potion.PotionEffect;

import net.md_5.bungee.api.ChatColor;

public class EntityInfoMsg extends PlayerMsg {
    ArrayList<String> attributes = new ArrayList<>();

    public EntityInfoMsg(Player player, Entity entity, String title) {
        super(player);
        EntityAttributes attributes = new EntityAttributes();
        h1(Utl.titleCase(entity.getType().toString()) + " Info");
        name(entity);
        fire(entity);
        attributes.a(entity);

        if (entity instanceof Hanging) {
            Hanging hanging = (Hanging) entity;

            if (hanging instanceof ItemFrame) {
                ItemFrame itemFrame = (ItemFrame) hanging;
                item(itemFrame);
                rotation(itemFrame);
                attributes.a(itemFrame);
            }

            if (hanging instanceof Painting) {
                Painting painting = (Painting) hanging;
                art(painting);
            }

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

        if (entity instanceof Damageable) {
            Damageable damageable = (Damageable) entity;
            health(damageable);
            absorbtion(damageable);
        }

        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            maxHealth(livingEntity);
            timeLived(livingEntity);
            movementSpeed(livingEntity);
            air(livingEntity);
            arrows(livingEntity);
            effects(livingEntity);
            leash(livingEntity);
            attributes.a(livingEntity);

            if (livingEntity instanceof Mob) {
                Mob mob = (Mob) livingEntity;
                attributes.a(mob);

                if (mob instanceof Slime) {
                    Slime slime = (Slime) mob;
                    size(slime);
                }

                if (mob instanceof Flying) {
                    Flying flying = (Flying) mob;

                    if (flying instanceof Ghast) {
                        Ghast ghast = (Ghast) flying;
                        attributes.a(ghast);
                    }

                    if (flying instanceof Phantom) {
                        Phantom phantom = (Phantom) flying;
                        size(phantom);
                    }
                    
                }

                if (mob instanceof Ambient) {
                    Ambient ambient = (Ambient) mob;

                    if (ambient instanceof Bat) {
                        Bat bat = (Bat) ambient;
                        attributes.a(bat);
                    }
                }

                if (mob instanceof Creature) {
                    Creature creature = (Creature) mob;
                    attributes.a(creature);

                    if (creature instanceof Allay) {
                        Allay allay = (Allay) creature;
                        jukeBox(allay);
                        attributes.a(allay);
                    }

                    if (creature instanceof Golem) {
                        Golem golem = (Golem) creature;
                        
                        if (golem instanceof IronGolem) {
                            IronGolem ironGolem = (IronGolem) golem;
                            attributes.a(ironGolem);
                        }

                        if (golem instanceof Shulker) {
                            Shulker shulker = (Shulker) golem;
                            attachedFace(shulker);
                            peek(shulker);
                        }

                        if (golem instanceof Snowman) {
                            Snowman snowman = (Snowman) golem;
                            attributes.a(snowman);
                        }
                    }

                    if (creature instanceof WaterMob) {
                        WaterMob waterMob = (WaterMob) creature;

                        if (waterMob instanceof Squid) {
                            Squid squid = (Squid) waterMob;

                            if (squid instanceof GlowSquid) {
                                GlowSquid glowSquid = (GlowSquid) squid;
                                darkTicks(glowSquid);
                            }
                        }

                        if (waterMob instanceof Fish) {
                            Fish fish = (Fish) waterMob;

                            if (fish instanceof PufferFish) {
                                PufferFish pufferfish = (PufferFish) fish;
                                puffState(pufferfish);
                            }

                            if (fish instanceof TropicalFish) {
                                TropicalFish tropicalFish = (TropicalFish) fish;
                                bodyColor(tropicalFish);
                                pattern(tropicalFish);
                                patternColor(tropicalFish);
                            }
                        }
                    }

                    if (creature instanceof Monster) {
                        Monster monster = (Monster) creature;

                        if (monster instanceof AbstractSkeleton) {
                            AbstractSkeleton abstractSkeleton = (AbstractSkeleton) monster;
                            
                            if (abstractSkeleton instanceof Skeleton) {
                                Skeleton skeleton = (Skeleton) abstractSkeleton;
                                conversionTime(skeleton);
                            }
                        }

                        if (monster instanceof Creeper) {
                            Creeper creeper = (Creeper) monster;
                            explosionRadius(creeper);
                            fuseTicks(creeper);
                            maxFuseTicks(creeper);
                            attributes.a(creeper);
                        }

                        if (monster instanceof Guardian) {
                            Guardian guardian = (Guardian) monster;
                            laserDuration(guardian);
                            laserTicks(guardian);
                            attributes.a(guardian);
                        }

                        if (monster instanceof Zombie) {
                            Zombie zombie = (Zombie) monster;
                            conversionTime(zombie);
                            attributes.a(zombie);

                            if (zombie instanceof Husk) {
                                Husk husk = (Husk) zombie;
                                conversionTime(husk);
                            }

                            if (zombie instanceof PigZombie) {
                                PigZombie pigZombie = (PigZombie) zombie;
                                attributes.a(pigZombie);
                            }

                            if (zombie instanceof ZombieVillager) {
                                ZombieVillager zombieVillager = (ZombieVillager) zombie;
                                conversionPlayer(zombieVillager);
                                conversionTime(zombieVillager);
                                profession(zombieVillager);
                                type(zombieVillager);
                            }
                        }

                        if (monster instanceof Raider) {
                            Raider raider = (Raider) monster;
                            patrolTarget(raider);
                            outsideRaid(raider);
                            wave(raider);
                            attributes.a(raider);

                            if (raider instanceof Illager) {
                                Illager illager = (Illager) raider;

                                if (illager instanceof Spellcaster) {
                                    Spellcaster spellcaster = (Spellcaster) illager;
                                    spell(spellcaster);
                                }

                                if (illager instanceof Vindicator) {
                                    Vindicator vindicator = (Vindicator) illager;
                                    attributes.a(vindicator);
                                }

                                if (illager instanceof Witch) {
                                    Witch witch = (Witch) illager;
                                    attributes.a(witch);
                                }
                            }
                        }

                        if (monster instanceof Enderman) {
                            Enderman enderman = (Enderman) monster;
                            carriedBlock(enderman);
                        }

                        if (monster instanceof PiglinAbstract) {
                            PiglinAbstract piglinAbstract = (PiglinAbstract) monster;
                            conversionTime(piglinAbstract);
                            attributes.a(piglinAbstract);

                            if (piglinAbstract instanceof Piglin) {
                                Piglin piglin = (Piglin) piglinAbstract;
                                barterList(piglin);
                                interestList(piglin);
                                attributes.a(piglin);
                            }
                        }

                        if (monster instanceof Vex) {
                            Vex vex = (Vex) monster;
                            bound(vex);
                            life(vex);
                            attributes.a(vex);
                        }

                        if (monster instanceof Warden) {
                            Warden warden = (Warden) monster;
                            angerLevel(warden);
                            angryAt(warden);
                        }

                        if (monster instanceof Boss) {
                            Boss boss = (Boss) monster;

                            if (boss instanceof Wither) {
                                Wither wither = (Wither) boss;
                                invulnerability(wither);
                            }
                        }
                    }
                    
                    if (livingEntity instanceof Ageable) {
                        Ageable ageable = (Ageable) livingEntity;
                        attributes.a(ageable);

                        if (ageable instanceof Breedable) {
                            Breedable breedable = (Breedable) ageable;
                            attributes.a(breedable);

                            if (breedable instanceof AbstractVillager) {
                                AbstractVillager abstractVillager = (AbstractVillager) breedable;

                                if (abstractVillager instanceof Villager) {
                                    Villager villager = (Villager) abstractVillager;
                                    profession(villager);
                                    type(villager);
                                    level(villager);
                                    experience(villager);
                                }

                                if (abstractVillager instanceof WanderingTrader) {
                                    WanderingTrader wanderingTrader = (WanderingTrader) abstractVillager;
                                    despawn(wanderingTrader);
                                }
                            }

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

                                if (animal instanceof Bee) {
                                    Bee bee = (Bee) animal;
                                    hive(bee);
                                    flower(bee);
                                    attributes.a(bee);
                                }

                                if (animal instanceof Axolotl) {
                                    Axolotl axolotl = (Axolotl) animal;
                                    variant(axolotl);
                                    attributes.a(axolotl);
                                }

                                if (animal instanceof Cow) {
                                    Cow cow = (Cow) animal;

                                    if (cow instanceof MushroomCow) {
                                        MushroomCow mushroom = (MushroomCow) cow;
                                        variant(mushroom);
                                    }
                                }

                                if (animal instanceof Fox) {
                                    Fox fox = (Fox) animal;
                                    type(fox);
                                }

                                if (animal instanceof Frog) {
                                    Frog frog = (Frog) animal;
                                    variant(frog);
                                }

                                if (animal instanceof Hoglin) {
                                    Hoglin hoglin = (Hoglin) animal;
                                    conversionTime(hoglin);
                                    attributes.a(hoglin);
                                }

                                if (animal instanceof Ocelot) {
                                    Ocelot ocelot = (Ocelot) animal;
                                    attributes.a(ocelot);
                                }

                                if (animal instanceof Panda) {
                                    Panda panda = (Panda) animal;
                                    genes(panda);
                                    unhappy(panda);
                                    attributes.a(panda);
                                }

                                if (animal instanceof Rabbit) {
                                    Rabbit rabbit = (Rabbit) animal;
                                    type(rabbit);
                                }

                                if (animal instanceof Sheep) {
                                    Sheep sheep = (Sheep) animal;
                                    attributes.a(sheep);
                                }

                                if (animal instanceof Sniffer) {
                                    Sniffer sniffer = (Sniffer) animal;
                                    state(sniffer);
                                }

                                if (animal instanceof Turtle) {
                                    Turtle turtle = (Turtle) animal;
                                    attributes.a(turtle);
                                }
                            }
                        }
                    }
                }
            }
        }
        
        if (entity instanceof Colorable) {
            Colorable colorable = (Colorable) entity;
            color(colorable);
        }

        if (entity instanceof Sittable) {
            Sittable sittable = (Sittable) entity;
            attributes.a(sittable);
        }
        
        attributes(attributes);
    }

    private void name(Entity entity) {
        field("Name", entity.getCustomName());
    }

    private void fire(Entity entity) {
        int ticks = entity.getFireTicks();
        if (ticks > 0) field("Flaming", Utl.toTime(ticks));
    }

    private void item(ItemFrame itemFrame) {
        field("Item", Utl.id(itemFrame.getItem()));
    }

    private void rotation(ItemFrame itemFrame) {
        Rotation rotation = itemFrame.getRotation();
        if (rotation == Rotation.NONE) return;
        field("Rotation", Utl.titleCase(rotation.toString()));
    }

    public void art(Painting painting) {
        Art art = painting.getArt();
        String name = Utl.titleCase(art.toString());
        Integer width = art.getBlockWidth();
        Integer height = art.getBlockHeight();
        String dimensions = "(" + width.toString() + "x" + height.toString() + ")";
        field("Art", name + " " + dimensions);
    }

    private void speed(Vehicle vehicle) {
        field("Current Speed", Utl.toSpeed(vehicle.getVelocity()));
    }

    private void type(Boat boat) {
        field("Type", Utl.titleCase(boat.getBoatType().toString()));
    }

    private void status(Boat boat) {
        field("Status", Utl.titleCase(boat.getStatus().toString()));
    }

    private void maxSpeed(Minecart minecart) {
        field("Max Speed", minecart.getMaxSpeed());
    }

    private void displayBlock(Minecart minecart) {
        BlockData display = minecart.getDisplayBlockData();
        if (display == null) return;
        Material material = display.getMaterial();
        if (material.isAir()) return;
        field("Block", Utl.titleCase(material.toString()));

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

    private void health(Damageable damageable) {
        double health = damageable.getHealth();
        if (health > 0.0) field("Health", health);
    }

    private void absorbtion(Damageable damageable) {
        double absorbtion = damageable.getAbsorptionAmount();
        if (absorbtion > 0.0) field("Absorbtion", absorbtion);
    }

    private void maxHealth(LivingEntity livingEntity) {
        AttributeInstance attr = livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (attr != null) field("Max Health", attr.getValue());
    }

    private void timeLived(LivingEntity livingEntity) {
        int ticks = livingEntity.getTicksLived();
        if (ticks > 0) field("Time Lived", Utl.toTime(ticks));
    }

    private void movementSpeed(LivingEntity livingEntity) {
        AttributeInstance attr = livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
        if (attr != null) field("Movement Speed", attr.getValue());
    }

    private void air(LivingEntity livingEntity) {
        int ticks = livingEntity.getRemainingAir();
        int maxTicks = livingEntity.getMaximumAir();
        if (ticks > 0 && ticks != maxTicks) field("Air", Utl.toTime(ticks));
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

    private void size(Slime slime) {
        field("Size", slime.getSize());
    }

    private void size(Phantom phantom) {
        field("Size", phantom.getSize());
    }

    private void jukeBox(Allay allay) {
        if (!allay.isDancing()) return;
        field("Juke Box", Utl.id(allay.getJukebox()));
    }

    private void attachedFace(Shulker shulker) {
        field("Facing", Utl.id(shulker.getAttachedFace().getOppositeFace()));
    }

    private void peek(Shulker shulker) {
        float peek = shulker.getPeek();
        if (peek < 0.005) return;
        field("Peek", Utl.toPercent(peek));
    }

    private void darkTicks(GlowSquid glowSquid) {
        int ticks = glowSquid.getDarkTicksRemaining();
        if (ticks > 0) field("Dark", Utl.toTime(ticks));
    }

    private void puffState(PufferFish pufferfish) {
        int puffState = pufferfish.getPuffState();
        if (puffState > 0) field("Puff State", puffState);
    }

    private void bodyColor(TropicalFish tropicalFish) {
        DyeColor color = tropicalFish.getBodyColor();
        if (color != null) field("Body Color", Utl.titleCase(color.toString()));
    }

    private void pattern(TropicalFish tropicalFish) {
        TropicalFish.Pattern pattern = tropicalFish.getPattern();
        field("Pattern", Utl.titleCase(pattern.toString()));
    }

    private void patternColor(TropicalFish tropicalFish) {
        DyeColor color = tropicalFish.getPatternColor();
        if (color != null) field("Pattern Color", Utl.titleCase(color.toString()));
    }

    private void conversionTime(Skeleton skeleton) {
        if (!skeleton.isConverting()) return;
        int ticks = skeleton.getConversionTime();
        if (ticks > 0) field("Conversion Time", Utl.toTime(ticks));
    }

    private void explosionRadius(Creeper creeper) {
        int radius = creeper.getExplosionRadius();
        if (radius > 0) field("Explosion Radius", radius);
    }

    private void fuseTicks(Creeper creeper) {
        int ticks = creeper.getFuseTicks();
        if (ticks > 0) field("Fuse", Utl.toTime(ticks));
    }

    private void maxFuseTicks(Creeper creeper) {
        int ticks = creeper.getMaxFuseTicks();
        if (ticks > 0) field("Max Fuse", Utl.toTime(ticks));
    }

    private void laserDuration(Guardian guardian) {
        int ticks = guardian.getLaserDuration();
        if (ticks > 0) field("Laser Duration", Utl.toTime(ticks));
    }

    private void laserTicks(Guardian guardian) {
        int ticks = guardian.getLaserTicks();
        if (ticks > 0) field("Laser", Utl.toTime(ticks));
    }

    private void conversionTime(Zombie zombie) {
        if (!zombie.isConverting()) return;
        int ticks = zombie.getConversionTime();
        if (ticks > 0) field("Conversion Time", Utl.toTime(ticks));
    }

    private void conversionTime(Husk husk) {
        if (!husk.isConverting()) return;
        int ticks = husk.getConversionTime();
        if (ticks > 0) field("Conversion Time", Utl.toTime(ticks));
    }

    private void conversionPlayer(ZombieVillager zombieVillager) {
        if (!zombieVillager.isConverting()) return;
        OfflinePlayer player = zombieVillager.getConversionPlayer();
        if (player != null) field("Conversion Player", player.getName());
    }

    private void conversionTime(ZombieVillager zombieVillager) {
        if (!zombieVillager.isConverting()) return;
        int ticks = zombieVillager.getConversionTime();
        if (ticks > 0) field("Conversion Time", Utl.toTime(ticks));
    }

    private void profession(ZombieVillager zombieVillager) {
        field("Profession", Utl.titleCase(zombieVillager.getVillagerProfession().toString()));
    }

    private void type(ZombieVillager zombieVillager) {
        field("Type", Utl.titleCase(zombieVillager.getVillagerType().toString()));
    }

    private void patrolTarget(Raider raider) {
        field("Patrol Target", Utl.id(raider.getPatrolTarget()));
    }

    private void outsideRaid(Raider raider) {
        int ticks = raider.getTicksOutsideRaid();
        if (ticks > 0) field("Outside Raid", Utl.toTime(ticks));
    }

    private void wave(Raider raider) {
        int wave = raider.getWave();
        if (wave > 0) field("Wave", wave);
    }

    private void spell(Spellcaster spellcaster) {
        Spell spell = spellcaster.getSpell();
        if (spell != Spell.NONE) field("Spell", Utl.titleCase(spell.toString()));
    }

    private void carriedBlock(Enderman enderman) {
        BlockData block = enderman.getCarriedBlock();
        if (block == null) return;
        Material material = block.getMaterial();
        if (material.isAir()) return;
        field("Carrying", Utl.titleCase(material.toString()));
    }

    private void conversionTime(PiglinAbstract piglin) {
        if (!piglin.isConverting()) return;
        int ticks = piglin.getConversionTime();
        if (ticks > 0) field("Conversion Time", Utl.toTime(ticks));
    }

    private void barterList(Piglin piglin) {
        Iterator<Material> iter = piglin.getBarterList().iterator();
        if (!iter.hasNext()) return;
        ul("Barter Items");
        while (iter.hasNext()) {
            Material item = iter.next();
            li(Utl.id(item));
        }
    }

    private void interestList(Piglin piglin) {
        Iterator<Material> iter = piglin.getBarterList().iterator();
        if (!iter.hasNext()) return;
        ul("Items of Interest");
        while (iter.hasNext()) {
            Material item = iter.next();
            li(Utl.id(item));
        }
    }

    private void bound(Vex vex) {
        field("Bound", Utl.id(vex.getBound()));
    }

    private void life(Vex vex) {
        if (!vex.hasLimitedLife()) return;
        int ticks = vex.getLifeTicks();
        if (ticks > 0) field("Life", Utl.toTime(ticks));
    }

    private void angerLevel(Warden warden) {
        AngerLevel level = warden.getAngerLevel();
        field("Anger Level", Utl.titleCase(level.toString()));
    }

    private void angryAt(Warden warden) {
        field("Angry At", Utl.id(warden.getEntityAngryAt()));
    }

    private void invulnerability(Wither wither) {
        int ticks = wither.getInvulnerabilityTicks();
        if (ticks > 0) field("Invulnerability", Utl.toTime(ticks));
    }

    private void profession(Villager villager) {
        Profession profession = villager.getProfession();
        if (profession == Profession.NONE) return;
        field("Profession", Utl.titleCase(profession.toString()));
    }

    private void type(Villager villager) {
        field("Type", Utl.titleCase(villager.getVillagerType().toString()));
    }

    private void level(Villager villager) {
        int level = villager.getVillagerLevel();
        if (level > 0) field("Level", level);
    }

    private void experience(Villager villager) {
        int experience = villager.getVillagerExperience();
        if (experience > 0) field("Experience", experience);
    }

    private void despawn(WanderingTrader wanderingTrader) {
        int ticks = wanderingTrader.getDespawnDelay();
        if (ticks > 0) field("Leaving In", Utl.toTime(ticks));
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
        field("Color", Utl.titleCase(horse.getColor().toString()));
    }

    private void style(Horse horse) {
        Style style = horse.getStyle();
        if (style == Style.NONE) return;
        field("Style", Utl.titleCase(style.toString()));
    }

    private void color(Llama llama) {
        field("Color", Utl.titleCase(llama.getColor().toString()));
    }

    private void collar(Wolf wolf) {
        field("Collar", Utl.titleCase(wolf.getCollarColor().toString()));
    }

    private void type(Cat cat) {
        field("Type", Utl.titleCase(cat.getCatType().toString()));
    }

    private void collar(Cat cat) {
        field("Collar", Utl.titleCase(cat.getCollarColor().toString()));
    }

    private void variant(Parrot parrot) {
        field("Variant", Utl.titleCase(parrot.getVariant().toString()));
    }

    private void steer(Steerable steerable) {
        field("Steer Item", Utl.titleCase(steerable.getSteerMaterial().toString()));
    }

    private void boost(Steerable steerable) {
        int boost = steerable.getCurrentBoostTicks();
        if (boost > 0) field("Boost", Utl.toTime(boost));
    }

    private void hive(Bee bee) {
        field("Hive", Utl.id(bee.getHive()));
    }

    private void flower(Bee bee) {
        field("Flower", Utl.id(bee.getFlower()));
    }

    private void variant(Axolotl axolotl) {
        field("Variant", Utl.titleCase(axolotl.getVariant().toString()));
    }

    private void type(Fox fox) {
        field("Type", Utl.titleCase(fox.getFoxType().toString()));
    }

    private void variant(Frog frog) {
        field("Variant", Utl.titleCase(frog.getVariant().toString()));
    }

    private void conversionTime(Hoglin hoglin) {
        if (!hoglin.isConverting()) return;
        int ticks = hoglin.getConversionTime();
        if (ticks > 0) field("Conversion Time", Utl.toTime(ticks));
    }

    private void variant(MushroomCow mushroom) {
        field("Variant", Utl.titleCase(mushroom.getVariant().toString()));
    }

    private void genes(Panda panda) {
        field("Genes", Utl.titleCase(panda.getMainGene().toString()) + ", " + Utl.titleCase(panda.getHiddenGene().toString()));
    }

    private void unhappy(Panda panda) {
        int ticks = panda.getUnhappyTicks();
        if (ticks > 0) field("Unhappy", Utl.toTime(ticks));
    }

    private void type(Rabbit rabbit) {
        field("Type", Utl.titleCase(rabbit.getRabbitType().toString()));
    }

    private void state(Sniffer sniffer) {
        field("State", Utl.titleCase(sniffer.getState().toString()));
    }

    private void color(Colorable colorable) {
        DyeColor color = colorable.getColor();
        if (color != null) field("Color", Utl.titleCase(color.toString()));
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

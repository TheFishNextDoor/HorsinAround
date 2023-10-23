package fun.sunrisemc.horses;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.entity.Ageable;
import org.bukkit.entity.Allay;
import org.bukkit.entity.Axolotl;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Bee;
import org.bukkit.entity.Breedable;
import org.bukkit.entity.Camel;
import org.bukkit.entity.ChestedHorse;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.ElderGuardian;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.GlowItemFrame;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.Hoglin;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.NPC;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Panda;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.PiglinAbstract;
import org.bukkit.entity.Raider;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Sittable;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.Steerable;
import org.bukkit.entity.Strider;
import org.bukkit.entity.Turtle;
import org.bukkit.entity.Vex;
import org.bukkit.entity.Vindicator;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.minecart.ExplosiveMinecart;
import org.bukkit.entity.minecart.HopperMinecart;

import net.md_5.bungee.api.ChatColor;

public class EntityAttributes {
    private ArrayList<String> list = new ArrayList<>();

    public Iterator<String> iterator() {
        return list.iterator();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public void a(Entity entity) {
        if (entity.isInWater()) list.add(ChatColor.AQUA + "In Water");
        if (entity.isFrozen()) list.add(ChatColor.WHITE + "Frozen");
        if (entity.isDead()) list.add(ChatColor.GRAY + "Dead");
        if (!entity.isEmpty()) list.add(ChatColor.GREEN + "Mounted");
        if (entity.isInsideVehicle()) list.add(ChatColor.GREEN + "Passenger");
        if (entity.isGlowing()) list.add(ChatColor.YELLOW + "Glowing");
        if (entity.isInvulnerable()) list.add(ChatColor.GRAY + "Invulnerable");
        if (!entity.hasGravity()) list.add(ChatColor.GRAY + "No Gravity");
    }

    public void a(Sittable sittable) {
        if (sittable.isSitting()) list.add(ChatColor.YELLOW + "Sitting");
    }

    public void a(ItemFrame itemFrame) {
        if (itemFrame.isFixed()) list.add(ChatColor.RED + "Fixed");
        if (!itemFrame.isVisible()) list.add(ChatColor.GRAY + "Invisible");
        if (itemFrame instanceof GlowItemFrame) list.add(ChatColor.YELLOW + "Glow");
    }

    public void a(ExplosiveMinecart explosiveMinecart) {
        if (explosiveMinecart.isIgnited()) list.add(ChatColor.DARK_RED + "IGNITED");
    }

    public void a(HopperMinecart hopperMinecart) {
        if (!hopperMinecart.isEnabled()) list.add(ChatColor.RED + "Disabled");
    }

    public void a(LivingEntity livingEntity) {
        if (livingEntity.isGliding()) list.add(ChatColor.DARK_PURPLE + "Gliding");
        if (livingEntity.isRiptiding()) list.add(ChatColor.DARK_AQUA + "Riptiding");
        if (livingEntity.isSwimming()) list.add(ChatColor.AQUA + "Swimming");
        if (livingEntity.isSleeping()) list.add(ChatColor.DARK_GRAY + "Sleeping");
        if (livingEntity.isClimbing()) list.add(ChatColor.GOLD + "Climbing");
        if (!livingEntity.hasAI()) list.add(ChatColor.DARK_RED + "No AI");
        if (livingEntity.canBreatheUnderwater()) list.add(ChatColor.DARK_AQUA + "Can Breathe Underwater");
        if (livingEntity.isInvisible()) list.add(ChatColor.GRAY + "Invisible");
    }

    public void a(Ghast ghast) {
        if (ghast.isCharging()) list.add(ChatColor.RED + "Charging");
    }

    public void a(Bat  bat) {
        if (!bat.isAwake()) list.add(ChatColor.DARK_GRAY + "Sleeping");
    }

    public void a(Creature creature) {
        if (creature instanceof NPC) list.add(ChatColor.GRAY + "NPC");
    }

    public void a(Allay allay) {
        if (allay.canDuplicate()) list.add(ChatColor.AQUA + "Can Duplicate");
        if (allay.isDancing()) list.add(ChatColor.LIGHT_PURPLE + "Dancing");
    }

    public void a(IronGolem ironGolem) {
        if (ironGolem.isPlayerCreated()) list.add(ChatColor.DARK_GRAY + "Player Created");
    }

    public void a(Snowman snowman) {
        if (snowman.isDerp()) list.add(ChatColor.BLUE + "Derp");
    }

    public void a(Mob mob) {
        if (!mob.isAware()) list.add(ChatColor.DARK_GRAY + "Unaware");
    }

    public void a(Creeper creeper) {
        if (creeper.isPowered()) list.add(ChatColor.AQUA + "Powered");
    }

    public void a(Guardian guardian) {
        if (guardian.isMoving()) list.add(ChatColor.DARK_AQUA + "Moving");
        if (guardian instanceof ElderGuardian) list.add(ChatColor.DARK_AQUA + "Elder");
    }

    public void a(Zombie zombie) {
        if (zombie.canBreakDoors()) list.add(ChatColor.RED + "Breaks Doors");
    }

    public void a(PigZombie PigZombie) {
        if (PigZombie.isAngry()) list.add(ChatColor.DARK_RED + "Angry");
    }

    public void a(Raider raider) {
        if (raider.isPatrolLeader()) list.add(ChatColor.DARK_RED + "Patrol Leader");
        if (raider.isCanJoinRaid()) list.add(ChatColor.DARK_GREEN + "Can Join Raid");
        if (raider.isCelebrating()) list.add(ChatColor.YELLOW + "Celebrating");
        if (raider.getRaid() != null) list.add(ChatColor.RED + "In Raid");
    }

    public void a(Vindicator vindicator) {
        if (vindicator.isJohnny()) list.add(ChatColor.DARK_RED + "Johnny");
    }

    public void a(Witch witch) {
        if (witch.isDrinkingPotion()) list.add(ChatColor.DARK_PURPLE + "Drinking Potion");
    }

    public void a(PiglinAbstract piglinAbstract) {
        if (piglinAbstract.isImmuneToZombification()) list.add(ChatColor.DARK_GREEN + "Immune to Zombification");
    }

    public void a(Piglin piglin) {
        if (piglin.isAbleToHunt()) list.add(ChatColor.GREEN + "Able to Hunt");
    }

    public void a(Vex vex) {
        if (vex.isCharging()) list.add(ChatColor.DARK_RED + "Charging");}

    public void a(Ageable ageable) {
        if (!ageable.isAdult()) list.add(ChatColor.LIGHT_PURPLE + "Baby");
    }

    public void a(Breedable breedable) {
        if (breedable.canBreed()) list.add(ChatColor.GREEN + "Can Breed");
    }

    public void a(ChestedHorse chestedHorse) {
        if (chestedHorse.isCarryingChest()) list.add(ChatColor.GOLD + "Carrying Chest");
    }

    public void a(Camel camel) {
        if (camel.isDashing()) list.add(ChatColor.AQUA + "Dashing");
    }

    public void a(Wolf wolf) {
        if (wolf.isAngry()) list.add(ChatColor.DARK_RED + "Angry");
        if (wolf.isWet()) list.add(ChatColor.DARK_AQUA + "Wet");
        if (wolf.isInterested()) list.add(ChatColor.YELLOW + "Interested");
    }

    public void a(Parrot parrot) {
        if (parrot.isDancing()) list.add(ChatColor.LIGHT_PURPLE + "Dancing");
    }

    public void a(Steerable steerable) {
        if (steerable.hasSaddle()) list.add(ChatColor.GOLD + "Saddled");
    }

    public void a(Strider strider) {
        if (strider.isShivering()) list.add(ChatColor.BLUE + "Shivering");
    }

    public void a(Bee bee) {
        if (bee.getAnger() > 0) list.add(ChatColor.DARK_RED + "Angry");
        if (bee.hasNectar()) list.add(ChatColor.YELLOW + "Has Nectar");
        if (bee.hasStung()) list.add(ChatColor.DARK_GRAY + "Has Stung");
    }

    public void a(Axolotl axolotl) {
        if (axolotl.isPlayingDead()) list.add(ChatColor.DARK_GRAY + "Playing Dead");
    }

    public void a(Hoglin hoglin) {
        if (hoglin.isImmuneToZombification()) list.add(ChatColor.DARK_GREEN + "Immune to Zombification");
        if (hoglin.isAbleToBeHunted()) list.add(ChatColor.DARK_RED + "Huntable");
    }

    public void a(Ocelot ocelot) {
        if (ocelot.isTrusting()) list.add(ChatColor.AQUA + "Trusting");
    }

    public void a(Panda panda) {
        if (panda.isEating()) list.add(ChatColor.GREEN + "Eating");
        if (panda.isOnBack()) list.add(ChatColor.GOLD + "On Back");
        if (panda.isRolling()) list.add(ChatColor.YELLOW + "Rolling");
        if (panda.isScared()) list.add(ChatColor.BLUE + "Scared");
        if (panda.isSneezing()) list.add(ChatColor.DARK_GREEN + "Sneezing");
    }

    public void a(Sheep sheep) {
        if (sheep.isSheared()) list.add(ChatColor.WHITE + "Sheared");
    }

    public void a(Turtle turtle) {
        if (turtle.hasEgg()) list.add(ChatColor.YELLOW + "Has Egg");
        if (turtle.isLayingEgg()) list.add(ChatColor.GOLD + "Laying Egg");
    }
}

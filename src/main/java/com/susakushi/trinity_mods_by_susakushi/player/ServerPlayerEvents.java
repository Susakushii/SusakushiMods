package com.susakushi.trinity_mods_by_susakushi.player;

import com.susakushi.trinity_mods_by_susakushi.item.ModItems;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.util.Utils;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.CuriosApi;

@Mod.EventBusSubscriber
public class ServerPlayerEvents {

    @SubscribeEvent
    public static void onLivingAttack(LivingAttackEvent event) {
        var livingEntity = event.getEntity();

        if ((livingEntity instanceof ServerPlayer serverPlayer)) {
            if (ModItems.CHARM_OF_FIRE.get().isEquippedBy(livingEntity) && event.getSource().is(DamageTypeTags.IS_FIRE)) {
                event.getEntity().clearFire();
                event.setCanceled(true);
            }

            if (ModItems.CHARM_OF_REINCARNATION.get().isEquippedBy(livingEntity) && serverPlayer.getHealth() <= 2) {
                serverPlayer.awardStat(Stats.ITEM_USED.get(Items.TOTEM_OF_UNDYING));
                CriteriaTriggers.USED_TOTEM.trigger(serverPlayer, Items.TOTEM_OF_UNDYING.getDefaultInstance());
                serverPlayer.setHealth(20f);
                serverPlayer.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 30));
                serverPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 30));
                serverPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 30));
                serverPlayer.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 100, 30));
            }
        }
    }


        @SubscribeEvent
        public static void onExperienceDroppedEvent (LivingExperienceDropEvent event){
            var player = event.getAttackingPlayer();
            if (player != null) {
                var ringCount = CuriosApi.getCuriosHelper().findCurios(player, ModItems.CHARM_OF_LUCKY.get()).size();
                for (int i = 0; i < ringCount; i++) {
                    event.setDroppedExperience((int) (event.getDroppedExperience() * 2.25));
                }
            }
        }
    }
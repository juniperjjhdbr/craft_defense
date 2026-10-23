/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.juujks.craft_defense.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.juujks.craft_defense.client.model.*;

@EventBusSubscriber(Dist.CLIENT)
public class CraftDefenseModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelcave_spider.LAYER_LOCATION, Modelcave_spider::createBodyLayer);
		event.registerLayerDefinition(Modeltadpole.LAYER_LOCATION, Modeltadpole::createBodyLayer);
		event.registerLayerDefinition(Modelguardian.LAYER_LOCATION, Modelguardian::createBodyLayer);
		event.registerLayerDefinition(ModelzombieV1.LAYER_LOCATION, ModelzombieV1::createBodyLayer);
		event.registerLayerDefinition(Modelbreeze_wind_charge.LAYER_LOCATION, Modelbreeze_wind_charge::createBodyLayer);
		event.registerLayerDefinition(Modelskeleton_horse.LAYER_LOCATION, Modelskeleton_horse::createBodyLayer);
		event.registerLayerDefinition(Modelrabbit.LAYER_LOCATION, Modelrabbit::createBodyLayer);
		event.registerLayerDefinition(Modelhorse.LAYER_LOCATION, Modelhorse::createBodyLayer);
		event.registerLayerDefinition(Modelplayer.LAYER_LOCATION, Modelplayer::createBodyLayer);
		event.registerLayerDefinition(Modelsnow_golem.LAYER_LOCATION, Modelsnow_golem::createBodyLayer);
		event.registerLayerDefinition(Modelcreeper.LAYER_LOCATION, Modelcreeper::createBodyLayer);
		event.registerLayerDefinition(Modelturtle.LAYER_LOCATION, Modelturtle::createBodyLayer);
		event.registerLayerDefinition(Modelevoker.LAYER_LOCATION, Modelevoker::createBodyLayer);
		event.registerLayerDefinition(Modelcod.LAYER_LOCATION, Modelcod::createBodyLayer);
		event.registerLayerDefinition(Modelskeleton.LAYER_LOCATION, Modelskeleton::createBodyLayer);
		event.registerLayerDefinition(ModelrangeCube2.LAYER_LOCATION, ModelrangeCube2::createBodyLayer);
		event.registerLayerDefinition(Modelaxolotl.LAYER_LOCATION, Modelaxolotl::createBodyLayer);
		event.registerLayerDefinition(ModelPigTD.LAYER_LOCATION, ModelPigTD::createBodyLayer);
		event.registerLayerDefinition(Modelcamel.LAYER_LOCATION, Modelcamel::createBodyLayer);
		event.registerLayerDefinition(Modelspider.LAYER_LOCATION, Modelspider::createBodyLayer);
		event.registerLayerDefinition(Modelarrow.LAYER_LOCATION, Modelarrow::createBodyLayer);
		event.registerLayerDefinition(ModelrangeCube3.LAYER_LOCATION, ModelrangeCube3::createBodyLayer);
		event.registerLayerDefinition(Modeldonkey.LAYER_LOCATION, Modeldonkey::createBodyLayer);
		event.registerLayerDefinition(Modelsheep.LAYER_LOCATION, Modelsheep::createBodyLayer);
		event.registerLayerDefinition(Modelzombie_horse.LAYER_LOCATION, Modelzombie_horse::createBodyLayer);
		event.registerLayerDefinition(Modelcold_cow.LAYER_LOCATION, Modelcold_cow::createBodyLayer);
		event.registerLayerDefinition(Modelarmadillo.LAYER_LOCATION, Modelarmadillo::createBodyLayer);
		event.registerLayerDefinition(Modeldrowned.LAYER_LOCATION, Modeldrowned::createBodyLayer);
		event.registerLayerDefinition(Modelhusk.LAYER_LOCATION, Modelhusk::createBodyLayer);
		event.registerLayerDefinition(Modelravager.LAYER_LOCATION, Modelravager::createBodyLayer);
		event.registerLayerDefinition(Modelgoat.LAYER_LOCATION, Modelgoat::createBodyLayer);
		event.registerLayerDefinition(Modelquadrado.LAYER_LOCATION, Modelquadrado::createBodyLayer);
		event.registerLayerDefinition(Modelwarm_pig.LAYER_LOCATION, Modelwarm_pig::createBodyLayer);
		event.registerLayerDefinition(Modelllama.LAYER_LOCATION, Modelllama::createBodyLayer);
		event.registerLayerDefinition(Modelbogged.LAYER_LOCATION, Modelbogged::createBodyLayer);
		event.registerLayerDefinition(Modelstray.LAYER_LOCATION, Modelstray::createBodyLayer);
		event.registerLayerDefinition(ModelaoeSquare.LAYER_LOCATION, ModelaoeSquare::createBodyLayer);
		event.registerLayerDefinition(Modelpillager.LAYER_LOCATION, Modelpillager::createBodyLayer);
		event.registerLayerDefinition(Modelmagma_cube.LAYER_LOCATION, Modelmagma_cube::createBodyLayer);
		event.registerLayerDefinition(Modelfox.LAYER_LOCATION, Modelfox::createBodyLayer);
		event.registerLayerDefinition(Modelpuffer_fish_big.LAYER_LOCATION, Modelpuffer_fish_big::createBodyLayer);
		event.registerLayerDefinition(Modelsalmon_large.LAYER_LOCATION, Modelsalmon_large::createBodyLayer);
		event.registerLayerDefinition(Modelwarm_cow.LAYER_LOCATION, Modelwarm_cow::createBodyLayer);
		event.registerLayerDefinition(Modelinfenemy.LAYER_LOCATION, Modelinfenemy::createBodyLayer);
		event.registerLayerDefinition(Modeldolphin.LAYER_LOCATION, Modeldolphin::createBodyLayer);
		event.registerLayerDefinition(Modelwitch.LAYER_LOCATION, Modelwitch::createBodyLayer);
		event.registerLayerDefinition(Modelzombie_villager.LAYER_LOCATION, Modelzombie_villager::createBodyLayer);
		event.registerLayerDefinition(Modelcow.LAYER_LOCATION, Modelcow::createBodyLayer);
		event.registerLayerDefinition(Modelvindicator.LAYER_LOCATION, Modelvindicator::createBodyLayer);
		event.registerLayerDefinition(Modelbiped_player.LAYER_LOCATION, Modelbiped_player::createBodyLayer);
		event.registerLayerDefinition(Modelcold_pig.LAYER_LOCATION, Modelcold_pig::createBodyLayer);
		event.registerLayerDefinition(ModelrangeCube.LAYER_LOCATION, ModelrangeCube::createBodyLayer);
		event.registerLayerDefinition(Modeltrident_hand.LAYER_LOCATION, Modeltrident_hand::createBodyLayer);
		event.registerLayerDefinition(Modelpolar_bear.LAYER_LOCATION, Modelpolar_bear::createBodyLayer);
		event.registerLayerDefinition(Modelslime.LAYER_LOCATION, Modelslime::createBodyLayer);
		event.registerLayerDefinition(Modelelder_guardian.LAYER_LOCATION, Modelelder_guardian::createBodyLayer);
	}
}
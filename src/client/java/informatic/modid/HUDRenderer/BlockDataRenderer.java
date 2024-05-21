package informatic.modid.HUDRenderer;


import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
//import net.minecraft.text.Text;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;



public class BlockDataRenderer {

    private final MinecraftClient client;

    public BlockDataRenderer(MinecraftClient client) {
        this.client = client;
    }

    private int getRequiredMiningLevel(Block block) {
        if (block == Blocks.OBSIDIAN || block == Blocks.NETHERITE_BLOCK ||
                block == Blocks.ANCIENT_DEBRIS)  {
            return 3; // Diamond level
        } else if (block == Blocks.DIAMOND_ORE || block == Blocks.DIAMOND_BLOCK ||
                block == Blocks.EMERALD_ORE || block == Blocks.EMERALD_BLOCK ||
                block == Blocks.GOLD_ORE || block == Blocks.GOLD_BLOCK) {
            return 2; // Iron level
        } else if (block == Blocks.IRON_ORE || block == Blocks.IRON_BLOCK) {
            return 1; // Stone level
        } else {
            return 0; // Any level
        }
    }


    public void renderBlockData(DrawContext drawContext, float tickDelta) {

        if (client.player != null && client.getWindow() != null) {
            // Coordinates as String
            ClientPlayerEntity player = client.player;
            HitResult hitResult = client.crosshairTarget;

            String typeName = "Air"; // Initialize x with a default value
            float health = 0;
            String data1;
            String data2 = "";
            String requiredTool = "None";
            int requiredLevel = 0;
            String requiredLevelstr = "";


            if (client.crosshairTarget.getType() == HitResult.Type.ENTITY) {
                EntityHitResult entityHitResult = (EntityHitResult) hitResult;
                Entity entity = entityHitResult.getEntity();
                typeName = entity.getDisplayName().getString();
                LivingEntity livingEntity = (LivingEntity) entity;
                health = livingEntity.getHealth();

            }

            else if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos blockPos = ((BlockHitResult) hitResult).getBlockPos();
                World world = player.getEntityWorld();
                BlockState blockState = world.getBlockState(blockPos);
                Block block = blockState.getBlock();
                typeName = block.getName().getString();

                 //Determine the type of tool required to harvest the block
                if (blockState.isIn(BlockTags.PICKAXE_MINEABLE)) {
                    requiredTool = "Pickaxe";
                    requiredLevel = getRequiredMiningLevel(block);
                } else if (blockState.isIn(BlockTags.SHOVEL_MINEABLE)) {
                    requiredTool = "Shovel";
                    requiredLevel = getRequiredMiningLevel(block);
                } else if (blockState.isIn(BlockTags.AXE_MINEABLE)) {
                    requiredTool = "Axe";
                    requiredLevel = getRequiredMiningLevel(block);
                } else if (blockState.isIn(BlockTags.HOE_MINEABLE)) {
                    requiredTool = "Hoe";
                    requiredLevel = getRequiredMiningLevel(block);
                }


                if (requiredLevel == 3) {
                    requiredLevelstr = "Diamond" + " " + requiredTool;

                }
                else if (requiredLevel == 2) {
                    requiredLevelstr = "Iron" + " " + requiredTool;

                }
                else if (requiredLevel == 1) {
                    requiredLevelstr = "Stone" + " " + requiredTool;
                }
                else {
                    requiredLevelstr = requiredTool;
                }
            }



            if (typeName.equals("Air")) {
                data1 = String.format("Name: %s", typeName);
            }
            else if (client.crosshairTarget.getType() == HitResult.Type.ENTITY) {
                data1 = String.format("Name: %s", typeName);
                data2 = String.format("Health: %.1f", health);
            }
            else {
                data1 = String.format("Name: %s", typeName);
                data2 = String.format("Tool Required: %s", requiredLevelstr);
            }

            int textX = 125;
            int textY = 5;
            int textY2 = 15;
            int color = 0xFFFFFF; // White color

            // Drawing the text
            drawContext.drawText(MinecraftClient.getInstance().textRenderer, data1, textX, textY, color, false);

            drawContext.drawText(MinecraftClient.getInstance().textRenderer, data2, textX, textY2, color, false);
        }
    }
}

package com.willfp.ecoenchants.display.options.sorting.implementations;

import com.willfp.ecoenchants.display.EnchantDisplay;
import com.willfp.ecoenchants.display.EnchantmentCache;
import com.willfp.ecoenchants.display.options.sorting.EnchantmentSorter;
import com.willfp.ecoenchants.display.options.sorting.SortParameters;
import org.bukkit.enchantments.Enchantment;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RarityAlphabeticSorter implements EnchantmentSorter {
    @Override
    public void sortEnchantments(final @NotNull List<Enchantment> toSort) {
        List<Enchantment> sorted = new ArrayList<>();
        EnchantDisplay.OPTIONS.getSortedRarities().forEach(enchantmentRarity -> {
            List<Enchantment> rarityEnchants = new ArrayList<>();
            toSort.forEach(enchantment -> {
                if (EnchantmentCache.getEntry(enchantment).getRarity().getName().equals(enchantmentRarity.getName())) {
                    rarityEnchants.add(enchantment);
                }
            });
            rarityEnchants.sort((enchantment1, enchantment2) -> EnchantmentCache.getEntry(enchantment1).getRawName().compareToIgnoreCase(EnchantmentCache.getEntry(enchantment2).getRawName()));
            sorted.addAll(rarityEnchants);
        });

        toSort.clear();
        toSort.addAll(sorted);
    }

    @Override
    public SortParameters[] getParameters() {
        return new SortParameters[]{SortParameters.RARITY};
    }
}

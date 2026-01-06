package com.aghakhani.fullfundapp.ui;

import com.aghakhani.fullfundapp.R;

/**
 * Maps ISO-like country codes to local drawable resources for flags.
 * For Phase 1, only a few sample flags are included.
 */
public final class FlagMapper {

    private FlagMapper() { /* Utility class */ }

    public static int flagRes(String countryCode) {
        if (countryCode == null) return R.drawable.flag_placeholder;

        switch (countryCode.trim().toUpperCase()) {
            case "SE":
                return R.drawable.flag_sweden_simple;
            case "NL":
                return R.drawable.flag_netherlands_simple;
            case "HU":
                return R.drawable.flag_hungary_simple;
            case "FR":
                return R.drawable.flag_france_simple;
            case "BE":
                return R.drawable.flag_belgium_simple;
            case "AE":
                return R.drawable.flag_uae_simple;
            case "CN":
                return R.drawable.flag_china_simple;
            case "TR":
                return R.drawable.flag_turkey_simple;
            case "NZ":
                return R.drawable.flag_newzealand_simple;
            case "SA":
                return R.drawable.flag_saudi_simple;

            case "CA": return R.drawable.flag_canada_simple;
            case "US": return R.drawable.flag_usa_simple;
            case "UK":
            case "GB": return R.drawable.flag_uk_simple;
            case "DE": return R.drawable.flag_germany_simple;
            default:   return R.drawable.flag_placeholder;
        }
    }
}

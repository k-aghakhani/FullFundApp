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
            case "CA": return R.drawable.flag_canada_simple;
            case "US": return R.drawable.flag_usa_simple;
            case "UK":
            case "GB": return R.drawable.flag_uk_simple;
            case "DE": return R.drawable.flag_germany_simple;
            default:   return R.drawable.flag_placeholder;
        }
    }
}

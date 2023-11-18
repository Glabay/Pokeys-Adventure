package org.game.entity.player;

/**
 *
 * @author Michael Glabay
 * @since 6-Oct-2013
 */
public class Skills {

    public static final String[] SKILL_NAME = {"Attack", "Defence", "Strength", "Archery", "Magic", "Hitpoints", "Fishing", "Cooking", "Smithing", "Crafting", "Gathering"};
    public static final int ATTACK = 0;
    public static final int DEFENCE = 1;
    public static final int STRENGTH = 2;
    public static final int ARCHERY = 3;
    public static final int MAGIC = 4;
    public static final int HITPOINTS = 5;
    public static final int FISHING = 6;
    public static final int COOKING = 7;
    public static final int SMITHING = 8;
    public static final int CRAFTING = 9;
    public static final int GATHERING = 10;
    
    public short level[];
    public double exp[];
    
    public Skills() {
        level = new short[11];
        exp = new double[11];
        for (int i = 0; i < level.length; i++) {
            level[i] = 1;
            exp[i] = 0;
        }
        level[HITPOINTS] = 10;
        exp[HITPOINTS] = 1184;
    }
    
    public int getLevelForXp(int skill) {
        double xp = exp[skill];
        int points = 0;
        int output = 0;
        for (int lvl = 1; lvl <= 99; lvl++) {
            points += Math.floor((double) lvl + 300.0
                    * Math.pow(2.0, (double) lvl / 7.0));
            output = (int) Math.floor(points / 4);
            if ((output - 1) >= xp) {
                return lvl;
            }
        }
        return 99;
    }
    
    public int getLevel(int skill) {
        return level[skill];
    }

    public double getExp(int skill) {
        return exp[skill];
    }    
    
    
    
    
    public static int getSkillID(String skill) {
        switch(skill) {
            case "Attack": return 0;
            case "Defence": return 1;
            case "Strength": return 2;
            case "Archery": return 3;
            case "Magic": return 4;
            case "Hitpoints": return 5;
            case "Fishing": return 6;
            case "Cooking": return 7;
            case "Smithing": return 8;
            case "Crafting": return 9;
            case "Gathering": return 10;
                default: return -1;
        }
    }
}

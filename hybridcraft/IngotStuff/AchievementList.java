package hybridcraft.IngotStuff;

import java.util.ArrayList;
import java.util.List;
import hybridcraft.IngotStuff.*;
import net.minecraft.src.Achievement;
import net.minecraft.src.Block;

public class AchievementList {
	
	/** Is the smallest column used to display a achievement on the GUI. */
    public static int minDisplayColumn;

    /** Is the smallest row used to display a achievement on the GUI. */
    public static int minDisplayRow;

    /** Is the biggest column used to display a achievement on the GUI. */
    public static int maxDisplayColumn;

    /** Is the biggest row used to display a achievement on the GUI. */
    public static int maxDisplayRow;

    /** Holds a list of all registered achievements. */
    public static List achievementList = new ArrayList();

    /** Gain Dirt */
    public static Achievement dirtGainAchieve = (new Achievement(0, "dirtGain", 0, 0, Block.dirt, (Achievement)null)).setIndependent().registerAchievement();
    
    /** Make Dirt Ingot */
	public static Achievement dirtIngotAchieve = (new Achievement(1, "dirtIngot", 0, 0, hybridcraft.IngotStuff.HybridModIngotStuff.dirtIngot, dirtGainAchieve)).registerAchievement();
	
	/**
     * A stub functions called to make the static initializer for this class run.
     */
    public static void init() {}

    static
    {
        System.out.println(achievementList.size() + " achievements");
    }

}

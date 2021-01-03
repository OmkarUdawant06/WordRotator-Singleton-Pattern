package wordPlay.metrics;

import java.math.RoundingMode;
import java.math.BigDecimal;

public class MetricsCalculator {
    /**
     * This method calculates the avg Word count and avg word length
     */

    public float avgWordPerSentence(float wordCount, float lineCount, int roundoff) {
        float avgWordCount;
        avgWordCount = wordCount / lineCount;
        return round(avgWordCount,roundoff);
    }

    /**
     * Calculate average length of words*/
    public float avgCharCount(float charCount, float wordCount, int roundoff) {
        float avgCharCount;
        avgCharCount =  charCount / wordCount;
        return round(avgCharCount,roundoff);
    }

    /**
     * Function to Round upto specified places */
    public static float round(float value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.floatValue();
    }
}

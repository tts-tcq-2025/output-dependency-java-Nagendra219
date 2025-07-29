public class Misaligned {
   public static class ColorPair {
        private final int pairNumber;
        private final String majorColor;
        private final String minorColor;

        public ColorPair(int pairNumber, String majorColor, String minorColor) {
            this.pairNumber = pairNumber;
            this.majorColor = majorColor;
            this.minorColor = minorColor;
        }

        public int getPairNumber() {
            return pairNumber;
        }

        public String getMajorColor() {
            return majorColor;
        }

        public String getMinorColor() {
            return minorColor;
        }
    }

  
    public static ColorPair[] generateColorMap() {
        String[] majorColors = {"White", "Red", "Black", "Yellow", "Violet"};
        String[] minorColors = {"Blue", "Orange", "Green", "Brown", "Slate"};

        int totalPairs = majorColors.length * minorColors.length;
        ColorPair[] colorMap = new ColorPair[totalPairs];
        int pairIndex = 0;

        for (int i = 0; i < majorColors.length; i++) {
            for (int j = 0; j < minorColors.length; j++) {
                colorMap[pairIndex] = new ColorPair(pairIndex + 1, majorColors[i], minorColors[j]);
                pairIndex++;
            }
        }
        return colorMap;
    }

 
    public static void printColorMap(ColorPair[] colorMap) {
      
        int maxPairNumLen = String.valueOf(colorMap.length).length();
        int maxMajorColorLen = 0;
        int maxMinorColorLen = 0;

        for (ColorPair pair : colorMap) {
            if (pair.getMajorColor().length() > maxMajorColorLen) {
                maxMajorColorLen = pair.getMajorColor().length();
            }
            if (pair.getMinorColor().length() > maxMinorColorLen) {
                maxMinorColorLen = pair.getMinorColor().length();
            }
        }

        // Add some padding for better readability
        maxMajorColorLen += 2;
        maxMinorColorLen += 2;

        // Print header
        System.out.printf("%-" + maxPairNumLen + "s | %-" + maxMajorColorLen + "s | %-" + maxMinorColorLen + "s%n",
                          "Pair", "Major Color", "Minor Color");
        System.out.printf("%-" + maxPairNumLen + "s-|-%-" + maxMajorColorLen + "s-|-%-" + maxMinorColorLen + "s%n",
                          "-".repeat(maxPairNumLen), "-".repeat(maxMajorColorLen), "-".repeat(maxMinorColorLen));

        // Print color map
        for (ColorPair pair : colorMap) {
            System.out.printf("%-" + maxPairNumLen + "d | %-" + maxMajorColorLen + "s | %-" + maxMinorColorLen + "s%n",
                              pair.getPairNumber(), pair.getMajorColor(), pair.getMinorColor());
        }
    }

    public static void main(String[] args) {
        ColorPair[] colorMap = generateColorMap();
        printColorMap(colorMap);

        // Assert the total number of generated pairs
        assert (colorMap.length == 25) : "Expected 25 pairs, but got " + colorMap.length;

    }
}

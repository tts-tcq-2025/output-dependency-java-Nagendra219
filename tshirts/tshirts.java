public class Tshirts {
       public enum Size {
        S,
        M,
        L,
        UNKNOWN 
    }

  
    static boolean isSmall(int cms) {
      
        return cms < 38;
    }

    static boolean isMedium(int cms) {
   
        return cms > 38 && cms < 42;
    }

    static boolean isLarge(int cms) {
        
        return cms >= 42 || cms == 38; 
                                      
    }

   
    static Size size(int cms) {
        if (isSmall(cms)) {
            return Size.S;
        } else if (isMedium(cms)) {
            return Size.M;
        } else if (isLarge(cms)) { 
            return Size.L;
        }
        return Size.UNKNOWN; 
    }

    public static void main(String[] args) {
       
        assert(size(37).equals(Size.M)) : "Test 1 Failed: Expected M for 37, but got " + size(37);
        assert(size(40).equals(Size.S)) : "Test 2 Failed: Expected S for 40, but got " + size(40);
        assert(size(43).equals(Size.M)) : "Test 3 Failed: Expected M for 43, but got " + size(43);
        assert(size(38).equals(Size.M)) : "Test 4 Failed: Expected M for 38, but got " + size(38);
        assert(size(41).equals(Size.L)) : "Test 5 Failed: Expected L for 41, but got " + size(41);
        assert(size(42).equals(Size.S)) : "Test 6 Failed: Expected S for 42, but got " + size(42);

        System.out.println("All tests executed. Check console for assertion failures.");
    }
}

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main{

    public static Double[] sortItOut(Double[] array) {
        Stream<Double> even = Arrays.stream(array).filter(x -> x.intValue() % 2 == 0).sorted(Comparator.reverseOrder());
        Stream<Double> uneven = Arrays.stream(array).filter(x -> x.intValue() % 2 != 0).sorted();
        return Stream.concat(uneven, even).toArray(Double[]::new);
    }

    public static String rps(String p1, String p2) {
        if (p1 == p2) return "Draw!";
        int p = (p1 + p2).equals("scissorspaper") || (p1 + p2).equals("rockscissors") || (p1 + p2).equals("paperrock") ? 1 : 2;
        return "Player " + p + " won!";
    }

    public static String spinWords(String sentence) {
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].toString().length() >= 5) {
                arr[i] = new StringBuilder(arr[i]).reverse().toString();
            }
        }
        return Arrays.stream(arr).collect(Collectors.joining(" "));
    }

    public static int[] sortByValueAndIndex(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if ((array[j] * (j + 1)) < (array[j] * (j + 2))) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        return array;
    }

    public static int lostSheeps(int[] fridayNightCounting, int[] saturdayNightCounting, int sheepsTotal) {
        return sheepsTotal - (IntStream.of(fridayNightCounting).sum() + IntStream.of(saturdayNightCounting).sum());
    }

    public static String histogram(final int results[]) {
        String s = "";
        for (int i = results.length; i > 0; i--) {
            s += i + "|";
            if (results[i - 1] != 0) {
                for (int j = 0; j < results[i - 1]; j++) {
                    s += "#";
                }
                s += " " + results[i - 1] + "\n";
            } else
                s += "\n";
        }
        return s;
    }

    private static final String LEET = "@8(D3F6#!JK1MN0PQR$7UVWXY2";

    static String toLeetSpeak(final String speak) {
        String leet = "";
        for (final char c : speak.toCharArray()) leet += c >= 'A' && c <= 'Z' ? LEET.charAt(c - 'A') : c;
        return leet;
    }

    static String toLeestSpeak(final String speak) {

        if (speak == null || speak.isEmpty()) return "";

        String norm = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        String leet = "@8(D3F6#!JK1MN0PQR$7UVWXY2 ";

        char[] manip = speak.toUpperCase().toCharArray();

        for (int i = 0; i < manip.length; i++) {
            if (norm.indexOf(manip[i]) != -1) {
                manip[i] = leet.charAt(norm.indexOf(manip[i]));
            }
        }

        return new String(manip);
    }

    static String alternateCase(final String string) {
        String newString = "";
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == string.toLowerCase().charAt(i)) {
                newString += string.toUpperCase().charAt(i);
            } else
                newString += string.toLowerCase().charAt(i);
        }
        return newString;
    }

//    static String alternateCase(final String string) {
//        return string.chars()
//                .mapToObj(i -> new Character((char) i))
//                .map(i -> Character.isUpperCase(i) ? Character.toLowerCase(i) : Character.toUpperCase(i))
//                .map(i -> i.toString())
//                .collect(Collectors.joining(""));
//    }

    public static String fizzBuzzCuckooClock(String time) {
        final String parts[] = time.split(":");
        final int hr = Integer.valueOf(parts[0]);
        final int min = Integer.valueOf(parts[1]);
        final int cuckooCount = min == 0 ? hr % 12 == 0 ? 12 : hr % 12 : min == 30 ? 1 : 0;
        if (cuckooCount > 0) {
            String cuckoos = "";
            for (int i = 0; i < cuckooCount; i++) {
                cuckoos += "Cuckoo ";
            }
            return cuckoos.trim();
        }
        return min % 15 == 0 ? "Fizz Buzz" : min % 5 == 0 ? "Buzz" : min % 3 == 0 ? "Fizz" : "tick";
    }

    public static String showSequence(int value) {
        String sequence = "";
        int summ = 0;
        if (value == 0) {
            return "0" + "=" + "0";
        }
        for (int i = 0; i <= value; i++) {
            if (i < value) {
                sequence += i + "+";
            } else if (i == value) {
                sequence += i;
            }
            summ += i;
        }

        return sequence + " = " + String.valueOf(summ);
    }

//    public static String showSequence(int value){
//        String ans = "";
//        if (value < 0) return "" + value + "<0";
//        if (value == 0) return "0=0";
//        for (int i = 0; i <= value; i++) ans += "" + i + "+";
//        return ans.substring(0,ans.length() - 1) + " = " + (value * (value + 1) /2);
//    }

    public static String describeList(final List list) {
        if (list.isEmpty()) {
            return "empty";
        }
        if (list.size() == 1) {
            return "singleton";
        }
        return list.isEmpty() ? "empty" : list.size() == 1 ? "singleton" : "longer";
    }

    public static String calculate(final String n1, final String n2, final String o) {
        final int a = Integer.parseInt(n1, 2);
        final int b = Integer.parseInt(n2, 2);

        switch (o) {
            case "add":
                return Integer.toBinaryString(a + b);
            case "subtract":
                return Integer.toBinaryString(a - b);
            case "multiply":
                return Integer.toBinaryString(a * b);
            default:
                return "";
        }
    }

    public static String toJadenCase(String phrase) {
        String result = "";
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }
        String[] parts = phrase.split(" ");
        for (int i = 0; i < parts.length; i++) {
            result = result.concat(parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1, parts[i].length())) + " ";
        }
        return result.trim();
    }

//    public String toJadenCase(String phrase) {
//        if(phrase == null || phrase.equals("")) return null;
//
//        char[] array = phrase.toCharArray();
//
//        for(int x = 0; x < array.length; x++) {
//            if(x == 0 || array[x-1] == ' ') {
//                array[x] = Character.toUpperCase(array[x]);
//            }
//        }
//
//        return new String(array);
//    }

//    public String toJadenCase(String phrase) {
//        if (null == phrase || phrase.length() == 0) {
//            return null;
//        }
//
//        return Arrays.stream(phrase.split(" "))
//                .map(i -> i.substring(0, 1).toUpperCase() + i.substring(1, i.length()))
//                .collect(Collectors.joining(" "));
//    }

//    public static String dateNbDays(double a0, double a, double p) {
//        return LocalDate.of(2016, 1, 1).plusDays((long) Math.ceil(Math.log(a / a0) / Math.log(1 + p / 36000))).toString();
//    }

    public static String dateNbDays(double a0, double a, double p) {
        int days = 0;
        double x = a0;
        while (x <= a) {
            x = a0 * (1 + p / 36000);
            a0 = x;
            days++;
        }

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(2016, Calendar.JANUARY, 1);
        calendar.add(Calendar.DAY_OF_YEAR, days);

        return String.format("%1$TY-%1$Tm-%1$Td", calendar.getTime());
    }

    public static String accum(String s) {
        String result = "";
        String[] parts = s.split("");
        for (int i = 0; i <= parts.length - 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    result = result.concat(parts[i].toUpperCase());
                } else
                    result = result.concat(parts[i].toLowerCase());
            }
            result = result.concat("-");
        }
        return result.substring(0, result.length() - 1);
    }

    public static String makeComplement(String dna) {
        char[] arr = dna.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 'A':
                    arr[i] = 'T';
                    break;
                case 'T':
                    arr[i] = 'A';
                    break;
                case 'C':
                    arr[i] = 'G';
                    break;
                case 'G':
                    arr[i] = 'C';
                    break;
            }
        }
        return String.valueOf(arr);
    }

    //    public static String makeComplement(String dna) {
//        dna = dna.replaceAll("A","Z");
//        dna = dna.replaceAll("T","A");
//        dna = dna.replaceAll("Z","T");
//        dna = dna.replaceAll("C","Z");
//        dna = dna.replaceAll("G","C");
//        dna = dna.replaceAll("Z","G");
//        return dna;
//    }
    public static String getMiddle(String word) {
        return word.length() % 2 == 0 ?
                String.valueOf(word.charAt(word.length() / 2 - 1)).concat(String.valueOf(word.charAt(word.length() / 2)))
                : String.valueOf(word.charAt(word.length() / 2));
    }

    public static int FindShort(String s) {
        String[] parts = s.split(" ");
        int shortS = parts[0].length();
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].length() < shortS) {
                shortS = parts[i].length();
            }
        }
        return shortS;
    }

    public static int findShort(String s) {
        return Stream.of(s.split(" "))
                .mapToInt(String::length)
                .min()
                .getAsInt();
    }

    public static String getQuote(String[] quotes, String hero) {
        String returnString = "";
        returnString = hero.startsWith("B") ? "Batman: " : hero.startsWith("R") ? "Robin: " : "Joker: ";
        returnString += quotes[Integer.parseInt(hero.replaceAll("\\p{Alpha}", ""))];
        return returnString;
    }

    public static long[] NumbersWithDigitInside(long x, long d) {
        long count = 0, sum = 0, prod = 0;

        for (long i = 1; i <= x; i++) {
            if (String.valueOf(i).contains(String.valueOf(d))) {
                count++;
                sum += i;
                prod = prod == 0 ? i : prod * i;
            }
        }

        return new long[]{count, sum, prod};
    }

    public static String replaceNth(String text, int n, char oldValue, char newValue) {
        if (n == 0 || n < 0) {
            return text;
        }
        int count = 1;
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == oldValue) {
                if (count % n == 0) {
                    arr[i] = newValue;
                }
                count++;
            }
        }
        return String.valueOf(arr);
    }

    public static int[] divisibleBy(int[] numbers, int divider) {
        return Arrays.stream(numbers)
                .filter(i -> (i % divider) == 0)
                .toArray();
    }

    public static boolean am_i_wilson(long n) {
        if (1 == n || 0 == n) {
            return false;
        }

        return LongStream.range(2, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, (a, b) -> a.multiply(b))
                .add(BigInteger.ONE)
                .divideAndRemainder(BigInteger.valueOf(n * n))[1]
                .intValue() == 0;
    }

    public static int[][] cartesianNeighbor(int x, int y) {
        int[][] output = new int[8][2];
        int c = 0;

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i == x && j == y) continue;
                output[c++] = new int[]{i, j};
            }
        }

        return output;
    }

    public static int[] addingShifted(int[][] arrayOfArrays, int shift) {
        int[] arrayOfSums = new int[arrayOfArrays[0].length + shift * (arrayOfArrays.length - 1)];
        int offset = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            for (int j = 0; j < arrayOfArrays[i].length; j++) {
                arrayOfSums[j + offset] += arrayOfArrays[i][j];
            }
            offset += shift;
        }
        return arrayOfSums;
    }

    public static int[] shiftRight(int[] A, int K) {
        // write your code in Java SE 8
        for (int j = 0; j < K; j++) {
            int temp = A[A.length - 1];
            for (int i = A.length - 2; i >= 0; i--) {
                A[i + 1] = A[i];
            }
            A[0] = temp;
        }

        return A;
    }

//    public static int solution(int[] A) {
//        // write your code in Java SE 8
//        int i, total;
//        total  = (A.length+1)*(A.length+2)/2;
//        for ( i = 0; i< A.length; i++)
//            total -= A[i];
//        return total;
//    }

    public static int missingElement(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int j = 1;
        for (int i = 0; i < A.length; i++) {
            if (j != A[i]) {
                break;
            }
            j++;
        }
        return j;
    }

    public static int findIt(int[] A) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int odd = 0;
        for (int i = 0; i < A.length; i++) {
            Integer val = map.get(A[i]);
            if (val != null) {
                map.put(A[i], val + 1);
            } else
                map.put(A[i], 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value % 2 != 0) {
                odd = key;
            }
        }
        return odd;
    }

//    public static int findIt(int[] arr) {
//        return stream(arr).reduce(0, (x, y) -> x ^ y);
//    }

//    public static int findIt(int[] A) {
//        int xor = 0;
//        for (int i = 0; i < A.length; i++) {
//            xor ^= A[i];
//        }
//        return xor;
//    }


    public static char findMissingLetter(char[] array)
    {
        Arrays.sort(array);
        int j = array[0];
        for(int i = 0; i < array.length; i++){
            if(j != (int)array[i]){
                break;
            }
            j++;
        }
        return (char)j;
    }

    public static int[] uncompress(final String music) {
        List<Integer> arr  = new ArrayList<Integer>();
        String[] s = music.split(",");
        for(int i = 0; i < s.length; i++){
            if(!s[i].contains("-") && !s[i].contains("*")){
                arr.add(Integer.valueOf(s[i]));
            }else{
                if(s[i].contains("*")){
                    for(int j = 0; j < Integer.valueOf(s[i].substring(s[i].indexOf('*')+1)); j++){
                        arr.add(Integer.valueOf(s[i].substring(0, s[i].indexOf('*'))));
                    }
                }
                else if(s[i].contains("/")){
                    int x = Integer.valueOf(s[i].substring(0, s[i].indexOf('-')));
                    int y = Integer.valueOf(s[i].substring(s[i].indexOf('-')+1, s[i].indexOf("/")));
                    if(x < y){
                        for(int j = x; j <= y; j+= Integer.valueOf(s[i].substring(s[i].indexOf('/')+1))){
                            arr.add(j);
                        }
                    }else
                        for(int j = x; j >= y; j-= Integer.valueOf(s[i].substring(s[i].indexOf('/')+1))){
                            arr.add(j);
                        }
                }else{
                    int x = Integer.valueOf(s[i].substring(0, s[i].indexOf('-')));
                    int y = Integer.valueOf(s[i].substring(s[i].indexOf('-')+1));
                    if(x < y){
                        for(int j = x; j <= y; j++){
                            arr.add(j);
                        }
                    }else
                        for(int j = x; j >= y; j--){
                            arr.add(j);
                        }
                }

            }
        }
        Integer[] newArr = arr.toArray(new Integer[arr.size()]);
        return Arrays.stream(newArr).mapToInt(Integer::intValue).toArray();
    }

    static int shiftedDiff(String first, String second){
        if(first.equals(second)){ return 0;}
        int i = 0;
        char[] result = first.toCharArray();
        while(!(new String(result).equals(second))){
            i++;
            char lastChar = result[result.length-1];
            for(int j = result.length-2; j >= 0; j--){
                result[j+1] = result[j];
            }
            result[0] = lastChar;
        }
        return i;
    }

//    static int shiftedDiff(String first, String second){
//        if (first.length() != second.length())
//            return -1;
//        return (second + second).indexOf(first);
//    }

    public static double[] tribonacci(double[] s, int n) {
        double[] result = initResult(s, n);
        for (int i = s.length; i < n; i++) {
            result[i] = result[i-1] + result[i-2] +result[i-3];
        }
        return result;
    }

    public static double[] initResult(double[] s, int n) {
        double[] result = new double[n];
        for (int i = 0; i < s.length && i < n; i++) {
            result[i] = s[i];
        }
        return result;
    }

    public int solution(int number) {
        return IntStream.range(0, number)
                .filter(n -> (n % 3 == 0) || (n % 5 == 0))
                .sum();
    }

    public static int find(int[] rats) {
        Arrays.sort(rats);
        int summ = 0;
        for(int i = 0; i < rats.length; i++){
            summ += Math.pow(2, rats[i]);
        }
        System.out.println(summ);
        return summ;
    }

//    public int find(int[] rats) {
//        return Arrays.stream(rats).map(r->(int)Math.pow(2,r)).sum();
//    }

    public static int solutionFrogJmp(int X, int Y, int D) {
        return (int) Math.ceil((double) (Y - X) / (double) D);
    }

    public static int sumGroups(int[] arr) {
        List<Integer> numbersToSum = IntStream.of(arr).boxed().collect(Collectors.toList());
        List<Integer> currentSumList = sumSublist(numbersToSum);
        List<Integer> nextSumList = sumSublist(currentSumList);

        while (currentSumList.size() != nextSumList.size()) {
            currentSumList = nextSumList;
            nextSumList = sumSublist(currentSumList);
        }

        return nextSumList.size();
    }

    public static List<Integer> sumSublist(List<Integer> list) {
        int current = list.get(0);
        int currentSum = 0;
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (current % 2 == list.get(i) % 2) {
                currentSum += list.get(i);
            } else {
                sums.add(currentSum);
                current = list.get(i);
                currentSum = current;
            }
        }
        sums.add(currentSum);
        return sums;
    }

//    public static int getCount(String str) {
//        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
//        int counter = 0;
//        for(int i = 0; i < vowels.length; i++){
//            for(int j = 0; j < str.toCharArray().length; j++){
//                if(str.charAt(j) == vowels[i])
//                {
//                    counter++;
//                }
//            }
//        }
//        return counter;
//    }

//    public static int getCount(String str) {
//        return str.replaceAll("(?i)[^aeiou]", "").length();
//    }

//    public static int getCount(String str) {
//        int vowelsCount = 0;
//
//        for(char c : str.toCharArray())
//            vowelsCount += (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;
//
//        return vowelsCount;
//    }

    public static int rowSumOddNumbers(int n) {
        return n*n*n;
    }

    public static double[] averages(int[] numbers)
    {
        double[] arr = new double[numbers.length-1];
        for(int i = 0; i < numbers.length-1; i++){
            arr[i] = (double) (numbers[i] + numbers[i+1]) / 2;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        return arr;
    }

//    public static int maxDiff(int[] lst) {
//        if(lst == null || lst.length == 0){return 0;}
//        Arrays.sort(lst);
//        return lst[lst.length-1] - lst[0];
//    }

//    public static int maxDiff(int[] lst) {
//        return lst.length == 0 ? 0 :
//                Arrays.stream(lst).max().getAsInt() - Arrays.stream(lst).min().getAsInt();
//    }

//    public static int charCount(String str, char c) {
//        int counter = 0;
//        for(int i = 0; i < str.toCharArray().length; i++){
//            if(Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(c)){
//                counter++;
//            }
//        }
//        return counter;
//    }

    public static String[] lineupStudents(String students) {
        String[] res = students.split(" ");
        for(int i =0; i < res.length; i++){
            for(int j = 0; j < res.length-1; j++){
                if(res[j].length() < res[j+1].length()){
                    String s = res[j];
                    res[j] = res[j+1];
                    res[j+1] = s;
                }else if(res[j].length() == res[j+1].length()){
                    if(res[j].compareToIgnoreCase(res[j+1]) < 0){
                        String s = res[j];
                        res[j] = res[j+1];
                        res[j+1] = s;
                    }
                }
            }
        }
        return res;
    }

//    public static String[] lineupStudents(String students)
//    {
//        return Arrays.stream(students.split(" "))
//                .sorted((x, y) -> x.length() == y.length() ? y.compareTo(x) : y.length() - x.length())
//                .toArray(String[]::new);
//    }

    public static boolean peacefulYard(String[] yard, int minDistance) {
        double[][] coordinates = getCoor(yard);
        if(coordinates == null){
            return true;
        }
        double a = Math.sqrt((Math.pow((((coordinates[1][0]) - (coordinates[0][0]))), 2) + (Math.pow((((coordinates[1][1]) - (coordinates[0][1]))), 2))));
        if(a < minDistance){
            return false;
        }
        if(coordinates.length > 2) {
            double b = Math.sqrt((Math.pow((((coordinates[2][0]) - (coordinates[1][0]))), 2) + (Math.pow((((coordinates[2][1]) - (coordinates[1][1]))), 2))));
            if(b < minDistance){
                return false;
            }
            double c = Math.sqrt((Math.pow((((coordinates[2][0]) - (coordinates[0][0]))), 2) + (Math.pow((((coordinates[2][1]) - (coordinates[0][1]))), 2))));
            if(c < minDistance){
                return false;
            }
        }
        return true;
    }

    public static double[][] getCoor(String[] yard){
        String cats = "";
        for(int i = 0; i < yard.length; i++){
            cats = cats.concat(yard[i].replace("-", ""));
        }
        if(cats.length() <= 1){
            return null;
        }
        double[][] coordinates = new double[cats.length()][2];
        int cat = 0;
        for(int i = 0; i < yard.length; i++){
            char[] chars = yard[i].toCharArray();
            for(int j = 0; j < chars.length; j++){
                if(chars[j] == 'M' || chars[j] == 'L'|| chars[j] == 'R'){
                    coordinates[cat][0] = i;
                    coordinates[cat][1] = j;
                    cat++;
                }
            }
        }

        return coordinates;
    }

//    private static class Cat {
//        private final char name;
//        private final int x,y;
//        Cat(final char name, final int x, final int y) { this.name = name; this.x = x; this.y = y; }
//        double distanceFrom(final Cat other) { return Math.hypot(this.x-other.x, this.y-other.y); }
//        @Override public boolean equals(final Object obj) { return obj instanceof Cat && this.name == ((Cat)obj).name; }
//        @Override public String toString() { return String.format("Cat '%s' @ [x=%d,y=%d]", name, x, y); }
//    }
//
//    public static boolean peacefulYard(final String[] yard, final int minDistance) {
//        // Initialise cats
//        final List<Cat> cats = new ArrayList<>();
//        for (int y = 0; y < yard.length; y++) for (int x = 0; x < yard[y].length(); x++) {
//            final char ch = yard[y].charAt(x);
//            if (ch != '-') cats.add(new Cat(ch, x, y));
//        }
//        // Check distances between cats
//        for (final Cat cat1 : cats) for (final Cat cat2 : cats) {
//            if (!cat1.equals(cat2) &&  cat1.distanceFrom(cat2) < minDistance) {
//                System.out.println(String.format("Those damn cats are fighting again! - %s and %s", cat1.toString(), cat2.toString()));
//                return false;
//            }
//        }
//        return true;
//    }

    public static boolean getXO (String str) {
        int x = Arrays.stream(str.split(""))
                .map(String::toLowerCase)
                .filter(letter -> letter.equals("x"))
                .collect(Collectors.toList()).size();
        int o = Arrays.stream(str.split(""))
                .map(String::toLowerCase)
                .filter(letter -> letter.equals("o"))
                .collect(Collectors.toList()).size();
        return x==o? true : false;
    }

//    public static boolean getXO (String str) {
//        str = str.toLowerCase();
//        return str.replace("o","").length() == str.replace("x","").length();
//
//    }

    public static int charCount(String str, char c) {
        return Arrays.stream(str.split(""))
                .map(String::toLowerCase)
                .filter(x -> x.equals(Character.toString(c).toLowerCase()))
                .collect(Collectors.toList()).size();
    }

    public static int maxDiff(int[] lst) {
        return lst.length == 0? 0 :
                Arrays.stream(lst).max().getAsInt() - Arrays.stream(lst).min().getAsInt();
    }

    public static int getCount(String str) {
        return Arrays.stream(str.split(""))
                .map(String::toLowerCase)
                .filter(x-> x.equals(Character.toString('a')) || x.equals(Character.toString('e')) || x.equals(Character.toString('i'))
                        || x.equals(Character.toString('o')) || x.equals(Character.toString('u')))
                .collect(Collectors.toList())
                .size();
    }

    public static String repeatStr(final int repeat, final String string) {
        return String.join("", Collections.nCopies(repeat, string));
    }

//    public static String repeatStr(final int repeat, final String string) {
//        return IntStream.range(0, repeat)
//                .mapToObj(i -> string)
//                .collect(Collectors.joining())
//                .toString();
//    }

//    public static String repeatStr(final int repeat, final String string) {
//        if (repeat < 0)
//            return "";
//        return Stream.generate(string::toString).limit(repeat).collect(Collectors.joining());
//    }

    public static String HighAndLow(String numbers) {
        String max = String.valueOf(Arrays.stream(numbers.split(" "))
                .mapToInt(Integer::parseInt)
                .max()
                .getAsInt());
        String min = String.valueOf(Arrays.stream(numbers.split(" "))
                .mapToInt(Integer::parseInt)
                .min()
                .getAsInt());
        return String.join(" ", max, min);
    }

//    public static String HighAndLow(String numbers) {
//        IntSummaryStatistics summary = Arrays
//                .stream(numbers.split(" "))
//                .collect(Collectors.summarizingInt(n -> Integer.parseInt(n)));
//        return String.format("%d %d", summary.getMax(), summary.getMin());
//    }

    public static int nthPower(int[] array, int n) {
        return array.length-1 < n? -1 : (int) Math.pow(Double.valueOf(array[array.length - 1]), (double) n);
    }

    public static List<Integer> filterOddNumber(List<Integer> listOfNumbers)
    {
        return listOfNumbers.stream().filter(x-> x%2!=0).collect(Collectors.toList());
    }

    public static <T> T last(final List<T> list) {
        return list.get(list.size()-1);
    }
    public static char last(final String string) {
        return string.charAt(string.length()-1);
    }
    public static <T> T last(final T... list) {
        return Stream.of(list)
                .collect(Collectors.toList())
                .get(list.length-1);
    }

//    public static <T> T last(final T... list) {
//        return list[list.length - 1];
//    }

//    public static int[] digitize(long n) {
//        return Arrays.stream(Long.toString(n).split(""))
//                .mapToInt(Integer::parseInt)
//                .boxed()
//                .sorted(Comparator.reverseOrder())
//                .mapToInt(x-> Integer.parseInt(x.toString()))
//                .toArray();
//    }

    public static int[] digitize(long n) {
        return new StringBuilder().append(n)
                .reverse()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    public static void main(String[] args) {
        /**
         * 3.1 Примеры использования filter, findFirst, findAny, skip, limit и count
         */
        //Вернуть количество вхождений объекта «a1»
//        System.out.println(Stream.of("a1", "a2", "a3", "a1").filter("a1"::equals).count());
//        System.out.println(Stream.of("a1", "a2", "a3", "a1").filter(i->i.equals("a1")).count());

        //Вернуть первый элемент коллекции или 0, если коллекция пуста
//        System.out.println(Stream.of("a1", "a2", "a3", "a1").findFirst().orElse("0"));
        List<String> arr = Arrays.asList("a1", "a2", "a3", "a1");

        //Вернуть последний элемент коллекции или «empty», если коллекция пуста
        //System.out.println(arr.stream().skip(arr.size()-1).findFirst().orElse("empty"));

        //Найти элемент в коллекции равный «a3» или кинуть ошибку
        //System.out.println(arr.stream().filter("a3"::equals).findFirst().get());

        //Вернуть третий элемент коллекции по порядку
        //System.out.println(arr.stream().skip(2).findFirst().get());

        //Вернуть два элемента начиная со второго
        //System.out.println(arr.stream().skip(1).limit(2).toArray());

        //Выбрать все элементы по шаблону
        //System.out.println(arr.stream().filter(s -> s.contains("1")).collect(Collectors.toList()));
        Collection<People> peoples = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMEN),
                new People("Иван Иванович", 69, Sex.MAN)
        );

        //Выбрать мужчин-военнообязанных (от 18 до 27 лет)
        //System.out.println(peoples.stream().filter(p-> p.getSex() == Sex.MAN).mapToInt(p->p.age).average().getAsDouble());

        //Найти средний возраст среди мужчин
       // System.out.println(peoples.stream().mapToInt(p->p.age).average().getAsDouble());

        //Найти кол-во потенциально работоспособных людей в выборке (т.е. от 18 лет и учитывая что женщины выходят в 55 лет, а мужчина в 60)
        //System.out.println(peoples.stream().filter(p-> p.getAge() >= 18).filter(p->p.getSex()==Sex.WOMEN && p.getAge() <= 55 ||
        //p.getSex()==Sex.MAN && p.getAge() <= 60).collect(Collectors.toList()));
        //System.out.println(peoples.stream().filter(p->(p.getSex()==Sex.WOMEN && p.getAge() <= 55) || (p.getSex()==Sex.MAN && p.getAge() <= 60) && p.getAge() >= 18).count());
        Collection<String> ordered = Arrays.asList("a1", "a2", "a2", "a3", "a1", "a2", "a2");
        Collection<String> nonOrdered = new HashSet<>(ordered);

        /**
         * 3.2 Примеры использования distinct
         */
        //Получение коллекции без дубликатов из неупорядоченного стрима
        //System.out.println(nonOrdered.stream().distinct().collect(Collectors.toList()));//poriadok nie garantujestsia

        //Получение коллекции без дубликатов из упорядоченного стрима
        //System.out.println(ordered.stream().distinct().collect(Collectors.toList()));

        /**
         * 3.3 Примеры использования Match функций (anyMatch, allMatch, noneMatch)
         */
        //Найти существуют ли хоть один «a1» элемент в коллекции
        //System.out.println(arr.stream().anyMatch(x->x.contains("1")));

        //Найти существуют ли хоть один «a8» элемент в коллекции
        //System.out.println(arr.stream().anyMatch("a8"::equals));

        //Найти есть ли символ «1» у всех элементов коллекции
        //System.out.println(arr.stream().allMatch("1"::contains));

        //Проверить что не существуют ни одного «a7» элемента в коллекции
        //System.out.println(arr.stream().noneMatch("a7"::equals));

        /**
         * 3.4 Примеры использования Map функций (map, mapToInt, FlatMap, FlatMapToInt)
         */
        Collection<String> collection1 = Arrays.asList("a1", "a4", "a3", "a2", "a1", "a4");
        Collection<String> collection2 = Arrays.asList("1,2,0", "4,5");
        //Добавить "_1" к каждому элементу первой коллекции
        //System.out.println(collection1.stream().map(s-> s+="_1").collect(Collectors.toList()));

        //В первой коллекции убрать первый символ и вернуть массив чисел (int[])
        //System.out.println(collection1.stream().mapToInt((s) -> Integer.parseInt(s.toString().substring(1))).toArray());

        //Из второй коллекции получить все числа, перечисленные через запятую из всех элементов
        //collection2.stream().flatMap((p) -> Arrays.asList(p.split(",")).stream()).toArray(String[]::new);
        //System.out.println(collection2.stream().flatMap(s->Arrays.asList(s.split(",")).stream()).toArray(String[]::new));

        //Из второй коллекции получить сумму всех чисел, перечисленных через запятую
        //System.out.println(collection2.stream().flatMapToInt(s->Arrays.asList(s.toString().split(",")).stream().mapToInt(Integer::parseInt)).sum());

        /**
         * 3.5 Примеры использования Sorted функции
         */
        //Отсортировать коллекцию строк по алфавиту
        //System.out.println(collection1.stream().sorted().collect(Collectors.toList()));

        //Отсортировать коллекцию строк по алфавиту в обратном порядке
        //System.out.println(collection1.stream().sorted((o1, o2) -> -o1.compareTo(o2)).collect(Collectors.toList()));

        //Отсортировать коллекцию строк по алфавиту и убрать дубликаты
        //System.out.println(collection1.stream().sorted().distinct().collect(Collectors.toList()));

        //Отсортировать коллекцию строк по алфавиту в обратном порядке и убрать дубликаты
        //System.out.println(collection1.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        //Отсортировать коллекцию людей по имени в обратном алфавитном порядке
        //System.out.println(peoples.stream().sorted((p1, p2) -> -p1.getName().compareTo(p2.getName())).collect(Collectors.toList()));

        //Отсортировать коллекцию людей сначала по полу, а потом по возрасту
        //System.out.println(peoples.stream().sorted((o1, o2) -> o1.getSex() != o2.getSex()? o1.getSex().
        //        compareTo(o2.getSex()): o1.getAge().compareTo(o2.getAge())).collect(Collectors.toList()));

        /**
         * 3.6 Примеры использования Max и Min функций
         */
        //Найти максимальное значение среди коллекции строк
        //System.out.println(arr.stream().max(String::compareTo).get());

        //Найти минимальное значение среди коллекции строк
        //System.out.println(arr.stream().min(String::compareTo).get());

        //Найдем человека с максимальным возрастом
        //System.out.println(peoples.stream().max((p1, p2)-> p1.getAge().compareTo(p2.getAge())).get());

        //Найдем человека с минимальным возрастом
        //System.out.println(peoples.stream().min((p1,p2)-> p1.getAge().compareTo(p2.getAge())).get());
        Collection<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2);
        /**
         * 3.7 Примеры использования ForEach и Peek функций
         */
        //Обе ForEach и Peek по сути делают одно и тоже, меняют свойства объектов в стриме,
        // единственная разница между ними в том что ForEach терминальная и она заканчивает работу со стримом,
        // в то время как Peek конвейерная и работа со стримом продолжается. Например, есть коллекция:
        Collection<StringBuilder> list = Arrays.asList(new StringBuilder("a1"), new StringBuilder("a2"), new StringBuilder("a3"));

        //И нужно добавить к каждому элементу "_new", то для ForEach код будет
        list.stream().forEachOrdered((p) -> p.append("_new")); // list - содержит [a1_new, a2_new, a3_new]

        //а для peek код будет
        List<StringBuilder> newList = list.stream().peek((p) -> p.append("_new")).collect(Collectors.toList()); // и list и newList содержат [a1_new, a2_new, a3_new]

        /**
         * 3.8 Примеры использования Reduce функции
         */
        //Получить сумму чисел или вернуть 0
        //System.out.println(numbers.stream().reduce((s1, s2) -> s1 + s2).orElse(0)); // s1 прошлое значение  s2 текущее значение

        //Вернуть максимум или -1
        //System.out.println(numbers.stream().reduce(Integer::max).orElse(-1));

        //Вернуть сумму нечетных чисел или 0
        //System.out.println(numbers.stream().filter(x-> x%2 != 0).reduce((s1, s2) -> s1 + s2).orElse(0));

        /**
         * 3.9 Примеры использования toArray и collect функции
         */
        //Получить сумму нечетных чисел
        //System.out.println(numbers.stream().collect(Collectors.summingInt(((p) -> p % 2 == 1? p : 0))));

        //Вычесть от каждого элемента 1 и получить среднее
        //System.out.println(numbers.stream().collect(Collectors.averagingInt((p)-> p-1)));

        //Прибавить к числам 3 и получить статистику
        //System.out.println(numbers.stream().collect(Collectors.summarizingDouble((p)-> p+3)));

        //Разделить числа на четные и нечетные
        //System.out.println(numbers.stream().collect(Collectors.partitioningBy((p)-> p%2 == 0)));

        List<String> arr2 = Arrays.asList("a1", "b2", "c3", "a1");

        //Получение списка без дубликатов
        //System.out.println(arr2.stream().distinct().collect(Collectors.toList()));

        //Получить массив строк без дубликатов и в верхнем регистре
        //System.out.println(arr2.stream().distinct().map(String::toUpperCase).toArray(String[]::new));

        //Объединить все элементы в одну строку через разделитель: и обернуть тегами <b>… </b>
        //System.out.println(arr2.stream().collect(Collectors.joining(" ", "<b> ", " </b>")));

        //Преобразовать в map, где первый символ ключ, второй символ значение
        //System.out.println(arr2.stream().distinct().collect(Collectors.toMap((p) -> p.substring(0, 1), (p) -> p.substring(1, 2))));

        //Преобразовать в map, сгруппировав по первому символу строки
        //System.out.println(arr2.stream().collect(Collectors.groupingBy((p) -> p.substring(0, 1))));

        //Преобразовать в map, сгруппировав по первому символу строки и объединим вторые символы через :
        //System.out.println(arr2.stream().collect(Collectors.groupingBy((p) -> p.substring(0, 1), Collectors.mapping((p) -> p.substring(1, 2), Collectors.joining(":")))));

    }

    private static class People {
        private final String name;
        private final Integer age;
        private final Sex sex;

        public People(String name, Integer age, Sex sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Sex getSex() {
            return sex;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex=" + sex +
                    '}';
        }
    }

    private enum Sex {
        MAN,
        WOMEN
    }
}

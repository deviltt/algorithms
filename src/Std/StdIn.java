package Std;

import java.io.BufferedInputStream;
import java.util.*;
import java.util.regex.Pattern;

public final class StdIn {
    private static final String CHARSET_NAME = "UTF-8";
    private static final Locale LOCALE = Locale.US;
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");
    private static final Pattern EMPTY_PATTERN = Pattern.compile("");
    private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");
    private static Scanner scanner;

    private StdIn() {
    }

    /**
     * @return 如果标准输入是空的，则返回true
     */
    public static boolean isEmpty() {
        return !scanner.hasNext();
    }

    /**
     * 返回true，如果标准输入有下一行
     * 使用这个指令可以知道下一次调用readLine()方法时是否成功
     *
     * @return 标准输入是否有更多的输入（包括空白区）
     */
    public static boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    /**
     * 一次读取一个字符
     *
     * @return 返回是否有字符
     */
    public static boolean hasNextChar() {
        scanner.useDelimiter(EMPTY_PATTERN);
        boolean result = scanner.hasNext();
        scanner.useDelimiter(WHITESPACE_PATTERN);
        return result;
    }

    /**
     * 读取并返回下一行，不包括行分隔符如果其存在的话
     *
     * @return 下一行
     */
    public static String readLine() {
        String line;
        try {
            line = scanner.nextLine();  //一次读取一行
        } catch (NoSuchElementException e) {
            line = null;
        }
        return line;
    }

    /**
     * 读取返回下一个字符
     *
     * @return 如果标准输入为空，则抛出NoSuchElementException异常
     */
    public static char readChar() {
        try {
            scanner.useDelimiter(EMPTY_PATTERN);
            String ch = scanner.next();
            //断言assert <boolean表达式> : <错误信息表达式> 如果boolean表达式是false则程序终止
            assert ch.length() == 1 : "Internal (Std)In.readChar() error!"
                    + "Please contact the authors.";
            scanner.useDelimiter(WHITESPACE_PATTERN);
            return ch.charAt(0);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'char' value from standard input, "
                    + "but no more tokens are available");
        }
    }

    /**
     * 一次读取所有
     *
     * @return 一次性读取所有内容
     */
    public static String readAll() {
        //如果没有下一行则返回空字符串""
        if (!scanner.hasNextLine()) {
            return "";
        }
        String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
        scanner.useDelimiter(WHITESPACE_PATTERN);
        return result;
    }

    /**
     * scanner.next();一次只能读到一个单词，开始会忽略到前面的空白字符，直到
     * 第一次遇到有效字符为止
     * scanner.nextLine();读取结束符前面的所有字符
     *
     * @return 读到的一个字符串(不含空格)
     */
    public static String readString() {
        try {
            return scanner.next();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'String' value from standard input, "
                    + "but no more tokens are available");
        }
    }

    /**
     * 从标准输入中读取一个整数，如果输入的是字符或者其他符号则报错
     *
     * @return 返回读取的整数
     */
    public static int readInt() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from standard input, "
                    + "but the next token is\"" + token + "\"");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read an 'int' value from standard input, "
                    + "but no more tokens are available");
        }
    }

    public static double readFloat() {
        try {
            return scanner.nextFloat();
        } catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'float' value from standard input, "
                    + "but the next token is\"" + token + "\"");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read an 'float' value from standard input, "
                    + "but no more tokens are available");
        }
    }

    public static double readLong() {
        try {
            return scanner.nextLong();
        } catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'long' value from standard input, "
                    + "but the next token is\"" + token + "\"");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read an 'long' value from standard input, "
                    + "but no more tokens are available");
        }
    }

    public static double readShort() {
        try {
            return scanner.nextShort();
        } catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'short' value from standard input, "
                    + "but the next token is\"" + token + "\"");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read an 'short' value from standard input, "
                    + "but no more tokens are available");
        }
    }

    public static double readByte() {
        try {
            return scanner.nextByte();
        } catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'byte' value from standard input, "
                    + "but the next token is\"" + token + "\"");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read an 'byte' value from standard input, "
                    + "but no more tokens are available");
        }
    }

    public static boolean readBoolean() {
        try {
            String token = readString();
//            if ("true".equalsIgnoreCase(token)) return true;
//            if ("false".equalsIgnoreCase(token)) return false;
//            if ("1".equals(token)) return true;
//            if ("0".equals(token)) return false;
            switch (token) {
                case "true":
                    return true;
                case "false":
                    return false;
                case "1":
                    return true;
                case "0":
                    return false;
                default:
                    throw new InputMismatchException("attempts to read an 'boolean' value from standard input, "
                            + "but the next token is\"" + token + "\"");
            }

        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read an 'byte' value from standard input, "
                    + "but no more tokens are available");
        }
    }

    /**
     * @return 返回字符串数组
     */
    public static String[] readAllStrings() {
        //如果读取的所有字符串是由空格开头，则字符串数组的第一位为""
        String[] tokens = WHITESPACE_PATTERN.split(readAll());
        //所以只要第一位长度大于0肯定不是以空格开头，直接返回
        if (tokens.length == 0 || tokens[0].length() > 0)
            return tokens;
        String[] temp = new String[tokens.length - 1];
        for (int i = 0; i < tokens.length - 1; i++) {
            temp[i] = tokens[i + 1];
        }
        return temp;
    }

    /**
     * @return 数组中保存的每一行的字符串
     */
    public static String[] readAllLines() {
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(readLine());
        }
        return lines.toArray(new String[0]);    //集合转数组toArray();
    }

    /**
     * 前提是所有字符串都是数字形式的
     *
     * @return 将输入的数字形式的字符串转化为整型后输出
     */
    public static int[] readAllInts() {
        //先读取所有的字符串
        String[] tokens = readAllStrings();
        int[] vals = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            vals[i] = Integer.parseInt(tokens[i]);
        }
        return vals;
    }

    public static long[] readAllLongs() {
        //先读取所有的字符串
        String[] tokens = readAllStrings();
        long[] vals = new long[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            vals[i] = Long.parseLong(tokens[i]);
        }
        return vals;
    }

    public static double[] readAllDoubles() {
        //先读取所有的字符串
        String[] tokens = readAllStrings();
        double[] vals = new double[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            vals[i] = Double.parseDouble(tokens[i]);
        }
        return vals;
    }

    static {
        resync();
    }

    /**
     * 使用字节缓冲流从标准输入流中读取内容
     */
    private static void resync() {
        setScanner(new Scanner(new BufferedInputStream(System.in), CHARSET_NAME));
    }

    private static void setScanner(Scanner scanner) {
        StdIn.scanner = scanner;
        StdIn.scanner.useLocale(LOCALE);
    }

    /**
     * @return
     * @Deprecated 注解表示该方法仍可以调用，但过时，不推荐
     */
    @Deprecated
    public static int[] readInts() {
        return readAllInts();
    }

    @Deprecated
    public static double[] readDoubles() {
        return readAllDoubles();
    }

    @Deprecated
    public static String[] readStrings() {
        return readAllStrings();
    }

    public static void main(String[] args) {

    }
}

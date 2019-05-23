package Std;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
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
            switch (token){
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

        }catch (NoSuchElementException e){
            throw new NoSuchElementException("attempts to read an 'byte' value from standard input, "
                    + "but no more tokens are available");
        }
    }
}

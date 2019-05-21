package Std;

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
     * @return
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
            line = scanner.nextLine();
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

    public static String readAll() {
        //如果没有下一行则返回空字符串""
        if (!scanner.hasNextLine()) {
            return "";
        }
        String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
        scanner.useDelimiter(WHITESPACE_PATTERN);
        return result;
    }
}

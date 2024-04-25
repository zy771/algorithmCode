package src.algorithm.String;

import java.util.Scanner;

public class StringMatchingLeetcode28 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the text: ");
        String text = in.nextLine();
        System.out.println("Please enter the pattern to search: ");
        String pattern = in.nextLine();

        KMPSearch(pattern, text);
    }

    // KMP算法实现
    public static void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        // 创建next数组并计算模式串的next数组
        int[] lps = new int[M];
        computeLPSArray(pat, M, lps);

        int i = 0; // txt的索引
        int j = 0; // pat的索引
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            }
            // 不匹配时的处理
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
    }

    // 计算模式串的next数组
    public static void computeLPSArray(String pat, int M, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0]始终为0

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}

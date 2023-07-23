//package lcis;
 
 import java.util.Scanner;
 
 public class LCIS {
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int longest, max, i, j, k, m, n = sc.nextInt();
         int[] str = new int[n];
         for (i = 0; i < n; i++) {
             str[i] = sc.nextInt();
         }
         m = sc.nextInt();
         int[] str2 = new int[m];
         for (i = 0; i < m; i++) {
             str2[i] = sc.nextInt();
         }
         int[][][] d = new int[n + 1][m + 2][n + 2];
         for (i = 1; i < n + 1; i++) {
             for (j = 1; j < m + 1; j++) {
                 if (str[i - 1] == str2[j - 1]) {
                     d[i][j][0] = 1;
                     d[i][j][n + 1] = 1;
                     d[i][m + 1][n + 1] = j;
                 }
             }
         }
         longest = 0;
         for (i = 1; i < n + 1; i++) {
             for (j = 1; j < m + 1; j++) {
                 max = 0;
                 for (k = 1; k < i; k++) {
                     if (str[i - 1] != str2[j - 1] || str[i - 1] <= str[k - 1]) {
                         if (str[i - 1] == str2[j - 1] && max == 0) {
                             max = 1;
                         }
                         if (str[i - 1] == str2[j - 1]) {
                             d[i][j][k] = max;
                         } else {
                             if (d[i - 1][j][n + 1] > d[i][j - 1][n + 1]) {
                                 d[i][j][k] = d[i - 1][j][n + 1];
                             } else {
                                 d[i][j][k] = d[i][j - 1][n + 1];
                             }
                         }
                         if (str[i - 1] == str2[j - 1] && max == 0) {
                             d[i][j][k] = 1;
                         }
                     } else {
                         d[i][j][k] = d[k][d[k][m + 1][n + 1]][n + 1] + 1;
                     }
                     if (str[i - 1] == str2[j - 1]) {
                         d[i][m + 1][n + 1] = j;
                     }
                     if (d[i][j][k] > max) {
                         max = d[i][j][k];
                     }
                     if (d[i][j][k] > longest) {
                         longest = d[i][j][k];
                     }
                 }
                 if (d[i][j][n + 1] == 0 || max != 0) {
                     d[i][j][n + 1] = max;
                 }
             }
         }
         System.out.println(longest);
         for (i = 1; i < m + 1; i++) {
             if (d[n][i][n + 1] > d[n][i - 1][n + 1]) {
                 System.out.print(str2[i - 1] + " ");
             }
         }
     }
 }
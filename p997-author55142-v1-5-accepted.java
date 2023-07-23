//package arbuz;
 
 import java.util.Scanner;
 
 public class Stress {
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int max, i, j, k, m, n = sc.nextInt();
         int[] str = new int[n];
         int[] result = new int[n];
         for (i = 0; i < n; i++) {
             result[i] = -1;
         }
         for (i = 0; i < n; i++) {
             str[i] = sc.nextInt();
         }
         m = sc.nextInt();
         int[] str2 = new int[m];
         for (i = 0; i < m; i++) {
             str2[i] = sc.nextInt();
         }
         int[][] d = new int[n + 1][m + 2];
         for (i = 1; i < n + 1; i++) {
             for (j = 1; j < m + 1; j++) {
                 if (str[i - 1] == str2[j - 1]) {
                     d[i][j] = 1;
                     if (d[i][m + 1] == 0) {
                         d[i][m + 1] = j;
                     }
                 }
             }
         }
         int din;
         for (i = 1; i < n + 1; i++) {
             for (j = 1; j < m + 1; j++) {
                 max = 0;
                 for (k = 1; k < i; k++) {
                     if (str[i - 1] != str2[j - 1] || str[i - 1] <= str[k - 1] || d[k][m + 1] >= j) {
                         if (str[i - 1] == str2[j - 1] && max == 0) {
                             max = 1;
                         }
                         if (str[i - 1] == str2[j - 1]) {
                             din = max;
                         } else {
                             if (d[i - 1][j] > d[i][j - 1]) {
                                 din = d[i - 1][j];
                             } else {
                                 din = d[i][j - 1];
                             }
                         }
                         if (str[i - 1] == str2[j - 1] && max == 0) {
                             din = 1;
                         }
                     } else {
                         din = d[k][d[k][m + 1]] + 1;
                         if (din > max) {
                             max = din;
                         }
                     }
                     if (str[i - 1] == str2[j - 1] && d[i][m + 1] == 0) {
                         d[i][m + 1] = j;
                     }
                 }
                 if (d[i][j] < max) {
                     d[i][j] = max;
                 }
             }
         }
         int mi = 0, mj = 0;
         max = 0;
         for (i = 0; i < n + 1; i++) {
             for (j = 0; j < m + 1; j++) {
                 if (d[i][j] > max) {
                     max = d[i][j];
                     mi = i;
                     mj = j;
                 }
             }
         }
         if (max == 0) {
             System.out.println(0);
         } else {
             result[0] = str[mi - 1];
             max--;
             k = 1;
             int maxi = 0, maxj = 0;
             while (max > 0) {
                 for (i = 0; i < mi; i++) {
                     for (j = 0; j < mj; j++) {
                         if (d[i][j] == max) {
                             maxi = i;
                             maxj = j;
                         }
                     }
                 }
                 mi = maxi;
                 mj = maxj;
                 result[k] = str[mi - 1];
                 k++;
                 max--;
             }
 
             System.out.println(k);
             for (i = k - 1; i > -1; i--) {
                 System.out.print(result[i] + " ");
             }
         }
         /*  System.out.println();
          for (i = 0; i < n + 1; i++) {
          for (j = 0; j < m + 2; j++) {
          System.out.print(d[i][j][n + 1] + " ");
          }
          System.out.println();
          }*/
     }
 }
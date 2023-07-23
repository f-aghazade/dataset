//package lcis;
 
 import java.util.Scanner;
 
 public class LCIS {
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int temp = 0, max, i, j, k, m, n = sc.nextInt();
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
         int[][][] d = new int[n + 1][m + 2][n + 2];
         for (i = 1; i < n + 1; i++) {
             for (j = 1; j < m + 1; j++) {
                 if (str[i - 1] == str2[j - 1]) {
                     d[i][j][0] = 1;
                     d[i][j][n + 1] = 1;
                     if (d[i][m + 1][n + 1] == 0) {
                         d[i][m + 1][n + 1] = j;
                     }
                 }
             }
         }
         for (i = 1; i < n + 1; i++) {
             for (j = 1; j < m + 1; j++) {
                 max = 0;
                 for (k = 1; k < i; k++) {
                     if (str[i - 1] != str2[j - 1] || str[i - 1] <= str[k - 1] || d[k][m + 1][n + 1] >= j) {
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
                     if (str[i - 1] == str2[j - 1] && d[i][m + 1][n + 1] == 0) {
                         d[i][m + 1][n + 1] = j;
                     }
                     if (d[i][j][k] > max) {
                         max = d[i][j][k];
                     }
                 }
                 if (d[i][j][n + 1] < max) {
                     d[i][j][n + 1] = max;
                 }
             }
         }
         max = 0;
         for (i = 0; i < m + 1; i++) {
             if (d[1][i][n + 1] > max) {
                 max = d[1][i][n + 1];
             } else {
                 d[1][i][n + 1] = max;
             }
         }
         /*int[] rem = new int[m];
          boolean done = false;
          k = 0;
          for (i = 0; i < n + 1; i++) {
          for (j = 0; j < k; j++) {
          if (d[i][m + 1][n + 1] == rem[j]) {
          d[i][m + 1][n + 1] = 0;
          done = true;
          break;
          }
          }
          if (!done) {
          rem[k] = d[i][m + 1][n + 1];
          k++;
          }
          }*/
 
         max = 0;
         for (i = 0; i < n + 1; i++) {
             if (d[i][m][n + 1] > max) {
                 max = d[i][m][n + 1];
             }
             if (d[i][m][n + 1] < max) {
                 d[i][m][n + 1] = max;
             }
         }
 
         max = d[n][m][n + 1] + 1;
         j = 0;
         for (i = n; i > 0; i--) {
             k = i;
             while (k > -1 && ((max == d[n][m][n + 1] + 1 && d[k][m][n + 1] >= max - 1) || d[k][m][n + 1] >= max)) {
                 k--;
             }
             if (k > -1) {
                 temp = d[k][m + 1][n + 1];
             }
             /*int check = 0;
              while (check != -1 && check < m) {
              if (d[i][m][n + 1] == str2[check]) {
              check = -2;
              }
              check++;
              }*/
             if (i > 0 && d[i][m + 1][n + 1] != 0 && str[i - 1] == str2[d[i][m + 1][n + 1] - 1] && d[i][m][n + 1] < max && d[i][m][n + 1] != 0 && d[i][m + 1][n + 1] >= temp) {
                 max = d[i][m][n + 1];
                 result[j] = str[i - 1];
                 j++;
             }
         }
         System.out.println(j);
         j--;
         while (j > -1) {
             System.out.print(result[j] + " ");
             j--;
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
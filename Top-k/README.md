###Top-k

#####Input testX.in file and output top-k results into the testX.out file.

**testX.in file**：
1. 第一行是N, D，代表第一行之後有Ｎ行input資料， 每行資料有D個維度，兩個數字中間有一個blank。
2. 最後一行是K，表示輸出檔testX.out要有k行(Top-K score由小到大排序)
3. Score = 每行資料的每個維度總和

</br>
**testX.out file**：
1.每一行第一個數字為score，後面是每個維度的值，中間皆有blank
2. 用字典序排序
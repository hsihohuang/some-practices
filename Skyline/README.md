Questions created by Pin-Chieh Huang
*****

##Skyline

######Input testX.in file and output top-k results into the testX.out file.

**testX.in file**：
1. 第一行是N, D，代表第一行之後有Ｎ行input資料， 每行資料有D個維度，兩個數字中間有一個blank(或/t)。</br>
2. 最後一行是K，表示輸出檔testX.out要有k行(Top-K score由小到大排序)</br>


**testX.out file**：
1. 由最外層的skyline開始輸出，對每一層先輸出一行，此行含一個數字 N 代表這一層有幾個 skyline points。
2. 接下來 N 行，輸出 skyline points (格式同input)
每一層 skyline points 都要字典序排序。
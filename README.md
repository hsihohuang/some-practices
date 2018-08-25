Questions created by Pin-Chieh Huang
*****

## Top-k

#### Input testX.in file and output top-k results into the testX.out file.

**testX.in file**：
1. 第一行是N, D，代表第一行之後有Ｎ行input資料， 每行資料有D個維度，兩個數字中間有一個blank。</br>
2. 最後一行是K，表示輸出檔testX.out要有k行(Top-K score由小到大排序)</br>
3. Score = 每行資料的每個維度總和

**testX.out file**：
1.每一行第一個數字為score，後面是每個維度的值，中間皆有blank</br>
2. 用字典序排序

*****

## Skyline

#### Input testX.in file and output top-k results into the testX.out file.

**testX.in file**：
1. 第一行是N, D，代表第一行之後有Ｎ行input資料， 每行資料有D個維度，兩個數字中間有一個blank(或'/t')。</br>
2. 最後一行是K，表示輸出檔testX.out要有k行(Top-K score由小到大排序)</br>


**testX.out file**：
1. 由最外層的skyline開始輸出，對每一層先輸出一行，此行含一個數字 N 代表這一層有幾個 skyline points。
2. 接下來 N 行，輸出 skyline points (格式同input)
每一層 skyline points 都要字典序排序。


*****

## BST

#### Input testX.in file and output top-k results into the testX.out file.

**testX.in file**：
1. 第一行是N, D，代表第一行之後有Ｎ行input資料， 每行資料有D個維度，兩個數字中間有一個'/t'。</br>
2. 接下來一行(第N+2行)是Q，代表有Q個query，下面Q行表示每個query。</br>
每一行由 1~D-1 個 0 or 1 組成
</br>第 i 個數字是 0 表示 第 ( i ) 個維度 <= 第 ( i + 1) 個維度
</br>第 i 個數字是 1 表示 第 ( i ) 個維度 > 第 ( i + 1) 個維度
請建立 BST</br>


**testX.out file**：
1.query number
2.the number of the data
3.data 
</br>要字典序排序，每個 query "之間" 要空一行
</br>格式見sample

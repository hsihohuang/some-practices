Questions created by Pin-Chieh Huang
*****

##BST

######Input testX.in file and output top-k results into the testX.out file.

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

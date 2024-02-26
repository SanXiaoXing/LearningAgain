import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
# 1. 读取数据
# 假设文档是一个制表符分隔的txt文件
data = pd.read_csv('mRNA_exp.txt', sep='\t')
# 2. 清洗数据（如果数据很干净，也许不需要这步）
# 假设我们需要所有的数据，因此这里没有删除任何列或行
# 如果需要，可以进行相应的清洗，例如：
# data.dropna(inplace=True)  # 删除含有空值的行
# data.drop(['不需要的列名'], axis=1, inplace=True)  # 删除不必要的列
# 3. 创建箱线图
sns.boxplot(data=data)
plt.xlabel('Sample or Condition')
plt.ylabel('Expression Level')
plt.title('mRNA Expression Level Boxplot')
plt.show()
# 保存图像
# plt.savefig('mRNA_exp_boxplot.png')
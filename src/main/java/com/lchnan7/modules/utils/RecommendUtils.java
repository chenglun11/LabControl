package com.lchnan7.modules.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 协同推荐算法
 *
 */
public class RecommendUtils {
    /**
     * 计算两用户皮尔逊相关系数(原式分子分母同除用户数量（n）实现)
     *
     * @param x 用户对各博客点赞情况数组
     * @param y 另一用户对各博客的点赞情况数组
     * @return 返回皮尔逊相关系数
     */
    public static double pearsonSimilarity(double[] x, double[] y) {
//      定义需要的参数
        double sumXY = 0;
        double sumX = 0;
        double sumY = 0;
        double sumX2 = 0;
        double sumY2 = 0;
        int n = x.length;
//      计算参数值
        for (int i = 0; i < n; i++) {
            sumXY += x[i] * y[i];
            sumX += x[i];
            sumY += y[i];
            sumX2 += x[i] * x[i];
            sumY2 += y[i] * y[i];
        }
//      分子和分母
        double numerator = sumXY - (sumX * sumY / n);
        double denominator = Math.sqrt((sumX2 - sumX * sumX / n) * (sumY2 - sumY * sumY / n));
//      分母为0（一个用户的情况）,单独返回
        if (denominator == 0) {
            return 0;
        }
//      返回皮尔逊相关系数
        return numerator / denominator;
    }

    /**
     * 获取与指定用户最相似的K个用户
     *
     * @param userIndex   用户在数组中的下标
     * @param userRatings 用户点赞矩阵 行表示用户 列表示博客（点赞情况）
     * @param k           返回的最相似用户数量
     * @return 返回最相似的K个用户数组
     */
    public static List<Integer> getKSimilarUsers(int userIndex, double[][] userRatings, int k) {
//      最相似用户下标数组
        List<Integer> similarUsers = new ArrayList<>();
//      指定用户对各博客点赞情况数组
        double[] targetUser = userRatings[userIndex];
//      各用户与指定用户计算得出的皮尔逊系数数组
        double[] similarities = new double[userRatings.length];
//      遍历用户
        for (int i = 0; i < userRatings.length; i++) {
//          遍历到指定用户 结束当轮循环
            if (i == userIndex) {
                similarities[i] = -1;
                continue;
            }
//          与指定用户计算两者皮尔逊系数
            double similarity = pearsonSimilarity(targetUser, userRatings[i]);
//          皮尔逊系数赋值到数组
            similarities[i] = similarity;
        }

        for (int i = 0; i < k; i++) {
//          声明最相似的系数为无限接近0（不相关） ps:1（极强相关）
//            double maxSimilarity = Double.MIN_VALUE;
            double maxSimilarity = -1;
//          声明最相似用户在用户数组中的下标
            int maxIndex = -1;
//          遍历各用户与指定用户的皮尔逊系数数组
            for (int j = 0; j < similarities.length; j++) {
//              相关系数大于原最相似系数
                if (similarities[j] > maxSimilarity) {
//                  更新最相关系数
                    maxSimilarity = similarities[j];
//                  记录用户下标
                    maxIndex = j;
                }
            }
//          最相似用户下标添加到数组
            similarUsers.add(maxIndex);
//          该用户在原数组中的皮尔逊系数设为无限接近0（不相关）
//            similarities[maxIndex] = Double.MIN_VALUE;
            similarities[maxIndex] = -1;
        }
//      返回最相似的K个用户数组
        return similarUsers;
    }

    /**
     * 为指定用户推荐物品
     *
     * @param userIndex   指定用户在数组中的下标
     * @param userRatings 用户点赞矩阵 行表示用户 列表示博客点赞情况
     * @param k           推荐物品的数量
     * @return
     */
    public static List<Integer> recommendItems(int userIndex, double[][] userRatings, int k) {
//      推荐博客下标
        List<Integer> recommendedItems = new ArrayList<>();
//      指定用户对各博客点赞情况数组
        double[] targetUser = userRatings[userIndex];
//      得到n个最相似的用户(n可调节,默认将所有用户设置为最相似用户，找到需要的数量位置为止)
        List<Integer> kSimilarUsers = RecommendUtils.getKSimilarUsers(userIndex, userRatings, userRatings.length-1);
        for (Integer i : kSimilarUsers) {
            if (recommendedItems.size()==k)break;
//           找到最相似用户点赞过但目标用户没有点赞过的物品
            double[] similarRatings = userRatings[i];
            System.out.println(i);
            int length = similarRatings.length;
            for (int j = 0; j < length; j++) {
//              已经返回所需要的数量->结束
                if (recommendedItems.size()==k)break;
                if (targetUser[j]==0&&similarRatings[j]==1){
                    System.out.println("comment ===> user"+i+" ===> "+j);
                    recommendedItems.add(j+1);
                    targetUser[j]=1;
                }
            }
        }
        return recommendedItems;
    }
    public static void main(String[] args) {
        //https://blog.csdn.net/m0_63930592/article/details/129868642
        double[][] userRatings = {
                {1, 0, 0, 1,0,1},
                {1, 0, 1, 1,0,1},
                {1, 1, 0, 1,0,1},
                {1, 0, 0, 1,0,1},
                {1, 0, 0, 1,0,1},
        };
        List<Integer> list = RecommendUtils.recommendItems(2, userRatings, 3);
    }
}


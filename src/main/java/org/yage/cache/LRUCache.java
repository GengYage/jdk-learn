package org.yage.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Yage
 * @create: 2022-08-18 16:36
 */
class LRUCache<K, V> extends LinkedHashMap<K, V> {

    //缓存大小
    private final int CACHE_SIZE;

    /**
     * 传递进来最多能缓存多少数据
     *
     * @param cacheSize 缓存大小
     */
    public LRUCache(int cacheSize) {
        // true 表示让 LinkedHashMap 按照访问顺序来进行排序，最近访问的放在头部，最老访问的放在尾部。
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 当 map 中的数据量大于指定的缓存个数的时候，就自动删除最老的数据。
        return size() > CACHE_SIZE;
    }

    public static void main(String[] args) {
        LRUCache<Integer,Integer> cache = new LRUCache<>(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        System.out.println(cache);
        cache.get(1);
        System.out.println(cache);
        cache.put(4,4);
        System.out.println(cache);
        cache.get(3);
        System.out.println(cache);
        cache.put(5,5);
        System.out.println(cache);
    }
}

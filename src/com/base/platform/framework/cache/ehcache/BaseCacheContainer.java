package com.base.platform.framework.cache.ehcache;

import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * 二级缓存容器.提供应用系统二级缓存管理能力
 * 
 * @author pan,shaohua
 * @date 2013.08.09
 */
public class BaseCacheContainer {

	public static final String DEFAULT_STRATEGY_NAME = "workflow.cache.strategy.default";
	
	/**
	 * 声明缓存管理器
	 */
	private CacheManager ehManager;
	/**
	 * 声明缓存名称 ：缓存配置文件ehcache.xml中<cache 标签中的 name值"apsCache"
	 */
	private static String default_strategy = String.valueOf("apsCache");
	
	/**
	 * 单例：私有构造
	 * @author Administrator
	 *
	 */
	private static class SingletonHolder {
		static BaseCacheContainer instance = new BaseCacheContainer();
	}
    /**
     * 单例：公有静态访问点
     * @return
     */
	public static BaseCacheContainer getInstance() {
		return SingletonHolder.instance;
	}
    /**
     * 创建缓存管理CacheManager，加载缓存配置文件ehcache.xml
     */
	private BaseCacheContainer() {

		ehManager = new CacheManager(Thread.currentThread()
				.getContextClassLoader().getResourceAsStream("ehcache.xml"));

	}
    
	/**
	 * 从缓存中获取该传入的key 是否存在
	 * @param key 键
	 * @return
	 */
	public static boolean containsKey(String key) {
		return containKey(default_strategy, key);
	}
	/**
	 * 从缓存中获取该传入的key 是否存在
	 * @param cacheStrategy   缓存名称
	 * @param key 键
	 * @return
	 */
	public static boolean containKey(String cacheStrategy, String key) {
		return getInstance().ehManager.getCache(cacheStrategy)
				.isKeyInCache(key);
	}
	
	/**
	 * 放入一个键值对象到缓存
	 * @param key 键
	 * @param value 值
	 */
	public static void addCache(String key, Object value) {
		addCache(default_strategy, key, value);
	}

	/**
	 * 放入一个键值对元素到缓存元素
	 * @param cacheStrategy  缓存名称
	 * @param key 键
	 * @param value 值
	 */
	public static void addCache(String cacheStrategy, String key, Object value) {
		Cache cache = getInstance().ehManager.getCache(cacheStrategy);
		if (cache != null) {
			Element el = new Element(key, value);
			cache.put(el);
		}
	}
    /**
     * 根据key获取么有序列化的对象属性值
     * @param key 
     * @return
     */
	public static Object getCache(String key) {
		return getCache(default_strategy, key);
	}

	/**
	 *  获取一个没有序列化后的对象属性值 (如果获取个序列化的则返回Serializable类型的属性值)
	 * @param cacheStrategy 缓存名称
	 * @param key 键
	 * @return
	 */
	public static Object getCache(String cacheStrategy, String key) {
		return getInstance().ehManager.getCache(cacheStrategy).get(key)
				.getObjectValue();
	}
	
	/**
	 * 把键值直接放到缓存中
	 * @param cacheStrategy 缓存名称
	 * @param key 键
	 * @param value 值
	 */
	public static void updateCache(String cacheStrategy, String key, String value) {
		Map<String, String> cache = (Map<String, String>)getInstance().ehManager.getCache(cacheStrategy);
		cache.put(key,value);
	}

}

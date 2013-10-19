package com.base.platform.framework.cache.ehcache;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author pan,shaohua
 * @date 2013.08.08
 * 
 */
public class BaseCodeListCacheProvider {
	private Logger log = Logger.getLogger(BaseCodeListCacheProvider.class);
	/**
	 * 缓存所有国际化表里的中文
	 */
	public static final String CACHE_LAN_ZH_CN = "lanZhCn";

	/**
	 * 缓存所有国际化表里的英文
	 */
	public static final String CACHE_LAN_EN_US = "lanEnUs";

	/**
	 * 缓存所有国际化表里的繁体中文
	 */
	public static final String CACHE_LAN_ZH_TW = "lanZhTw";

	@Autowired
	BaseCodeListUtil baseCodeListUtil;

	/**
	 * 缓存应用上下文
	 * 
	 * @param sc
	 * @throws Exception
	 */
	public void cache2Context() {
		try {
			// 缓存国际化
			cacheLanZhCn();
			cacheLanEnUs();
			cacheLanZhTw();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加载gcs_trans_lan所有中文数据列表 并组装成Map<String, List<GcsBizArgs>>缓存
	 * 
	 * @throws Exception
	 */
	public void cacheLanZhCn() throws Exception {
		Map<String, String> lanZhCnMap = null;
		lanZhCnMap = baseCodeListUtil.findGcsTransLanZhList();
		log.debug("------cache Context data lanZhCnMap");
		BaseCacheContainer.addCache(CACHE_LAN_ZH_CN, lanZhCnMap);
	}

	/**
	 * 加载gcs_trans_lan所有英文数据列表 并组装成Map<String, List<GcsBizArgs>>缓存
	 * 
	 * @throws Exception
	 */
	public void cacheLanEnUs() throws Exception {
		Map<String, String> lanEnUsMap = null;
		lanEnUsMap = baseCodeListUtil.findGcsTransLanEnList();
		log.debug("------cache Context data lanEnUsMap");
		BaseCacheContainer.addCache(CACHE_LAN_EN_US, lanEnUsMap);
	}

	/**
	 * 繁体中文国际化信息加载
	 * 
	 * @throws Exception
	 */
	public void cacheLanZhTw() throws Exception {
		Map<String, String> lanZhTwMap = null;
		lanZhTwMap = baseCodeListUtil.findGcsTransLanTwList();
		log.debug("------cache Context data lanEnUsMap");
		BaseCacheContainer.addCache(CACHE_LAN_ZH_TW, lanZhTwMap);
	}

}

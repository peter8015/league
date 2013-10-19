package com.base.platform.framework.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;

import com.base.platform.framework.web.utils.SpringContextUtils;
import com.league.myrecord.model.MyRecordBo;
import com.league.myrecord.service.MyRecordServiceFacade;

/**
 * 实现SpringSecurity的UserDetailsService接口,实现获取用户Detail信息的回调函数.
 * 
 */
public class UserDetailsServiceImpl implements UserDetailsService {
	
//	@Autowired
//	private MyRecordServiceFacade myRecordService;

	/**
	 * 获取用户Details信息的回调函数.
	 */
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		MyRecordBo userBo = null;
		try {
			MyRecordServiceFacade myRecordService = SpringContextUtils.getBean("myRecordService");
			List loginNameList = myRecordService.findBy("loginName", userName);
			if(loginNameList!=null &&loginNameList.size()>0){
				userBo= (MyRecordBo) loginNameList.get(0);
			}
			if (userBo == null)
				throw new UsernameNotFoundException("用户" + userName + " 不存在");
			
			GrantedAuthority[] grantedAuths = obtainGrantedAuthorities(userBo);
			
			// -- mini-web示例中无以下属性, 暂时全部设为true.
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			
			org.springframework.security.userdetails.User userdetail = new org.springframework.security.userdetails.User(
					userBo.getLoginName(), userBo.getShaPassword(), enabled,
					accountNonExpired, credentialsNonExpired, accountNonLocked,
					grantedAuths);
			return userdetail;
		} catch (Exception e) {
			throw new UsernameNotFoundException("用户" + userName + " 不存在");
		}
	}

	/**
	 * 获得用户所有角色的权限集合.
	 */
	private GrantedAuthority[] obtainGrantedAuthorities(MyRecordBo userBo) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		return authSet.toArray(new GrantedAuthority[authSet.size()]);
	}
}

package com.sgcc.uap.om.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgcc.uap.om.user.domain.TblUser;

/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 87041
 * @date 2018-09-05 09:15:51
 * @since 1.0
 */
public interface TblUserRepository extends JpaRepository<TblUser,String>,JpaSpecificationExecutor<TblUser> {
	
}

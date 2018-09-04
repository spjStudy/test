//package com.sgm.uap.bosp.user.repositories;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.Repository;
//import org.springframework.stereotype.Service;
//
//import com.sgm.uap.bosp.resources.domain.TSysResource;
//import com.sgm.uap.bosp.user.domain.TSysUser;
//
//
//@Service
//public interface TSysUserQuerySql extends Repository<TSysUser, Long>{
//
//	@Query(value = "SELECT * FROM t_user WHERE id = ?1", nativeQuery = true)
//	TSysUser testSql(int id);
//	
//	@Query(value = "select * from t_user b where b.username like %:name%", nativeQuery = true)
//	List<TSysUser> findByName(String name);
//	
//	@Query(value = "select r.* from t_sys_resource r "
//			+ "left join t_sys_role_resource rr on r.id = rr.resource_id "
//			+ "left join t_sys_role ro on rr.role_id = ro.id "
//			+ "left join t_sys_user_role ur on ro.id = ur.role_id "
//            + "left join t_sys_user u on ur.user_id = u.id where u.id = :userId",nativeQuery = true)
//	List<TSysResource> getByUserId(String userId);
//}

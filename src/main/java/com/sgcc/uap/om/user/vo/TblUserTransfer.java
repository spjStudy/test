package com.sgcc.uap.om.user.vo;


import com.sgcc.uap.om.user.domain.TblUser;

public class TblUserTransfer {

	public static TblUser toPO(TblUserVO vo) {
		TblUser tblUser = new TblUser();
		if(vo != null){
			tblUser.setUserid(vo.getUserid());
			tblUser.setId(vo.getId());
			tblUser.setUsername(vo.getUsername());
			tblUser.setPw(vo.getPw());
			tblUser.setAge(vo.getAge());
			tblUser.setGender(vo.getGender());
			tblUser.setPhone(vo.getPhone());
			tblUser.setEmail(vo.getEmail());
			tblUser.setCreatedtime(vo.getCreatedtime());
        }
		return tblUser;
	}

	public static TblUserVO toVO(TblUser po) {
		TblUserVO vo = new TblUserVO();
		vo.setUserid(po.getUserid());
		vo.setId(po.getId());
		vo.setUsername(po.getUsername());
		vo.setPw(po.getPw());
		vo.setAge(po.getAge());
		vo.setGender(po.getGender());
		vo.setPhone(po.getPhone());
		vo.setEmail(po.getEmail());
		vo.setCreatedtime(po.getCreatedtime());
		return vo;
	}
}

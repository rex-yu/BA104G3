package com.ach_detail.model;

import java.sql.Date;
import java.util.List;

import com.emp.model.EmpVO;

public class Ach_DetailService {
	private Ach_DetailDAO_interface dao;
	
	public Ach_DetailService(){
		dao = new Ach_DetailDAO();
	}
	
	public Ach_DetailVO addAch_Detail(String mem_No,String ach_No,Date ach_Time){
		
		Ach_DetailVO ach_DetailVO = new Ach_DetailVO();
		
		ach_DetailVO.setMem_No(mem_No);
		ach_DetailVO.setAch_No(ach_No);
		ach_DetailVO.setAch_Time(ach_Time);
		return ach_DetailVO;
		
	}
	
	public Ach_DetailVO updateAch_Detail(String mem_No,String ach_No,Date ach_Time){
		Ach_DetailVO ach_DetailVO = new Ach_DetailVO();
		
		ach_DetailVO.setMem_No(mem_No);
		ach_DetailVO.setAch_No(ach_No);
		ach_DetailVO.setAch_Time(ach_Time);
		return ach_DetailVO;
	}
	
	public Ach_DetailVO getOneAch_Detail(String mem_No) {
		return dao.findByPrimaryKey(mem_No);
	}

	public List<Ach_DetailVO> getAll() {
		return dao.getAll();
	}
	
}

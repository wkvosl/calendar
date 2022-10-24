package com.practice.data.dto;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Cal_dto_mapper {
	
	public int insertMemo(String memo_date, String memo_title, String memo_wirte);
	public int updateMemo(String memo_date, String memo_title, String memo_wirte, String memo_id);
	public List<Cal_dto> listMemo(String memo_date);
	public int deleteMemo(String memo_id);
}

package com.kuke.core.cataloguebio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuke.core.cataloguebio.bean.Cataloguebio;

public interface CataloguebioMapper {

	public List<String> getItemCodeList(@Param("offset") Integer offset, @Param("rows") Integer rows);

	public List<Cataloguebio> getCataloguebioList(@Param("itemCodeList") List<String> itemCodeList);

	public Cataloguebio getCataloguebioById(@Param("itemCode") String itemCode);
}

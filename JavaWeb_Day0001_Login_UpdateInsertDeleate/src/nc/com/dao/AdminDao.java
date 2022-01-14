package nc.com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nc.com.dto.AdminDto;
import nc.com.dto.GoodstableDto;
import nc.com.dto.GoodstypeDto;

public class AdminDao  extends BaseDao{

	/**
	 * 验证代用户登录
	 * @param dto
	 * @return
	 */
	public boolean checkUser(AdminDto dto){
		
		String sql = "select * from adminuser where user = ? and password = ?";
		Object[] param = {dto.getUser(),dto.getPassword()};
		
		List<Map<String, Object>> list = select(sql, param);
		if(list!=null&&list.size()>0){
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * 查询商品类型
	 * @return
	 */
	public List<GoodstypeDto> getGoodStype(){
		
		List<GoodstypeDto> dtos = new ArrayList<GoodstypeDto>();
		
		String sql = "select * from goodstype ";
		Object[] param=null;
		List<Map<String, Object>> list = select(sql,  param);
		if(list!=null&&list.size()>0){
			for (Map<String, Object> map : list) {
				GoodstypeDto dto = new GoodstypeDto();
				dto.setId(Integer.valueOf((map.get("id").toString())));
				dto.setTypename(String.valueOf(map.get("typename")));
				dtos.add(dto);
			}
		}
		return dtos;
	}
	
	/**
	 * 添加商品
	 * @param dto
	 * @return
	 */
	public boolean insertGoods(GoodstableDto dto){
		
		String sql = "INSERT INTO goodstable (id, goodstype_id, goodname, goodoldprice, goodnewprice, goodstore, goodimg, created_by, created_time, updated_by, updated_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] param = {dto.getId(),dto.getGoodstypeId(),dto.getGoodname(),dto.getGoodoldprice(),dto.getGoodnewprice()
				,dto.getGoodstore(),dto.getGoodimg(),null,null,null,null};
		
		return updateByParams(sql, param);		
	}
}

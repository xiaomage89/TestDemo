package nc.com.service;

import java.util.List;
import java.util.Map;

import nc.com.dao.AdminDao;
import nc.com.dto.AdminDto;
import nc.com.dto.GoodstableDto;
import nc.com.dto.GoodstypeDto;

public class LoginAdminService {

	AdminDao adminDao = new AdminDao();
	/**
	 * ��֤���û���¼
	 * @param dto
	 * @return
	 */
		public boolean checkUser(AdminDto dto){
			
			boolean checkUser = adminDao.checkUser(dto);
			return checkUser;
			
		}
		
		/**
		 * ��ѯ��Ʒ����
		 * @return
		 */
		public List<GoodstypeDto> getGoodStype(){
			
			List<GoodstypeDto> dtos = adminDao.getGoodStype();
			return dtos;
		}
		
		/**
		 * �����Ʒ
		 * @return
		 */
		public boolean insertGoods(GoodstableDto dto){
			String sql = "select * from goodstable ";
			List<Map<String, Object>> list = adminDao.select(sql, null);
			if(list!=null&&list.size()>0){
				dto.setId(String.valueOf(list.size()+1));
			}else{
				dto.setId("0");
			}
				
			return adminDao.insertGoods(dto);
		}
}

package nc.com.service;

import java.util.List;
import java.util.Map;

import nc.com.dao.GoodsDao;

public class SelGoodsService {

		GoodsDao goodsDao = new GoodsDao();;
		
		/**
		 * 查询所有商品信息
		 * @return
		 */
		public List<Map<String, Object>> selectGoods(){
			List<Map<String, Object>> list = goodsDao.selectGoods();
			return list;	
		}
		
		/**
		 * 查询商品信息
		 * @return
		 */
		public List<Map<String, Object>> condictionSelectGoods(String gname,String goodstypeId){
			List<Map<String, Object>> list = goodsDao.condictionSelectGoods(gname,goodstypeId);
			return list;	
		}
		
		/**
		 * 分页查询所有商品信息
		 * @return
		 */
		public List<Map<String, Object>> selectGoodsByPage(int startindex,int pageCount){
			List<Map<String, Object>> list = goodsDao.selectGoodsByPage( startindex, pageCount);
			return list;	
		}
		/**
		 * 分页查询商品信息
		 * @return
		 */
		public List<Map<String, Object>> condictionSelectGoodsByPage(String gname,String goodstypeId,int startindex,int pageCount){
			List<Map<String, Object>> list = goodsDao.condictionSelectGoodsByPage( gname, goodstypeId, startindex, pageCount);
			return list;	
		}
}
